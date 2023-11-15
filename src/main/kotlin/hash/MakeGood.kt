package hash

import java.util.*

fun makeGood(s: String): String {
    val goodStack = Stack<Char>()
    var goodString = ""
    goodStack.push(s[0])

    for (iPlus in 1..s.length - 1) {
        if (goodStack.isNotEmpty()) {
            if (goodStack.peek().oppositeLetter(s[iPlus])) {
                goodStack.pop()
            } else {
                goodStack.push(s[iPlus])
            }
        } else {
            goodStack.push(s[iPlus])
        }
    }
    while (goodStack.isNotEmpty()) {
        goodString += goodStack.pop()
    }

    return goodString.reversed()
}


fun Char.oppositeLetter(j: Char): Boolean {
    if (this == j){
        return false
    }
    if(this.isUpperCase()){
        if(j.toString().uppercase().equals(this.toString())){
            return true
        }
    }else{
        if(j.toString().lowercase().equals(this.toString())){
            return true
        }
    }
    return false
}