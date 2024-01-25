
/*
    0 과 1 로 이루어진 어떤 문자열 x에 대한 이진 변환을 다음과 같이 정의
    - x의 모든 0을 제거
    - x의 길이를 c라고 하면, x를 'c를 2진법으로 표현한 문자열로 변경' 
*/

function solution(s) {
    let count = 0;
    let zeroCount = 0;

    while (s !== '1') {
        let newS = '';
        for (const c of s) {
            if (c === '0') {
                zeroCount += 1;
            } else {
                newS += c;
            }
        }
        count += 1;
        s = newS.length.toString(2);
    }

    return [count, zeroCount];
}