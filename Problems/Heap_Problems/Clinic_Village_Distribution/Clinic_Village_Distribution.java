package Heap_Problems.Clinic_Village_Distribution;

import java.util.*;

public class Clinic_Village_Distribution {

    public static double findMinMaxLoad(double[] arr, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((e1, e2) -> Double.compare(e2[0], e1[0]));
        int n = arr.length;
        if (k < n) {
            return -1;
        }

        for (int i = 0; i < n; i++) {
            pq.add(new double[] { arr[i], arr[i], 1 });
            k--;
        }

        for (int i = 0; i < k; i++) {
            double[] curr = pq.poll();
            double originalValue = curr[1], clinics = curr[2];
            pq.add(new double[] { originalValue / (clinics + 1), originalValue, clinics + 1 });
        }
        return pq.peek()[0];
    }
}
