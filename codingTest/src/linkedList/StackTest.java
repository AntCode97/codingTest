package linkedList;

public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("악뮤");
        stack.push("아이유");
        stack.push("김재환");
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
}
