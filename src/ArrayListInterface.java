import java.util.Iterator;

public interface ArrayListInterface<E> extends Iterable<E> {

    public int size();

    public E get(int index) throws IndexOutOfBoundsException;

    public void add(E value);

    public boolean contains(Object object);

    public int lastIndexOf(Object object);

    public E remove(int index) throws IndexOutOfBoundsException;

    @Override
    public Iterator<E> iterator();
}
