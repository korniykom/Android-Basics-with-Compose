fun main() {
    val firstNumber = 10
    val secondNumber = 5
    
    println(add(firstNumber, secondNumber))
    println(subtract(firstNumber, secondNumber))
}

fun add(firstNumber: Int, secondNumber: Int): Int{
    return firstNumber + secondNumber
}

fun subtract(firstNumber: Int, secondNumber: Int): Int {
    return firstNumber - secondNumber;
}

