import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class NewMenu {

	public static void main(String[] args) {
		NewMenu n = new NewMenu();
		String[] res = n.solution(new String[] { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" },
				new int[] { 2, 3, 4 });
		res = n.solution(new String[] { "XYZ", "XWY", "WXA" }, new int[] { 2, 3, 4 });
		System.out.println("======");
		for (String s : res) {
			System.out.println(s);
		}
	}

	HashMap<String, Integer> map;
	List<String> answerList;

	private String[] solution(String[] menus, int[] courseN) {
		// orders를 모두 오름차순으로 정렬
		for (int i = 0; i < menus.length; i++) {
			char[] arr = menus[i].toCharArray();
			Arrays.sort(arr);
			menus[i] = String.valueOf(arr);
		}
		map = new HashMap<>();
		answerList = new ArrayList<>();
		for (int i = 0; i < courseN.length; i++) {
			for (int j = 0; j < menus.length; j++) {
				boolean[] visited = new boolean[menus.length];
				combinationThis(menus[j], 0, courseN[i], visited);
			}
			if (!map.isEmpty()) {
				findTops();
				map.clear();
			}
		}
		Collections.sort(answerList);
		String[] answer = new String[answerList.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = answerList.get(i);
		}
		return answer;
	}

	private void findTops() {
		List<Integer> countList = new ArrayList<>(map.values());
		int max = Collections.max(countList);

		if (max >= 2) {
			for (String key : map.keySet()) {
				if (max == map.get(key)) {
					answerList.add(key);
					System.out.println(key);
				}
			}
		}
	}

	private void combinationThis(String string, int start, int n, boolean[] visited) {
		if (n == 0) {
			String a = "";
			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) {
					a += string.charAt(i);
				}
			}
			map.put(a, map.getOrDefault(a, 0) + 1);
			return;
		}

		for (int i = start; i < string.length(); i++) {
			visited[i] = true;
			combinationThis(string, i + 1, n - 1, visited);
			visited[i] = false;
		}
	}
}
