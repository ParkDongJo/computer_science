// https://leetcode.com/problems/find-the-distance-value-between-two-arrays/

/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @param {number} d
 * @return {number}
 */
var findTheDistanceValue = function(arr1, arr2, d) {
  let distance = arr1.length;
  // arr2.sort((a, b) => a - b);
  for(let i = 0; i < arr1.length; i++) {
      for (let j = 0; j < arr2.length; j++) {
        if (Math.abs(arr1[i] - arr2[j]) <= d) {
          distance--;
          break;
        }
      }
  }
  return distance;
};



console.log(findTheDistanceValue([4,5,8], [10,9,1,8], 2));
console.log(findTheDistanceValue([1,4,2,3], [-4,-3,6,10,20,30], 3));
