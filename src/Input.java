import java.util.Scanner;
public class Input {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int num = Integer.parseInt(input);

        System.out.println(num);

        String Name;
        String Password;
        String Memo;

        System.out.printf("이름을 입력하세요.%n");
        Name = scan.nextLine();
        System.out.printf("비밀번호를 입력하세요.%n");
        Password = scan.nextLine();
        System.out.printf("메모를 입력하세요.%n");
        Memo = scan.nextLine();


    }
}
