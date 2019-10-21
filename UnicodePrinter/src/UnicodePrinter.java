public class UnicodePrinter {

    private static final int UNICODE_START = 0;
    private static final int UNICODE_END = 65536;

    public static void print(){
        int iter = UNICODE_START;

        for (; iter<= UNICODE_END; iter++){
            System.out.print((char)iter);
        }
    }
}
