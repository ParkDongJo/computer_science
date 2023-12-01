// 먼저 소팅을 한다
// 다시 반복문을 돌면서 최초 숫자가 나타나면, 결과 배열로 push 한다.
// 다시 반복문을 돌면서 숫자가 없으면 _ 를 넣는다
let nums = [0,0,0,0,0]

function removeDuplicates(nums: (number|string)[]): number {
    const result: (number|string)[] = []
    for (let i = 0; i < nums.length; i++) {
      if (!result.includes(nums[i])) {
        result.push(nums[i])
      }
    }
    const len = nums.length
    console.log(len, result)
    for (let i = 0; i < len; i++) {
      if (result[i] !== undefined) {
        nums[i] = result[i]
      } else {
        nums[i] = '_'
      }
    }
    return result.length
};


function removeDuplicates2(nums: (number|string)[]): number {
  const result: (number|string)[] = []
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] !== nums[i+1]) {
      result.push(nums[i])
    }
  }
  for (let i = 0; i < nums.length; i++) {
    if (result[i] !== undefined) {
      nums[i] = result[i]
    } else {
      nums[i] = '_'
    }
  }
  return result.length
};

function removeDuplicates3(nums: number[]): number {
  for (let i = 0; i < nums.length; i++) {
      if (nums[i] === nums[i+1]) {
          nums.splice(i, 1);
          i--;
      }

  }

  return nums.length;
};

console.log(removeDuplicates2(nums))
console.log(nums)
