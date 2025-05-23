fun main() {
    val treatFunction = trickOrTreat(false) { "$it quarters" }
    val trickFunction = trickOrTreat(true, null)
    repeat(4) {
        treatFunction()
    }
    trickFunction()
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if(isTrick) {
        return trick
    } else {
        if (extraTreat != null) {
	        println(extraTreat(5))
        }
        return treat
    }
}

var trick = {
    println("No treats!")
}

var treat: () -> Unit = {
    println("Have a treat!")
}

