package linkedList;

public class SinglyLinkedListTest {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLastNode("정산하");
        System.out.println(list.getLastNode());
        list.addLastNode("박혜준");
        list.printList();

        list.addFirstNode("이현식");
        list.printList();

        list.insertAfterNode(list.getNode("이현식"), "임혁");
        list.printList();
        Node target = list.getNode("박혜준");
        System.out.println(list.getPreviousNode(target));
        System.out.println(list.getNode("이현식"));
        list.deleteNode("임혁");
        list.printList();
    }
}
