// https://school.programmers.co.kr/learn/courses/30/lessons/12948

function solution(phone_number) {
    var answer = '';
    for (let i = 0; i < phone_number.length; i++) {
        if (i < phone_number.length - 4) {
            answer += "*"
        } else {
            answer += phone_number[i];
        }
    }
    
    return answer;
}