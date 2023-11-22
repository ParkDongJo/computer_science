/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

class ListNode {
  val: number
  next: ListNode | null
  constructor(val?: number, next?: ListNode | null) {
    this.val = (val===undefined ? 0 : val)
    this.next = (next===undefined ? null : next)
  }
}

function convertToList(nums: number[]): ListNode {
  const list: ListNode[] = []
  for (let i = 0; i < nums.length; i++) {
    const node = new ListNode()
    node.val = nums[i];
    list.push(node)
  }
  for (let i = 0; i < list.length; i++) {
    try {
      const node = list[i]
      const next = list[i+1]
      node.next = next
    } catch (e) {}
  }
  return list[0]
}

// list
function mergeTwoLists(list1: ListNode | null, list2: ListNode | null): ListNode | null {
  const result: number[] = [];
  let point1 = list1
  let point2 = list2
  while (point1?.val) {
      if (point1?.val) result.push(point1.val)
      point1 = point1.next
  }
  while (point2?.val) {
    if (point2?.val) result.push(point2.val)
    point2 = point2.next
  }
  result.sort()
  return convertToList(result)
};


console.log(mergeTwoLists(convertToList([1,2,4]), convertToList([1,3,4])));
console.log(mergeTwoLists(convertToList([]), convertToList([])));
console.log(mergeTwoLists(convertToList([]), convertToList([0])));


function mergeTwoLists2(list1: ListNode | null, list2: ListNode | null): ListNode | null {
  if (!list1) return list2;
  if (!list2) return list1;
  
  if (list1.val <= list2.val) {
      list1.next = mergeTwoLists(list1.next, list2);
      return list1;
  } else {
      list2.next = mergeTwoLists(list1, list2.next);
      return list2;
  }
};

console.log(mergeTwoLists2(convertToList([1,2,4]), convertToList([1,3,4])));
console.log(mergeTwoLists2(convertToList([]), convertToList([])));
console.log(mergeTwoLists2(convertToList([]), convertToList([0])));