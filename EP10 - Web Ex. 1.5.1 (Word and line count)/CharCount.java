/******************************************************************************
 * $ java-introcs CharCount < in.1
 ******************************************************************************/

public class CharCount {

    public static void main(String[] args) {
        int chars = 0;    
        while (StdIn.hasNextChar()) {
            char c = StdIn.readChar();
	    chars++;
        }
	StdOut.println("number of chars  = " + chars);
    }
    
}

