package contest.weekly34;

import java.util.*;

/**
 * 599. Minimum Index Sum of Two Lists
 * https://leetcode.com/contest/leetcode-weekly-contest-34/problems/minimum-index-sum-of-two-lists/
 * <p>
 * Created by max on 17-5-28.
 */
public class P599 {

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};

        list1 = new String[]{"k", "KFC"};
        list2 = new String[]{"k", "KFC"};

        String[] result = findRestaurant2(list1, list2);
        for (String r : result) {
            System.out.println(r);
        }
    }

    /**
     * Using HashMap
     *
     * @param list1
     * @param list2
     * @return
     */
    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Set<String> common = new HashSet<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }

        common.addAll(map1.keySet());
        common.retainAll(map2.keySet());

        Map<String, Integer> maps = new TreeMap<>();
        for (String key : common) {
            maps.put(key, map1.get(key) + map2.get(key));
        }

        // 升序比较器
        Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        };

        // map转换成list进行排序
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(maps.entrySet());

        // 排序
        Collections.sort(list, valueComparator);

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int s = list.get(i).getValue();
            String k = list.get(i).getKey();
            if (i == 0) {
                sum = s;
                result.add(k);
            } else if (s == sum) {
                result.add(k);
            }
            if (s > sum) {
                break;
            }
        }

        return result.toArray(new String[result.size()]);
    }

    /**
     * Using HashMap & TreeMap
     *
     * @param list1
     * @param list2
     * @return
     */
    public static String[] findRestaurant2(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Map<Integer, List<String>> result = new TreeMap<>();

        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }

        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                int sum = map1.get(key) + map2.get(key);
                if (!result.containsKey(sum)) {
                    result.put(sum, new ArrayList<String>() {{
                        add(key);
                    }});
                } else {
                    result.get(sum).add(key);
                }
            }
        }

        Map.Entry<Integer, List<String>> entry = result.entrySet().iterator().next();

        return entry.getValue().toArray(new String[entry.getValue().size()]);
    }
}
