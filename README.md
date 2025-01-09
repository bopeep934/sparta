# 📱CH2.계산기 과제 

## 📚목차 
 1. 프로젝트 소개
 2. 개발 기간
 3. 개발 환경
 4. 기능 설명
 

## 1️⃣ 프로젝트 소개

자바 클래스를 이용해 사용자에게 피연산자를 입력받아 사칙연산을 실행하고 결과를 보여주는 계산기 프로그램입니다.

## 2️⃣ 개발 기간

2025.1.2~2025.1.10 8일

## 3️⃣ 개발 환경
- IntellyJ IDEA
- JDK 17
- corretto 17.0.3
- Gradle

## 4️⃣ 기능 구현

### Lv 1. 클래스 없이 기본적인 연산을 수행할 수 있는 계산기 만들기

- [ ]  **양의 정수(0 포함)를 입력받기**
```java
 - Scanner.nextDouble()로 정수 입력받기
```

 
- [ ]  **사칙연산 기호(➕,➖,✖️,➗)를 입력받기**
```java
 - Scanner.nextLine()으로 String형 입력받은 후
  CharAt(0)으로 한글자만 처리
```


- [ ]  **위에서 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력하기**
```java
 - switch(char c) 문으로 
    case '+': 기호별로 구분한 후 
    result=a+b; 연산 실행 
```

- [ ]  **반복문을 사용하되, 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 수정하기**
```java
while(true)문으로 무한으로 돌린 후 
if (operation.equals("exit")) { if문으로 입력받은 문자가 exit인 경우
      System.out.println("끝");
       break; } break; 로 while문 빠져나가기
```


### Lv 2. 클래스를 적용해 기본적인 연산을 수행할 수 있는 계산기 만들기
- [ ] 사칙연산을 수행 후, 결과값 반환 메서드 구현 & 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성


```java
public class App {

Calculator calculate = new Calculator(); 
```


  |자료형|역할|
  |--|--|
  |int result| 계산 결과값을 저장|
  |ArrayList<Integer> resultArray|결과값을 모은 배열|
  
- [ ] Lv 1에서 구현한 App 클래스의 main 메서드에 Calculator 클래스가 활용될 수 있도록 수정
```java
Calculator calculate = new Calculator(); 메인에서 Calculator 클래스를 생성 후
  ...
  result = calculator.calculate(a, b, symbol);  Scanner로 입력받은 인자를 계산 함수 calculate에 매개변수로 넘겨 결과값을 반환받는다.
  ```
- [ ] App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정 (캡슐화)
  
    필드 앞에 private 명령어를 사용해 접근하지 못하도록 하고,
  Calculator allResult() 함수를 통해 결과값들을 불러옴

```java
  Calculator{
   private int result;
   private ArrayList<Integer> resultArray;
  
   ....
  
   void allResult(){ 
        System.out.println(resultArray.toString());
    }
  
  Main{
     ...
       calculator.allResult();
  

  ```
- [ ] Calculator 클래스에 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드를 구현한 후 App 클래스의 main 메서드에 삭제 메서드가 활용될 수 있도록 수정
  
  arrayList.remove(0)을 써서 가장 먼저 앞에 있는 결과값 삭제하도록 함.
  삭제 후에는 뒤의 인자가 0번으로 오기 때문에 인덱스 값을 (0)으로 지정해도 상관없음.
```java
 void removeResult () { 
            resultArray.remove(0); 
            System.out.println("삭제됐습니다.");
        }
  
  ... 
  main{ 
    for(int i=0;i<num;i++) { 
            System.out.println("삭제하시겠습니까? (y:예 n:아니오):");
            operation = sc2.nextLine();

            if (operation.equals("y")) {
                calculator.removeResult();
                calculator.allResult();
            }// 가장 먼저 저장된 연산결과 삭제하기
```

### Lv 3. Enum, 제네릭, 람다 & 스트림을 이해한 계산기 만들기
                           
- [ ] Enum 타입을 활용하여 연산자 타입에 대한 정보를 관리하고 이를 사칙연산 계산기 ArithmeticCalculator 클래스에 활용 해봅니다.
```java
   public enum OperatorType{
        PLUS("+", (x, y) -> x + y),
        MINUS("-", (x, y) -> x - y),
        MULTI("*", (x, y) -> x * y),
        DIVIDE("/", (x, y) -> x / y);
  ```                           
                           

- [ ] 실수, 즉 double 타입의 값을 전달 받아도 연산이 수행하도록 만들기
  
  제네릭을 이용해 main에서 어떤 자료형을 입력받아도 상관없도록 T로 묶은 후 doubleValue()로 double형으로 변환 후 계산
                           
```java
  class ArithmeticCalculator{
  public <T extends Number> double calculate(T a, T b, char symbol) {
        OperatorType ot;

        this.x=a.doubleValue();
        this.y=b.doubleValue();
```    
 

