
public class MyArrayList<Type> {
    protected int capacity;
    protected Type[] list;
    protected int size;

    public MyArrayList() {
        capacity = 16;
        this.list = (Type[]) new Object[capacity];
    }

    public void insert(Type item, int index){
        if(index > size || index < 0){
            return;
        }

        if (capacity == size){
            resize();
        }

        for(int i = capacity - 1; i >= index; i--){
            if (list[i] != null) {
                list[i + 1] = list[i];
            }
        }
        list[index] = item;
        size++;
    }

    public Type remove(int index){
        if (index < 0 || index > size){
            return null;
        }
        Type returnValue = list[index];
        for(int i = index; i < capacity - 1; i++){
            list[i] = list[i + 1];
        }

        size--;
        return returnValue;

    }

    public boolean contains(Type item){
       for (int i = 0; i <= size; i++){
           if (list[i] == item) {
               return true;
           }
       }
       return false;
    }

    public int indexOf(Type item){
        for (int i = 0; i <= size; i++){
            if (list[i] == item){
                return i;
            }
        }
        return -1;
    }

    public Type get(int index){
        if (index >= 0 && index < capacity){
            return list[index];
        }
        return null;
    }

    public void set(Type item, int index){
        if (index >= 0 && index < capacity){
            list[index] = item;
            size++;
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public String toString(){
        String arrayString;
        arrayString = "[";
        for (int i = 0; i < size - 1; i++){
            arrayString = arrayString.concat(list[i] + ", ");
        }
        return arrayString = arrayString.concat(list[size - 1] + "]");
    }

    protected void resize(){
        capacity *= 2;
        Type[] mirror = (Type[]) new Object[capacity];
        for (int i =0; i < list.length; i++){
            mirror[i] = list[i];
        }
        list = mirror;

    }

}
