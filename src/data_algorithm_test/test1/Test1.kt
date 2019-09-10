package data_algorithm_test.test1

import kotlin.math.*
import java.lang.*


fun main(args: Array<String>) {
    println(solution("aabbaccc"))
    println(solution("ababcdcdababcdcd"))
    println(solution("abcabcdede"))
    println(solution("abcabcabcabcdededededede"))
    println(solution("xababcdcdababcdcd"))
}

fun solution(s: String): Int {
    if (s.isEmpty()) return 0

    var compressed = StringBuilder()
    var compCnt = 1
    var compTxt = ""
    var cursor = ""
    var minLen = s.length

    for (i in 1..(s.length/2)) {
        for (j in 0 until (s.length) step i) {
            try {
                cursor = s.substring(j,j+i)

                if (compTxt.length < i) {
                    compTxt = cursor
                } else {
                    if (compTxt == cursor) {
                        compCnt++
                    }

                    if (compTxt != cursor) {

                        appendTxt(compressed, compCnt, compTxt)
                        compCnt = 1
                        compTxt = cursor
                    }
                }

                if (j+i >= s.length) {
                    appendTxt(compressed, compCnt, cursor)
                }
            } catch (e: Exception) {
                appendTxt(compressed, compCnt, compTxt)
                compressed.append(_substring(s,j,s.length-1))
            }

        }
        compCnt = 1
        compTxt = ""
        minLen = min(minLen, compressed.length)
        compressed.delete(0,  compressed.length)
    }

    return minLen
}

fun appendTxt(sb: StringBuilder, cnt: Int, txt: String): StringBuilder {
    if(cnt > 1) sb.append(cnt)
    sb.append(txt)
    return sb
}

fun _substring(s: String, start: Int, end: Int): String {
    return if (start == end) s[start].toString() else s.substring(start..end)
}