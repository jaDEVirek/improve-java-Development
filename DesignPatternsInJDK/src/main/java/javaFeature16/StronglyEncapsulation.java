package javaFeature16;


import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Random;

/**
 *
 *
 */
public class StronglyEncapsulation {

    public static void main(String[] args) {
        RecordComponent[] recordComponents = MyRecord.class.getRecordComponents();
        MyRecord witkor = new MyRecord("Witkor", "11");

        System.out.println(Arrays.stream(recordComponents).toList());

    }
    record MyRecord(String name, String id) {
         static String Field;
        public MyRecord(String name) {
            this(name, String.valueOf(new Random().nextInt(1)+11));
        }

        public String getField() {
           return this.name;
        }
    }


}

