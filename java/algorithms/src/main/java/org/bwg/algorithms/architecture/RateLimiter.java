package org.bwg.algorithms.architecture;

import java.util.LinkedList;

public class RateLimiter {
    private final int limit;
    private final int timeWindow ;
    private final LinkedList<Integer> requests = new LinkedList<>();

    public RateLimiter(int n, int t) {
        this.limit = n;
        this.timeWindow = t;
    }

    public boolean shouldAllow(int timestamp) {
        int minAllowedTime = timestamp - timeWindow + 1;
        while (!requests.isEmpty() && requests.getFirst() < minAllowedTime) {
            requests.removeFirst();
        }
        if (requests.size() < limit) {
            requests.add(timestamp);
            return true;
        }
        return false;
    }
}
