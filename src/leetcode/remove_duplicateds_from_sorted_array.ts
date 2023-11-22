// 먼저 소팅을 한다
// 다시 반복문을 돌면서 최초 숫자가 나타나면, 결과 배열로 push 한다.
// 다시 반복문을 돌면서 숫자가 없으면 _ 를 넣는다
let nums = [1,1,2]

// function removeDuplicates(nums: number[]): number {
//     const result: number[] = []
//     nums.sort()
//     for (let i = 0; i < nums.length; i++) {
//       if (!result.includes(nums[i])) {
//         result.push(nums[i])
//       }
//     }
//     nums = result
//     for (let i = 0; i < result.length; i++) {
//       nums[i] = 0
//     }
//     console.log(nums)
//     return result.length
// };

function removeDuplicates(nums: number[]): number {
  for (let i = 0; i < nums.length; i++) {
      if (nums[i] === nums[i+1]) {
          nums.splice(i, 1);
          i--;
      }

  }

  return nums.length;
};

console.log(removeDuplicates(nums))
console.log(nums)
