fun main(){
    val money1 = JavaMoney(2)
    val money2 = JavaMoney(1)

    // 객체 비교시 compareTo를 자동으로 호출해줌. CompareTo 작성하지 않아도 됨.


    val moneyA = JavaMoney(1000)
    val moneyB = moneyA
    val moneyC = JavaMoney(1000)

    //println(moneyA == moneyB)
    //println(moneyA === moneyB)
    println(moneyA == moneyC) //
    println(moneyA === moneyC)

}