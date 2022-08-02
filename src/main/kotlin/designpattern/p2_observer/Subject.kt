package designpattern.p2_observer

interface Subject {
    fun registerObserver()
    fun removeObserver()
    fun notifyObservers()
}