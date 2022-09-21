package programmers

fun main() {
    val id_list = arrayOf("muzi", "frodo", "apeach", "neo")
    val report = arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi")
    val k = 2


    val sol:IntArray? = p92334_god().solution(id_list, report, k)

}
class p92334_god {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray? {
        val a =  report.map { it.split(" ") } // list[0] = [muzi, frodo], list[1] = [apeach, frodo]...
            .groupBy { it[1] } // 신고당한 사람을 키로 그룹을 짓는다. Map<신고당한 사람, List<신고한 사람>> . groupby를 여러 케이스로 연습해야겠다.
            //.asSequence()
            .map{it.value.distinct()} // 신고한 사람이 여러명이면 발라낸다. <frodo, [muzi, muzi, neo]> -> <frodo, [muzi, neo]> // map컬렉션을 map{}으로 가져오면 it가 키벨류 쌍이 되는건가? 맞네. value로 list를 받아와 distinct
            .filter { it.size >= k } // 왜 it.value.size가 아닐까? it가 arrayList가 됐다. 스트림 별 자료형 반환형태 확인필요

        return null
    }
}
//test3