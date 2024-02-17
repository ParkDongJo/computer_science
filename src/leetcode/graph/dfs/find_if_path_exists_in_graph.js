// https://leetcode.com/problems/find-if-path-exists-in-graph/description/
/**
 * @param {number} n
 * @param {number[][]} edges
 * @param {number} source
 * @param {number} destination
 * @return {boolean}
 */
var validPath = function (n, edges, source, destination) {
  let graph = {};
  for (let i = 0; i < edges.length; i++) {
    let [a, b] = edges[i];
    if (!graph[a]) {
      graph[a] = [];
    }
    if (!graph[b]) {
      graph[b] = [];
    }
    graph[a].push(b);
    graph[b].push(a);
  }

  let visited = new Set();
  let stack = [source];
  while (stack.length) {
    let node = stack.pop();
    if (node === destination) {
      return true;
    }
    if (visited.has(node)) {
      continue;
    }
    visited.add(node);
    if (graph[node]) {
      stack.push(...graph[node]);
    }
  }
  return false;
};

// 코드 조합한 버전
// 603ms
var validPath = function (n, edges, source, destination) {
  let graph = new Map();
  let visited = new Set();

  // 그래프를 생성한다.
  /*
    { 
      0 => [ 1, 2 ],
      1 => [ 0, 2 ], 
      2 => [ 1, 0 ] 
    }
  */
  for (const [v, e] of edges) {
    if (!graph.has(v)) {
      graph.set(v, []);
    }
    if (!graph.has(e)) {
      graph.set(e, []);
    }
    graph.get(v).push(v);
    graph.get(e).push(e);
  }

  function dfs(v) {
    visited.add(v);

    const edges = graph.get(v);

    if (edges && edges.length > 0) {
      for (const e of edges) {
        if (!visited.has(e)) {
          dfs(e);
        }
      }
    }
  }
  dfs(start);

  return visited.has(end);
};

// 175ms
var validPath = function (n, edges, source, destination) {
  const map = {};
  for (let i = 0; i < n; i++) {
    map[i] = i;
  }

  const traverseToParent = (vertice) => {
    while (vertice != map[vertice]) {
      vertice = map[vertice];
    }
    return vertice;

    // let root = vertice;
    // while (root != map[root]) {
    //     root = map[root];
    // }

    // while (vertice != root) {
    //     next = map[vertice];
    //     map[vertice] = root;
    //     vertice = next;
    // }

    // return root;
  };

  edges.forEach(([v1, v2]) => {
    map[traverseToParent(v2)] = traverseToParent(v1);
  });

  return traverseToParent(source) == traverseToParent(destination);
};
