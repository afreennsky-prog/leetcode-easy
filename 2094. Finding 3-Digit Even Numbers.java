import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];
        for (int d : digits) count[d]++;

        List<Integer> res = new ArrayList<>();
        for (int i = 100; i < 1000; i += 2) {
            int d1 = i / 100, d2 = (i / 10) % 10, d3 = i % 10;
            
            count[d1]--; count[d2]--; count[d3]--;
            if (count[d1] >= 0 && count[d2] >= 0 && count[d3] >= 0) {
                res.add(i);
            }
            count[d1]++; count[d2]++; count[d3]++;
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
