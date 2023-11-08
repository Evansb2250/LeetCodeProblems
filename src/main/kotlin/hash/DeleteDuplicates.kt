package hash


fun deleteDuplicates(head: ListNode?): ListNode? {
    var node = head
    var secondNode = head?.next
    var memory = hashSetOf<Int>()

    if (head?.value != null){
        memory.add(head.value)
    }else{
        return head
    }

    while (secondNode?.next != null){
        if(memory.contains(secondNode.value)){
            node?.next = secondNode.next.next
        }else{
            node = node?.next
            secondNode = secondNode.next.next
            if(node?.value != null){
                memory.add(node.value)
            }
        }
    }

    return head
}