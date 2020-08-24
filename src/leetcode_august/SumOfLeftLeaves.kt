package leetcode_august;

/**
 *
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 */
fun main() {
    val root1 = TreeNode(3)
    val leftChildOfRoot1 = TreeNode(9)
    val rightChildOfRoot1 = TreeNode(20)
    root1.left = leftChildOfRoot1
    root1.right = rightChildOfRoot1
    rightChildOfRoot1.left = TreeNode(15)
    rightChildOfRoot1.left = TreeNode(7)
    println(sumOfLeftLeaves(root1))
}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

private fun isLeaf(node: TreeNode) = node.left != null && node.left?.left == null && node.left?.right == null
fun sumOfLeftLeaves(root: TreeNode?): Int {
    var count = 0
    if (root == null)
        return count

    count += when (isLeaf(root)) {
        true -> root.left?.`val` ?: 0
        false -> sumOfLeftLeaves(root.left)
    }

    count += sumOfLeftLeaves(root.right);
    return count
}
