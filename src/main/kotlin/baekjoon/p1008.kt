import java.util.*

// with이 뭔지, 함수의 본체에 중괄호가 존재하는건 왜인
/*fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    println(nextInt() / nextInt())

}*/


fun main(args: Array<String>) {
    val input = Scanner(System.`in`)

    val a = input.nextDouble()
    val b = input.nextDouble()

    println(a / b)

}


// 리펙토링
