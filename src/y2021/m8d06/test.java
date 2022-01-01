package y2021.m8d06;

class Parent{
    int a;

    Parent(int a){
        this.a = a;
    }
}
class Child extends Parent{
    int b;
    Child(int a, int b){
        super(a);
        this.b = b;
    }
}

public class test {
    public static void main(String[] args) {
        Parent p = new Parent(1);
        Child c = new Child(1, 2);
        System.out.println(c);
        int i1= 19;
        long i2 =20;
        //int i3 = i1 +i2;

        float fi = 10.0f;
        float f2 = fi + 20.1f;
        System.out.println(f2);
        int nums []= new int[3];
        nums = new int[] {1,2 ,3,4};




    }
}
