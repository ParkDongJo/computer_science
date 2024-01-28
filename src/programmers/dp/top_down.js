let dp = [];

function fibonacci(n) {
  if (n == 0) return 0;
  if (n == 1) return 1;

  if (dp[n] != -1) return dp[n];

  dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
  return dp[n];
}

console.log(fibonacci(10));
