fun main() {
    val str = readln()

    var flag = 0
    var sum = 0
    for((i, char) in str.withIndex()) {
        if(i == str.length - 1) {
            sum += (char - '0')
            break;
        }

        var calNum = 0
        if((i + 1) % 2 != 0) {
            calNum = 1;
        } else {
            calNum = 3;
        }

        if(char == '*') {
            flag = calNum;
        } else {
            val num = char - '0'
            sum += calNum * num
        }
    }

    if(sum % 10 ==0) {
        println(0)
    } else {
        for(i in 1..9) {
            if((sum + i * flag) % 10 == 0) {
                println(i)
                break
            }
        }
    }
}