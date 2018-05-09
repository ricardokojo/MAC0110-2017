/******************************************************************************
 * $ java-introcs CharHisto < CharHisto.java
 * 32  : 94
 * 33 !: 0
 * 34 ": 4
 * 35 #: 0
 * 36 $: 1
 * 37 %: 0
 * 38 &: 2
 * 39 ': 0
 * 40 (: 9
 * 41 ): 9
 * [...]
 ******************************************************************************/

public class CharHisto {

    public static void main(String[] args) {
	String s = StdIn.readAll();
	int l = s.length();
	int[] h = new int[127];

	for (int i = 0; i < l; i++) {
	    char c = s.charAt(i); 
	    if (32 <= c && c < 127) // printable chars
		h[c]++;
	}

	for (int i = 32; i < 127; i++) {
	    char c = (char)i;
	    StdOut.println(i + " " + c + ": " + h[i]);
	}

    }
}

