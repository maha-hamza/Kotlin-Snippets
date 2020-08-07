package leetcode_august

class MyHashSet() {

    /** Initialize your data structure here. */
    private var set: Set<Int> = HashSet()

    fun add(key: Int) {
        set = set.plus(key)
    }

    fun remove(key: Int) {
        set = set.minus(key)
    }

    /** Returns true if this set contains the specified element */
    fun contains(key: Int): Boolean {
        return set.contains(key)
    }

}

fun main() {
    val key = 1
    var obj = MyHashSet()
    obj.add(key)
    obj.add(key)
    obj.remove(key)
    var param_3 = obj.contains(key)
    println(param_3)
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */