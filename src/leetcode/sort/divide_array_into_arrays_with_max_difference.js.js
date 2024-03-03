// https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[][]}
 */
var divideArray = function(nums, k) {
    // [풀이]
    // nums, k 양수
    // nums 분할
    // - 각 불할된 배열의 요소 갯수가 3개 (1개 이상) -> 아니면 빈배열
    // - 중복 X
    // - 각 요소들의 차이 -> k와 같거나 작아야한다.

    // [전략]
    // k보다 차이를 적게하려면, 붙어있고 k보다 작은애들끼리만 3개씩 만들어야한다.
    // - nums 가 3으로 나뉘어 지는지
    // - 정렬
    // - 반복문을 돌면서 k보다 차이가 큰지 작은지를 판단
    //      - 0번째와 2번째의 차이가 k보다 큰지 작은지 판단


    // [회고]
    // - temp 를 만들어서 넣을 필요가 있을까? min 값으로 체크하는건 안되나?
    //    - 그러면 좀 더 공간복잡도를 낮출수 있지 않을까?
    //    - 메모리를 효율적으로 사용할수 있지 않을까?

    // - 실무라면 nums 조작하지 않는다. -> 불변성을 유지한다.

    // [피드벡]
    // - A한다
    // - B한다

    if (nums.length % 3 !== 0) {
        return [];
    }

    nums.sort((a, b) => a - b);

    let results = [];
    let temp = [];
    for (let i = 0; i < nums.length; i++) {
        if (temp.length === 2) {
            if (nums[i] - temp[0] > k) {
                return [];
            } else {
                temp.push(nums[i]);
                results.push(temp);
                temp = [];
            }
        } else {
            temp.push(nums[i]);
        }
    }

    return results;
};