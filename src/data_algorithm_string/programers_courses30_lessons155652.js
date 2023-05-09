// 문제 연습 : https://school.programmers.co.kr/learn/courses/30/lessons/155652
/*
두 문자열 s와 skip, 그리고 자연수 index가 주어질 때, 다음 규칙에 따라 문자열을 만들려 합니다. 암호의 규칙은 다음과 같습니다.

문자열 s의 각 알파벳을 index만큼 뒤의 알파벳으로 바꿔줍니다.
index만큼의 뒤의 알파벳이 z를 넘어갈 경우 다시 a로 돌아갑니다.
skip에 있는 알파벳은 제외하고 건너뜁니다.
예를 들어 s = "aukks", skip = "wbqd", index = 5일 때, a에서 5만큼 뒤에 있는 알파벳은 f지만 [b, c, d, e, f]에서 'b'와 'd'는 skip에 포함되므로 세지 않습니다. 따라서 'b', 'd'를 제외하고 'a'에서 5만큼 뒤에 있는 알파벳은 [c, e, f, g, h] 순서에 의해 'h'가 됩니다. 나머지 "ukks" 또한 위 규칙대로 바꾸면 "appy"가 되며 결과는 "happy"가 됩니다.

두 문자열 s와 skip, 그리고 자연수 index가 매개변수로 주어질 때 위 규칙대로 s를 변환한 결과를 return하도록 solution 함수를 완성해주세요.

제한사항
5 ≤ s의 길이 ≤ 50
1 ≤ skip의 길이 ≤ 10
s와 skip은 알파벳 소문자로만 이루어져 있습니다.
skip에 포함되는 알파벳은 s에 포함되지 않습니다.
1 ≤ index ≤ 20

입출력 예
s	skip	index	result
"aukks"	"wbqd"	5	"happy"

입출력 예 설명
입출력 예 #1
본문 내용과 일치합니다.
*/


// 첫 풀이 코드
function solution(s, skip, index) {
    var answer = '';
    const skipArr = skip.split('').sort();

    for(const char of s) {
        let currChar = char.charCodeAt(0);
        let pointer = 0;
        let count = 0;

        while(count < index) {
            if (!skipArr.includes(String.fromCharCode(currChar))) {
                count += 1;
            }
            currChar += 1;
            if (currChar > 122) {
                currChar = 97;
            }
        }

        answer += String.fromCharCode(currChar);
    }
    return answer;
}
// console.log(solution('aukks', 'wbqd', 5));

console.log(solution('aaaaa', 'wxyz', 20));


// gpt 에게 물어본 내 풀이의 문제점
/*
주어진 코드를 살펴보니, 문자열 s의 각 문자에 대해 반복문을 수행하며 index만큼의 알파벳으로 변환하는 로직이 있습니다.
하지만 문제에서 주어진 규칙에 따라 건너뛰어야 하는 문자열 skip을 처리하지 않고 있습니다.
skip의 각 알파벳을 처리하는 부분이 빠져있어서 제대로 된 결과가 나오지 않을 수 있습니다. 
예를 들어, skip이 "wxyz"이고 index가 5라면, a는 f로 바뀌어야 합니다. 
그러나 주어진 코드에서는 w만 건너뛰고 x, y, z는 처리하지 않고 넘어가기 때문에 a는 h로 바뀌게 됩니다. 
따라서 skip의 각 알파벳을 처리하는 부분도 적절히 추가해주어야 합니다.

또한, 주어진 제한 사항 중 하나인 "1 ≤ index ≤ 20"을 고려하여 index가 26을 초과하는 경우를 처리해주어야 합니다. 
이 경우에는 알파벳을 뒤로 이동하는 것이 의미가 없으므로, index를 26으로 나눈 나머지만큼만 이동하도록 수정해야 합니다.

이러한 부분들을 고려하여 코드를 수정하면 문제를 해결할 수 있을 것입니다.

*/


// 두번째 풀이 방법
function solution(s, skip, index) {
    var answer = '';
    // chars 는 a-z 까지의 문제열이다. skip 에 해당하는 문자열을 제외시킨다.
    const chars = [];
    for(let i = 97; i <= 122; i++) {
        if (!skip.includes(String.fromCharCode(i))) {
            chars.push(String.fromCharCode(i));
        }
    }

    for(let i = 0; i < s.length; i++) {
        const char = s[i];
        const charIndex = chars.indexOf(char)
        const newIndex = charIndex + index;
        if (newIndex >= chars.length) {
            answer += chars[newIndex % chars.length];
        } else {
            answer += chars[newIndex];
        }
    }

    return answer;
}

// 첫 오답 풀이 접근의 문제점
/*
    제외시켜야할 문자를 포인터가 돌때마다 갯수를 세어서 index 만큼의 문자를 건너뛰는 방식으로 접근했어야 했다.
    하지만 첫 풀이 방식은 index 만큼의 문자를 건너뛰는 방식이 아니라, index 만큼의 문자를 건너뛰고, 건너뛰어야할 문자를 제외시키는 방식으로 접근했다.
*/