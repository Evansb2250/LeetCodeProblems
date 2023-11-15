package stacks

import java.util.*


fun simplifyPath(path: String): String {
    val pathStack = Stack<Char>()
    var simplePath = ""


    for(i in path){
        pathStack.push(i)
    }

    while(pathStack.isNotEmpty()){
        val placeHolder =  pathStack.pop()
        if(placeHolder == '/'){
            if(pathStack.isNotEmpty()){
                val peekValue = pathStack.peek()
                if(peekValue != '/'){
                    simplePath += placeHolder
                }
            }else{
                if(simplePath.get(simplePath.length) != '/' ){
                    simplePath += placeHolder
                }
            }
        }

    }


    return simplePath.reversed()
}