package weakness.scopefunction
fun main(){
    var a = Book("책이름", 1000)
    a.discount()
    println("a.price = ${a.price}")

    // apply 스코프 함수를 통해 바로 실행
    var b = Book("책이름2", 2000).apply { // apply는 자기 자신을 반환하므로 생성하자마자 수정시킬 수 있다.
        //this = Book
        name = "더해진 이름 $name" // 참조연산자 없이 인스턴스 속성과 함수에 접근 가능
        discount() // 참조연산자 없이 인스턴스 속성과 함수에 접근 가능
    }

    // let
    var c = Book("책이름3", 3000).let {
        println(it)
    }

    // run
    b.run { println("$name") }

}

data class Book(var name:String, var price: Int) {
    fun discount(){
        price -= 2000
    }
}

