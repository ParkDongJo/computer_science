// https://school.programmers.co.kr/learn/courses/30/lessons/42885

function solution(people, limit) {
    // 구명 보트 수 최소값
    // 1개당 100kg 제한
    
    // 오름차순 정렬
    // 가장 작은 수와 가장 큰수 더해보기
    // -> 그다음 큰 수와 더해보기
    // -> 그다음 가장 작은 수와 그 다음 큰수와 더해보기
    // -> 매칭이 될 때마다 배열에서 제외
    // 남은 사람은 각자 1대씩 배 할당
    var answer = 0;
    let head = 0;
    let tail = people.length - 1; 
    
    people.sort((a, b) => a - b);
    
    while (head <= tail) {
        if (people[head] + people[tail] <= limit) {
            head++;
            tail--;
        } else {
            tail--;
        }
        answer++;
    }
    
    return answer;
}

// 다른 사람 풀이
function solution(people, limit) {
    let answer = 0
    people.sort((a, b) => a - b)
    let i = 0
    for(let length = people.length-1; i < length; length--) {
        if(people[i] + people[length] <= limit ) i++
    }    
    return people.length-i;
}
