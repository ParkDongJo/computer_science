// https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/

/**
 * @param {string} s
 * @return {string}
 */
// var reverseParentheses = function (s) {
//   const stack = [];
//   let buffer = "";
//   const words = [];
//   for (const c of s) {
//     if (c === "(") {
//       console.log("( -", buffer);
//       if (buffer.length > 0) {
//         words.push(buffer);
//         buffer = "";
//       }
//       stack.push(c);
//     } else if (c === ")") {
//       let str = buffer.length > 0 ? buffer : stack.pop();

//       if (words.length > 0) {
//         words[words.length - 1] = words[words.length - 1] + reverse(str);
//       } else {
//         words.push(reverse(str));
//       }
//     } else {
//       console.log("c - ", c);
//       buffer += c;
//     }
//   }

//   console.log(words);
//   return words[0];
// };

// 다른사람 풀이
var reverseParentheses = function (s) {
  // Convert the input string to an array for easier manipulation
  let arr = s.split("");
  // Initialize a stack and a queue for processing characters
  let stack = [],
    q = [];
  // Iterate through each character in the array
  for (let x of arr) {
    if (x === ")") {
      // If a closing parenthesis is encountered, reverse characters until an opening parenthesis is found
      let j = stack.length - 1;
      while (stack[j] !== "(") {
        q.push(stack.pop());
        j--;
      }
      stack.pop(); // Remove the opening parenthesis
      // Add reversed characters back to the stack
      while (q.length) {
        stack.push(q.shift());
      }
    } else {
      // Push non-parenthesis characters to the stack
      stack.push(x);
    }
  }
  // Join the characters in the stack to form the final reversed string
  return stack.join("");
};

function reverse(str) {
  return str.split("").reverse().join("");
}

console.log(reverseParentheses("(abcd)")); //
console.log(reverseParentheses("(u(love)i)"));
