package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class ListView {

    private int x;
    ArrayList<Operation> allArrayList = new ArrayList<>();//전체 연산배열  리스트
    ArrayList<Operation> xArrayList = new ArrayList<>();//x값 이상 연산배열  리스트


    public void getXList(ArrayList<Operation> allList, int x){//전체 리스트를 받은 후
        allArrayList=allList;//현재 리스트에 넣고
        this.x=x;
        xArrayList.addAll(addXList(allArrayList,x));//매개변수로 넘겨서 x값 이상의 결과값을 구하는 함수를 실행해 값을 구해서
        printList(xArrayList);//출력함수를 통해 출력한다.
    }
    public void printList(ArrayList<Operation> allList){//xList 함수를 돌려 리스트를 반환한다.
        for(Operation operate: allList){
            operate.resultOperation();
        }
    }

    public static ArrayList<Operation> addXList(ArrayList<Operation> allList, int x) {
        ArrayList<Operation> xAnswerList = new ArrayList<>();
        for (Operation xAnswer : allList) {
            if (xAnswer.getAnswer()>=x) {// 입력한 x값보다 반환받은 답이 크다면
                xAnswerList.add(xAnswer);//새로운 리스트에 추가
            } }
        return xAnswerList;
    }

}
