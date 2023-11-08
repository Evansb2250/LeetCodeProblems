package hash

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.LinkedList

internal class DeleteDuplicatesKtTest{

    @Test
    fun deleteDuplicatesNodeTes(){
      val result =  deleteDuplicates(
            constructListNode(
                intArrayOf(2,3,5,2,4)
            )
        )
        while(result?.next != null){
            print(result.value)
        }
    }


    fun constructListNode(
        array: IntArray
    ): ListNode{
        var headNode =ListNode(
            array[0]
        )

        for(x in 1 until array.size){
            val temptNode = ListNode(array[x])
            var movingNode = headNode.next
            while (movingNode.next != null){
                movingNode = movingNode.next
            }
            movingNode.next  = temptNode
            temptNode.prev = movingNode
        }



        return headNode
    }
}