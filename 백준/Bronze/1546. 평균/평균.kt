import java.io.*;
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    val list = br.readLine().split(" ")

    var sum = 0.0
    var max = 0.0
    for(i in list) {
        sum += i.toDouble();
        max = maxOf(max, i.toDouble())
    }

    println((sum / max * 100.0)/N);
}