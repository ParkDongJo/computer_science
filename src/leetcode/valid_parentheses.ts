// 여는 괄호는 스택에 넣고 닫는 괄호는 스택에서 빼면서 진행
// 같은 타입의 괄호만 스택에서 뺄 수 있음
// stack 에 괄호가 남아있으면 false
// stack 에 괄호를 빼냈는데, 다른 타입이면 false
// stack 에 괄호가 없으면 true

function isValid(s: string): boolean {
  const stack: string[] = [];
  const open = ['(', '{', '['];
  const close = [')', '}', ']'];
  for (let i = 0; i < s.length; i++) {
    const c = s[i];
    if (open.includes(c)) {
      stack.push(c);
    } else {
      const last = stack.pop();
      if (!last || open.indexOf(last) !== close.indexOf(c)) {
        return false;
      }
    }
  }
  return stack.length === 0;
};

console.log(isValid('()'));
console.log(isValid('()[]{}'));
console.log(isValid('(]'));