fun main() {
    val N = readln().toInt()
    
    var number = 0
    var count = 0
    while(count != N) {
        number++
        val str = number.toString()
        if(str.contains("666")) {
            count++;
        }
    }
    
    println(number)
}