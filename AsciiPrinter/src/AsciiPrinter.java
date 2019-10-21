public class AsciiPrinter {

    private static final int ASCII_START = 0;
    private static final int ASCII_END = 255;

    public static void print() {
        int iter = ASCII_START;

        for (; iter <= ASCII_END; iter++) {
            System.out.print((char) iter);
        }
    }

}
