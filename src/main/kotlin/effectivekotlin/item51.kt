package effectivekotlin

class item51 {
}

open class InlineFilterBenchmark{
    lateinit var list: List<Int>
    lateinit var array: IntArray

    fun init(){
        list = List(1000000){ it}
        array = IntArray(1_000_000){ it}
    }

}