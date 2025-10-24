package zadaniaDomowe.zad1;

public class Newton {
    private static final double EPSILON = 1e-12;
    private static final int MAX_ITERATIONS = 10_000;


    public double calculateRoot(double a, double root) {
        if (root == 0) return Double.NaN;

        if (a < 0 && root % 2 == 1) return -nthRoot(-a, root);
        if (a < 0 && root % 2 == 0) return Double.NaN;

        if (abs(root - floor(root)) < EPSILON) {
            return nthRoot(a, root);
        } else {
            double exponent = 1.0 / root;
            return pow(a, exponent);
        }
    }

    private double nthRoot(double number, double root) {
        double x = number > 1 ? number / root : 1.0;

        for (int i = 0; i < MAX_ITERATIONS; i++) {
            double xPrev = x;
            x = ((root - 1) * x + number / pow(x, root - 1)) / root;
            if (abs(x - xPrev) < EPSILON) break;
        }

        return x;
    }

    private double abs(double x) {
        if  (x < 0) return -x;
        return x;
    }

    private double pow(double base, double exp) {
        if (base < 0 && exp % 1 != 0) return Double.NaN;

        return expApprox(exp * lnApprox(base));
    }

    private static double lnApprox(double x) {
        if (x <= 0) return Double.NaN;
        double y = 0.0;
        for (int i = 0; i < 25; i++) {
            double eToY = expApprox(y);
            y -= (eToY - x) / eToY;
        }
        return y;
    }

    private static double expApprox(double x) {
        double term = 1.0;
        double sum = 1.0;
        for (int i = 1; i < 35; i++) {
            term *= x / i;
            sum += term;
        }
        return sum;
    }

    private static double floor(double x) {
        long i = (long) x;
        if (x < 0 && x != i) {
            return i - 1;
        }
        return i;
    }
}