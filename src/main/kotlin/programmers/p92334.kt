package programmers
// https://school.programmers.co.kr/learn/courses/30/lessons/92334
//    for (e in emailMap.keys) {
//            answer.plus(emailMap[e]!!)
//            println("an = ${emailMap[e]}")
//        }
/*
불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템.
- 각 유저는 한 번에 한 명의 유저를 신고할 수 있음
-- 신고 횟수 무제한, 한 유저를 여러번 신고할 수 있으나 횟수는 1회
- k번 이상 신고된 유저는 게시판 이용이 정지됨. 신고한 유저에게 정지사실을 메일로 고지.
- 마지막에 한 번에 이용정지 메일 발송

- 유저별 처리 결과 메일을 받은 횟수를 리턴한다.
* */
fun main() {
    val id_list = arrayOf("muzi", "frodo", "apeach", "neo")
    val report = arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi")
    val k = 2


    val sol:IntArray = p92334().solution(id_list, report, k)
    for (i in sol) {
        println("i = ${i}")
    }
}
class p92334 {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer: IntArray = IntArray(id_list.size){0}

        val emailMap: MutableMap<String, Int> = mutableMapOf()
        for (s in id_list) {
            emailMap[s] = 0
        }


        val warnedMap: MutableMap<String, MutableList<String>> = mutableMapOf()
        val reporterMap: MutableMap<String, MutableList<String>> = mutableMapOf()

        for (s in report) {
            val reporter = s.split(" ")[0]
            val warned = s.split(" ")[1]

            // 신고자 맵 만들기
            if (reporterMap[reporter] == null) {
                reporterMap[reporter] = mutableListOf()
            }
            if(!reporterMap[reporter]!!.contains(warned)) reporterMap[reporter]!!.add(warned)

            // 신고당한사람 맵 만들기
            if(warnedMap[warned] == null){
                warnedMap[warned] = mutableListOf()
            }
            if(!warnedMap[warned]!!.contains(reporter)) warnedMap[warned]!!.add(reporter)

        }

        for (m in warnedMap.keys) {
            if(warnedMap[m]!!.size >= k){ // m이 신고를 k 번 이상 당한 사람이면
                // reporterMap에서 m을 포함 사람의 emailMap의 값을 1 증가시킨다
                for(r in reporterMap.keys){
                    if(reporterMap[r]!!.contains(m)){
                        //!! 여기 루프가 아예 안돈다.
                        emailMap[r] = emailMap[r]!! + 1

                    }
                }
            }
        }

        var t = 0
        for (e in emailMap.keys) {
            answer[t] = emailMap[e]!!
            println("answer = ${answer[t]}")
            t ++
        }
        return answer
    }
}