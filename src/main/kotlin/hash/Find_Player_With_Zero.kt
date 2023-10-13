package hash

fun findWinners(matches: Array<IntArray>): List<List<Int>> {
    val winners = hashSetOf<Int>()
    val loosers = hashSetOf<Int>()

    val looserList = hashMapOf<Int, Int>()
    matches.forEach { loosers ->
        looserList[loosers[1]] = looserList[loosers[1]]?.plus(1) ?: 1
    }

    matches.forEach { winnerArray ->
        if (!looserList.containsKey(winnerArray[0])) {
            winners.add(winnerArray[0])
        }
    }

    for (looser in looserList.keys) {
        if (looserList[looser]!! <= 1) {
            loosers.add(looser)
        }
    }

    return listOf(
        winners.toList(),
        loosers.toList().sorted(),
    )
}