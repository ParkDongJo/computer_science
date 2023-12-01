class MinHeap {
  constructor() {
      this.heap = [null];
  }

  push(value) {
      this.heap.push(value);
      let currentIndex = this.heap.length - 1;
      let parentIndex = Math.floor(currentIndex / 2);

      while (parentIndex !== 0 && this.heap[parentIndex].cost > value.cost) {
          this._swap(parentIndex, currentIndex)

          currentIndex = parentIndex;
          parentIndex = Math.floor(currentIndex / 2);
      }
  }

  pop() {
      if (this.isEmpty()) return;
      if (this.heap.length === 2) return this.heap.pop();

      const returnValue = this.heap[1];
      this.heap[1] = this.heap.pop();

      let currentIndex  = 1;
      let leftIndex = 2;
      let rightIndex = 3;
      while ((this.heap[leftIndex] && this.heap[currentIndex].cost > this.heap[leftIndex].cost) || 
             (this.heap[rightIndex] && this.heap[currentIndex].cost > this.heap[rightIndex].cost)) {
          if (this.heap[leftIndex] === undefined) { // 왼쪽 정점이 없을 경우
              this._swap(rightIndex, currentIndex)
          } else if (this.heap[rightIndex] === undefined) { // 오른쪽 정점이 없을 경우
              this._swap(leftIndex, currentIndex)
          } else if (this.heap[leftIndex].cost > this.heap[rightIndex].cost) {
              this._swap(rightIndex, currentIndex)
          } else if (this.heap[leftIndex].cost <= this.heap[rightIndex].cost) {
              this._swap(leftIndex, currentIndex)
          }
          leftIndex = currentIndex * 2;
          rightIndex = currentIndex * 2 + 1;
      }

      return returnValue;
  }

  isEmpty() {
      return this.heap.length === 1;
  }

  _swap(a, b) { // 편의를 위해 배열의 요소를 swap하는 함수 작성
      [this.heap[a], this.heap[b]] = [this.heap[b], this.heap[a]];
  }
}

function dijkstra(cost, start) {
  const heap = new MinHeap(); // 우선순위 큐(힙)
  heap.push({ node: start, cost: cost[start] }) // 1번 마을부터 시작

  const dist = [...Array(N + 1)].map(() => Infinity); // 계산하기 편하도록 N+1 길이만큼 리스트 생성
  dist[1] = 0; // 1번 마을은 무조건 거리가 0

  while (!heap.isEmpty()) { // heap이 비어있지 않다면
      // cost가 가장 낮은 정점을 뽑는다.
      const { node: current, cost: currentCost } = heap.pop();

      for (let i = 0; i < cost.length; i++) { // 루프를 돌며 시작점, 도착점, 비용을 꺼낸다
        const dist = i
        if (dist == current && nextCost < dist) {
          heap.push({ node: dist, cost: cost[dist] + currentCost })
        }
      }
  }

  return dist; // 1번 마을부터 각 마을까지의 최단 거리
}

/**
 * @param {number[]} cost
 * @return {number}
 */
var minCostClimbingStairs = function(cost) {
  const dist = dijkstra(cost, cost.length - 1);
  return dist;
};

console.log(minCostClimbingStairs([10,15,20]))
