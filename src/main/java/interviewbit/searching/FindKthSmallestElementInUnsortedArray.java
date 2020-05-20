package interviewbit.searching;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Given an unsorted array/List. need to find the Kth smallest element
 * without using extra space and without modifying the list.
 * There are no faster solution than NlogN. Even if we relax space optimization.
 * One solution can be to just sort the array and find the kth index.
 * 2nd solution be using Quick Select.
 * This solution involves binary search.
 */
public class FindKthSmallestElementInUnsortedArray {
    public static void main(String[] args) {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();

        Executors.newCachedThreadPool();
        SynchronousQueue queue;
        Lock lock = new ReentrantLock();
        Condition con = readLock.newCondition();
        Semaphore semaphore;
        List<Integer> ls = new ArrayList();
        Optional op;
        Set<String> s = new HashSet<>(Arrays.asList());
        //s.toArray(String[] )
        //IntSummaryStatistics intSummaryStatistics = ls.stream().mapToInt(ls).summaryStatistics()
    }
}
