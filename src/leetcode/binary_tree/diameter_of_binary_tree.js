// https://leetcode.com/problems/diameter-of-binary-tree/description/
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
 * @return {number}
 */

function TreeNode(val, left, right) {
  this.val = (val===undefined ? 0 : val)
  this.left = (left===undefined ? null : left)
  this.right = (right===undefined ? null : right)
}
var diameterOfBinaryTree = function(root) {
  let answer = [];

  const searchTree = (node) => {
    if (node === null) {
      return 0;
    }
    const left = searchTree(node.left) + (node.left ? 1 : 0);
    const right = searchTree(node.right) + (node.right ? 1 : 0);

    answer.push(left + right);

    return Math.max(left, right);
  };

  searchTree(root);

  return Math.max(...answer);
};


const root = new TreeNode(1);
const node2 = new TreeNode(2);
const node3 = new TreeNode(3);
const node4 = new TreeNode(4);
const node5 = new TreeNode(5);

node2.left = node4;
node2.right = node5;

root.left = node2;
root.right = node3;

console.log(diameterOfBinaryTree(root));
