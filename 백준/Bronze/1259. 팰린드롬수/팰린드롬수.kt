import java.io.*;
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    while(true) {
        val str = br.readLine();
        if(str.equals("0")) {
            break;
        }

        val reverseStr = StringBuilder(str).reverse().toString()

        if(str.equals(reverseStr)) {
            println("yes")
        } else {
            println("no")
        }
    }
}