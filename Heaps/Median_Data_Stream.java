import java.util.PriorityQueue;

public class Median_Data_Stream {
    PriorityQueue<Double> maxHeap;
    PriorityQueue<Double> minHeap;

    Median_Data_Stream() {
        maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b, a));// takes smaller elements
        minHeap = new PriorityQueue<>((a, b) -> Double.compare(a, b));// takes larger elements
    }

    public void insert(int num) {
        if (maxHeap.isEmpty() || num < maxHeap.peek()) {
            maxHeap.add(num + 0.0);
        } else {
            minHeap.add(num + 0.0);
        }

        // balance the heaps
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double getMedian() {
        if ((maxHeap.size() + minHeap.size()) % 2 == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        Median_Data_Stream median1 = new Median_Data_Stream();
        median1.insert(1);
        median1.insert(2);
        System.out.println(median1.getMedian());
        median1.insert(3);
        System.out.println(median1.getMedian());

        Median_Data_Stream median2 = new Median_Data_Stream();
        median2.insert(1);
        System.out.println(median2.getMedian());
    }
}
