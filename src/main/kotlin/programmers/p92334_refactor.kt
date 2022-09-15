package programmers

fun main() {
    val id_list = arrayOf("muzi", "frodo", "apeach", "neo")
    val report = arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi")
    val k = 2


    val sol:IntArray = p92334_god().solution(id_list, report, k)
    for (i in sol) {
        println("i = ${i}")
    }

}
class p92334_god {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer = IntArray(id_list.size){0}
        var clearReport = report.distinct() // 중복제거. 한 사람이 같은 사람 여러번 신고한걸 걸러낸다.

        // 맵 쓰지 말고 리스트로 처리
        val warned = Array(clearReport.size){""}
        val reporter = Array(clearReport.size){""}

        // 신고 횟수
        val warnedCount = IntArray(id_list.size){0}

        for(i in clearReport.indices) {
            reporter[i] = clearReport[i].split(" ")[0]
            warned[i] = clearReport[i].split(" ")[1]
        }

        // alist.indexOf(x) : alist 내에 x 원소가 몇 번째 인덱스에 있는지를 리턴
        for(i in clearReport.indices) warnedCount[id_list.indexOf(warned[i])]++

        for(i in clearReport.indices){
            if(warnedCount[id_list.indexOf(warned[i])] >= k){ // 신고 당한 횟수가 k 이상이면.
                answer[id_list.indexOf(reporter[i])]++ // answer의 신고자 인덱스(id_list 기준)에 1을 더해줌.
            }
        }

        return answer
    }
}