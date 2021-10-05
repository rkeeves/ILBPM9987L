import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://progcont.hu/submission/?id=ddea4c5b-649c-4988-971b-da03efb129ee
public class Nessie {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            br.readLine();
            String[] buff;
            while (true) {
                buff = br.readLine().split("\\s+");
                System.out.println((Integer.parseInt(buff[0])/3) * (Integer.parseInt(buff[1])/3));
            }
        } catch (Exception e) {

        }
    }
}
