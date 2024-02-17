// https://leetcode.com/problems/range-sum-of-bst/submissions/1177807521/
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} low
 * @param {number} high
 * @return {number}
 */
var rangeSumBST = function (root, low, high) {
  let sum = 0;
  function dfs(v) {
    if (!v) {
      return;
    }
    if (v.val < low) {
      dfs(v.right);
      return;
    }
    if (v.val > high) {
      dfs(v.left);
      return;
    }

    sum += v.val;
    dfs(v.left);
    dfs(v.right);
  }
  dfs(root);

  return sum;
};

// 87ms
// 동일한 문제지만, BST 로 문제를 푸는 것이 훨씬 효율이 좋고 깔끔하다.
var rangeSumBST = function (root, low, high) {
  if (root === null) {
    return 0;
  }

  if (low <= root.val && root.val <= high) {
    return (
      root.val +
      rangeSumBST(root.left, low, high) +
      rangeSumBST(root.right, low, high)
    );
  } else if (root.val < low) {
    return rangeSumBST(root.right, low, high);
  } else {
    return rangeSumBST(root.left, low, high);
  }
};
