
public class MyLinkedList<Type> {
    protected Node first;
    protected Node current;
    protected Node previous;
    protected int size;

    public MyLinkedList() {
        first = null;
        current = null;
        previous = null;
    }

    protected class Node {
        public Type item;
        public Node next;
        public String toString(){
            return item.toString();
        }

    }

    public void addBefore(Type item){
        Node newNode = new Node();
        newNode.item = item;

        if (current == null){
            if (previous == null) {
                previous = newNode;
                first = previous;
            } else {
                newNode.next = null;
                previous.next = newNode;
                previous = newNode;
            }
        }
        if (current == first){
            first = newNode;
        }
        previous.next = newNode;
        newNode.next = current;
        previous = newNode;
        size++;
    }

    public void addAfter(Type item){
        Node newNode = new Node();
        newNode.item = item;
        if (current != null){
            if (current.next != null){
                newNode.next = current.next;
            }
            current.next = newNode;
            size++;
        }
    }

    public Type remove(){
        if (current == null){
            return null;
        }
        Type store = current.item;
        if (current == first){
            first = first.next;
            current = first;
            previous = first;
        } else {
            previous.next = current.next;
            current = current.next;
        }
        size--;
        return store;

    }

    public Type current(){
        if (current == null) {
            return null;
        } else {
            return current.item;
        }
    }

    public Type first(){
        if (first == null) return null;
        current = first;
        return first.item;
    }

    public Type next(){
        if (current == null){
            return null;
        } else {
            current = current.next;
            return current.item;
        }
    }

    public boolean contains(Type item){
        while (current != null){
            if (next() == item){
                return true;
            }
        }
        return false;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public String toString(){
        String returnString = "[" + first.item;
        Node temp = new Node();
        temp = first.next;
        while (temp != null){
            returnString = returnString.concat(", ").concat(temp.toString());
            temp = temp.next;
        }
        returnString = returnString.concat("]");
        return returnString;
    }

}
