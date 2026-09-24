package Heap_Problems.Median_Data_Stream;

import java.util.*;

public class Median_Data_Stream {

    PriorityQueue<Double> minHeap = new PriorityQueue<>();
    PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public Median_Data_Stream() {
        // TODO: Initialize your data structures here
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num < maxHeap.peek()) {
            maxHeap.add(num + 0.0);
        } else {
            minHeap.add(num + 0.0);
        }

        // Balance the heaps
        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if ((maxHeap.size() + minHeap.size()) % 2 == 0) {
            double el1 = maxHeap.peek(), el2 = minHeap.peek();
            return (el1 + el2) / 2;
        } else {
            return maxHeap.peek();
        }
    }
}
