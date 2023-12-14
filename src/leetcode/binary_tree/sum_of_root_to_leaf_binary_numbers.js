// https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */


/*
  위 문제를 bfs 로 탐색한 각 노드들을 2진수로 합쳐서
  최종 결과를 십진수로 변환하는 식으로 문제를 풀었다.

  하지만, 문제의 요구사항은 dfs로 가각 leaf 노드까지 탐색해서
  각 2진수를 10진수로 변환하고 합치는 것이었다.
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

const calcBit = function(val) {
  let num = 0;
  let digit = 0;
  for (let i = val.length - 1; i >= 0; i--) {
    console.log(Math.pow(2, digit), val[i])
    num += Math.pow(2, digit) * val[i];
    digit++;
  }
  return num;
};

var sumRootToLeaf = function(root) {
  let nums = [];
  let sum = 0;
  const searchTree = (node, bit) => {
    if (node.left === null && node.right === null) {
      nums.push(bit + node.val);
      return;
    }
    if (node.left) searchTree(node.left, bit + node.val);
    if (node.right) searchTree(node.right, bit + node.val);
  };

  searchTree(root, '')
  console.log(nums)

  for (let i = 0; i < nums.length; i++) {
    console.log(calcBit(nums[i]))
    sum += calcBit(nums[i]);
  }
  return sum;
};

// const root = new TreeNode(1);
// const node2 = new TreeNode(0);
// const node3 = new TreeNode(1);
// const node4 = new TreeNode(0);
// const node5 = new TreeNode(1);
// const node6 = new TreeNode(0);
// const node7 = new TreeNode(1);

// node2.left = node4;
// node2.right = node5;

// node3.left = node6;
// node3.right = node7;

// root.left = node2;
// root.right = node3;
// console.log(sumRootToLeaf(root));


const root = new TreeNode(1);
const node2 = new TreeNode(1);

root.left = node2;
console.log(sumRootToLeaf(root));
