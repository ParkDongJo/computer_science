// https://leetcode.com/problems/find-center-of-star-graph/
/**
 * @param {number[][]} edges
 * @return {number}
 */
var findCenter = function(edges) {
    let graph = [];
    for (let i = 0; i < edges.length; i++) {
        const [u, v] = edges[i];
        
        if (graph[u]) {
            graph[u].push(v);
        } else {
            graph[u] = [v];
        }

        if (graph[v]) {
            graph[v].push(u);
        } else {
            graph[v] = [u];
        }
    }

    let center = {
        node: 0,
        len: 0,
    };
    for (let i = 1; i < graph.length; i++) {
        if (graph[i].length > center.len) {
            center.node = i;
            center.len = graph[i].length;
        }
    }

    return center.node;
};

// 다른 사람이 푼 풀이
/**
 * @param {number[][]} edges
 * @return {number}
 */
var findCenter = function(edges) {
    star=edges[0][0]
    for(let i=1;i<edges.length;i++){
        if(!edges[i].includes(star)){
            return edges[0][1]
        }
    }
    return star
};


/**
 * @param {number[][]} edges
 * @return {number}
 */
var findCenter = function(edges) {
    let set=new Set(edges[1])
    return set.has(edges[0][0])?edges[0][0]:edges[0][1]
};