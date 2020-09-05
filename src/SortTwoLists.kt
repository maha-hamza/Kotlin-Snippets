package src

/**
 * Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
Example:
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 */
fun main() {
    val li1 = ListNode(1)
    val next1 = ListNode(2)
    val next2 = ListNode(4)
    li1.next = next1
    next1.next = next2

    val li2 = ListNode(1)
    val next12 = ListNode(3)
    val next22 = ListNode(4)
    li2.next = next12
    next12.next = next22
    var result = mergeTwoLists(li1, li2)
    println(result)

    val li = ListNode(5)

    val lin = ListNode(1)
    val next122 = ListNode(2)
    val next222 = ListNode(4)
    lin.next = next122
    next122.next = next222
    var result2 = mergeTwoLists(li, lin)
    println(result2)
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        var s = ""
        var node: ListNode? = this
        while (node != null) {
            s += node.`val`
            if (node.next != null)
                s += "->"
            node = node.next
        }
        return s
    }
}

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1?.`val` == null && l2?.`val` != null)
        return l2
    else if (l1?.`val` != null && l2?.`val` == null)
        return l1
    val list = mutableListOf<Int>()

    var node1: ListNode? = l1
    var node2: ListNode? = l2
    while (node1 != null) {
        list.add(node1.`val`)
        node1 = node1.next
    }
    while (node2 != null) {
        list.add(node2.`val`)
        node2 = node2.next
    }
    var node: ListNode? = null
    var temp: ListNode? = node
    list.sorted().forEach {
        if (node == null) {
            node = ListNode(it)
            temp = node
        } else {
            temp?.next = ListNode(it)
            temp = temp?.next
        }
    }

    return node
}