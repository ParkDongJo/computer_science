// https://leetcode.com/problems/minimize-result-by-adding-parentheses-to-expression/

/**
 * @param {string} expression
 * @return {string}
 */
var minimizeResult = function(expression) {
    const nums = expression.split("+");
    let min = nums[0] + nums[1];
    let front = 0;
    let tail = 0;
    let middle = '';
    let buffer = '';
    let sum = 0;
    let answer = `(${expression})`;

    for (let i = 0; i < expression.length; i++) {
        for (let j = i; j < expression.length; j++) {
            const c = expression[j];
            buffer += c;
            if (c === '+') {
                buffer = buffer.slice(0, buffer.length - 1);
                sum += Number(buffer);
                middle = `${buffer}+`
                buffer = '';
            }
            if (expression.length - 1 - i === j) {
                sum += Number(buffer);
                middle += `${buffer}`;
                buffer = '';
                break;
            }
        }

        for (let k = 0; k < i; k++) {
            buffer += expression[k];
        }
        front = i === 0 ? 1 : Number(buffer);
        buffer = '';

        for (let l = expression.length - 1 - i; l < expression.length; l++) {
            buffer += expression[l];
        }
        tail = expression.length === expression.length - i ? 1 : Number(buffer);
        buffer = '';

        let result = front * sum * tail;
        if (min > result) {
            min = result;
            if (front === 1) {
                answer = "(";
            } else {
                answer = `${front}(`;
            }
            answer += `${middle}`;
            if (tail === 1) {
                answer += ")";
            } else {
                answer += `)${tail}`;
            }
        }
        front = 0;
        tail = 0;
        middle = '';
    }

    return answer;
};

console.log(minimizeResult("247+38")); 

// 남의 풀이
var minimizeResult = function (ex) {
    let min = Infinity
    let an = []
  
    let [l, r] = ex.split("+");
    for (let i = 0; i < l.length; i++) {
      let a = l.slice(0, i)
      let b = l.slice(i)
  
      for (let j = 1; j <= r.length; j++) {
        let c = r.slice(0, j)
        let d = r.slice(j)
  
        let val = +b + +c
        if (a !== '') val = a * val
        if (d !== '') val = val * d
  
        if (val < min) {
          min = Math.min(min, val)
          an = [a, b, c, d]
        }
      }
    }
  
    let [a, b, c, d] = an
    return '' + a + '(' + b + '+' + c + ')' + d
  };
