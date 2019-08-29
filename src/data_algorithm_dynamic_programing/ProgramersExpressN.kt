package data_algorithm_dynamic_programing


//var min: Int = 9
var min: Int = -1

fun main(args: Array<String>) {
    println(solution(5, 12))
}

fun solution(N: Int, number: Int): Int {
//    cal(N, number, 0, 0)
//    if(min>8)
//        min = -1

    dfs(N, number, 0, 0)

    return min
}

fun cal(N: Int, number: Int, count: Int, result: Int) {
    if (min < count) return
    if (result==number) {
        if(min > count)
            min = count
        return
    }
    if (count == 8) {
        return
    } else {
        var rest = 8-count

        for (i in 1..rest) {
            var tailmax = i/2

            for (j in 0..tailmax) {
                var head = 0

                for (k in 1..(i-j)) {
                    head = head*10 + N
                }
                var tail = 0
                for (k in 1..j) {
                    tail = tail*10 + N
                }

                // 아니 꼬리 몇개이고 헤드 몇개인거 갯수 세는 이유는 알겠어
                // NNN/NN 뭐 이런경우때문이잖아!!
                // 근데 왜 하필!!! /(나눗셈)만 하냐?
                // NNN*NN 뭐 이런건 고려 안하냐?
                // 뭐하는 짓인지 이해가 안가네!!!
                // 이렇게 베베 꼬이게 생각해놓고
                // 뭐? 어려운 문제는 아니라고?? ..
                // 장난 치냐? 허언증 있는건가??
                var next: Int
                if (tail>0) {
                    next = head / tail
                } else {
                    next = head
                }

                cal(N, number,count+i, result+next)
                cal(N, number,count+i, result-next)
                cal(N, number,count+i, result*next)
                cal(N, number,count+i, result/next)
                cal(N, number,count+i, result*-1*next)
                cal(N, number,count+i, result*-1/next)
            }

            // ㅅㅂ 아니 이걸 왜 이렇게 했는지 이해가 안간다.
            // 뭐 블로그에 쏼라쏼라 해놨는데, 진짜 왠만한 개발자들은 글작성 능력이 떨어지는건지 귀찮은 건지..
            // 무슨 말인지 하나도 모르겠네..
            // 현록!! 도대체 뭐때문에 이러는거냐!! 이해하지 못하는게 한두개가 아니야!!
            // 근데.. 이문제 네놈 말고도 뭔말인지도 더 모를만큼
            // 해석하고 코딩해놓은 놈들 세고센거 인정..
            // 아니 알고리즘 문제를 풀었다고 해서 그 사람이 개발 잘한다? 이건 아닌거 같다는 생각이 확 드네
            if (i>2) {
                cal(N, number, count+i, result)
                cal(N, number, count+i, 0)
            }
        }
    }
}

fun dfs(N: Int, number: Int, count: Int, prev: Int) {
    var tmpN = N
    if (count > 8) {
        min = -1
        return
    }
    if (number == prev) {
        if (min == -1 || min > count) min = count
        return
    }

    /*
        이게 가능한 이유가 있음!!
        문제를 좀 더 꼬았다면, 이거가지고는 안되겠지만
        예를 들어
        A식 - 12 = 5 + 5 + (5/5) + (5/5) 는
        B식 - 12 = (5 + 5)/5 + 5 + 5 와
        같은 수식이라고 할수 있지만, 5가 덜 쓰였다.
        즉 아래의 코드는 A식을 만들지 못한다!!!
        하지만 B식은 만들수 있다!!! 설령 A식을 만들지 못한다 해도 상관 없는 것이
        어차피 B식이 A식 보다 5가 적게 쓰였기 때문읻다.

        하지만 만약 문제가 조금 더 꼬인다면,
        이 방식은 통하지 않는다.
        하지만.. 너무 코드가 깔끔한것!!

     */
    for (i in 0..(8-count-1)) {
        dfs(N, number, count+i+1, prev-tmpN)
        dfs(N, number, count+i+1, prev+tmpN)
        dfs(N, number, count+i+1, prev*tmpN)
        dfs(N, number, count+i+1, prev/tmpN)

        tmpN = tmpN * 10 + N
    }
}

