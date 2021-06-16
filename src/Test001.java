public class Test001 {

    public static int compareTo(String str1, String str2) {
        int comparable = str1.compareToIgnoreCase(str2);
        System.out.println("Comparable: " + comparable);
        return (comparable > 0) ? 1 : (comparable <= 0) ? -1 : 0;
    }

    public static int compareTo(int id1, int id2) {
        return (id1 > id2) ? 1 : (id1 < id2) ? -1 : 0;
    }

    public static void main(String[] args) {

        // System.out.print(compareTo("ab1", "ab2"));
        // System.out.print(compareTo("ab2", "ab1"));
        
        
        System.out.println(compareTo(132, 123));
        System.out.println(compareTo(123, 132));
        
        int ba= 323;
        int ba2=121;
        int former , latter;

        if (compareTo(ba,ba2) < 0) {
          former = ba2;
          latter = ba;
        } else {
          former = ba;
          latter = ba2;
        }
        System.out.println(former +", "+ latter);
        
        

    }
}
