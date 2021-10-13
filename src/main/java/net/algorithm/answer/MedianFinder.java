package net.algorithm.answer;

import java.util.PriorityQueue;

/**
 * @Author TieJianKuDan
 * @Date 2021/8/27 11:21
 * @Description 295. 数据流的中位数
 * @Since version-1.0
 */
public class MedianFinder {
    private PriorityQueue<Integer> minQue;
    private PriorityQueue<Integer> maxQue;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        minQue = new PriorityQueue<Integer>((a, b) -> b - a);
        maxQue = new PriorityQueue<Integer>((a, b) -> a - b);
    }

    public void addNum(int num) {
        if (!minQue.isEmpty() && num <= minQue.peek()) {
            if (minQue.size() == maxQue.size()) {
                minQue.offer(num);
            } else {
                maxQue.offer(minQue.poll());
                minQue.offer(num);
            }
        }
        if (!minQue.isEmpty() && num > minQue.peek()) {
            if (minQue.size() == maxQue.size()) {
                maxQue.offer(num);
                minQue.offer(maxQue.poll());
            } else {
                maxQue.offer(num);
            }
        }
        if (minQue.isEmpty()) {
            minQue.offer(num);
        }
    }

    public double findMedian() {
        if (minQue.isEmpty()) {
            return 0;
        } else {
            if (minQue.size() == maxQue.size()) {
                return ((double) minQue.peek() + (double) maxQue.peek()) / 2;
            } else {
                return minQue.peek();
            }
        }
    }
}
