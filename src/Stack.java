import java.util.EmptyStackException;
public class Stack<E> {

    private ArrayList<E> arrayList;

    public Stack() {
        arrayList = new ArrayList<E>();
    }

    public boolean empty() {
        return arrayList.size() == 0;
    }

    public E push(E item) {
        arrayList.add(item);

        return item;
    }

    public E peek() {
        int len = arrayList.size();

        if (len == 0)
            throw new EmptyStackException();
        return arrayList.get(len - 1);
    }

    public E pop() {
        E obj = arrayList.remove(arrayList.size() - 1);

        return obj;
    }

    public int search(Object o) {
        int i = arrayList.lastIndexOf(o);

        if (i >= 0) {
            return arrayList.size() - i;
        }
        return -1;
    }

    public boolean contains(Object object) {
        return arrayList.contains(object);
    }

    public void add(E value) {
        arrayList.add(value);
    }

    public int size() {
        return arrayList.size();
    }
}

