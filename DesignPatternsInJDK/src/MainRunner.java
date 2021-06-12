import java.util.ArrayList;
import java.util.List;

public class MainRunner {


    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("Wiktor");
        names.add("Tomek");
        names.add(0,"Maciek");
        names.set(0,"Asia");
        names.remove("Asia");
        System.out.println(names.size());

        for (String name : names){
            // iterator use hasNext() - so the last element will never be delete
            System.out.println("Name is : " + name);
            //names.remove(name);
//            System.out.println(name);
        }
    }
}
