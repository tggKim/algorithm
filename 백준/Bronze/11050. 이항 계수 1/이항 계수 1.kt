fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }

    println(method(N) / (method(K) * method(N - K)))
}

fun method(number: Int): Int {
    var mul = 1
    for(i in number downTo 1) {
        mul *= i
    }
    return mul
}