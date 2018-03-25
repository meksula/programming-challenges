package com.meksula.collections;

/**
 * @Author
 * Karol Meksuła
 * 25-03-2018
 * */

public interface List <T> {
    void putElement(T element);

    T getElement(int index);

    int size();

    void print();
}
