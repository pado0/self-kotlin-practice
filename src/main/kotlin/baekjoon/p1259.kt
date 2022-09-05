import java.util.*

fun main(args: Array<String>){

    while(true){
        val input = "val"
        if (input == "0") return
        for (i in input.indices) {

            // 커서를 두개 두고 팰린드롬 비교
            val s = i
            val e = input.length - i - 1

            // 중간에 틀린게 있으면 바로 넘어감
            if (input[s] != input[e]) {
                println("no"); break
            }

            // 햄버거처럼 찌부하며 비교 후 중간 이상까지 갈 경우 yes
            if (s >= e) {
                println("yes"); break
            }
        }

    }
}
/* 리팩토링 참고
		res += if (n == n.reversed()) {
			"yes\n"
		} else {
			"no\n"
		}
 */