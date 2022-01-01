package y2021.m8d06;

public class Static {
    public static void main(String[] args) {
        Test.t1(); // 1.값? or 에러?
      //  Test.t2(); // 2.값? or 에러?
        Test test = new Test();
        test.t1(); // 3.값? or 에러?
        test.t2(); // 4.값? or 에러?

        Test2 testA = new Test2();
        System.out.println(testA.count); // 5.값? or 에러?
        Test2 testB = new Test2();
        System.out.println(testB.count); // 6.값? or 에러?
        Test2 testC = new Test2();
        System.out.println(Test2.count); // 7.값? or 에러?
    }
}

class Test {
    static void t1 () {
        System.out.println("1");
    }
    void t2 () {
        System.out.println("2");
    }
}

class Test2 {
    static int count = 0;

    Test2(){
        count++;
    }
}
