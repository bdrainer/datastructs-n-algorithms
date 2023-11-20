/*
 *
 * Execute from a terminal:  node tower_breakers.js 4 8
 *
 */

var args = process.argv.slice(2);

var numberOfTowers = +args[0];
var heightOfTowers = +args[1];

var winner = towerBreakers(numberOfTowers, heightOfTowers);

console.log("Winner is " + winner);

/*
 * Complete the 'towerBreakers' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n - number of towers
 *  2. INTEGER m - height of towers
 */

function towerBreakers(n, m) {
    if (m == 1 || n % 2 == 0) {
        return 2;
    } else {
        return 1;
    }
}