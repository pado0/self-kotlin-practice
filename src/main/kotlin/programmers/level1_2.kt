package programmers

fun main() {

}

fun p12917(s: String): String{
    return String(s.toCharArray().sortedArrayDescending())
}


// zip은 list pair로 만들어준다.
fun p70128_r1(a: IntArray, b: IntArray): Int {
    return a.zip(b).map { it.first * it.second }.sum()
}

fun p70128(a: IntArray, b: IntArray): Int {
    return (a.indices).sumOf { a[it] * b[it] }
}