// https://leetcode.com/problems/increasing-order-search-tree/
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
 * @return {TreeNode}
 */
function TreeNode(val, left, right) {
  this.val = (val===undefined ? 0 : val)
  this.left = (left===undefined ? null : left)
  this.right = (right===undefined ? null : right)
}
const searchTree = (node, arr) => {
  if (node === null) {
      return;
  }
  arr.push(node.val)
  searchTree(node.left, arr)
  searchTree(node.right, arr)

  return arr
}
var increasingBST = function(root) {
  const vals = searchTree(root, []);

  const sortedVals = vals.sort((a, b) => a - b);

  let tree = new TreeNode(sortedVals[0]);
  let current = tree;
  for (let i = 1; i < sortedVals.length; i++) {
    current.right = new TreeNode(sortedVals[i]);
    current = current.right;
  }
  return tree;
};

const root = new TreeNode(5);
root.left = new TreeNode(1);
root.right = new TreeNode(7);

console.log(increasingBST(root));
