package programmers.level2

class level2_1 {
}

fun main() {
//    println(p12914(4))
//    println(p12914(2000))
//    println(p12939("-1 -2 -3 -4"))
//    println(p12939("1 2 3 4"	))

    println(p12945(3))
    println(p12945(5))
}

fun p12945(n: Int): Int{
    val f = mutableListOf<Int>()

    f.add(0)
    f.add(1)

    for(i in 2..n){
        f.add((f[i-1] + f[i-2]) % 1234567)
    }
    return f[n]
}


fun p12939(s: String): String {
    val list = s.split(" ").map { it.toLong() }.sorted()
    return list.first().toString()+" "+list.last()
}

//p12914 코드 정리. map이 전역에 있는게 너무 구리다.
// 재귀가 아닌 그냥 어레이로 해도 될뻔. DP[i] = DP[i-1] + DP[i-2] 니,,,
fun p122914_r1(n: Int): Long = getFibonacci(n = n + 1)
private tailrec fun getFibonacci(n: Int, pre: Long = 0, now: Long = 1): Long =
    if(n == 0) pre
    else getFibonacci(n - 1, now, (pre+now) % 1234567 )

var map = mutableMapOf<Int, Long>()

// 한 번에 1칸 또는 2칸을 뛸 ㅅ 있음. 끝까지 도달하는 방법을 1234567로 나눠 리턴함는 함수
fun p12914(n: Int): Long {
    // f(n) = f(n-1) + f(n-2)
    // n 번째 까지 가기 위한 방법의 수는
    // n-1 번째 까지 가기 위한 방법의 수  + n - 2 번째까지 가기 위한 방법 수
    return f(n)
}

fun f(n : Int): Long{

    if(map[n] != null) return map[n]!!

    if(n == 1 || n == 2){
        map[n] = n.toLong()
        return n.toLong()
    }
    map[n] = f(n - 1) + f(n - 2)
    return map[n]!! % 1234567L // 모든 계산 과정에서 1234567를 나머지로 하는 값을 리턴해야한다. 이유는 모르겠어
}
