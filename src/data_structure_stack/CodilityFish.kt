package data_structure_stack

import java.util.Stack

/**
You are given two non-empty arrays A and B consisting of N integers.
Arrays A and B represent N voracious fish in a river, ordered downstream along the flow of the river.

The fish are numbered from 0 to N − 1. If P and Q are two fish and P < Q,
then fish P is initially upstream of fish Q. Initially, each fish has a unique position.

Fish number P is represented by A[P] and B[P]. Array A contains the sizes of the fish.
All its elements are unique. Array B contains the directions of the fish.
It contains only 0s and/or 1s, where:

0 represents a fish flowing upstream,
1 represents a fish flowing downstream.
If two fish move in opposite directions and there are no other (living) fish between them,
they will eventually meet each other.
Then only one fish can stay alive − the larger fish eats the smaller one.
More precisely, we say that two fish P and Q meet each other when P < Q, B[P] = 1 and B[Q] = 0,
and there are no living fish between them. After they meet:

If A[P] > A[Q] then P eats Q, and P will still be flowing downstream,
If A[Q] > A[P] then Q eats P, and Q will still be flowing upstream.
We assume that all the fish are flowing at the same speed. That is,
fish moving in the same direction never meet. The goal is to calculate the number of fish that will stay alive.

For example, consider arrays A and B such that:

A[0] = 4    B[0] = 0
A[1] = 3    B[1] = 1
A[2] = 2    B[2] = 0
A[3] = 1    B[3] = 0
A[4] = 5    B[4] = 0
Initially all the fish are alive and all except fish number 1 are moving upstream.
Fish number 1 meets fish number 2 and eats it, then it meets fish number 3 and eats it too.
Finally, it meets fish number 4 and is eaten by it.
The remaining two fish, number 0 and 4, never meet and therefore stay alive.

Write a function:

class Solution { public int solution(int[] A, int[] B); }

that, given two non-empty arrays A and B consisting of N integers,
returns the number of fish that will stay alive.

For example, given the arrays shown above, the function should return 2, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [0..1,000,000,000];
each element of array B is an integer that can have one of the following values: 0, 1;
the elements of A are all distinct.

 */

fun main(args: Array<String>) {
//    println(solution(intArrayOf(4, 3, 2, 1, 5), intArrayOf(0, 1, 0, 0, 0, 0)))
//    println(solution(intArrayOf(4), intArrayOf(1,0)))


    println(anotherSolution(intArrayOf(4, 3, 2, 1, 5), intArrayOf(0, 1, 0, 0, 0, 0)))
    println(anotherSolution(intArrayOf(4), intArrayOf(1,0)))
}

// 걸린시간 : 63 min
// 점수 : 75
// Task : 75
// Correctness : 75
// Performance : 75
fun solution(A: IntArray, B: IntArray): Int {
    var stack = StackFish()

    for(i in 0..(A.size-1)) {

        var top = stack.peek()

        if (top == null) {
            stack.push(Fish(A[i], B[i]))
        } else {
            when (top.dir) {
                0->{
                    stack.push(Fish(A[i], B[i]))
                }
                1->{
                    if (B[i] == 0) {

                        while (top != null && top.dir==1) {
                            if (top.size < A[i]) {
                                stack.pop()
                            } else {
                                break
                            }
                            top = stack.peek()
                        }

                        if (top != null && top.dir == 0) {
                            stack.push(Fish(A[i], B[i]))
                        }
                    } else {
                        stack.push(Fish(A[i], B[i]))
                    }
                }
            }
        }
    }

    return stack.size()
}

class Fish {
    var dir: Int
    var size: Int

    constructor(_size: Int, _dir: Int) {
        this.dir = _dir
        this.size = _size
    }
}

interface StackImpl {
    fun isEmpty(): Boolean
    fun size(): Int
    fun push(item: Fish)
    fun pop(): Fish?
    fun peek(): Fish?
}

class StackFish: StackImpl, Iterator<Fish> {
    var list: MutableList<Fish> = mutableListOf()
    override fun isEmpty(): Boolean =list.isEmpty()
    override fun size() = list.size
    override fun peek(): Fish? = list.lastOrNull()
    override fun pop(): Fish? {
        val item = list.lastOrNull()
        if(!isEmpty()) {
            list.removeAt(list.size-1)
        }
        return item
    }
    override fun push(item: Fish) { list.add(item) }
    override operator fun hasNext() = list.iterator().hasNext()
    override operator fun next() = list.iterator().next()
}


// 다른 사람의 코드
// 일단 변수명이 명확해서 좋다

// 와.. 진짜 코드 깔끔하고
// 진짜 생각 깔끔하다!!!!
// 진짜...
// 어떻게 이런 코드를 짜지...
// 와.. 진짜 깔끔하다!!

/*
    같은 생각을 했는데, 코드 풀이가 다르다.
    어떤 차이에서 이렇게 됐을까
 */
fun anotherSolution(A: IntArray, B: IntArray): Int {

    var upFish =0
    var downFish = Stack<Int>()

    for (i in 0..(A.size-1)) {

        if(B[i]==0) {
            if(downFish.empty()){ //downFish가 없으므로 Upfish가 살았다.
                upFish ++
            }else{
                while(!downFish.empty()){   //downFish가 있으므로 강자를 판단하자.
                    if(downFish.peek() > A[i]){ //upFish가 죽었다
                        break
                    }else{
                        downFish.pop()   //downFish가 죽었다.
                    }
                }
                if(downFish.empty()){ //upFish가 살았다
                    upFish++
                }
            }
        } else {
            downFish.push(A[i])
        }

    }

    return upFish + downFish.size
}