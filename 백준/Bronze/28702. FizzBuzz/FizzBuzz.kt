fun main() {
    val strs = Array<String>(3){i -> ""}
    strs[0] = readln();
    strs[1] = readln();
    strs[2] = readln();
    
    for(i in 0..2) {
        if(!strs[i].startsWith("F") && !strs[i].startsWith("B")) {
            val answer = method(strs[i].toInt() + (3 - i))
            println(answer)
            break
        }
    }
}

fun method(num: Int): String =
    when {
        num % 3 == 0 && num % 5 == 0 -> "FizzBuzz"
        num % 3 == 0 -> "Fizz"
        num % 5 == 0 -> "Buzz"
        else -> num.toString()
    }