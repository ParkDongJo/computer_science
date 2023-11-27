/**
 * @param {number} k
 */
var MyCircularDeque = function(k) {
    this.size = k;
    this.arr = new Array(this.size);
    this.front = -1;
    this.rear = 0;
};

/** 
 * @param {number} value
 * @return {boolean}
 */
MyCircularDeque.prototype.insertFront = function(value) {
  if (this.isFull()) {
    return false;
  }

  if (this.front == -1) {
    this.front = 0;
    this.rear = 0;
  } else if (this.front == 0) {
    this.front = this.size - 1;
  } else {
    this.front = this.front - 1;
  }
  this.arr[this.front] = value;
  return true;
};

/** 
 * @param {number} value
 * @return {boolean}
 */
MyCircularDeque.prototype.insertLast = function(value) {
    if (this.isFull()) {
      return false;
    }

    if (this.front == -1) {
      this.front = 0;
      this.rear = 0;
    } else if (this.rear == this.size -1) {
      this.rear = 0;
    } else {
      this.rear = this.rear + 1;
    }
    this.arr[this.rear] = value;
    return true;
};

/**
 * @return {boolean}
 */
MyCircularDeque.prototype.deleteFront = function() {
    if (this.isEmpty()) {
      return false;
    }
    if (this.front == this.rear) {
      this.front = -1;
      this.rear = -1;
      return true;
    } else {
      if (this.front == this.size - 1) {
        this.front = 0;
        return true;
      } else {
        this.front = this.front + 1;
        return true;
      }
    }
    return false;
};

/**
 * @return {boolean}
 */
MyCircularDeque.prototype.deleteLast = function() {
  if (this.isEmpty()) {
    return false;
  }
  if (this.front == this.rear) {
    this.front = -1;
    this.rear = -1;
    return true;
  } else if (this.rear == 0) {
    this.rear = this.size - 1;
    return true;
  } else {
    this.rear = this.rear - 1;
    return true;
  }
  return false;
};

/**
 * @return {number}
 */
MyCircularDeque.prototype.getFront = function() {
  if (this.isEmpty()) {
    return -1;
  }
  return this.arr[this.front];
};

/**
 * @return {number}
 */
MyCircularDeque.prototype.getRear = function() {
    if (this.isEmpty() || this.rear < 0) {
      return -1;
    }
    return this.arr[this.rear];
};

/**
 * @return {boolean}
 */
MyCircularDeque.prototype.isEmpty = function() {
    return (this.front == -1)
};

/**
 * @return {boolean}
 */
MyCircularDeque.prototype.isFull = function() {
    return (this.front == 0 && this.rear == this.size - 1) || this.front == this.rear + 1
};

/** 
 * Your MyCircularDeque object will be instantiated and called as such:
 * var obj = new MyCircularDeque(k)
 * var param_1 = obj.insertFront(value)
 * var param_2 = obj.insertLast(value)
 * var param_3 = obj.deleteFront()
 * var param_4 = obj.deleteLast()
 * var param_5 = obj.getFront()
 * var param_6 = obj.getRear()
 * var param_7 = obj.isEmpty()
 * var param_8 = obj.isFull()
 */