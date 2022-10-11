package toenhance

import java.math.BigDecimal
import java.math.RoundingMode

class BigDecimalZero {
}

fun main() {
    println(getRate(BigDecimal.valueOf(0), BigDecimal.valueOf(0)))
}

fun getRate(numerator: BigDecimal, denominator: BigDecimal): BigDecimal {
    if (denominator.compareTo(BigDecimal.ZERO) == 0) {
        return 0.000.toBigDecimal()
    }
    return numerator.divide(denominator, 2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100.toLong()))
}

fun getAverage(numbers: List<BigDecimal>): BigDecimal {
    if (numbers.isEmpty()) {
        return BigDecimal.ZERO
    }
    return numbers.sumOf { it }.divide(numbers.size.toBigDecimal(), 2, RoundingMode.HALF_UP)
}