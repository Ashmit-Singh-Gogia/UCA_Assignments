package Heap_Problems.Clinic_Village_Distribution;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Test 1: Example from problem description
        // 3 villages [200, 20, 50], 5 clinics -> 200/3 = 66.67
        double[] test1 = { 200, 20, 50 };
        System.out.printf("Test 1: Expected: 66.67, Result: %.2f%n",
                Clinic_Village_Distribution.findMinMaxLoad(test1, 5));

        // Test 2: Single village, single clinic
        // 1 village [100], 1 clinic -> 100/1 = 100.00
        double[] test2 = { 100 };
        System.out.printf("Test 2: Expected: 100.00, Result: %.2f%n",
                Clinic_Village_Distribution.findMinMaxLoad(test2, 1));

        // Test 3: Equal populations, double the clinics
        // 4 villages [100, 100, 100, 100], 8 clinics -> each village gets 2 clinics -> 50.00
        double[] test3 = { 100, 100, 100, 100 };
        System.out.printf("Test 3: Expected: 50.00, Result: %.2f%n",
                Clinic_Village_Distribution.findMinMaxLoad(test3, 8));

        // Test 4: One dominant village
        // 4 villages [1000, 10, 10, 10], 10 clinics -> 1000 gets 7 clinics -> 1000/7 = 142.86
        double[] test4 = { 1000, 10, 10, 10 };
        System.out.printf("Test 4: Expected: 142.86, Result: %.2f%n",
                Clinic_Village_Distribution.findMinMaxLoad(test4, 10));

        // Test 5: Small populations, many clinics
        // 3 villages [10, 20, 30], 10 clinics -> 30 gets extra clinics
        // Extra 7 clinics distributed greedily -> max load = 20/3 = 6.67
        double[] test5 = { 10, 20, 30 };
        System.out.printf("Test 5: Expected: 6.67, Result: %.2f%n",
                Clinic_Village_Distribution.findMinMaxLoad(test5, 10));

        // Test 6: Single village, multiple clinics
        // 1 village [500], 4 clinics -> 500/4 = 125.00
        double[] test6 = { 500 };
        System.out.printf("Test 6: Expected: 125.00, Result: %.2f%n",
                Clinic_Village_Distribution.findMinMaxLoad(test6, 4));

        // Test 7: Two villages, very uneven
        // 2 villages [900, 100], 5 clinics -> extra 3 go to 900
        // 900->450->300->225, max(225,100) = 225.00
        double[] test7 = { 900, 100 };
        System.out.printf("Test 7: Expected: 225.00, Result: %.2f%n",
                Clinic_Village_Distribution.findMinMaxLoad(test7, 5));

        // Test 8: All villages have zero population except one
        // 3 villages [0, 0, 300], 6 clinics -> extra 3 all go to 300
        // 300->150->100->75, max = 75.00
        double[] test8 = { 0, 0, 300 };
        System.out.printf("Test 8: Expected: 75.00, Result: %.2f%n",
                Clinic_Village_Distribution.findMinMaxLoad(test8, 6));
    }
}
