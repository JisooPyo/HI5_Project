package Memo_Project;

import java.util.Scanner;
public class Input { //Complexity is 3 Everything is cool!

        int number = 1;

       public Memo input(){
           Scanner sc = new Scanner(System.in);
           System.out.println("이름, 비밀번호, 메모를 입력해 주세요.");
           String name = sc.nextLine();
           String password = sc.nextLine();
           String note = sc.nextLine();
           String date = "20230606";
           Memo memo = new Memo(number,name,password,note,date);
           number++;
           return memo;
    }
}
