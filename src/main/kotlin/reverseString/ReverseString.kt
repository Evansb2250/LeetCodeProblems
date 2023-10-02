package reverseString

fun reverseString(array: CharArray): Unit{
    val newArray = CharArray(array.size)
    var x = 0
    var y = array.size - 1

    while(x >= y){
       val placeHolder = array.get(x)
        newArray.set(x, array.get(y))
        newArray.set(y, placeHolder)
        x++
        y --
    }


}