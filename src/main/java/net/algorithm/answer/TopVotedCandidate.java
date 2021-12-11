package net.algorithm.answer;

import java.util.*;

/**
 * @Author TieJianKuDan
 * @Date 2021/12/11 10:37
 * @Description 911. 在线选举
 * @Since version-1.0
 */
public class TopVotedCandidate {
    private int[] map;
    private int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        int max = Integer.MIN_VALUE;
        this.map = new int[times.length];
        this.times = times;
        HashMap<Integer, Integer> voteRecords = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            int votes = voteRecords.getOrDefault(persons[i], 0);
            votes++;
            voteRecords.put(persons[i], votes);
            Integer maxVotes = voteRecords.getOrDefault(max, 0);
            if (votes >= maxVotes) {
                max = persons[i];
            }
            map[i] = max;
        }
    }

    public int q(int t) {
        int low = 0;
        int high = times.length - 1;
        while (low <= high) {
            int cen = (high - low) / 2 + low;
            if (times[cen] > t) {
                high = cen - 1;
            }
            if (times[cen] == t) {
                high = cen;
                break;
            }
            if (times[cen] < t) {
                low = cen + 1;
            }
        }
        return map[high];
    }
}
