import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        try {
            ExecTimeCalculator sprawdzianJeden = new ExecTimeCalculator(SprawdzianPierwszyReference.class);
            ExecTimeCalculator sprawdzianDwa = new ExecTimeCalculator(SprawdzianDrugi.class);
            sprawdzianJeden.run(new String[]{});
            sprawdzianDwa.run(new String[]{});
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
