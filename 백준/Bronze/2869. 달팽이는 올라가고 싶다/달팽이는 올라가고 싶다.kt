fun main() {
    val (A, B, V) = readln().split(" ").map{ it.toLong() }
    var day = (V - B) / (A - B)
    if((V - B) % (A - B) != 0L) {
        day++
    }
    println(day)
}