package com.example.calculator;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Hello, Calculator!");
        int a;//양의정수 a
        int b;//양의정수 b
        int result;//결과값
        String operation;//연산과 종료값 입력받을 문자열
        char symbol;//기호


        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);


         while(true) {
             System.out.println("양의 정수를 입력하세요:");
             a = sc.nextInt();
             System.out.println("두번째 양의 정수를 입력하세요:");
             b = sc.nextInt();
             System.out.println("사칙연산 기호를 입력하세요:");
             operation = sc2.nextLine();
             symbol = operation.charAt(0);


             if (operation.equals("exit")){
                 System.out.println("연산을 종료합니다.");
                 break;
             }
             else {

                 switch (symbol) {
                     case '+':
                         result=a+b;
                         System.out.println("연산결과: "+ a +" + " + b+" = " +result);
                         break;

                     case '-':
                         result=a-b;
                         System.out.println("연산결과: "+ a +" - " + b+" = " +result);
                         break;

                     case '*':
                         result=a*b;
                         System.out.println("연산결과: "+ a +" * " + b+" = " +result);
                         break;

                     case '/':
                         result=a/b;
                         System.out.println("연산결과: "+ a +" / " + b+" = " +result);
                         break;

                     default:
                         System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                         break;
                 }
                 System.out.println("종료를 원하시면 'exit'를 입력, 아니면 0을 입력해주세요:");
                 operation = sc2.nextLine();
                 if (operation.equals("exit")){
                     System.out.println("연산을 종료합니다.");
                     break;
                 }
             }
         }

        sc.close();
        sc2.close();

}
}
