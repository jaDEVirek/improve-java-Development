package JavaStringBuilder;

public class NotSafeString {
    public static StringBuilder stringBuilder = new StringBuilder();
    public static volatile int x;

    public static void main(String[] args) {
        write()
        new Thread(new NotSafeString().runner("A")).start();
        new Thread(new NotSafeString().runner("B")).start();
        System.out.println("Builder " + stringBuilder.toString());
    }

    public Runnable runner(String name) {
        return () -> {
            for (int i = 0; i <= 100; i++) {
                ++x;
                stringBuilder.append(name)
                        .append("-" + x + "-");
            }
        };
    }
}
