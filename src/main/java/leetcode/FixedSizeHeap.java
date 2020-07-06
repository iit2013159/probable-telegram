package leetcode;

import java.util.PriorityQueue;

public class FixedSizeHeap<E> extends PriorityQueue<E> {
    int size;
    @Override
    public boolean add(E e) {
        if(super.size() > size){

        }
        return super.add(e);
    }
}
