package commons;

import java.util.Arrays;

public class Matrix {
    private int[][] matrix;

    public Matrix(int n) {
        matrix = new int[n][n];
    }

    public Matrix(int n, int m) {
        matrix = new int[n][m];
    }

    public Matrix(int[] input) {
        matrix = new int[input.length][1];
        for (int i = 0; i < input.length; i++) {
            matrix[i][0] = input[i];
        }
    }

    public Matrix(int[][] input) {
        matrix = input;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setValue(int i, int j, int value) {
        matrix[i][j] = value;
    }

    public void output() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public Matrix transpose() {
        int n = matrix.length;
        int m = matrix[0].length;
        Matrix transMatrix = new Matrix(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transMatrix.getMatrix()[i][j] = matrix[j][i];
            }
        }
        return transMatrix;
    }

    public Matrix multiply(Matrix inputMatrix) {
        Matrix result = new Matrix(this.matrix.length, inputMatrix.getMatrix()[0].length);
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < inputMatrix.getMatrix()[0].length; j++) {
                int temp = 0;
                for (int k = 0; k < this.matrix[0].length; k++) {
                    temp += this.matrix[i][k] * inputMatrix.getMatrix()[k][j];
                }
                result.getMatrix()[i][j] = temp;
            }
        }
        return result;
    }

    public Matrix multiply(int value) {
        Matrix result = new Matrix(this.matrix.length, this.matrix[0].length);
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                result.getMatrix()[i][j] = this.matrix[i][j] * value;
            }
        }
        return result;
    }

    public Matrix sub(Matrix inputMatrix) {
        Matrix result = new Matrix(this.matrix.length, this.matrix[0].length);
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                result.getMatrix()[i][j] = this.matrix[i][j] - inputMatrix.getMatrix()[i][j];
            }
        }
        return result;
    }

    public Matrix add(Matrix inputMatrix) {
        Matrix result = new Matrix(this.matrix.length, this.matrix[0].length);
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                result.getMatrix()[i][j] = this.matrix[i][j] + inputMatrix.getMatrix()[i][j];
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(matrix);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Matrix other = (Matrix) obj;
        if (!Arrays.deepEquals(matrix, other.matrix))
            return false;
        return true;
    }

    public static Matrix getIdentityMetrix(int n) {
        Matrix identity = new Matrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    identity.getMatrix()[i][j] = 1;
                } else {
                    identity.getMatrix()[i][j] = 0;
                }
            }
        }
        return identity;
    }
}
