import java.io.*
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val N = Integer.parseInt(br.readLine())
    val arr = Array(10001) {i -> 0}

    for(i in 0 until N) {
        val num = Integer.parseInt(br.readLine());
        arr[num]++
    }
    
    for((i, value) in arr.withIndex()) {
        for(j in 0 until value) {
            bw.write("${i}\n")
        }
    }

    bw.flush()
    bw.close()
}