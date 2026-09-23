package Hashing.Max_Number_Of_Points_On_StraightLine;

public class Max_Points_On_Line_Brute {
    public double getSlope(int[] point1, int[] point2) { // x1,y1 x2,y2
        int numerator = point2[1] - point1[1]; // y2 - y1
        int denominator = point2[0] - point1[0]; // x2 - x1

        if (denominator == 0) {
            return Double.POSITIVE_INFINITY;
        }

        return (double) numerator / denominator;
    }

    public int maxPoints(int[][] points) {
        int n = points.length, max = 0;
        if (n <= 2)
            return n;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int count = 2;
                double slope = getSlope(points[i], points[j]);
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j)
                        continue;
                    double currSlope = getSlope(points[i], points[k]);
                    if (slope == currSlope)
                        count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
