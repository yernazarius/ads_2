import java.util.Arrays;
import java.util.Iterator;

public class myArrayList<T extends Comparable<T>> implements myList<T> {
    private int size;
    private Object[] data;

    public myArrayList() {
        data = new Object[10];
    }

    private void increaseCapacity() {
        Object[] newArray = new Object[(int) (data.length * 2)];
        for (int i = 0; i < data.length; i++)
            newArray[i] = data[i];
        data = newArray;
    }

    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < this.size; i++)
            if (data[i].equals(o)) return true;

        return false;
    }

    @Override
    public void add(T item) {
        if (size == data.length) increaseCapacity();
        data[size++] = item;
    }

    @Override
    public void add(T item, int index) {
        if (size == data.length) increaseCapacity();
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = item;
        size++;
    }

    @Override
    public boolean remove(T item) {
        if (indexOf(item) == -1) return false;
        remove(indexOf(item));
        return true;
    }

    @Override
    public T remove(int index) {
        if(index >= size || index < 0) throw new IndexOutOfBoundsException();
        T removed = (T) data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return removed;
    }

    @Override
    public void clear() {
        data = new Object[10];
        size = 0;
    }

    @Override
    public T get(int index) {
        if(index >= size || index < 0) throw new IndexOutOfBoundsException();
        return (T) data[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(o)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i].equals(o)) return i;
        }
        return -1;
    }

    @Override
    public void sort() {
        Arrays.sort(data, 0, size);
    }


    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public T next() {
            return get(index++);
        }
    }
}
