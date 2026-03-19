import java.util.*
fun main() {
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    val nums = mutableListOf<Int>()
    for(i in 0 until N) {
        nums.add(st.nextToken().toInt())
    }

    var max = 0
    for(i in 0 until nums.size - 2) {
        for(j in i + 1 until nums.size - 1) {
            for(k in j + 1 until nums.size) {
                val sum = nums[i] + nums[j] + nums[k]
                if(sum > max && sum <= M) {
                    max = sum
                }
            }
        }
    }

    println(max)
}