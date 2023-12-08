// https://leetcode.com/problems/count-complete-tree-nodes/

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */

function TreeNode(val, left, right) {
    this.val = (val===undefined ? 0 : val)
    this.left = (left===undefined ? null : left)
    this.right = (right===undefined ? null : right)
}
/**
 * @param {TreeNode} root
 * @return {number}
 */
const searchTree = (root) => {
    if (!root?.left && !root?.right) {
        return 1;
    }

    const left = root.left ? searchTree(root.left) : 0;
    const right = root.right ? searchTree(root.right) : 0;

    return left + right + 1; 
}
var countNodes = function(root) {
    if (!root?.val) {
        return 0;
    }
    return searchTree(root)
};

const root = new TreeNode(1)
const t2 = new TreeNode(2)
const t3 = new TreeNode(3)
const t4 = new TreeNode(4)
const t5 = new TreeNode(5)
const t6 = new TreeNode(6)

t2.left = t4
t2.right = t5
t3.left = t6
root.left = t2
root.right = t3

console.log(countNodes(root));
console.log(countNodes(new TreeNode(1)));
console.log(countNodes(new TreeNode()));
