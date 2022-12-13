import java.util.EmptyStackException;


public class Stack<Type> {

    private ArrayList<Type> arrayList;

    public Stack() {
        arrayList = new ArrayList<Type>();
    }

    public boolean empty() {
        return arrayList.size() == 0;
    }

    public Type push(Type item) {
        arrayList.add(item);

        return item;
    }

    public Type peek() {
        int len = arrayList.size();

        if (len == 0)
            throw new EmptyStackException();
        return arrayList.get(len - 1);
    }

    public Type pop() {
        Type obj = arrayList.remove(arrayList.size() - 1);

        return obj;
    }

    public int search(Object o) {
        int i = arrayList.lastIndexOf(o);

        if (i >= 0) {
            return arrayList.size() - i;
        }
        return -1;
    }

    public void add(Type value) {
        arrayList.add(value);
    }

    public int size() {
        return arrayList.size();
    }

}

