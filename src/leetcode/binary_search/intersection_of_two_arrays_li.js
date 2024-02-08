// https://leetcode.com/problems/intersection-of-two-arrays-ii/
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersect = function (nums1, nums2) {
  const answer = [];
  nums2.sort((a, b) => a - b);
  for (let i = 0; i < nums1.length; i++) {
    const t = binary_search(nums2, 0, nums2.length - 1, nums1[i]);
    if (t) {
      answer.push(nums1[i]);
    }
  }
  return answer;
};

function binary_search(nums, s, e, target) {
  if (s > e) {
    return false;
  }
  const m = Math.floor((s + e) / 2);

  if (nums[m] === target) {
    // 이 부분이 핵심!!
    nums.splice(m, 1);
    return true;
  } else if (nums[m] > target) {
    return binary_search(nums, s, m - 1, target);
  } else {
    return binary_search(nums, m + 1, e, target);
  }
}

// console.log(intersect([1, 2, 2, 1], [2, 2])); // [2, 2]
// console.log(intersect([4, 9, 5], [9, 4, 9, 8, 4])); // [4, 9]
// console.log(intersect([4, 4, 9, 5, 9], [9, 4, 9, 8, 4])); // [4, 4, 9]

// console.log(
//   intersect(
//     [80, 80, 80],
//     [
//       1, 39, 6, 81, 85, 10, 38, 22, 0, 89, 57, 93, 58, 69, 65, 80, 84, 24, 27,
//       54, 37, 36, 26, 88, 2, 7, 24, 36, 51, 5, 74, 57, 45, 56, 55, 67, 25, 33,
//       78, 49, 16, 79, 74, 80, 36, 27, 89, 49, 64, 73, 96, 60, 92, 31, 98, 72,
//       22, 31, 0, 93, 70, 87, 80, 66, 75, 69, 81, 52, 94, 90, 51, 90, 74, 36, 58,
//       38, 50, 9, 64, 55, 4, 21, 49, 60, 65, 47, 67, 8, 38, 83,
//     ]
//   )
// ); // [80, 80, 80]

console.log(
  intersect(
    [
      61, 24, 20, 58, 95, 53, 17, 32, 45, 85, 70, 20, 83, 62, 35, 89, 5, 95, 12,
      86, 58, 77, 30, 64, 46, 13, 5, 92, 67, 40, 20, 38, 31, 18, 89, 85, 7, 30,
      67, 34, 62, 35, 47, 98, 3, 41, 53, 26, 66, 40, 54, 44, 57, 46, 70, 60, 4,
      63, 82, 42, 65, 59, 17, 98, 29, 72, 1, 96, 82, 66, 98, 6, 92, 31, 43, 81,
      88, 60, 10, 55, 66, 82, 0, 79, 11, 81,
    ],
    [
      5, 25, 4, 39, 57, 49, 93, 79, 7, 8, 49, 89, 2, 7, 73, 88, 45, 15, 34, 92,
      84, 38, 85, 34, 16, 6, 99, 0, 2, 36, 68, 52, 73, 50, 77, 44, 61, 48,
    ]
  )
);
