class TreeNode {
  constructor(value, left, right) {
    this.value = (value===undefined ? 0 : value)
    this.left = (left===undefined ? null : left);
    this.right = (right===undefined ? null : right);
  }
}
const sortedBTC = (nums) => {
  if (nums.length === 0) {
    return null;
  }

  const mid = Math.floor(nums.length / 2);
  const root = new TreeNode(nums[mid]);
  const q = [[root, [0, mid - 1]], [root, [mid + 1, nums.length -1]]];

  while (q.length > 0) {
    const [parent, [left, right]] = q.shift();

    if (left <= right && parent !== null) {
      const mid = Math.floor((left + right) / 2);
      const child = new TreeNode(nums[mid]);

      if (nums[mid] < parent.val) {
        parent.left = child;
      } else {
        parent.right = child;
      }

      q.push([child, [left, mid - 1]]);
      q.push([child, [mid + 1, right]]);
    }
  }
  return root;
}
const printBTC = (root) => {
  if (root === null) {
    return;
  }
  console.log(root.value);
  printBTC(root.left);
  printBTC(root.right);
}
var sortedArrayToBST = function(nums) {
  const root = sortedBTC(nums)
  printBTC(root);
};

console.log(sortedArrayToBST([-10,-3,0,5,9]))