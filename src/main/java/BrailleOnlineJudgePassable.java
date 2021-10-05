import java.io.*;

// Runtime Error https://progcont.hu/submission/?id=4cedb10c-dde0-4086-8a54-ae863bec3823
public class BrailleOnlineJudgePassable {

    static final int BUFFER_SIZE = 1000;

    static final char[] inputBuffer = new char[BUFFER_SIZE+1];

    static final char[] outputBuffer = new char[BUFFER_SIZE+1];

    static final int[] DIGIT_TO_BRAILLE = new int[] {14,1,5,3,11,9,7,15,13,6};

    static final char[] BRAILLE_TO_DIGIT = computeBrailleToDigit();

    static char[] computeBrailleToDigit() {
        char[] arr = new char[16];
        for (int i = 0; i < DIGIT_TO_BRAILLE.length; i++) {
            arr[DIGIT_TO_BRAILLE[i]] = (char) ('0' + i);
        }
        return arr;
    }

    public static void main(String[] args) {
        try (final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int count;
            String modeSymbol;
            while ((count = Integer.parseInt(br.readLine())) > 0) {
                modeSymbol = br.readLine();
                if (modeSymbol.equals("S")) {
                    acceptDecimal(count, br, bw);
                } else {
                    acceptBraille(count, br, bw);
                }
            }
        } catch (IOException e) {

        }
    }

    static char[] BRAILLE_MARKS = new char[] {'.', '*'};

    static void acceptDecimal(int decimalDigitCount, BufferedReader br, BufferedWriter bw) throws IOException {
        br.read(inputBuffer, 0, decimalDigitCount+1);
        int offset = 3 * decimalDigitCount;
        int doffset = 2 * offset;
        int num;
        int base;
        for (int i = 0; i < decimalDigitCount; i++) {
            base = i*3;
            num =  DIGIT_TO_BRAILLE[inputBuffer[i]-'0'];
            outputBuffer[base+doffset+2] = ' ';
            outputBuffer[base+doffset+1] = '.';
            outputBuffer[base+doffset] = '.';
            outputBuffer[base+offset+2] = ' ';
            outputBuffer[base+offset+1] = BRAILLE_MARKS[(num & 8) >> 3];
            outputBuffer[base+offset] = BRAILLE_MARKS[(num & 4) >> 2];
            outputBuffer[base+2] = ' ';
            outputBuffer[base+1] =BRAILLE_MARKS[(num & 2) >> 1];
            outputBuffer[base] = BRAILLE_MARKS[num & 1];
        }
        for (int i = decimalDigitCount*3-1; i < decimalDigitCount*9; i+=decimalDigitCount*3) {
            outputBuffer[i] = '\n';
        }
        bw.write(outputBuffer, 0, decimalDigitCount * 9);
    }

    static void acceptBraille(int brailleDigitCount, BufferedReader br, BufferedWriter bw) throws IOException {
        br.read(inputBuffer, 0, brailleDigitCount*9);
        int offset = 3 * brailleDigitCount;
        int num;
        int base;
        for (int i = 0; i < brailleDigitCount; i++) {
            base = i*3;
            num = (inputBuffer[base+offset+1] - 1) % 5;
            num = (num << 1) | ((inputBuffer[base+offset] - 1) % 5);
            num = (num << 1) | ((inputBuffer[base+1] - 1) % 5);
            num = (num << 1) | ((inputBuffer[base] - 1) % 5);
            outputBuffer[i] = BRAILLE_TO_DIGIT[num];
        }
        outputBuffer[brailleDigitCount] = '\n';
        bw.write(outputBuffer, 0, brailleDigitCount+1);
    }
}
