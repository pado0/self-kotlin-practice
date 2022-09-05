package toenhance

class FilterTest {



}

fun main() {
    val dinnerList = listOf("Pizza", "Risotto", "Pasta", "Hamburger")
    val filteredList = dinnerList.filter { it.startsWith("P") }
    if(filteredList.isEmpty()) println("filteredList!! = ${filteredList}")
    if(!filteredList.isEmpty()) println("filteredList?? = ${filteredList}")

}