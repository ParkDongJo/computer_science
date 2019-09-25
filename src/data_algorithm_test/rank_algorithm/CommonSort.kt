package data_algorithm_test.rank_algorithm

import java.util.*

fun main(args: Array<String>) {
    var array = intArrayOf(3,5,1,8,6,2,4,7)

    // 선택 정렬
    println(Arrays.toString(selectSort(array)))

    // 삽입 정렬
    println(Arrays.toString(insertSort(array)))

    // 버블 정렬
    println(Arrays.toString(insertSort(array)))

}

// 선택 정렬
// 일단 i를 최초 min로 잡고 그 이후의 숫자들 중 가장 최소값이 존재한다면
// min을 갱신하고 i와 스왑해준다.

// 내부 성능적으로는 O(n^2/2) 이다. 하지만 상수는 제외.. O(n^2)로 이다.

// [ 문법 ]
// array.copyOf() - copy value
// var a = b.also { }
// for (i in a until b )
fun selectSort(array: IntArray): IntArray {
    var answer = array.copyOf()

    for (i in 0 until array.size) {
        var min = i
        for (j in i+1 until array.size) {
            if (answer[min] >= answer[j]) min = j
        }
        answer[i] = answer[min].also { answer[min] = answer[i] }
    }

    return answer
}

// 삽입 정렬
// 일단 i를 cursor로 지정한 다음 i보다 앞단의 값들을 차례대로 비교해 간다.
// 만약 array[cursor] 보다 큰 값이 있다면 swap() 해주고 cursor로 바꿔준다.
// 만약 작은값을 마주치면 2차 loop를 벗어난다.

// 내부 성능적으로는 선택정렬보다는 우세하다.
// 운이 좋다면 비교를 멈추고 다음 숫자로 갈수 있기 때문

// [ 문법 ]
// for (i in a downTo 0 step 1)

fun insertSort(array: IntArray): IntArray {
    var answer = array.copyOf()

    for (i in 1 until array.size) {
        var cursor = i
        for (j in i-1 downTo 0 step 1) {
            if (answer[cursor] < answer[j]) {
                answer[j] = answer[cursor].also { answer[cursor] = answer[j] }
                cursor = j
            } else {
                break
            }
        }
    }

    return answer
}

// 버블 정렬
// 일단 1차 loop는 단순히 n번 반복하는 구문이다.
// 2차 loop는 j-1와 j의 값을 비교해가면서 가장 max한 값을 뒤로 위치 시킨다.
// 실제 시간복잡도는 선택 정렬과 동일하다.
// 내부 성능적으로는 O(n^2/2) 이다. 하지만 상수는 제외.. O(n^2)로 이다.
fun bubbleSort(array: IntArray): IntArray {
    var answer = array.copyOf()

    for (i in 0 until array.size) {
        for (j in 1 until array.size-i) {
            if (answer[j] < answer[j-1]) {
                answer[j] = answer[j-1].also { answer[j-1] = answer[j] }
            }
        }
    }

    return answer
}