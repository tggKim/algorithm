fun main() {
    val L = readln().toInt()
    val str = readln()

    var sum = 0L
    var r = 1L
    val M = 1234567891

    for(i in 0 until str.length) {
        val num = str[i] - 'a' + 1
        sum = (sum + (num * r)) % M
        r = (r * 31) % M
    }

    println(sum)
}