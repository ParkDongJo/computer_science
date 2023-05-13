// https://school.programmers.co.kr/learn/courses/30/lessons/160586
/*
문제 설명
휴대폰의 자판은 컴퓨터 키보드 자판과는 다르게 하나의 키에 여러 개의 문자가 할당될 수 있습니다. 키 하나에 여러 문자가 할당된 경우, 동일한 키를 연속해서 빠르게 누르면 할당된 순서대로 문자가 바뀝니다.
예를 들어, 1번 키에 "A", "B", "C" 순서대로 문자가 할당되어 있다면 1번 키를 한 번 누르면 "A", 두 번 누르면 "B", 세 번 누르면 "C"가 되는 식입니다.
같은 규칙을 적용해 아무렇게나 만든 휴대폰 자판이 있습니다. 이 휴대폰 자판은 키의 개수가 1개부터 최대 100개까지 있을 수 있으며, 특정 키를 눌렀을 때 입력되는 문자들도 무작위로 배열되어 있습니다. 또, 같은 문자가 자판 전체에 여러 번 할당된 경우도 있고, 키 하나에 같은 문자가 여러 번 할당된 경우도 있습니다. 심지어 아예 할당되지 않은 경우도 있습니다. 따라서 몇몇 문자열은 작성할 수 없을 수도 있습니다.
이 휴대폰 자판을 이용해 특정 문자열을 작성할 때, 키를 최소 몇 번 눌러야 그 문자열을 작성할 수 있는지 알아보고자 합니다.
1번 키부터 차례대로 할당된 문자들이 순서대로 담긴 문자열배열 keymap과 입력하려는 문자열들이 담긴 문자열 배열 targets가 주어질 때, 각 문자열을 작성하기 위해 키를 최소 몇 번씩 눌러야 하는지 순서대로 배열에 담아 return 하는 solution 함수를 완성해 주세요.
단, 목표 문자열을 작성할 수 없을 때는 -1을 저장합니다.

제한사항
1 ≤ keymap의 길이 ≤ 100
1 ≤ keymap의 원소의 길이 ≤ 100
keymap[i]는 i + 1번 키를 눌렀을 때 순서대로 바뀌는 문자를 의미합니다.
예를 들어 keymap[0] = "ABACD" 인 경우 1번 키를 한 번 누르면 A, 두 번 누르면 B, 세 번 누르면 A 가 됩니다.
keymap의 원소의 길이는 서로 다를 수 있습니다.
keymap의 원소는 알파벳 대문자로만 이루어져 있습니다.
1 ≤ targets의 길이 ≤ 100
1 ≤ targets의 원소의 길이 ≤ 100
targets의 원소는 알파벳 대문자로만 이루어져 있습니다.

입출력 예
keymap	targets	result
["ABACD", "BCEFD"]	["ABCD","AABB"]	[9, 4]
["AA"]	["B"]	[-1]
["AGZ", "BSSS"]	["ASA","BGZ"]	[4, 6]

입출력 예 설명
입출력 예 #1

"ABCD"의 경우,
1번 키 한 번 → A
2번 키 한 번 → B
2번 키 두 번 → C
1번 키 다섯 번 → D
따라서 총합인 9를 첫 번째 인덱스에 저장합니다.
"AABB"의 경우,
1번 키 한 번 → A
1번 키 한 번 → A
2번 키 한 번 → B
2번 키 한 번 → B
따라서 총합인 4를 두 번째 인덱스에 저장합니다.
결과적으로 [9,4]를 return 합니다.

입출력 예 #2

"B"의 경우, 'B'가 어디에도 존재하지 않기 때문에 -1을 첫 번째 인덱스에 저장합니다.
결과적으로 [-1]을 return 합니다.
입출력 예 #3

"ASA"의 경우,
1번 키 한 번 → A
2번 키 두 번 → S
1번 키 한 번 → A
따라서 총합인 4를 첫 번째 인덱스에 저장합니다.
"BGZ"의 경우,
2번 키 한 번 → B
1번 키 두 번 → G
1번 키 세 번 → Z
따라서 총합인 6을 두 번째 인덱스에 저장합니다.
결과적으로 [4, 6]을 return 합니다.
*/

function solution(keymap, targets) {
    var answer = [];

    // targets을 순회하면서 각각의 target을 꺼낸다.
    // 그 안에서 keymap을 순회하면서 각각의 keymap을 꺼낸다.
    // 꺼낸 keymap에서 find() 함수를 통해 target이 있는 최초 index를 구한다.
    // 꺼낸 index는 구했을 때 마다, 최소값 변수에 저장한다. 이때 저장 조건은 이미 저장되어 있는 값보다 작을때만 저장한다.
    // keymap을 다 순회하면, 최소값 변수를 answer에 더한다.

    targets.forEach(target => {
        let count = 0;
        const targetArr = target.split('')
        for(const char of targetArr) {
            let min = 100;
            keymap.forEach(key => {
                let index = key.indexOf(char);
                if (index !== -1) {
                    min = Math.min(min, index + 1);
                }
            })

            if (min === 100) {
                count = -1;
            } else if (count >= 0) {
                count += min
            }
        }
        answer.push(count);
    })

    return answer;
}

// console.log(solution(["ABACD", "BCEFD"], ["ABCD", "AABB"]));
console.log(solution(["AA"], ["BA"]));
console.log(solution(["AGZ", "BSSS"], ["ASA", "BGZ"]));

// 다른 사람 풀이
// reduce 로 훨씬 깔끔하게 푼 케이스
// 게다가 O(n^2)으로 풀었음
function solution(keymap, targets) {
    const answer = [];
    const map = {}
    for (const items of keymap) {
        items.split('').map((item, index) => map[item] = (map[item] < index+1 ? map[item] : index+1))
    }
    for (const items of targets) {
        answer.push(items.split('').reduce((cur, item) => cur += map[item], 0) || -1)
    }
    return answer;
}

// 첫 오답 풀이 접근의 문제점
// 문제의 접근은 옳았으나 [-1]을 return 에 대한 처리에 대해 경우의 수를 생각하지 못함
// 이후 바로 수정하여 통과 했지만, 다른 사람의 풀이를 보니 reduce를 사용하여 훨씬 깔끔하게 풀었음
// 코드의 성능도 떨어진다.