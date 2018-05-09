/******************************************************************************
 * $ java-introcs LetterHisto < CharHisto.java
 * 0 A: 20
 * 1 B: 3
 * 2 C: 19
 * 3 D: 4
 * 4 E: 4
 * 5 F: 3
 * 6 G: 4
 * 7 H: 15
 * 8 I: 30
 * 9 J: 2
 * [...]
 ******************************************************************************/

public class LetterHisto {

    public static void main(String[] args) {
	String s = StdIn.readAll();
	int l = s.length();
	int[] h = new int['Z' - 'A' + 1]; // index 0 will be for 'A' etc

	for (int i = 0; i < l; i++) {
	    char c = s.charAt(i); 
	    if ('A' <= c && c <= 'Z')
		h[c - 'A']++; // "convert" 'A' to 0, 'B' to 1, etc
	    if ('a' <= c && c <= 'z')
		h[c - 'a']++; // "convert" 'a' to 0, 'b' to 1, etc
	}

	for (int i = 0; i < 'Z' - 'A' + 1; i++) {
	    char c = (char)(i + 'A');
	    StdOut.println(i + " " + c + ": " + h[i]);
	}

    }
}

