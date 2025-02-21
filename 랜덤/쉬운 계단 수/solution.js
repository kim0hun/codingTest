const fs = require("fs")
let input = fs.readFileSync("input.txt").toString().trim().split(/\r?\n/);

const N = Number(input[0])

let dp = [[0, 1, 1, 1, 1, 1, 1, 1, 1, 1]]

if (N === 1) {
  console.log(9)
}
else {
  for (let i = 1; i < N; i++) {
    let newList = []
    newList.push(dp[i - 1][1] % 1000000000)
    for (let j = 1; j < 9; j++) {
      newList.push((dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000)

    }
    newList.push(dp[i - 1][8] % 1000000000)

    dp.push(newList)
  }
}
const sum = dp[dp.length - 1].reduce((acc, current) => ((current + acc) % 1000000000), 0)
console.log(sum % 1000000000)