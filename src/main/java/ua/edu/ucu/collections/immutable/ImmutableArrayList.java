package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {
    private Object[] array;

    public ImmutableArrayList() {
        this.array = new Object[0];
    }

    private void outOfBounds(int ind) {
        if (ind < 0 || ind > array.length) {
            throw new IndexOutOfBoundsException();
        }
    }

    public ImmutableArrayList(Object[] outside) {
        this.array = Arrays.copyOf(outside, outside.length);
    }

    @Override
    public ImmutableList add(Object e) {
        Object[] newarray = new Object[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newarray[i] = array[i];
        }
        newarray[array.length] = e;
        return new ImmutableArrayList(newarray);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        outOfBounds(index);
        Object[] newarray = new Object[array.length + 1];
        int i = 0;
        int j = i;
        for (i = 0; i < newarray.length; i++, j++) {
            if (i != index) {
                newarray[i] = array[j];
            } else {
                newarray[i] = e;
                j--;
            }
        }
        return new ImmutableArrayList(newarray);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(array.length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        outOfBounds(index);
        Object[] newarray = new Object[array.length + c.length];
        int i = 0;
        int j = i;
        for (i = 0; i < newarray.length; i++, j++) {
            if (i != index) {
                newarray[i] = array[j];
            } else {
                for (int k = 0; k < c.length; k++) {
                    newarray[i + k] = c[k];
                }
                i = i + c.length - 1;
                j--;
            }
        }
        return new ImmutableArrayList(newarray);
    }

    @Override
    public Object get(int index) {
        return array[index];
    }

    @Override
    public ImmutableList remove(int index) {
        outOfBounds(index);
        Object[] newarray = new Object[array.length - 1];
        int i = 0;
        int j = i;
        for (i = 0; i < newarray.length; i++, j++) {
            if (i != index) {
                newarray[i] = array[j];
            } else {
                j++;
                newarray[i] = array[j];
            }
        }
        return new ImmutableArrayList(newarray);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        outOfBounds(index);
        Object[] newarray = Arrays.copyOf(array, array.length);
        newarray[index] = e;
        return new ImmutableArrayList(newarray);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, array.length);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";

        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            result.append(array[i].toString()).append(", ");
        }
        result.deleteCharAt(result.length()
                - 1).deleteCharAt(result.length() - 1);

        return result.toString();
    }
}
