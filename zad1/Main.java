package zadaniaDomowe.zad1;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Użycie: java Main <number> <root>");
            return;
        }

        double a = Double.parseDouble(args[0]);
        double root = Double.parseDouble(args[1]);


        System.out.printf("Root: %s^(1/%.4f) = %.12f%n", args[0], root, new Newton().calculateRoot(a, root));
    }
}