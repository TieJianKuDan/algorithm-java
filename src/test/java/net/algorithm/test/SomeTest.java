package net.algorithm.test;

import org.junit.Test;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

public class SomeTest {
    @Test
    public void test1() {
        for (int i = 0; i < 5; i++) {
            int a = i;
            new Thread(() -> {
                System.out.println(a);
            }).start();
        }
    }

    @Test
    public void test2() {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        heap.offer(1);
        heap.offer(2);
        System.out.println(heap.poll());
    }

    @Test
    public void test3() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println(DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8", "root", "123456"));
    }

    @Test
    public void test4() {
        int a = 0;
        a = 1 << 63;
        System.out.println(a);
    }

    public long convert(double a, int n) {
        for (int i = 0; i < n; i++) {
            a *= 10;
        }
        return (long) a;
    }

    public int fun(int n) {
        // key -> 数位和 value -> 个数
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int temp = i;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            max = Math.max(max, map.get(sum));
        }
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            if (map.get(key) == max) {
                res++;
            }
        }
        return res;
    }

    @Test
    public void test5() {
        System.out.println(fun(13));
    }

    @Test
    public void test6() {
        String str = "a";
        System.out.println(str.substring(1, 1));
    }

}
