package data_structure_queue

import java.util.*

/*
    [ 문제 설명 ]
    트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
    ※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.

    예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다. 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.

    경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
    0	[]	[]	[7,4,5,6]
    1~2	[]	[7]	[4,5,6]
    3	[7]	[4]	[5,6]
    4	[7]	[4,5]	[6]
    5	[7,4]	[5]	[6]
    6~7	[7,4,5]	[6]	[]
    8	[7,4,5,6]	[]	[]
    따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.

    solution 함수의 매개변수로 다리 길이 bridgelength, 다리가 견딜 수 있는 무게 weight, 트럭별 무게 truckweights가 주어집니다. 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.

    [ 제한 조건 ]
    bridge_length는 1 이상 10,000 이하입니다.
    weight는 1 이상 10,000 이하입니다.
    truck_weights의 길이는 1 이상 10,000 이하입니다.
    모든 트럭의 무게는 1 이상 weight 이하입니다.

    [ 입출력 예 ]
    bridge_length	weight	truck_weights	return
    2	10	[7,4,5,6]	8
    100	100	[10]	101
    100	100	[10,10,10,10,10,10,10,10,10,10]
 */

/*
    [ 알아두면 좋을 것들 ]
    - 코틀린에서 Queue를 구현하고자 할 때 MutableList를 구현해서 만들면 된다.
    다만, 특정 실행에 따라서 추가적인 작업을 해줘야 할수도 있다.

    MutableList<Int> = mutableListOf()

 */

/*
    [ 문제에 대한 해설 ]

 */

fun main(args: Array<String>) {
//    println(solution(2, 10, intArrayOf(7,4,5,6)))
//    println(solution(100, 100, intArrayOf(10)))
    println(solution(100, 100, intArrayOf(10,10,10,10,10,10,10,10,10,10)))
}

fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray) : Int {
    var answer: Int = 0

    var waitingQ: MutableList<Int> = mutableListOf()
    var bridgeQ: MutableList<Int> = mutableListOf()
    // 대기자 Queue 셋팅
    for (truck in truck_weights) {
        waitingQ.add(truck)
    }
    // 다리 Queue 셋팅
    for (i in 0..(bridge_length-1)) {
        bridgeQ.add(0)
    }

    var currWeight: Int = weight
    var passedCnt: Int = 0
    while(truck_weights.size > passedCnt) {
        if (answer != 0 && bridgeQ[0] != 0) {
            passedCnt++
        }
        currWeight += bridgeQ[0]
        bridgeQ.removeAt(0)

        try {
            if (waitingQ[0] <= currWeight) {
                bridgeQ.add(waitingQ[0])
                currWeight -= waitingQ[0]

                waitingQ.removeAt(0)
            } else {
                bridgeQ.add(0)
            }
        } catch (e: Exception) {
            // 대기자가 더이상 없을 시
            bridgeQ.add(0)
        }

        answer++
    }

    return answer
}

// 다른 사람 풀이

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0

        var tempIndex = 0
        var tempWeight = 0
        val weightsArray = truck_weights.toMutableList()
        val loadTrucks = ArrayList<Int>() // 다리를 건너고있는 트럭들의 다리를 건너기 시작한 시간.

        while (weightsArray.isNotEmpty()) {
            if (loadTrucks.count() != 0 && (answer - loadTrucks[0]) == bridge_length) {
                tempWeight -= weightsArray[0]
                weightsArray.removeAt(0)
                loadTrucks.removeAt(0)
            }

            if (tempWeight + truck_weights[tempIndex] <= weight) {
                tempWeight += truck_weights[tempIndex]
                loadTrucks.add(answer)
                if (tempIndex + 1 < truck_weights.size) tempIndex++
            }


            answer++
        }

        return answer
    }
}

