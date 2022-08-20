package effectivekotlin

class item45 {
}



fun main() {
    val str1 = "hello world"
    val str2 = "hello world"
    print(str1 == str2) // true
    print(str1 === str2) // true, 기존 문자열을 재사용하므로 동일한 메모리에서 읽어옴

    val i1: Int? = 1
    val i2: Int? = 1
    print(i1 == i2) // true
    print(i1 === i2) // true, Int는 -128~127 범위를 캐시로부터 읽어오기 때문이다. 본 범위를 벗어나면 캐시되지 않는다.

    val i3: Int? = 1234
    val i4: Int? = 1234
    print(i3 == i4) // true
    print(i3 === i4) // false, 범위를 벗어나므로 캐시되지 않아 다른 객체로 판단

    // 예제1. 링크드리스트 사용
    val list: LinkedList<Int> = Node(1, Node(2, Node(3, Empty())))
    val list2: LinkedList<String> = Node("A", Node("B", Empty()))

    // 예제2. object 사용, Empty2가 싱글톤이니 유일한 인스턴스라 class 명으로 바로 접근 가능
    val list3: LinkedList2<Int> = Node2(1, Node2(3, Empty2))

}

// 308P 객체 생성을 피하기 위한 예제1
sealed class LinkedList<T>

class Node<T>(
    val head: T,
    val tail: LinkedList<T>
): LinkedList<T>()

class Empty<T>: LinkedList<T>()

// 308P 예제2. 예제 1에서 Empty()객체를 매번 생성해야함을 해결
// 1. Empty 인스턴스를 하나만 만들고, 다른 모든 리스트에서 활용
// 2. 1과 같이 하려면 해당 인스턴스의 제네릭 타입이 Nothing이어야 한다.
// 3. 다만 이때, out 한정자로 타입 인자를 out T 처리하면 좋다 (아이템 24)
sealed class LinkedList2<out T>
class Node2<out T>(
    val head: T,
    val tail: LinkedList2<T>
) : LinkedList2<T>()

object Empty2 : LinkedList2<Nothing>()