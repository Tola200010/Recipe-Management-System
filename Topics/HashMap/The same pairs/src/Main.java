import java.util.*;


class MapFunctions {

    public static void calcTheSamePairs(Map<String, String> map1, Map<String, String> map2) {
        // write your code here
        int samePairsCount = 0;

        for (Map.Entry<String, String> entry : map1.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            // Check if the second map contains the same key and value
            if (map2.containsKey(key) && map2.get(key).equals(value)) {
                samePairsCount++;
            }
        }
        System.out.println(samePairsCount);
    }
}