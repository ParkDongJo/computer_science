// s의 전체 반복문을 돈다.
// 각 c 를 뽑아낸다.
// word 변수를 선언해 놓는다.
// - c가 공백이면 word 에 추가하지 않는다. isWaiting을 true 로 바꿔준다.
// - c가 공백이 아니면 word 에 추가한다. isWaiting이 true 였다면, 새로 담는다. 그리고 isWaiting을 false로 바꿔준다.
// isWaiting 이라는 flag 를 둔다.
// - c가 공백일때 isWaiting 은 true 이다
// - c가 공백이 아니면 isWaiting 는 false 이다.
var lengthOfLastWord = function(s) {
  let words = []
  let isWaiting = true;
  for (let c of s) {
    if (c === " ") {
      isWaiting = true;
      continue;
    }
    isWaiting ? (words = [c]) : (words.push(c))
    isWaiting = false
  }
  return words.length;
};

console.log(lengthOfLastWord("Hello World"))
console.log(lengthOfLastWord("   fly me   to   the moon  "))
console.log(lengthOfLastWord("luffy is still joyboy"))
