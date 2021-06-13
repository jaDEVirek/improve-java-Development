package JavaStringBuilder;

public class NotSafeString {
    public static StringBuilder stringBuilder = new StringBuilder();
    public static volatile int x;
    public static void main(String[] args) {

        new Thread(new NotSafeString().runner("A")).start();
        new Thread(new NotSafeString().runner("B")).start();
        System.out.println("Builder " + stringBuilder.toString());
    }

    public Runnable runner(String name) {
        Runnable rn = new Runnable() {
            @Override public void run() {
                for (int i = 0; i <= 100; i++) {
                    ++x;
                    stringBuilder.append(name)
                            .append("-"+x+"-");
                }

            }
        };
        rn.run();
        return rn;
    }
}
