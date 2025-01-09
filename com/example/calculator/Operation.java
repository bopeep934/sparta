package com.example.calculator;

public class Operation {

    private int num;
    private double x;
    private double y;
    private char symbol;
    private double answer;

    public Operation(double x, double y, char symbol){

        this.x=x;
        this.y=y;
        this.symbol=symbol;

    }
    public Operation(int num,double x, double y, char symbol, double answer){

        this.num=num;
        this.x=x;
        this.y=y;
        this.symbol=symbol;
        this.answer=answer;

    }

    public void resultOperation(){//연산식 출력

        System.out.println(num+"."+ x+" "+symbol+" "+y+"="+answer);
    }

    public Operation getOperation(){//객체 반환
        return this;
    }

    public void modifyOperation(char symbol){//연산기호 수정->결과 변경
        this.symbol=symbol;
        ArithmeticCalculator reCalculate=new ArithmeticCalculator();
        this.answer=reCalculate.calculate(x,y,symbol);
    }

    public double getAnswer(){
        return answer;
    }

    public char getSymbol(){
        return symbol;
    }

}
