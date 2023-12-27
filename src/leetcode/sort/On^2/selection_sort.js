function selectionSort(arr) {
  for (let i = 0; i < arr.length; i++) {
    let lowest = i
    for (let j = i + 1; j < arr.length; j++) {
      if (arr[j] < arr[lowest]) {
        lowest = j
      }
    }
    if (lowest !== i) {
      // Swap
      /*
        이 코드는 JavaScript의 배열 비구조화 할당(destructuring assignment)을 사용하고 있습니다. 
        이를 통해 두 변수의 값을 교환하는 것이 가능합니다. 예를 들어, [a, b] = [b, a]는 a와 b의 값을 서로 교환합니다. 
        이 코드는 선택 정렬(selection sort) 알고리즘에서 두 원소의 위치를 바꾸는데 사용됩니다.
      */
      ;[arr[i], arr[lowest]] = [arr[lowest], arr[i]]
    }
  }
  return arr
}