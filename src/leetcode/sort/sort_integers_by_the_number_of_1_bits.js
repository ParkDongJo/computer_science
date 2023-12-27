// https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
/**
 * @param {number[]} arr
 * @return {number[]}
 */
function createBitMap(arr) {
  const map = {};
  for (let i = 0; i < arr.length; i++) {
      map[arr[i]] = arr[i].toString(2).replaceAll('0', '').split('').length;
  }
  return map;
}
var sortByBits = function(arr) {
  const map = createBitMap(arr);
  const sortedMap = [...Object.entries(map)].sort((a, b) => a[1] - b[1]);
  return sortedMap.map(([k, _]) => Number(k));
};

// console.log(sortByBits([0,1,2,3,4,5,6,7,8]));
console.log(sortByBits([10000,10000]));