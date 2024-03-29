// 시간 복잡도 O(nlogn)
// 최악의 경우 시간 복잡도 O(nlogn)
function merge(left, right) {
  let sortedArr = []

  while (left.length && right.length) {
    if (left[0] < right[0]) {
      sortedArr.push(left.splice(0,1)[0])
    } else {
      sortedArr.push(right.splice(0,1)[0])
    }
  }
  return [...sortedArr, ...left, ...right]
}

function mergeSort(arr) {
  if (arr.length <= 1) return arr
  let mid = Math.floor(arr.length / 2)

  let left = mergeSort(arr.slice(0, mid))
  let right = mergeSort(arr.slice(mid))

  return merge(left, right)
}

console.log(mergeSort([10, 4, 8, 2, 6, 7, 3]))