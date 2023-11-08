package hash

fun lengthOfLongestSubstring(s: String): Int {
    var l = 0
    var r = 1
    var currentMaxSubString = 0
    val mapOfSubString = hashMapOf<Char, Int>()
    mapOfSubString[s[l]] = 0
    while(r < s.length){
        if(mapOfSubString[s[r]] != null){
            l +=1
            mapOfSubString.remove(s[r])
        } else{
            mapOfSubString[s[r]] = r
            r +=1
        }
        if ((r-1) - l > currentMaxSubString) {
            currentMaxSubString = (r-1) - l
        }
    }

    return currentMaxSubString
}

 /*
  */
class ListNode(
    val value: Int,
){
    lateinit var prev: ListNode
    lateinit var next: ListNode
}

fun addNode(node: ListNode, nodeToAdd: ListNode) {
    val prevNode: ListNode = node.prev
    nodeToAdd.next = node
    nodeToAdd.prev = prevNode
    prevNode.next = nodeToAdd
    node.prev = nodeToAdd
}

fun main() {
    // Create three nodes: A, B, and C
    val nodeA = ListNode(1)
    val nodeB = ListNode(2)
    val nodeC = ListNode(3)

    // Set the initial structure: A <-> B <-> C
    nodeA.next = nodeB
    nodeB.prev = nodeA
    nodeB.next = nodeC
    nodeC.prev = nodeB

    // Create a new node, X, and add it after node B
    val nodeX = ListNode(99)
    addNode(nodeB, nodeX)

    // The updated structure: A <-> B <-> X <-> C
    println("Node A's next: ${nodeA.next.value}")
    println("Node B's next: ${nodeB.next.value}")
    println("Node X's prev: ${nodeX.prev.value}")
    println("Node C's prev: ${nodeC.prev.value}")
}