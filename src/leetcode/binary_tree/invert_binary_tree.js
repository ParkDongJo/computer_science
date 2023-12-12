// https://leetcode.com/problems/invert-binary-tree/
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
var invertTree = function(root) {
  if (root === null || (root.left === null && root.right === null)) {
      return root;
  }
  const left = invertTree(root.left);
  const right = invertTree(root.right);

  root.left = right;
  root.right = left;
  return root;
};

const root = new TreeNode(4);
const node2 = new TreeNode(2);
const node7 = new TreeNode(7);
const node1 = new TreeNode(1);
const node3 = new TreeNode(3);
const node6 = new TreeNode(6);
const node9 = new TreeNode(9);

node2.left = node1;
node2.right = node3;

node7.left = node6;
node7.right = node9;

root.left = node2;
root.right = node7;

console.log(invertTree(root));
