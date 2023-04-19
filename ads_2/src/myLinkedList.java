import java.util.Iterator;
public class myLinkedList<T extends Comparable<T>> implements myList<T>{
    class myNode {
        private T data;
        private myNode prev;
        private myNode next;

        public myNode (T data) {
            this.data = data;
        }

        public myNode (T data, myNode prev) {
            this(data);
            this.prev = prev;
        }

        public myNode (T data, myNode prev, myNode next) {
            this(data, prev);
            this.next = next;
        }
    }
    private int size;
    private myNode head;
    private myNode tail;


    private myNode nodeByIndex(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();
        myNode temp = head;
        int i = 0;
        while (temp != null){
            if (i == index) return temp;
            i++;
            temp = temp.next;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        myNode temp = head;
        for(int i = 0; i < size; i++) {
            if(temp.data.equals(o)) return true;
            temp = temp.next;
        }
        return false;
    }

    @Override
    public void add(T item) {
        myNode newNode = new myNode(item);
        size++;
        if (head == null) {
            head = newNode;
            tail = head;
            return;
        }
        newNode.prev = tail;
        tail.next = newNode;
        tail = tail.next;

    }

    @Override
    public void add(T item, int index) {
        if(index >= size) throw new IndexOutOfBoundsException();
        size++;
        myNode newNode = new myNode(item);

        if(index == 0) {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            return;
        }
        if(index == size - 1) {
            add(item);
            return;
        }
        myNode prev = nodeByIndex(index - 1);
        myNode next = nodeByIndex(index);
        prev.next = newNode;
        newNode.prev = next;
        next.prev = newNode;
        newNode.next = next;
    }

    @Override
    public boolean remove(T item) {
        int i = 0;
        for (T nodede: this){
            if (nodede.equals(item)){
                remove(i);
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public T get(int index) {
        if(index >= size ) throw new IndexOutOfBoundsException();
        int i = 0;
        for (T nodede : this){
            if (i == index) return nodede;
            i++;
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        int i = 0;
        for (T nodede: this){
            if (nodede.equals(o)) return i;
            i ++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        myNode nodede = tail;
        int i = size - 1;
        while (nodede != null){
            if (nodede.data.equals(o)) return i;
            nodede = nodede.prev;
            i--;
        }
        return -1;
    }

    @Override
    public void sort() {
        myNode curr = head;
        myNode index;

        while (curr != null) {
            index = curr.next;
            while (index != null) {
                if (index.data.compareTo(curr.data) < 0) {
                    T temp = curr.data;
                    curr.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            curr = curr.next;
        }
    }



    @Override
    public T remove(int index) {
        if(index >= size) throw new IndexOutOfBoundsException();
        size--;
        if(index == 0) {
            T data = head.data;
            head = head.next;
            return data;
        } else if(size - 1 == index) {
            T data = tail.data;
            tail = tail.prev;
            tail.next = null;
            return data;
        }
        myNode current = head;
        for(int i = 0; i < index - 1; i++)
            current = current.next;

        T data = current.next.data;
        current.next = current.next.next;
        return data;
    }


    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        myNode node = head;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            T data = node.data;
            node = node.next;
            return data;
        }
    }
}
