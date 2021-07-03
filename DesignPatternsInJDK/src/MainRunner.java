

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainRunner {

    transient Object[] list;
    int size;
    int array[] = {1,2,3,4,5,6};
    int d = 11;
    Integer integer = 90;
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        MainRunner run = new MainRunner();
        run.modifyArr(run.array, run.d,run.integer);
        System.out.println("Outer " + Arrays.toString(run.array));
        System.out.println(run.d);
        System.out.println(run.integer);
//        MainRunner mainRunner = new MainRunner();
//        mainRunner.list = new Object[3];
//        mainRunner.size += 1;
//        mainRunner.list[0] = "Test4";
//
//        mainRunner.list[1] = "Test3";
//        mainRunner.size += 1;
//        mainRunner.list[2] = "Test2";
//        mainRunner.clear(mainRunner);
//
//        System.out.println(mainRunner.list[0]);
//        names.add("Wiktor");
//        names.add("Tomek");
//        names.add(0, "Maciek");
//        //  names.clear();
//        names.set(0, "Asia");
//        names.remove("Asia");
//        System.out.println(names.size());


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

    void clear(MainRunner byCopyOfRef) {
        MainRunner localRunner = byCopyOfRef;
        final Object[] inner = localRunner.list;
        byCopyOfRef = new MainRunner();
        for (int to = size, i = size = 0; i <= to; i++) {
            inner[i] = null;
        }

        byCopyOfRef.list[1] = "TommyLe";
        this.size = 0;
        System.out.println("Lista " + list.length);
    }

    void modifyArr(int []tab, int b, Integer a){
        for (int e: tab) {
           tab[e]= e++;
        }
        b= 5;
        a=11;
        integer = a;
        System.out.println(Arrays.toString(tab));
    }
}
