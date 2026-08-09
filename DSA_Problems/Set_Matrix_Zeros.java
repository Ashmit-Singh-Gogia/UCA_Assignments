class Set_Matrix_Zeros {
    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void setZeroes(int[][] matrix) {
        int col0 = matrix[0][0];
        int rows = matrix.length, cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j == 0) {
                        col0 = 0;
                        continue;
                    }
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < cols; i++) {
            if (matrix[0][0] == 0) {
                matrix[0][i] = 0;
            }
        }
        for (int i = 0; i < rows; i++) {
            if (col0 == 0) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 }
        };
        int[][] matrix2 = {
                { 0, 1, 2, 0 },
                { 3, 4, 5, 2 },
                { 1, 3, 1, 5 }
        };
        setZeroes(matrix1);
        setZeroes(matrix2);
        print(matrix1);
        print(matrix2);
    }

}
