package src

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.
Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
1->4->5,
1->3->4,
2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 */
fun mergeKLists(lists: Array<ListNode?>): ListNode? {

    return when {
        lists.isEmpty() -> return null
        lists.filter { it == null }.size == lists.size -> return null
        else -> {
            val merge = mutableListOf<Int>()
            for (it in lists) {
                var node = it
                while (node != null) {
                    merge.add(node.`val`)
                    node = node.next
                }
            }
            changeToListNode(merge)
        }
    }
}

private fun changeToListNode(merge: MutableList<Int>): ListNode? {
    var node: ListNode? = null
    var temp: ListNode? = node
    merge.sorted().forEach {
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

    val li = ListNode(5)

    val lin = ListNode(1)
    val next122 = ListNode(2)
    val next222 = ListNode(3)
    lin.next = next122
    next122.next = next222

    var result2 = mergeKLists(arrayOf(li1, li2, li, lin))
    println(result2)
}
