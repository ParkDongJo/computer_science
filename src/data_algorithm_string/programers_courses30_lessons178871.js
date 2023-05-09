// https://school.programmers.co.kr/learn/courses/30/lessons/178871
/*
문제 설명
얀에서는 매년 달리기 경주가 열립니다. 해설진들은 선수들이 자기 바로 앞의 선수를 추월할 때 추월한 선수의 이름을 부릅니다. 예를 들어 1등부터 3등까지 "mumu", "soe", "poe" 선수들이 순서대로 달리고 있을 때, 해설진이 "soe"선수를 불렀다면 2등인 "soe" 선수가 1등인 "mumu" 선수를 추월했다는 것입니다. 즉 "soe" 선수가 1등, "mumu" 선수가 2등으로 바뀝니다.

선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 players와 해설진이 부른 이름을 담은 문자열 배열 callings가 매개변수로 주어질 때, 경주가 끝났을 때 선수들의 이름을 1등부터 등수 순서대로 배열에 담아 return 하는 solution 함수를 완성해주세요.

제한사항
5 ≤ players의 길이 ≤ 50,000
players[i]는 i번째 선수의 이름을 의미합니다.
players의 원소들은 알파벳 소문자로만 이루어져 있습니다.
players에는 중복된 값이 들어가 있지 않습니다.
3 ≤ players[i]의 길이 ≤ 10
2 ≤ callings의 길이 ≤ 1,000,000
callings는 players의 원소들로만 이루어져 있습니다.
경주 진행중 1등인 선수의 이름은 불리지 않습니다.

입출력 예
players	callings	result
["mumu", "soe", "poe", "kai", "mine"]	["kai", "kai", "mine", "mine"]	["mumu", "kai", "mine", "soe", "poe"]

입출력 예 설명
입출력 예 #1

4등인 "kai" 선수가 2번 추월하여 2등이 되고 앞서 3등, 2등인 "poe", "soe" 선수는 4등, 3등이 됩니다. 5등인 "mine" 선수가 2번 추월하여 4등, 3등인 "poe", "soe" 선수가 5등, 4등이 되고 경주가 끝납니다. 1등부터 배열에 담으면 ["mumu", "kai", "mine", "soe", "poe"]이 됩니다.
*/

// 첫번째 문제풀이 
// 일부 테스트 케이스 시간초과!
function solution(players, callings) {
    var answer = [...players];
    for (const calling of callings) {
        const index = answer.indexOf(calling);
        
        if (index < 1) continue;
        const temp = players[index - 1];
        players[index - 1] = calling;
        players[index] = temp;
    }

    return players;
}

// console.log(solution(["mumu", "soe", "poe", "kai", "mine"], ["kai", "kai", "mine", "mine"]));

/*
    ['a', 'b'] 배열을 {'a': 0, 'b': 1} 객체로 변환하는 함수 만들기
*/
function convertArrayToObj(array) {
    return array.reduce((acc, cur, index) => {
        acc[cur] = index;
        return acc;
    }, {});
}
function solution2(players, callings) {
    let answer = convertArrayToObj(players);
    for (const calling of callings) {
        const index = answer[calling];
        
        if (index < 1) continue;

        const temp = players[index - 1];
        players[index - 1] = calling;
        answer[calling] = index - 1;
        players[index] = temp;
        answer[temp] = index;
    }

    return players;
}
console.log(solution2(["mumu", "soe", "poe", "kai", "mine"], ["kai", "kai", "mine", "mine"]));

// 다른 사람의 풀이
// Map을 사용하여 풀이
const solution = (players, callings) => {
    const order = new Map(players.map((player, idx) => [player, idx]));
    callings.forEach((calling) => {
      const idx = order.get(calling);
      if (idx > 0) {
        const prevPlayer = players[idx - 1];
        players[idx - 1] = calling;
        players[idx] = prevPlayer;
        order.set(calling, idx - 1);
        order.set(prevPlayer, idx);
      }
    });
  
    return players;
};

// for 문으로 더 심플하게 풀이
function solution(players, callings) {
    const playerMap = {};
    for (let i = 0; i < players.length; i++) {
        playerMap[players[i]] = i;
    }

    for (let i = 0; i < callings.length; i++) {
        const idx = playerMap[callings[i]];
        const temp = players[idx-1];
        players[idx-1] = callings[i];
        players[idx] = temp;
        playerMap[callings[i]] = idx - 1;
        playerMap[temp] = idx;
    }

    return players;
}

// 첫 오답 풀이 접근의 문제점
/*
    문제에 보면 callings는 1,000,000 이하까지로 되어 있다. 이걸 O(n^2)으로 풀면 시간초과가 날 수 밖에 없다.
    그로므로 O(n)으로 풀려면, for을 병렬로 돌아서 처리해야한다.

    또한 for 문을 돌때 callings 에서 값을 빼오려면, key를 가지고 오는 방법이 있어야한다.
    그래야 데이터를 가져올때 O(1)로 가져올 수 있다.
*/