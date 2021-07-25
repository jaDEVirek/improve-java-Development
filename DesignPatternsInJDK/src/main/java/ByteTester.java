import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 *
 */
public class ByteTester {


    public static void main(String[] args) throws IOException {

        InputStream is = new ByteArrayInputStream( new byte[]{0, 1, 2, 5, 6, 7, 8});
        Long aLong = new Long(1l);
        byte[] arrByte = new byte[]{0, 1, 2, 5, 6, 7, 8};
        ByteArrayOutputStream outBt = new ByteArrayOutputStream();
        byte[] data = new byte[4];

        int integer;
        while ((integer = is.read(data,0,data.length) )!= -1 ){
            System.out.println("Times");
                outBt.write(data,0,integer);
        }
        outBt.flush();

        System.out.println(Arrays.toString(outBt.toByteArray()));

    }
}
