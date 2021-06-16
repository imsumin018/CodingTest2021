/* package whatever; // don't place package name! */

import java.io.*;
import java.util.LinkedList;
import java.util.NoSuchElementException;
/** compextiy of this program
 O(N)
*/
class myCode
{
    static LinkedList<String> fifo = new LinkedList<String>();
    public static String process_OFFER(String input, int capacity){
        if (fifo.size()>=capacity){
                return "false";
        }
        fifo.add(input);
        return "true";
    }
    public static void process_TAKE(){
        try{
            System.out.println(fifo.removeFirst());
        
        } catch (NoSuchElementException exception) {
            return ;
        }catch (Exception e){
            return ;
        }
    }
    public static int process_SIZE(){
        return fifo.size();
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        String s[] = input.split(" ");
        int N = Integer.parseInt(s[0]);
        int C = Integer.parseInt(s[1]);
        
        for( int i=0; i<N; i++){
    
            String cmd_arr[] = br.readLine().split(" ");
           if (cmd_arr[0].equals("OFFER")){
                System.out.println(process_OFFER(cmd_arr[1], C));
           } else if (cmd_arr[0].equals("TAKE")){
               process_TAKE();
           }else if (cmd_arr[0].equals("SIZE")){
               System.out.println(process_SIZE());
           }
        }
    }
}