package uva.nessie;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

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
