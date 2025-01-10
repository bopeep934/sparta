
package com.example.calculator;
import java.util.function.BinaryOperator;
import java.util.*;
import java.util.function.DoubleBinaryOperator;

public class ArithmeticCalculator{
    double answer;//결과값
    Operation operate;//연산 객체 변수
    private ArrayList<Operation> resultArray = new ArrayList<>();//연산 객체 배열
    private int num=1;//배열 번호 변수
    private double x,y;


    public ArithmeticCalculator() {
    }

    public enum OperatorType{
        PLUS("+", (x, y) -> x + y),
        MINUS("-", (x, y) -> x - y),
        MULTI("*", (x, y) -> x * y),
        DIVIDE("/", (x, y) -> x / y);

        private DoubleBinaryOperator op; // 람다식을 저장할 필드

        private String symbol;

        OperatorType(String symbol, DoubleBinaryOperator op) {
            this.symbol = symbol;
            this.op = op;
        }

        @Override
        public String toString() {
            return symbol;
        }

        public double apply(double x, double y) {
            return op.applyAsDouble(x, y);
        }
    }


    public <T extends Number> double calculate(T a, T b, char symbol) {
        OperatorType ot;

        this.x=a.doubleValue();
        this.y=b.doubleValue();



        switch (symbol) {
            case '+':
                ot = OperatorType.PLUS;
                answer = ot.apply(x, y);
                break;
            case '-':
                ot = OperatorType.MINUS;
                answer = ot.apply(x, y);
                break;
            case '*':
                ot = OperatorType.MULTI;
                answer = ot.apply(x, y);
                break;
            case '/':
                ot = OperatorType.DIVIDE;
                answer = ot.apply(x, y);
                break;
        }
        operate=new Operation(num,x,y,symbol,answer);//연산 객체 하나 생성

        resultArray.add(operate);//연산 객체 배열에 계산할 때마다 연산 객체 하나씩 추가
        num++;

        return answer;
    }

        void allResult () {
            for(Operation operate: resultArray){
                operate.resultOperation();
            }
        }

        void getResult (int i){
             resultArray.get(i-1).resultOperation();
        }

        void setResult ( int i, char symbol){
            resultArray.get(i-1).modifyOperation(symbol);
            resultArray.get(i-1).resultOperation();
            System.out.println("수정됐습니다.");
        }

        void xResult(int i){
        ListView lv=new ListView();
        ArrayList<Operation> xList;
        lv.getXList(resultArray,i);
        }

        void removeResult () {
            resultArray.remove(0);//arrayList는 삭제되면 앞으로 당겨지기 때문에 인덱스를 0으로 지정해도 상관없음.
            System.out.println("삭제됐습니다.");
        }
    }


