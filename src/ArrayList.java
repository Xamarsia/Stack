import java.util.Iterator;

public class ArrayList<E> implements ArrayListInterface<E> {

    private int capacity = 10;

    private int size = 0;

    private Object[] content = {};

    public ArrayList() {
        this.content = new Object[capacity];
    }

    public ArrayList(int initialCapacity) {
        capacity = initialCapacity;
        this.content = new Object[capacity];
    }

    public ArrayList(ArrayList<E> arraylists) {
        if (arraylists == null) {
            return;
        }
        capacity = arraylists.size() * 2;
        this.content = new Object[capacity];

        for (int i = 0; i < arraylists.size(); i++) {
            content[i] = arraylists.get(i);
            ++size;
        }
    }

    public static class ArrayIterator<E> implements Iterator<E> {
        int currentIndex = 0;
        transient ArrayList<E> array;

        public ArrayIterator(ArrayList<E> array) {
            this.array = array;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < array.size();
        }

        @Override
        public E next() {
            E value = array.get(currentIndex);
            ++currentIndex;
            return value;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        return (E) content[index];
    }

    @Override
    public void add(E value) {
        if (size == capacity) {
            grow();     // increase current capacity of list
        }
        content[size++] = value;
    }

    @Override
    public int lastIndexOf(Object object) {
        int lastIndex = size() - 1;
        if (lastIndex >= size) {
            throw new IndexOutOfBoundsException(lastIndex + " >= "+ size);
        }

        if (object == null) {
            for (int i = lastIndex; i >= 0; i--)
                if (content[i]==null)
                    return i;
        } else {
            for (int i = lastIndex; i >= 0; i--)
                if (object.equals(content[i]))
                    return i;
        }
        return -1;
    }


    @Override
    public boolean contains(Object object) {
        if (object == null) {
            for (int i = 0; i < size; i++) {
                if (content[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (object.equals(content[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + size);
        }

        Object removedElement = content[index];
        for (int i = index; i < size - 1; i++) {
            content[i] = content[i + 1];
        }
        content[size - 1] = null;
        size--;
        return (E) removedElement;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(this);
    }

    private void grow() {
        Object[] newContent = new Object[capacity * 2];
        capacity *= 2;
        for (int i = 0; i < size; i++) {
            newContent[i] = content[i];
        }
        content = newContent;
    }
}

