import java.util.ArrayList;
import java.util.HashMap;

public class LinePrevious01 {
    int count = 0;

    public int solution(int[][] boxes) {
        HashMap<Integer, Integer> set = new HashMap<>();

        for (int i = 0; i < boxes.length; i++) {
            set.put(boxes[i][0], set.getOrDefault(boxes[i][0], 0) + 1);
            set.put(boxes[i][1], set.getOrDefault(boxes[i][1], 0) + 1);
        }

        for (int e : set.keySet()) {
            if (set.get(e) % 2 == 0) {
                set.put(e, 0);
            }
        }
        for (int e : set.keySet()) {
            System.out.println("key" + e + " " + set.get(e));
        }

        for (int e : set.keySet()) {
            if (set.get(e) % 2 == 0) {
                set.put(e, 0);
            } else
                count++;
        }
        while (true) {
            int c = 0;
            for (int e : set.keySet()) {
                if (set.get(e) % 2 != 0) {
                    for (int i = 0; i < boxes.length; i++) {
                        if (set.get(e) == boxes[i][0] || set.get(e) == boxes[i][1]) {
                            set.put(boxes[i][0], set.getOrDefault(boxes[i][0], 0) + 1);
                            set.put(boxes[i][1], set.getOrDefault(boxes[i][1], 0) + 1);
                        }
                    }
                } else {
                    set.put(e, 0);
                }
                if (c == 0)
                    break;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int[][] a = { { 1, 2 }, { 2, 1 }, { 3, 3 }, { 4, 5 }, { 5, 6 }, { 7, 8 } };
        System.out.println();
        LinePrevious01 num1 = new LinePrevious01();
        num1.solution(a);

        Num2 num2 = new Num2();
        int[] aa = { 1, 2, 3, 4, 5, 6 };
        int[] bb = { 6, 2, 5, 1, 4, 3 };
        num2.solution(aa, bb);

    }
}

class Num2 {
    public ArrayList<Integer> q = new ArrayList<>();
    public ArrayList<Integer> solve = new ArrayList<>();

    public int[] solution(int[] ball, int[] order) {
        int[] result = new int[ball.length];
        int resultIndex = 0;
        for (int i = 0; i < ball.length; i++) {
            q.add(ball[i]);
        }

        for (int i = 0; i < order.length; i++) {
            solve.add(order[i]);
        }
        int search = 0;
        while (q.size() > 0) {
            int findNumber = solve.get(search);

            if (findNumber == q.get(0)) {
                result[resultIndex++] = q.get(0);
                q.remove(0);
                solve.remove(search);
                search = 0;

            } else if (findNumber == q.get(q.size() - 1)) {
                result[resultIndex++] = q.get(q.size() - 1);
                q.remove(q.size() - 1);
                solve.remove(search);
                search = 0;

            } else {
                search++;
            }
        }

        return result;
    }
}
