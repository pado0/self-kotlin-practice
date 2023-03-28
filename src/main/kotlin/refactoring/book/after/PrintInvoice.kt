package refactoring.book.after

import java.text.DecimalFormat
import kotlin.math.floor
import kotlin.math.max

class PrintInvoice {
    companion object {
        fun statement(invoice: Invoice, plays: Map<String, Play>): String {
           
            var result = "청구 내역 (고객 명: ${invoice.customer})\n"
            for (perf in invoice.performances) {
                result += "- ${playFor(plays, perf).name} : ${usd(amountFor(plays, perf)/100)} (${perf.audience}석) \n"
            }

            result += "총액: ${usd(totalAmount(invoice, plays)/100)} \n"
            result += "적립포인트 ${totalVolumeCredits(invoice, plays)}점 \n"

            return result
        }

        private fun totalAmount(
            invoice: Invoice,
            plays: Map<String, Play>
        ): Int {
            var result = 0
            for (perf in invoice.performances) {
                result += amountFor(plays, perf)
            }
            return result
        }

        private fun totalVolumeCredits(
            invoice: Invoice,
            plays: Map<String, Play>
        ): Double {
            var result = 0.0
            for (perf in invoice.performances) {
                result += volumeCreditsFor(perf, plays)
            }
            return result
        }
        
        private fun volumeCreditsFor(
            perf: Performance,
            plays: Map<String, Play>
        ): Double {
            var result = 0.0
            result += max(perf.audience - 30, 0)
            if ("comedy" == playFor(plays, perf).type) result += floor((perf.audience / 5).toDouble())
            return result
        }

        private fun playFor(
            plays: Map<String, Play>,
            aPerformance: Performance
        ) = plays[aPerformance.playId]!!

        private fun amountFor(
            plays: Map<String, Play>,
            aPerformance: Performance
        ): Int {
            var result = 0
            when (playFor(plays, aPerformance).type) {
                "tragedy" -> {
                    result = 40000
                    if (aPerformance.audience > 30) result += 1000 * (aPerformance.audience - 30)
                }

                "comedy" -> {
                    result = 30000
                    if (aPerformance.audience > 20) result += 10000 + 500 * (aPerformance.audience - 20)
                    result += 300 * aPerformance.audience
                }

                else -> throw RuntimeException("알 수 없는 장르 ${playFor(plays, aPerformance)}")
            }
            return result
        }
    }
}

fun main() {
    val invoice = Invoice(
        customer = "BigCo",
        performances = listOf(
            Performance(playId = "hamlet", audience = 55),
            Performance(playId = "as-like", audience = 35),
            Performance(playId = "othello", audience = 40)
        )
    )

    val plays = mapOf<String, Play>(
        "hamlet" to Play("Hamlet", type = "tragedy"),
        "as-like" to Play("As You Like It", type = "comedy"),
        "othello" to Play("Othello", type = "tragedy")
    )

    println(
        PrintInvoice.statement(
            invoice = invoice,
            plays = plays,
        )
    )


}

fun usd(data: Int) = "$"+DecimalFormat("#,###").format(data)
