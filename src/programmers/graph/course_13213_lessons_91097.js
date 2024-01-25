// https://school.programmers.co.kr/learn/courses/13213/lessons/91097?language=javascript

class Queue {
    constructor() {
        this.queue = [];
        this.front = 0;
        this.rear = 0;
    }
    enqueue(value) {
        this.queue[this.rear++] = value;
    }
    dequeue() {
        const value = this.queue[this.front];
        delete this.queue[this.front++];
    }
    isEmpty() {
        return this.front === this.rear;
    }
}

function solution(n, edge) {
    var answer = 0;
    const graph = Array.from(Array(n + 1), () => []);

    for (const [src, dest] of edge) {
        graph[src].push(dest);
        graph[dest].push(src);
    }

    const distance = Array(n + 1).fill(0);
    distance[1] = 1;
    // console.log(graph);

    const queue = [1];
    while (queue.length > 0) {
        const src = queue.shift();
        for (const dest of graph[src]) {
            if (distance[dest] === 0) {
                queue.push(dest);
                distance[dest] = distance[src] + 1;
            }
        }
    }
    // console.log(distance);
    const max = Math.max(...distance);
    return distance.filter((d) => d === max).length;
}

console.log(solution(6, [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]));

function solution2(n, edge) {
    var answer = 0;
    const graph = Array.from(Array(n + 1), () => []);

    for (const [src, dest] of edge) {
        graph[src].push(dest);
        graph[dest].push(src);
    }

    const distance = Array(n + 1).fill(0);
    distance[1] = 1;
    // console.log(graph);

    const queue = new Queue();
    while (!queue.isEmpty()) {
        const src = queue.dequeue();
        for (const dest of graph[src]) {
            if (distance[dest] === 0) {
                queue.enqueue(dest);
                distance[dest] = distance[src] + 1;
            }
        }
    }
    // console.log(distance);
    const max = Math.max(...distance);
    return distance.filter((d) => d === max).length;
}