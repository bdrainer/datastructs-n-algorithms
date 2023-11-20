package org.bwg.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Two players are playing a game of Tower Breakers! Player 1 always moves first, and both players always play
 * optimally.The rules of the game are as follows:
 * <p>
 *     <ul>
 *         <li>Initially there are n towers.</li>
 *         <li>Each tower is of height m. </li>
 *         <li>The players move in alternating turns.</li>
 *         <li>In each turn, a player can choose a tower of height x and reduce its height to y, where 1 <= y < z and y evenly divides x</li>
 *         <li>If the current player is unable to make a move, they lose the game.</li>
 *    </ul>
 * <p>
 * Given the values of n and m, determine which player will win. If the first player wins, return 1. Otherwise, return 2.
 */
public class TowerBreakerTest {

    @Test
    void shouldDetermineWhoWins() {
        assertEquals(2, towerBreakers(2, 6));
        assertEquals(2, towerBreakers(2, 6));
    }

    /**
     * @param n the number of towers
     * @param m the height of each tower
     * @return
     */
    private int towerBreakers(int n, int m) {
        return (m == 1) || (n % 2 == 0)
                ? 2 : 1;
    }
}
