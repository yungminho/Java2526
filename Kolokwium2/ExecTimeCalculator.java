import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ExecTimeCalculator {
    private Class<?> clazz;
    private List<Long> timeList;
    public ExecTimeCalculator(Class<?> clazz) {
        this.clazz = clazz;
        timeList = new ArrayList<>();
    }

    public void run(String[] argsForMain) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method mainMethod = clazz.getMethod("main", String[].class);
        for (int i = 0; i < 50; i++) {
            long start = System.currentTimeMillis();
            mainMethod.invoke(null, (Object) argsForMain);
            long end = System.currentTimeMillis();

            long duration = end - start;
            timeList.add(duration);
        }

        long sum = 0;

        for (Long time : timeList) {
            sum += time;
        }

        long mean = sum / timeList.size();

        System.out.println("Average execution time for "+ clazz.getName() +": " + mean + "ms");
    }
}
