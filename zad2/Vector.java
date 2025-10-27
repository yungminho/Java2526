package zadaniaDomowe.zad2;

import java.util.Arrays;

public class Vector extends Tensor{
    protected double[] values;

    public Vector(double[] values) {
        this.n = values.length;
        this.values = Arrays.copyOf(values, n);
    }


    @Override
    public Vector add(Tensor other) {
        if (!(other instanceof Vector v)) throw new  IllegalArgumentException("Można dodać tylko wektory");
        if (this.n != v.n) throw new IllegalArgumentException("Nieprawidłowy wymiar wektora");

        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            result[i] = this.values[i] + v.values[i];
        }
        return new Vector(result);
    }

    @Override
    public Vector multiply(double scalar) {
        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            result[i] = this.values[i] * scalar;
        }
        return new Vector(result);
    }

    @Override
    public double dot(Tensor other) {
        if (!(other instanceof Vector v)) throw new IllegalArgumentException("Iloczyn skalarny tylko dla wektorów");
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum += this.values[i] * v.values[i];
        }
        return sum;
    }

    public Matrix tensor(Vector other) {
        double[][] result = new double[n][other.n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < other.n; j++) {
                result[i][j] = this.values[i] * other.values[j];
            }
        }
        return new Matrix(result);
    }

    @Override
    public String toString() {
        return "Vector" + Arrays.toString(values);
    }
}
