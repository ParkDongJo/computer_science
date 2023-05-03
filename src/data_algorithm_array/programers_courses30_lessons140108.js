/*
문자열 s가 입력되었을 때 다음 규칙을 따라서 이 문자열을 여러 문자열로 분해하려고 합니다.

먼저 첫 글자를 읽습니다. 이 글자를 x라고 합시다.
이제 이 문자열을 왼쪽에서 오른쪽으로 읽어나가면서, x와 x가 아닌 다른 글자들이 나온 횟수를 각각 셉니다. 처음으로 두 횟수가 같아지는 순간 멈추고, 지금까지 읽은 문자열을 분리합니다.
s에서 분리한 문자열을 빼고 남은 부분에 대해서 이 과정을 반복합니다. 남은 부분이 없다면 종료합니다.
만약 두 횟수가 다른 상태에서 더 이상 읽을 글자가 없다면, 역시 지금까지 읽은 문자열을 분리하고, 종료합니다.
문자열 s가 매개변수로 주어질 때, 위 과정과 같이 문자열들로 분해하고, 분해한 문자열의 개수를 return 하는 함수 solution을 완성하세요.


제한사항
1 ≤ s의 길이 ≤ 10,000
s는 영어 소문자로만 이루어져 있습니다.

입출력 예
s	result
"banana"	3
"abracadabra"	6
"aaabbaccccabba"	3

입출력 예 설명
입출력 예 #1
s="banana"인 경우 ba - na - na와 같이 분해됩니다.

입출력 예 #2
s="abracadabra"인 경우 ab - ra - ca - da - br - a와 같이 분해됩니다.

입출력 예 #3
s="aaabbaccccabba"인 경우 aaabbacc - ccab - ba와 같이 분해됩니다.
*/

function solution(s) {
    // 1차 반복문을 돈다, 각 인덱스에 해당하는 글자를 추출한다.
    // 추출한 문자는 pointer에 저장한다.
    // pointer와 같은 문자가 나오면, count를 증가시킨다.
    // pointer와 다른 문자가 나오면, diffCount를 증가시킨다.
    // diffCount가 count보다 커지면, pointer를 바꾼다.
    // pointer를 바꾸면, count와 diffCount를 초기화한다.
    // pointer를 바꾸면, answer를 증가시킨다.
    let answer = 0;
    let pointer = s[0]
    let count = 1;
    let diffCount = 0;

    for(let i = 1; i < s.length; i++) {
        if (diffCount === count) {
            answer++;
            pointer = s[i];
            count = 1;
            diffCount = 0;
        } else {
            pointer === s[i] ? count++ : diffCount++;
        }
    }

    return answer + 1;
}

console.log(solution('banana'))
console.log(solution('abracadabra'))
console.log(solution('aaabbaccccabba'))


// 다른 사람의 풀이
// https://school.programmers.co.kr/learn/courses/30/lessons/140108/solution_groups?language=javascript
// 재귀로 푼 코드
function solution(s, count=0) {
    if(!s) return count
    let [first, ...rest] = s.split("")
    let countSame = 1
    let countInSame = 0
    let i=0
    for(; i<rest.length; i++){
        if(rest[i] === first) countSame++
        else countInSame++
        if(countSame === countInSame) break
    }
    return solution(rest.slice(i+1).join(""), count+1)
}

// 짧은 코드
function solution(s) {
    let tar = '';
    let cnt = ans = 0;
    for (let c of s) {
        if (!tar) tar = c;
        cnt += tar === c ? 1 : -1;
        if (!cnt) tar = '', ans++;
    }
    return !!cnt+ans;
}
