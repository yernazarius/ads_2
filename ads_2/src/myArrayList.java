import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class myArrayList<T> implements myList<T>{
    private Object[] data;
    private int size;

    public myArrayList() {
        this.data = new Object[10];
        this.size = 0;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < size; i++){
            if(data[i].equals(o)) return true;
        }

        return false;
    }
    private void increaseCapacity(){
        Object[] temp = new Object[size * 2];
        for(int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    @Override
    public void add(T item){
        if (size >= data.length) increaseCapacity();
        data[size++] = item;
    }

    @Override
    public void add(T item, int index) {
        if (index > size) throw new IndexOutOfBoundsException();
        if (size() == data.length) increaseCapacity();
        for (int i = size; i > index; i--)
            data[i] = data[i - 1];

        data[index] = item;
        size++;
    }

    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T>{
        private int index;
        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            return get(index++);
        }
    }
    private void private_remove(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
    }
    @Override
    public boolean remove(T item) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)) {
                private_remove(i);
                return true;
            }
        }
        size--;
        return false;
    }
    @Override
    public T remove(int index) {
        T temp = get(index);
        for (int i = index; i < size - 1; i++){
            data[i] = data[i + 1];
        }
        data[size--] = null;
        return temp;
    }
    @Override
    public T get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();
        return (T) data[index];
    }
    @Override
    public void clear() {
        size = 0;
        data = new Object[10];
    }

    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < size; i++){
            if(data[i].equals(o)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int i = size - 1; i >= 0; i--){
            if(data[i].equals(o)) return i;
        }
        return -1;
    }
    @Override
    public void sort() {
        Arrays.sort(data, 0, size);
    }

}
