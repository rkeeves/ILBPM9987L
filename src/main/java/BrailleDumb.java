import java.io.*;
import java.util.StringJoiner;

public class BrailleDumb {

    public static void main(String[] args) {
        try (final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int count;
            String modeSymbol;
            while ((count = Integer.parseInt(br.readLine())) > 0) {
                modeSymbol = br.readLine();
                if ("S".equals(modeSymbol)) {
                    acceptDecimal(count, br, bw);
                } else {
                    acceptBraille(count, br, bw);
                }
            }
        } catch (IOException e) {

        }
    }

    static String[][] BRAILLES = new String[][] {
            {".*", "**", ".."},
            {"*.", "..", ".."},
            {"*.", "*.", ".."},
            {"**", "..", ".."},
            {"**", ".*", ".."},
            {"*.", ".*", ".."},
            {"**", "*.", ".."},
            {"**", "**", ".."},
            {"*.", "**", ".."},
            {".*", "*.", ".."}
    };

    static String[] BRAILLE_BOOSTER_ROW0 = new String[10];

    static String[] BRAILLE_BOOSTER_ROW1 = new String[10];

    static {
        for (int i = 0; i < 10; i++) {
            BRAILLE_BOOSTER_ROW0[i] = BRAILLES[i][0];
            BRAILLE_BOOSTER_ROW1[i] = BRAILLES[i][1];
        }
    }

    static void acceptDecimal(int decimalDigitCount, BufferedReader br, BufferedWriter bw) throws IOException {
        String decimals = br.readLine();
        StringJoiner row0 = new StringJoiner(" ");
        StringJoiner row1 = new StringJoiner(" ");
        StringJoiner row2 = new StringJoiner(" ");
        for (int i = 0; i < decimalDigitCount; i++) {
            row0.add(BRAILLE_BOOSTER_ROW0[decimals.charAt(i) - '0']);
            row1.add(BRAILLE_BOOSTER_ROW1[decimals.charAt(i) - '0']);
            row2.add("..");
        }
        bw.write(row0.toString());
        bw.newLine();
        bw.write(row1.toString());
        bw.newLine();
        bw.write(row2.toString());
        bw.newLine();
    }

    static String[] DIGITS = new String[] { "0","1","0","3","0","2","9","6","0","5","0","4","0","8","0","7" };

    static void acceptBraille(int brailleDigitCount, BufferedReader br, BufferedWriter bw) throws IOException {
        String brailleRow0 = br.readLine();
        String brailleRow1 = br.readLine();
        br.readLine();
        StringBuilder sb = new StringBuilder();
        int code;
        for (int i = 0; i < brailleDigitCount*3; i+=3) {
            code = ((brailleRow0.charAt(i) - 1) % 5)
                    + ((brailleRow0.charAt(i+1) - 1) % 5) * 2
                    + ((brailleRow1.charAt(i) - 1) % 5) * 4
                    + ((brailleRow1.charAt(i+1) - 1) % 5) * 8;
            sb.append(DIGITS[code]);
        }
        bw.write(sb.toString());
        bw.newLine();
    }
}
