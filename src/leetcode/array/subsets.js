/**
 * @param {number[]} nums
 * @return {number[][]}
 */
// https://ungodly-hour.tistory.com/52
// 풀이법을 봤다. 하지만 설명이 잘못되어 있어서 설명을 더하는 그림을 그려보았다.

/*
        [ ]
       / | \
    [1] [2] [3]
    |    |
    |  [2,3]
  / | \
[1,2] [1,3] [2,3]
  |
[1,2,3]
*/
var subsets = function (nums) {
  const result = [];
  const dfs = (start, visited) => {
    result.push(visited);
    for (let i = start; i < nums.length; i++) {
      dfs(i + 1, [...visited, nums[i]]);
    }
  };
  dfs(0, []);
  return result;
};

console.log(subsets([1, 2, 3]));
console.log(subsets([0]));
console.log(subsets([1, 2]));
