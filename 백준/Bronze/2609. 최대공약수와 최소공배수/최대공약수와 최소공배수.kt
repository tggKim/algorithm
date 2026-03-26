fun main() {
    val list = readln().split(" ").map { it.toInt() }
    val max = maxOf(list[0], list[1])
    val min = minOf(list[0], list[1])

    var x = max
    var y = min
    var r = max % min
    while(r != 0) {
        x = y;
        y = r;
        r = x % y;
    }
    println(y)
    println(max * min / y)
}