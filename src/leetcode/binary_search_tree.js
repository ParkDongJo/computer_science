class TreeNode {
  constructor(value, left, right) {
    this.value = (value===undefined ? 0 : value)
    this.left = (left===undefined ? null : left);
    this.right = (right===undefined ? null : right);
  }
}

class binarySearchTree {
  constructor() {
    this.root = null;
  }
  insert(value) {
    const newNode = new TreeNode(value);
    if (this.root == null) {
      this.root = newNode;
      return;
    }

    let currNode = this.root;
    while (currNode !== null) {
      if (currNode.value < value) {
        if (currNode.right === null) {
          currNode.right = newNode;
          break;
        }
        currNode = currNode.right
      } else {
        if (currNode.left === null) {
          currNode.left = newNode;
          break;
        }
        currNode = currNode.left;
      }
    }
  }

  has(value) {
    let currNode = this.root;
    while (currNode !== null) {
      if (currNode.value === value) {
        return true;
      }
      if (currNode.value < value) {
        currNode = currNode.right;
      } else {
        currNode = currNode.left;
      }
    }
    return false;
  }

  // tree 에 있는 모든 요소를 출력하는 함수
  print() {
    const queue = [this.root];
    while (queue.length > 0) {
      const currNode = queue.shift();
      if (currNode.left !== null) {
        queue.push(currNode.left);
      }
      if (currNode.right !== null) {
        queue.push(currNode.right);
      }
    }
    return queue;
  }
}

const tree = new binarySearchTree();
tree.insert(5);
tree.insert(4);
tree.insert(7);
tree.insert(8);
tree.insert(5);
tree.insert(6);
tree.insert(2);

// console.log(tree.has(8));
// console.log(tree.has(1));
console.log(tree.print());
