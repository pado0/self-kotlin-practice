package refactoring.book.before

import java.text.DecimalFormat
import kotlin.math.floor
import kotlin.math.max

class PrintInvoice {
    companion object {
        fun statement(invoice: Invoice, plays: Map<String, Play>): String {
            var totalAmount = 0
            var volumeCredits: Double = 0.0
            var result = "청구 내역 (고객 명: ${invoice.customer})\n"

            // 장르 별 비용
            for (i in invoice.performances) {
                val play = plays[i.playId]!!
                var thisAmount = 0

                when (play.type) {
                    "tragedy" -> {
                        thisAmount = 40000
                        if (i.audience > 30) thisAmount += 1000 * (i.audience - 30)
                    }

                    "comedy" -> {
                        thisAmount = 30000
                        if (i.audience > 20) thisAmount += 10000 + 500 * (i.audience - 20)
                        thisAmount += 300 * i.audience
                    }

                    else -> throw RuntimeException("알 수 없는 장르 ${play.type}")
                }

                // 포인트 적립
                volumeCredits += max(i.audience - 30, 0)

                // 희극 관객 5명마다 추가 포인트 제공
                if ("comedy" == play.type) volumeCredits += floor((i.audience / 5).toDouble())

                // 청구 내역 출력
                result += "- ${play.name} : ${format(thisAmount/100)} (${i.audience}석) \n"
                totalAmount += thisAmount
            }

            result += "총액: ${format(totalAmount/100)} \n"
            result += "적립포인트 ${volumeCredits}점 \n"


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

fun format(data: Int) = "$"+DecimalFormat("#,###").format(data)
