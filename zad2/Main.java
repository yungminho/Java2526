package zadaniaDomowe.zad2;

public class Main {
    public static void main(String[] args) {
        Vector v1 = new Vector(new double[]{1, 2, 3});
        Vector v2 = new Vector(new double[]{4, 5, 6});
        System.out.println(v1);
        System.out.println(v2);
        System.out.println("v1 + v2 = " + v1.add(v2));
        System.out.println("v1 · v2 = " + v1.dot(v2));
        System.out.println("2 * v1 = " + v1.multiply(2));
        System.out.println("v1 ⊗ v2 = \n" + v1.tensor(v2));

        Matrix A = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Matrix B = new Matrix(new double[][]{{5, 6}, {7, 8}});
        System.out.println(A);
        System.out.println(B);
        System.out.println("\nA + B = \n" + A.add(B));
        System.out.println("A · B = " + A.dot(B));
        System.out.println("A × 2 = \n" + A.multiply(2));
        System.out.println("A × B = \n" + A.multiply(B));
    }
}
