// https://leetcode.com/problems/best-poker-hand/description/
/**
 * @param {number[]} ranks
 * @param {character[]} suits
 * @return {string}
 */
// 64ms
// 아주 쓰레기같은 코드를 작성함
var bestHand = function(ranks, suits) {
    // Flush -> Tree -> Pair -> High
    // 반복문 1개
    // - ranks 와 suites 를 돈다
    // - suits 길이 sameCount 가 같을때
    // - ranks 에 v 3 또는 2

    let suitsMem = {};
    let ranksMem = {};

    for (let i = 0; i < ranks.length; i++) {
        if (!suitsMem[suits[i]]) {
            suitsMem[suits[i]] = 1;
        } else {
            suitsMem[suits[i]] += 1;
        }

        if (!ranksMem[ranks[i]]) {
            ranksMem[ranks[i]] = 1;
        } else {
            ranksMem[ranks[i]] += 1;
        }
    }

    if (Math.max(...Object.values(suitsMem)) === 5) {
        return 'Flush';
    }
    const ranksArr = Object.values(ranksMem).sort((a, b) => b - a)
    for (let r of ranksArr) {
        if (r >= 3) {
            return 'Three of a Kind';
        }
        if (r === 2) {
            return 'Pair';
        }
    }
    return 'High Card';
};


// 44ms
// 원리는 같지만 훨씬더 깔끔하게 처리하고 이싿.
var bestHand = function(ranks, suits) {
    if (suits.every(s => s === suits[0])) {
        return 'Flush';
    }
    const m = new Array(14).fill(0);
    let max = 1;
    for (const r of ranks) {
        m[r]++;
        max = Math.max(max, m[r]);
    }
    if (max >= 3) {
        return 'Three of a Kind';
    }
    if (max === 2) {
        return 'Pair';
    }
    return 'High Card';
};