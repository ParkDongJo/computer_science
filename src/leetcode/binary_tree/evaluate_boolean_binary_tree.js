// https://leetcode.com/problems/evaluate-boolean-binary-tree/
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
 * @return {boolean}
 */
var evaluateTree = function(root) {
  if (root.val === 0 || root.val === 1) {
      return root.val;
  }
  const leftVal = evaluateTree(root.left);
  const rightVal = evaluateTree(root.right);

  return {
      2: leftVal || rightVal,
      3: leftVal && rightVal,
  }[root.val]
};
