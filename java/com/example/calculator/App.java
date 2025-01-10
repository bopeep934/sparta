package com.example.calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        //     Calculator calculate = new Calculator();
        ArithmeticCalculator calculator = new ArithmeticCalculator();
        ListView list = new ListView();
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);


        double a, b;// 정수
        int x, y;//순번 입력, 수정할 값
        String operation;//문자열 입력 변수
        char symbol;//기호
        double result;//결과값
        int num = 0;//계산반복횟수


        while (true) {
            try {
                System.out.println("양의 정수를 입력하세요:");
                a = sc.nextDouble();
                System.out.println("두번째 양의 정수를 입력하세요:");
                b = sc.nextDouble();
                System.out.println("사칙연산 기호를 입력하세요:");
                operation = sc2.nextLine();
                symbol = operation.charAt(0);

                result = calculator.calculate(a, b, symbol);

                System.out.println("연산결과: " + a + symbol + b + " = " + result);

                System.out.println("더 계산하시겠습니까? 0을 입력하세요.(exit 입력 시 종료)");
                operation = sc2.nextLine();

                num++;

                if (operation.equals("exit")) {
                    System.out.println("끝");
                    break;
                }
            } catch (Exception e) {
                throw new BadInputException("정수");
            }
        }


        System.out.println("모든 연산결과");
        calculator.allResult();

        System.out.println("몇번째 연산결과를 가져올까요?:");
        x = sc.nextInt();
        calculator.getResult(x);//연산결과 가져오기

        System.out.println("수정하고 싶은 연산번호와 연산기호를 입력하세요");
        System.out.print("연산번호:");
        x = sc.nextInt();
        System.out.print("연산기호:");
        symbol = sc2.nextLine().charAt(0);

        calculator.setResult(x, symbol);//연산결과 수정하기

        System.out.println("재연산결과:");
        calculator.allResult();

        System.out.println("x 이상의 연산결과를 출력합니다.");
        System.out.print("x:");
        x = sc.nextInt();
        calculator.xResult(x);

        //    System.out.println("num:"+num);
        for (int i = 0; i < num; i++) {
            System.out.println("삭제하시겠습니까? (y:예 n:아니오):");
            operation = sc2.nextLine();

            if (operation.equals("y")) {
                calculator.removeResult();
                calculator.allResult();
            }// 가장 먼저 저장된 연산결과 삭제하기
            else break;
        }
        calculator.allResult();
        System.out.println("계산기 종료");
    }
}
