import java.util.Scanner; 
 
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float num1;    //실수형
        float num2;
        String oper; //문자열
        String con;
        boolean a; //논리값
        
        do{
            System.out.print("숫자 입력 : ");
            num1 = sc.nextFloat();
            a = true;
            do {
                System.out.print("연산자 입력 : ");
                oper = sc.next();
                
                switch(oper) {
                    case "+":
                        a=false;
                        break;
                    case "-":
                        a=false;
                        break;
                    case "*":
                        a=false;
                        break;
                    case "/":
                        a=false;
                        break;
                    default:
                        System.out.print("연산자를 다시 입력해주세요 \n ");                
                    }                
                }while(a);
                
            System.out.print("숫자 입력 : ");
            num2 = sc.nextFloat();
            
            switch(oper) {
            case "+":
                System.out.println(num1+num2);
                break;
            case "-":
                System.out.println(num1-num2);
                break;
            case "*":
                System.out.println(num1*num2);
                break;
            case "/":
                System.out.println(num1/num2);
                break;
            default:
                System.out.print("처음부터 다시 입력해주세요 \n ");
                continue;              
            }
        
            System.out.print("계산을 계속 하시려면  y 혹은 Y를 입력해 주세요 : ");
            con = sc.next();
            if(con.equals("y") || con.equals("Y") ){
                continue;
                }
                else{
                    System.out.println("종료합니다.");
                    break;
                }    
            }while(true);
    }
 
 
 
}

