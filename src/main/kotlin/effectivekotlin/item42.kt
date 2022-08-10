package effectivekotlin

class item42 {

}
class Book(var name:String, var price: Int){
    operator fun compareTo(b: Book): Int =
        when {
            this.price > b.price -> 1
            this.price < b.price -> -1
            else -> 0
        }

    companion object{
        val DISPLAY_ORDER = compareBy(Book::name, Book::price)
    }
}

class BookComparable(
    var name:String,
    var price: Int
    ) : Comparable<BookComparable>{
    override fun compareTo(other: BookComparable): Int {
        return compareValues(price, other.price)
    }
}
class BookComparable2(
    var name:String,
    var price: Int
) : Comparable<BookComparable2>{
    override fun compareTo(other: BookComparable2): Int {
        return compareValuesBy(this, other, {it.price}, {it.name })
    }
}

fun main() {
    var book1 = Book("name3", 12000)
    var book2 = Book("name2", 16000)
    var book3 = Book("name1", 12000)
    var book4 = Book("name5", 12000)
    var book5 = Book("name4", 12000)

    if(book1 < book2) println("book2 high") // book1.compareTo(book2) < 0 와 동일한 문법
    else if(book1 > book2) println("book1 high")
    else println("book1 == book2")

    if(book1 < book3) println("book3 high")
    else if(book1 > book2) println("book1 high")
    else println("book1 == book3")

    val books = listOf(book1, book2, book3, book4, book5)
    val sortedBooks = books.sortedBy { it.price }
    val sortedBooks2 = books.sortedWith(compareBy({ it.price },{it.name }))

    for (book in sortedBooks) {
        print("book.name = ${book.name} ")
        println("books = ${book.price}")
    }

    println("--")

    for (book in sortedBooks2) {
        print("book.name = ${book.name} ")
        println("books = ${book.price}")
    }

    println("--")
    // comparator를 통해 이름으로 먼저 비교한 뒤 가격으로 비교한다.
    val sortedBooks3 = books.sortedWith(Book.DISPLAY_ORDER)
    for (book in sortedBooks3) {
        print("book.name = ${book.name} ")
        println("books = ${book.price}")
    }
}