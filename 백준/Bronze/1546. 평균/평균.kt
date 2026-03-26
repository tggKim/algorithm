import java.io.*;
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    val list = br.readLine().split(" ").map { it.toDouble() }

    var sum = 0.0
    var max = 0.0
    for(i in list) {
        sum += i
        max = maxOf(max, i)
    }

    println((sum / max * 100)/N)
}