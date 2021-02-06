import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewMenu01 {
	public static void main(String[] args) {
		NewMenu01 n = new NewMenu01();
		String[] res = n.solution(new String[] { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" },
				new int[] { 2, 3, 4 });
		res = n.solution(new String[] {"XYZ", "XWY", "WXA"}, new int[] {2,3,4});
		System.out.println(); 
		for (String s : res) {
			System.out.println(s);
		}

	}

	Map<String, Integer> courseMap = new HashMap<>();
	List<String> answerList = new ArrayList<>();

	public String[] solution(String[] orders, int[] course) {

		// orders를 모두 오름차순으로 정렬
		for (int i = 0; i < orders.length; i++) {
			char[] arr = orders[i].toCharArray();
			Arrays.sort(arr);
			orders[i] = String.valueOf(arr);
		}

		// course수의 모든 조합 구하기
		for (int i = 0; i < course.length; i++) {
			for (int j = 0; j < orders.length; j++) {
				String order = orders[j];

				if (course[i] <= order.length()) {
					boolean[] visited = new boolean[order.length()];
					combination(order.toCharArray(), 0, course[i], visited);
				}
			}

			// 가장 많이 주문한 단품메뉴 조합 구하기, answer에 넣기
			if (!courseMap.isEmpty()) {
				findPopularCourse();
				courseMap.clear();
			}
		}

		Collections.sort(answerList);
		String[] answer = new String[answerList.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = answerList.get(i);
		}
		return answer;
	}

	public void combination(char[] order, int start, int r, boolean[] visited) {
		if (r == 0) {
			addCourse(order, visited);
			return;
		}

		for (int i = start; i < order.length; i++) {
			visited[i] = true;
			combination(order, i + 1, r - 1, visited);
			visited[i] = false;
		}
	}

	public void addCourse(char[] order, boolean[] visited) {
		String course = "";
		for (int i = 0; i < order.length; i++) {
			if (visited[i]) {
				course += order[i];
			}
		}
		courseMap.put(course, courseMap.getOrDefault(course, 0) + 1);
	}

	public void findPopularCourse() {
		List<Integer> countList = new ArrayList<>(courseMap.values());
		int max = Collections.max(countList);

		if (max >= 2) {
			for (String key : courseMap.keySet()) {
				if (courseMap.get(key) == max) {
					answerList.add(key);
					System.out.println(key);
				}
			}
		}
	}
}
