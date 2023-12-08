// https://leetcode.com/problems/intersection-of-two-arrays/
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */

const compare = (arr1, arr2) => {
    const set = new Set();
    for (const n of arr1) {
        const idx = arr2.indexOf(n);
        if (idx !== -1) {
            set.add(n);
        }
    }
    return set;
}

var intersection = function(nums1, nums2) {
    if (nums1.length > nums2.length) {
        return Array.from(compare(nums1, nums2));
    }
    return Array.from(compare(nums2, nums1));
};

console.log(intersection([1,2,2,1], [2,2]))
console.log(intersection([4,9,5], [9,4,9,8,4]))
