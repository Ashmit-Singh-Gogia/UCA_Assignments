package Heap_Problems.Median_Data_Stream;

public class Main {

    public static void main(String[] args) {

        // Test 1: Basic odd count
        // Stream: [1, 2, 3] -> sorted: [1, 2, 3] -> median = 2.0
        Median_Data_Stream mds1 = new Median_Data_Stream();
        mds1.addNum(1);
        mds1.addNum(2);
        mds1.addNum(3);
        System.out.printf("Test 1: Expected: 2.00, Result: %.2f%n", mds1.findMedian());

        // Test 2: Basic even count
        // Stream: [1, 2, 3, 4] -> sorted: [1, 2, 3, 4] -> median = (2+3)/2 = 2.5
        Median_Data_Stream mds2 = new Median_Data_Stream();
        mds2.addNum(1);
        mds2.addNum(2);
        mds2.addNum(3);
        mds2.addNum(4);
        System.out.printf("Test 2: Expected: 2.50, Result: %.2f%n", mds2.findMedian());

        // Test 3: Single element
        // Stream: [42] -> median = 42.0
        Median_Data_Stream mds3 = new Median_Data_Stream();
        mds3.addNum(42);
        System.out.printf("Test 3: Expected: 42.00, Result: %.2f%n", mds3.findMedian());

        // Test 4: Two elements
        // Stream: [5, 15] -> sorted: [5, 15] -> median = (5+15)/2 = 10.0
        Median_Data_Stream mds4 = new Median_Data_Stream();
        mds4.addNum(5);
        mds4.addNum(15);
        System.out.printf("Test 4: Expected: 10.00, Result: %.2f%n", mds4.findMedian());

        // Test 5: All duplicates
        // Stream: [5, 5, 5, 5, 5] -> median = 5.0
        Median_Data_Stream mds5 = new Median_Data_Stream();
        for (int i = 0; i < 5; i++) mds5.addNum(5);
        System.out.printf("Test 5: Expected: 5.00, Result: %.2f%n", mds5.findMedian());

        // Test 6: Negative numbers
        // Stream: [-3, -1, -5, -4, -2] -> sorted: [-5, -4, -3, -2, -1] -> median = -3.0
        Median_Data_Stream mds6 = new Median_Data_Stream();
        mds6.addNum(-3);
        mds6.addNum(-1);
        mds6.addNum(-5);
        mds6.addNum(-4);
        mds6.addNum(-2);
        System.out.printf("Test 6: Expected: -3.00, Result: %.2f%n", mds6.findMedian());

        // Test 7: Mixed positive and negative
        // Stream: [-10, 10, -20, 20] -> sorted: [-20, -10, 10, 20] -> median = (-10+10)/2 = 0.0
        Median_Data_Stream mds7 = new Median_Data_Stream();
        mds7.addNum(-10);
        mds7.addNum(10);
        mds7.addNum(-20);
        mds7.addNum(20);
        System.out.printf("Test 7: Expected: 0.00, Result: %.2f%n", mds7.findMedian());

        // Test 8: Longer stream with mixed values
        // Stream: [6, 10, 2, 6, 5, 0, 6, 3, 1, 0, 0] -> sorted: [0,0,0,1,2,3,5,6,6,6,10] -> median = 3.0
        Median_Data_Stream mds8 = new Median_Data_Stream();
        int[] stream = { 6, 10, 2, 6, 5, 0, 6, 3, 1, 0, 0 };
        for (int num : stream) mds8.addNum(num);
        System.out.printf("Test 8: Expected: 3.00, Result: %.2f%n", mds8.findMedian());
    }
}
