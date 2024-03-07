// https://velog.io/@jiyaho/%EB%B0%B1%EC%A4%80-4963-%EC%84%AC%EC%9D%98-%EA%B0%9C%EC%88%98-Node.js-DFSBFS-%ED%92%80%EC%9D%B4


function solution(graph) {
    let answer = 0;
    let visited = Array.from(
                    { length: graph.length }, 
                    () => Array(graph[0].length).fill(false)
                );

    function dfs(x, y) {
        // 범위를 벗어났다면 return
        if (x < 0 || y < 0 || x >= graph.length || y >= graph[0].length) {
            return;
        }
        // 이미 방문했거나, 0이라면 return
        if (visited[x][y] || graph[x][y] === 0) {
            return;
        }

        visited[x][y] = true;

        // 상하좌우 탐색
        dfs(x - 1, y);
        dfs(x + 1, y);
        dfs(x, y - 1);
        dfs(x, y + 1);
    }

    for (let i = 0; i < graph.length; i++) {
        for (let j = 0; j < graph[i].length; j++) {
            if (!visited[i][j] && graph[i][j] === 1) {
                dfs(i, j);
                answer++;
            }
        }
    }
    
    return answer;
}


const inputs = [
    [1, 0, 1, 0, 0],
    [1, 0, 0, 0, 0],
    [1, 0, 1, 0, 1],
    [1, 0, 0, 1, 0],
];

const inputs2 = [
    [1, 1, 1, 0, 1],
    [1, 0, 1, 0, 1],
    [1, 0, 1, 0, 1],
    [1, 0, 1, 1, 1],
];

console.log(solution(inputs)) // 5
console.log(solution(inputs2)) // 1
