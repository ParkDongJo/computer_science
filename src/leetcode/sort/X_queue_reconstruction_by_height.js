// https://leetcode.com/problems/queue-reconstruction-by-height/description/

/**
 * @param {number[][]} people
 * @return {number[][]}
 */
// 못 풀었음
var reconstructQueue = function(people) {
    // 정렬 가장 큰순
    // [[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]
    // [6,1] -> 1 확인
    // 앞쪽으로 돌면서, 큰수 갯수 세기
    // - count - k 만큼 앞으로 이동

    // [[7,0],[6,1],[7,1],[5,0],[5,2],[4,4]]

    people.sort((a, b) => b[0] - a[0] || a[1] - b[1]);
    const results = [...people];
    
    let count = 0;
    let left = 0;
    for (let i = 0; i < people.length; i++) {
        left = i;
        count = 0;

        while (left >= 0) {
            if (people[i][0] <= people[left][0]) {
                count++;
            }
            left--;
        }
        console.log(i, count)
        let temp = results[i - count];
        results[i - count] = people[i];
        results[i] = temp;
    }

    console.log(results)
};

// 남의 풀이
const reconstructQueue = people => {
    const res = []
	// sort by height desc, k asc
    const sortedPeople = people.sort(([h1, k1], [h2, k2]) => h1 === h2 ? k1 - k2 : h2 - h1)
    
    // insert each person at their k index
    for (const [height, k] of sortedPeople) {
        res.splice(k, 0, [height, k])
    }
    
    return res
}