- [ ] 저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값 들을 출력
1. 연산식들을 배열로 묶기 위해 Class Operation 생성
2. Operation에는 입력받은 피연산자 2개, 연산자 1개, 결과값이 저장되어 있음
3. 계산식을 ArrayList에 저장
4. main 에서 값을 입력받으면 ArithmeticCalculator클래스에서 처리
5. class ListView을 생성해 람다&스트림문으로 ArrayList에 저장한 계산식 배열들을 처리
  
  
```java
  main{
          calculator.xResult(x);

  
  class ArithmeticCalculator{
  ...
   void xResult(int i){ 
        ListView lv=new ListView();
        lv.getXList(resultArray,i);
        }
  
  class ListView{
  ...
   public void getXList(ArrayList<Operation> allList, int x){//전체 리스트를 받은 후
        allArrayList=allList;//현재 리스트에 넣고
        this.x=x;
        xArrayList.addAll(addXList(allArrayList,x));//매개변수로 넘겨서 x값 이상의 결과값을 구하는 함수를 실행해 값을 구해서
        printList(xArrayList);//출력함수를 통해 출력한다.
    }
```
  
  
 ## 5️⃣ 사용법
  1.사용자는 피연산자 두개, 사칙연산 기호를 입력한다.
  
  ![](https://velog.velcdn.com/images/gkinfn/post/09a87dc4-49a1-4cc9-a25d-19756a64c828/image.png)

  2.연산결과를 출력한다.
  
  ![](https://velog.velcdn.com/images/gkinfn/post/e0857959-370b-42b3-bb6c-65b6762feeba/image.png)

  3.다시 계산하고 싶으면, 0 아니면 exit를 입력해 계산을 종료한다.
  (exit를 입력할 때까지 무한으로 반복)
  
  ![](https://velog.velcdn.com/images/gkinfn/post/e46bb3d5-5591-4119-b309-be93ea9477d8/image.png)

  4.exit를 입력해 계산을 끝내면 모든 연산들을 보여준다.
  
  ![](https://velog.velcdn.com/images/gkinfn/post/956268e6-5529-441e-a14b-9bc68f1bbfcc/image.png)


  5.보고 싶은 연산식의 번호를 입력하면 그 계산식만 보여준다.
  
  ![](https://velog.velcdn.com/images/gkinfn/post/9fe39879-d4e4-4f6b-8cb2-7d670c82ed42/image.png)


  6.수정하고 싶은 연산번호와 연산기호를 입력하면,
  프로그램은 새로운 연산기호로 해당번호의 연산식을 다시 계산해서 출력한다.
  
  ![](https://velog.velcdn.com/images/gkinfn/post/b41bcbd9-e701-481c-8c5f-be1de10468cb/image.png)

  7.삭제여부를 물어봤을 때 y를 입력하면 맨 앞의 계산식이 사라지고 출력,
  모든 연산들이 없어질 때까지 반복해서 질문이 뜬다.
  n을 입력하면 더는 삭제하지 않고 종료한다.
  
  ![](https://velog.velcdn.com/images/gkinfn/post/123963a3-1c4f-4b53-93be-21e397a96322/image.png)

  8.계산기를 종료한다.
  
  ![](https://velog.velcdn.com/images/gkinfn/post/927ad8bf-df00-4ebc-b31d-0a566ce1cbfd/image.png)

  

  
 ## 6️⃣ 어려웠던 점
  1. enum,제네릭,람다&스트림 개념이 생소해서 강의 복습과 검색을 통해 익히느라 애를 먹었고, 실전에서 과제 의도대로 효율적으로 쓰지 못해 아쉬웠다.
  2. 클래스/메소드 별로 기능을 나눌 때 미리 다이어그램을 작성해놓지 않으면 기능이 중첩되기 쉬어 코드가 비효율적으로 작성됨을 알게됐다. 생각나는 대로 구현을 한 것이 오히려 시간이 많이 걸렸다.
  3. 의외로 환경설정에서도 에러가 많이 나서, 검색하면서 많이 고쳤다.
  4. 단순히 메소드 종류만 안다고 되는 것이 아니라, 자바의 기존 함수를 사용할 때는 내가 생각지도 못한 제한이나 규칙이 많아서 일단 하는 것보단, 함수에 자세히 공부하고 메소드를 쓰는 것이 더 바람직하다는 것을 느꼈다.
 

  
 ## 7️⃣ 아쉬웠던 점
  1. 입력에서 잘못된 값을 입력하면 잘못된 값이라고 출력하고 다시 시작하는 에러 구현을 하고 싶었다.
  2. 입력한 값보다 큰 값을 조회하는 기능 뿐만 아니라 연산기호에 따라 조회하기 기능도 추가하고 싶었다. 또는 음수, 양수에 따라 구별하기 기능도 추가하고 싶었다.





 # 🎊 읽어주셔서 감사합니다.

 
  
 ### 연락처
- Email: gkinfn@gmail.com
- GitHub: @bopeep934
