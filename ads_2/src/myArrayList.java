import java.util.Iterator;

public class myArrayList<T> implements myList<T> {
    private int size = 0;
    private Object[] data;

    public myArrayList() {
        this(10);
    }
    public myArrayList(int size) {
        data = new Object[size];
    }

    private void increaseSize() {
        Object[] temp = new Object[data.length * 2];
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
    }

    @Override
    public void add(T item) {
        if (size == data.length) {
            increaseSize();
        }
        data[size++] = item;
    }
    private void sizeCheck(int index) {
        if (index > data.length) throw new IndexOutOfBoundsException();
    }
    @Override
    public void remove(int index) {
        sizeCheck(index);
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    @Override
    public T get(int index) {
        sizeCheck(index);
        return (T) data[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private int cursor;

        @Override
        public boolean hasNext() {
            return cursor < size();
        }

        @Override
        public T next() {
            return get(cursor++);
        }
    }

}
