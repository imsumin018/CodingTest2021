/* package whatever; // don't place package name! */

import java.io.*;
import java.util.HashMap;
import java.util.Arrays;
class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        String input2 = br.readLine();
        int target = Integer.parseInt(input2);
               
        
        HashMap<Integer, Integer> map= new HashMap<>();
        
        String s[] = input.split(" ");
        int out[] = new int[s.length];
        for(int i = 0 ; i < s.length ; i++) {
            out[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(out);
        for(int i=0; i<out.length; i++) {
            //int p = Integer.parseInt(s[i]);
            int p = out[i];
            int check = map.getOrDefault(p,0);
            if (check==0){
                map.put(target-p,p);
            }
        }
        for (int i=out.length-1; i>=0; i--) {
            int check = map.getOrDefault(out[i],0);
            if (check != 0){
                
                System.out.print(Math.min(check,target-check)+" "+Math.max(check,target-check));
                return;
            }
            
            }
        
    }
}