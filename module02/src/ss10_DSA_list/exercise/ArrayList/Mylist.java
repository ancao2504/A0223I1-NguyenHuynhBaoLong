package ss10_DSA_list.exercise.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class Mylist<E> {
    private int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public Mylist() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public Mylist(int CAPACITY) {
        if (CAPACITY >= 0) {
            elements = new Object[CAPACITY];
        } else {
            throw new IllegalArgumentException("capacity: " + CAPACITY);
        }
    }

    public void add(E element, int index) {
        if (index >= elements.length) {
            throw new IllegalArgumentException("index: " + index);
        } else if (elements.length == size) {
            this.ensureCapacity(3);
        }

        if (elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
            for (int i = size + 1; i >= index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity <0) {
            throw new IllegalArgumentException("minCapacity: " +minCapacity);
        } else {
            int newSize = minCapacity + elements.length;
            elements = Arrays.copyOf(elements,newSize);
        }
    }

    public E remove (int index) {
        if (index <0 || index > elements.length) {
            throw new IndexOutOfBoundsException("remove index: " +index);
        }else {
            E element = (E) elements[index];
            for (int i = index; i < size -1; i++) {
                elements[i] = elements[i+1];
            }
            elements[size-1]=null;
            size--;
            return element;
        }
    }

    public E get (int index) {
        if(index <0 || index > elements.length ) {
            throw new IndexOutOfBoundsException("get index: " + index);
        } else {
            return (E) elements[index];
        }
    }

    public void clear () {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    public int size(){
        return this.size;
    }

    public E clone() {
        return (E) Arrays.copyOf(elements,elements.length);
    }

    public Boolean contains (E e) {
        for (int i = 0; i < size-1; i++) {
            if(elements[i] == e) {
                return true;
            }
        }
        return false;
    }

    public int indexOf (E e) {
        for (int i = 0; i < size -1 ; i++) {
            if (elements[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public Boolean add (E e) {
        if (elements.length == size) {
            ensureCapacity(3);
        }
        elements[size] =e;
        return true;
    }
}


