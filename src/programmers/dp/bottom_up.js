let dp = [];

function fibonacci(n) {
  (dp[0] = 0), (dp[1] = 1);
  for (let i = 2; i <= n; i++) {
    dp[i] = dp[i - 1] + dp[i - 2];
  }
}

console.log(fibonacci(10));
