//  https://leetcode.com/problems/fair-candy-swap/description/

/**
 * @param {number[]} aliceSizes
 * @param {number[]} bobSizes
 * @return {number[]}
 */

// 코파일럿이 푼 문제
var fairCandySwap = function(aliceSizes, bobSizes) {
    const sumA = aliceSizes.reduce((acc, cur) => acc + cur);
    const sumB = bobSizes.reduce((acc, cur) => acc + cur);
    const diff = (sumA - sumB) / 2;
    const setB = new Set(bobSizes);
    for (const a of aliceSizes) {
        if (setB.has(a - diff)) {
        return [a, a - diff];
        }
    }
    return [];
};

// 이진 탐색을 적용해서 푼 문제
var fairCandySwap = function(aliceSizes, bobSizes) {
    const sumA = aliceSizes.reduce((acc, cur) => acc + cur);
    const sumB = bobSizes.reduce((acc, cur) => acc + cur);
    const diff = (sumA - sumB) / 2;

    for (const a of aliceSizes) {
        const has = binarySearch(bobSizes.sort((a, b) => a - b), a - diff);
        console.log(bobSizes, diff, a - diff, has);
        if (has) {
            return [a, has];
        }
    }

    return [];
};

const binarySearch = (nums, target) => {
  const midIdx = parseInt(nums.length / 2)

  if (nums.length === 1) {
    return nums[0] === target ? nums[0] : null;
  }
  if (nums[midIdx] == target) {
    return nums[midIdx];
  } else if (nums[midIdx] > target) {
    return binarySearch(nums.slice(0, midIdx), target)
  } else if (nums[midIdx] < target) {
    
    return nums.length - 1 === midIdx 
      ? null
      : binarySearch(nums.slice(midIdx + 1), target)
  }
}

// console.log(fairCandySwap([1, 1], [2, 2])); // [1, 2]
// console.log(fairCandySwap([2], [1, 3])); // [2, 3]
// console.log(fairCandySwap([1,2,5], [2,4])); // [5, 4]
console.log(fairCandySwap([8,73,2,86,32], [56,5,67,100,31])); // [2,31]
