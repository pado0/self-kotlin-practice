package toenhance

class StringToListList {
}

fun main() {

    val str = "1-2-3"
    val profileId: List<Long> = str.split("-").map { it.trim().toLong() }
    println(profileId)
    val profileIdList: List<List<Long>> = arrayListOf(profileId)


}