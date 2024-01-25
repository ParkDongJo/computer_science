function bfs(graph, start, visited) {
    let queue = [start];
    visited[start] = true;
    while (queue.length > 0) {
        let v = queue.shift();
        console.log(v);
        for (let i of graph[v]) {
            if (!visited[i]) {
                queue.push(i);
                visited[i] = true;
            }
        }
    }
    return visited;
}

const graph = [
    [],
    [2, 3, 8],
    [1, 7],
    [1, 4, 5],
    [3, 5],
    [3, 4],
    [7],
    [2, 6, 8],
    [1, 7],
];
const visited = Array(graph.length).fill(false);

console.log(bfs(graph, 1, visited));
