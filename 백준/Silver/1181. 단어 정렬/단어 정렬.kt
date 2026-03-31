import java.util.stream.Collectors

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val N = br.readLine().toInt()

    val answer  = List(N) {br.readLine()}
        .stream()
        .distinct()
        .sorted { a1, a2 ->
            if (a1.length != a2.length) {
                a1.length - a2.length
            } else {
                a1.compareTo(a2)
            }
        }
        .collect(Collectors.toList())

    for(i in answer) {
        bw.write("${i}\n")
    }
    bw.flush()
    bw.close()
}