import java.util.*;

public class clinic_village_distribuition {

    public static double findMinMaxLoad(double[] arr, int k) {
        int n = arr.length;
        k = k - n;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for (double el : arr) {
            pq.add(new double[] { el, el, 1 });
        }
        if (k == 0) {
            return pq.peek()[0];
        }

        while (k > 0) {
            double[] atTop = pq.poll();
            double parent = atTop[1], countOfClinicsAlloted = atTop[2];
            pq.add(new double[] { parent / (countOfClinicsAlloted + 1), parent, countOfClinicsAlloted + 1 });
            k--;
        }

        return pq.peek()[0];
    }

    public static void main(String[] args) {

        double[] testCase1 = new double[] { 200, 50, 20 };
        System.out.println(findMinMaxLoad(testCase1, 5));

        double[] testCase2 = new double[] { 100 };
        System.out.println(findMinMaxLoad(testCase2, 1));

        double[] testCase3 = new double[] { 100, 100, 100, 100 };
        System.out.println(findMinMaxLoad(testCase3, 8));

        double[] testCase4 = new double[] { 1000, 10, 10, 10 };
        System.out.println(findMinMaxLoad(testCase4, 10));

        double[] testCase5 = new double[] { 10, 20, 30 };
        System.out.println(findMinMaxLoad(testCase5, 10));

    }
}