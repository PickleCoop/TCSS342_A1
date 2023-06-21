
public class TestLists{
    public static void main(String[] args){
        MyArrayList<Integer> list = new MyArrayList<>();
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        list.insert(100, 0);
        list.insert(100, 1);
        list.insert(100, 2);
        list.insert(100, 3);
        list.insert(100, 4);
        list.insert(100, 5);
        list.insert(100, 6);
        list.insert(100, 7);
        list.insert(100, 8);
        list.insert(100, 9);
        list.insert(100, 10);
        list.insert(100, 11);
        list.insert(100, 12);
        list.insert(100, 13);
        list.insert(100, 14);
        list.insert(100, 15);
        list.insert(100, 16);
        list.insert(100, 17);
        list.insert(100, 18);
        System.out.println(list.toString());
        System.out.println(list.indexOf(100));

        linkedList.addBefore(100);
        linkedList.addBefore(200);
        linkedList.addBefore(200);
        linkedList.addBefore(200);
        linkedList.addBefore(200);
        linkedList.first();
        linkedList.next();
        linkedList.addAfter(500);
        System.out.println(linkedList.toString());

    }
}