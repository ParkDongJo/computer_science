// https://leetcode.com/problems/maximum-subsequence-score/solutions/3557264/heap-python-js-solution/
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @param {number} k
 * @return {number}
 */
// var maxScore = function (nums1, nums2, k) {
//   // nums1
//   // nums2
//   // k = 2
//   // num1 기준으로 두개의 인덱스를 선택하는것
//   // num2 기준으로 두개의 인덱스를 선택하는것
//   // 비교해서 큰것을 뱉어낸다.

//   const cached = [];

//   for (let i = 0; i < nums1.length; i++) {
//     cached.push([nums1[i], nums2[i]]);
//   }

//   const sortedByNums1 = [...cached].sort((a, b) => b[0] - a[0]);
//   const sortedByNums2 = [...cached].sort((a, b) => b[1] - a[1]);

//   let resultByNums1 = 0;
//   for (let i = 0; i < k; i++) {
//     resultByNums1 += sortedByNums1[i][0];
//   }
//   let mins = [];
//   for (let i = 0; i < k; i++) {
//     mins.push(sortedByNums1[i][1]);
//   }
//   resultByNums1 *= Math.min(...mins);

//   let resultByNums2 = 0;
//   for (let i = 0; i < k; i++) {
//     resultByNums2 += sortedByNums2[i][0];
//   }
//   mins = [];
//   for (let i = 0; i < k; i++) {
//     mins.push(sortedByNums2[i][1]);
//   }
//   resultByNums2 *= Math.min(...mins);

//   return resultByNums1 > resultByNums2 ? resultByNums1 : resultByNums2;
// };

// 우선순위 큐를 사용한 풀이
//https://support.leetcode.com/hc/en-us/articles/360011833974-What-are-the-environments-for-the-programming-languages
// leetcode 에서는 우선순위 큐를 기본적으로 제공해주고 있다.
var maxScore = function (nums1, nums2, k) {
  // Create a reverse sorted array of [nums1(i), nums2(i)]
  const zip = nums1.map((x, i) => [x, nums2[i]]).sort((a, b) => b[1] - a[1]);
  let sum = 0,
    ans = 0;
  const pq = new MinPriorityQueue(); // Smallest element on top

  for (const [n1, n2] of zip) {
    // Insert element of nums1 in queue and also add to sum
    pq.enqueue(n1);
    sum += n1;

    // Now we get subsequence of k elements
    if (pq.size() === k) {
      ans = Math.max(ans, sum * n2); // Update our ans
      // Remove element from queue and also from sum
      sum -= pq.dequeue().element;
    }
  }

  return ans;
};

console.log(maxScore([1, 2, 3], [3, 2, 1], 3)); // 14
