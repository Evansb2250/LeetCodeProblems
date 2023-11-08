package hash

fun numJewelsInStones(jewels: String, stones: String): Int {
    val stonesThatAreJewels = hashMapOf<Char, Int>()
    var total = 0

    for(i in 0 until jewels.length){
        stonesThatAreJewels[jewels[i]] = 0
    }

    for(x in 0 until stones.length){
        if(stonesThatAreJewels.get(stones[x]) != null){
            stonesThatAreJewels[stones[x]]  = stonesThatAreJewels[stones[x]]?.plus(1) ?: 1
        }
    }

    for(key in stonesThatAreJewels.keys ){
        total += stonesThatAreJewels[key] ?: 0
    }

    return total

}