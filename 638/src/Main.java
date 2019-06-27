import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> price = new ArrayList<>();
        price.add(2);
        price.add(3);
        price.add(4);
        List<List<Integer>> special = new ArrayList<>();
        List<Integer> sp1 = new ArrayList<>();
        sp1.add(1);
        sp1.add(1);
        sp1.add(0);
        sp1.add(4);
        List<Integer> sp2 = new ArrayList<>();
        sp2.add(2);
        sp2.add(2);
        sp2.add(1);
        sp2.add(9);
        special.add(sp1);
        special.add(sp2);
        List<Integer> needs = new ArrayList<>();
        needs.add(1);
        needs.add(2);
        needs.add(1);
        System.out.println(s.shoppingOffers(price, special, needs));
    }
}

class Solution {
    boolean listPlus(List<Integer> list1, List<Integer> list2, int fix) {
        boolean reuslt = true;
        int temp;
        for (int i = 0; i < list1.size(); i++) {
            temp = list1.get(i) + list2.get(i) * fix;
            list1.set(i, temp);
            if (temp < 0) reuslt = false;
        }
        return reuslt;
    }

    int minOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int min = Integer.MAX_VALUE;
        int sum;
        boolean flag = true;
        // 使用礼包
        for (List<Integer> s : special) {
            if (listPlus(needs, s, -1)) {
                sum = s.get(s.size() - 1) + minOffers(price, special, needs);
                if (sum < min) min = sum;
                flag = false;
            }
            listPlus(needs, s, 1);
        }
        if (flag) {
            if (min == Integer.MAX_VALUE) min = 0;
            // 补充
            for (int i = 0; i < price.size(); i++) {
                min += price.get(i) * needs.get(i);
            }
        }
        return min;
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // 礼包检查
        for (List<Integer> s : special) {
            int sale = 0;
            for (int i = 0; i < s.size() - 1; i++) {
                sale += s.get(i) * price.get(i);
            }
            if (sale < s.get(s.size() - 1)) s.set(s.size() - 1, sale);
        }
        return minOffers(price, special, needs);
    }
}