import java.util.Arrays;

class SortCharracter {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};

         
        answer = Arrays.asList(strings).stream().sorted().sorted((s1,s2)-> s1.charAt(n)- s2.charAt(n)).toArray(String[] ::new);
        
        
        return answer;
    }

    public static void main(String[] args) {
        SortCharracter sol = new SortCharracter();
        
        String[] input = { "sun", "bed", "car" };
        
        String[] input2 = { "abce", "abcd", "cdx" };

    }
}