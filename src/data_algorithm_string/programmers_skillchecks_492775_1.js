//  https://programmers.co.kr/skill_checks/492775 1번 문제
/*

자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

제한 조건
n은 10,000,000,000이하인 자연수입니다.
입출력 예
n	return
12345	[5,4,3,2,1]
*/
function solution(n) {
    // n을 배열로 만들고, 그 배열을 역순화 한다.
    const arr = Array.from(n.toString())
    console.log(arr);
    return arr.reverse().map(v => parseInt(v));
}
console.log(solution(12345));
