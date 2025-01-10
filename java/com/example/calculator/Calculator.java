package com.example.calculator;
import java.util.*;


public class Calculator {

    int result;//결과값
    ArrayList<Integer> resultArray =new ArrayList<Integer>();

    int init=0;//배열 표시 변수

    public Calculator(){}

    public int resultOperate(int a,int b, char symbol){

        switch (symbol) {
            case '+':
                result=a+b;
                break;

            case '-':
                result=a-b;
                break;

            case '*':
                result=a*b;
                break;

            case '/':
                result=a/b;
                break;

            default:
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                break;
        }

        resultArray.add(result);
        return result;
    }

    void allResult(){
        System.out.println(resultArray.toString());
    }

    int getResult(int i){
        return resultArray.get(i);
    }
    void setResult(int x,int y){
        resultArray.set(x,y);
        System.out.println("수정됐습니다.");
    }
    void removeResult(){
        resultArray.remove(0);
        System.out.println("삭제됐습니다.");
    }
}