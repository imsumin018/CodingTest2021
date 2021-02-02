import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NewMenu03 {
    public static String[] solution(String[] orders, int[] course) {
        Map<Integer, Map<String, Integer>> orderMappers = new HashMap();

        for (int i = 0; i < orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            for (int j : course) {
                Character[] comArr = new Character[j];
                Map<String, Integer> value = orderMappers.getOrDefault(j, new HashMap<>());
                combination(comArr, chars.length, j, 0, 0, chars, value);
                orderMappers.put(j, value);
            }
        }

        List<String> answer = new ArrayList<>();
        for (Map<String, Integer> value : orderMappers.values()) {
            Integer maxCount = value.values().stream().max(Integer::compareTo).orElse(0);
            for (Map.Entry<String, Integer> value2 : value.entrySet()) {
                if (maxCount < 2) {
                    break;
                }
                if (maxCount.equals(value2.getValue())) {
                    answer.add(value2.getKey());
                }
            }
        }

        answer.sort(String::compareTo);
        return answer.toArray(new String[0]);
    }

    private static void combination(Character[] comArr, int n, int r, int index, int target, char[] arr,
            Map<String, Integer> map) {
        if (r == 0) {
            String value = Arrays.stream(comArr)
                    .sorted()
                    .map(String::valueOf)
                    .collect(Collectors.joining(""));
            map.put(value, map.getOrDefault(value, 0) + 1);
            return;
        }
        if (target == n) {
            return;
        }

        comArr[index] = arr[target];
        combination(comArr, n, r - 1, index + 1, target + 1, arr, map);
        combination(comArr, n, r, index, target + 1, arr, map);
    }
}

