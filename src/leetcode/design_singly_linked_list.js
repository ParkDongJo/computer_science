class Node {
  constructor(data, next = null) {
    this.data = data;
    this.next = next;
  }
}

class LinkedList {
  constructor() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  /**
   * @param {number} index
   * @return {number}
   */
  get(index) {
    let curr = this.head;
    let count = 0;

    while(curr) {
      if (count == index) {
        return curr.data;
      }
      count++;
      curr = curr.next;
    }
    return -1;
  }

  /**
   * @param {number} val
   * @return {void}
   */
  insertHead(val) {
    this.head = new Node(val, this.head);
    this.size++;
    return null;
  }

  /**
   * @param {number} val
   * @return {void}
   */
  insertTail(val) {
    let node = new Node(val);
    let curr;

    if (!this.head) {
      this.head = node;
    } else {
      curr = this.head;

      while (curr.next) {
        curr = curr.next;
      }
      curr.next = node;
    }
    return null;
  }

  /**
   * @param {number} index
   * @return {boolean}
   */
  remove(index) {
    if (index < 0 || index > this.size) {
      return false;
    }

    let curr = this.head;
    let prev;
    let count = 0;

    if (index == 0) {
      this.head = curr.next;
    } else {
      while (count < index) {
        count++;
        prev = curr;
        curr = curr.next;
      }
      prev.next = curr.next;
    }
    this.size--;
    return true;
  }

  /**
   * @return {number[]}
   */
  getValues() {
    let curr = this.head;
    let result = [];

    while(curr) {
      result.push(curr.data);
      curr = curr.next;
    }
    return result;
  }
}

const linkedList = new LinkedList();

console.log(linkedList.insertTail(1));
console.log(linkedList.insertTail(2));
console.log(linkedList.get(1));
console.log(linkedList.remove(1));
console.log(linkedList.insertTail(2));
console.log(linkedList.get(1));
console.log(linkedList.get(0));
console.log(linkedList.getValues());

