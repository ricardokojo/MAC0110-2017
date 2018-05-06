/******************************************************************************
 * java-introcs LineCount < in.1
 ******************************************************************************/

public class LineCount {

    public static void main(String[] args) {
	int lines = 0;    
        while (StdIn.hasNextChar()) {
            char c = StdIn.readChar();
	    if (c == '\n') lines++;
        }
	StdOut.println("number of lines  = " + lines);
    }
    
}

