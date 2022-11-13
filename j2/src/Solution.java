import java.util.InputMismatchException;

public class Solution {

    public static void main(String[] args) {
        String line;
        try {
            line = getLine(args);
        } catch (NoArgumentException exception) {
            System.err.println(exception.getMessage());
            return;
        }

        System.out.println(args[0]);
        StringBuffer string = new StringBuffer(args[0]);
        int position = 0;
        boolean exit = false;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                position = i;
                exit = true;
            }
            if (string.charAt(i) == ')' && exit) {
                string.delete(position + 1, i);
                exit = false;
            }
        }
        System.out.println(string);
    }

    private static String getLine(String[] args) throws NoArgumentException {
        if (args.length < 1) {
            throw new NoArgumentException("Error! Nothing was entered");
        }
        return args[0];
    }
}
