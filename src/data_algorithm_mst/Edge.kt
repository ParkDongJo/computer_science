package data_algorithm_mst

class Edge {
    var start: Int
    var end: Int
    var weight: Int

    constructor(s: Int, e: Int,  w: Int) {
        this.start = s
        this.end = e
        this.weight = w
    }
}