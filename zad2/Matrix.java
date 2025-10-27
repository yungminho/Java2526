package zadaniaDomowe.zad2;

import java.util.Arrays;

public class Matrix extends Tensor implements Multipliable<Matrix> {
    protected double[][] values;

    public Matrix(double[][] values) {
        this.n = values.length;
        this.values = new double[n][n];
        for (int i = 0; i < n; i++) {
            this.values[i] = Arrays.copyOf(values[i], n);
        }
    }

    @Override
    public Matrix add(Tensor other) {
        if (!(other instanceof Matrix m)) throw new IllegalArgumentException("Można dodać tylko macierze");

        double[][] result = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = this.values[i][j] + m.values[i][j];
            }
        }
        return new Matrix(result);
    }

    @Override
    public Matrix multiply(double scalar) {
        double[][] result = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = this.values[i][j] * scalar;
            }
        }
        return new Matrix(result);
    }

    @Override
    public double dot(Tensor other) {
        if (!(other instanceof Matrix m)) throw new IllegalArgumentException("Iloczyn skalarny tylko dla macierzy.");

        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += this.values[i][j] * m.values[i][j];
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Matrix[\n");
        for (int i = 0; i < n; i++) {
            sb.append("  ").append(Arrays.toString(values[i])).append("\n");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Matrix multiply(Matrix other) {
        double[][] result = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double sum = 0.0;
                for (int k = 0; k < n; k++)
                    sum += this.values[i][k] * other.values[k][j];
                result[i][j] = sum;
            }
        }
            return new Matrix(result);
    }
}
