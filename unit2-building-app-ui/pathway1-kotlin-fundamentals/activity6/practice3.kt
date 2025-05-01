fun main() {
    val child = 5
    val adult = 28
    val senior = 87
    
    val isMonday = true
    
    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    when {
        age <= 12 -> return 15
        age <= 60 -> return 30
        age >= 61 -> return 20
        age > 100 -> return -1
        age < 0 -> return -1
    }
    return 0
}

/*　解答
fun ticketPrice(age: Int, isMOnday: Boolean): Int {
    return when (age) {
        in 0..12 -> 15
        in 13..60 -> if (isMonday) 25 else 30
        in 61..100 -> 20
        else -> -1
    }
}
 */