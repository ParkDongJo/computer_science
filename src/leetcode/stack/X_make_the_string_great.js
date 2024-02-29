// https://leetcode.com/problems/make-the-string-great/description/
/**
 * @param {string} s
 * @return {string}
 */
// 137ms
// 스텍을 전혀 생각해내지 못했다.
// 로직을 한번에 구현하지 못했고, 디버깅도 오래걸렸다.
// 만약, 이 첫 문제였다면 이 후 과정에도 영향을 미칠 수 있다.
var makeGood = function(s) {
    // 인접하고, 동일한 문자이지만, 소문자/대문자가 서로 다른
    // 이 두문자를 제거 해야 -> 좋은 문자열이 된다.

    // 반복문 -> i 문자가 upper, lower 인지 체크
    // -> i + 1 문자는 lower
    // -> i + 1 문자는 upper

    // abBAcC -> aAcC -> cC -> ''
    let i = 0;
    while (s.length > i) {    
        if (i + 1 >= s.length) {
            break;
        }
        if ((s[i] === s[i].toUpperCase() && s[i + 1] === s[i + 1].toLowerCase())
        || s[i] === s[i].toLowerCase() && s[i + 1] === s[i + 1].toUpperCase()) {
            if (s[i].toLowerCase() === s[i + 1].toLowerCase()) {

                console.log(`${s[i]}${s[i+1]} -`, i, i+1)
                s = s.replace(`${s[i]}${s[i+1]}`, '');
                console.log(s)
                i = 0;
                continue;
            }
        }
        i++;
    }
    return s
};

// 43ms
function makeGood(s){
    const M = [''];
    for(let c of s) {
      if(M[M.length-1].toLowerCase()===c.toLowerCase()&&M[M.length-1]!==c) {
        M.pop();
      } else {
        M.push(c);
      }
    }
    return M.join('');
}
