import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

public class MainRunner {


    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("Wiktor");
        names.add("Tomek");
        names.add(0, "Maciek");
        names.set(0, "Asia");
        names.remove("Asia");
        System.out.println(names.size());


        for (String name : names) {
            // iterator use hasNext() - so the last element will never be delete
            System.out.println("Name is : " + name);
            //names.remove(name);
//            System.out.println(name);
        }

        for (int x = 0; x < names.size(); x++) {
            System.out.println("Without has next : " + names.get(x));
            if (names.iterator()
                    .next()
                    .equals(names.get(0))) {
                names.remove(0);
            }
            names.remove(x);
        }
        System.out.println(names);
    }
}
