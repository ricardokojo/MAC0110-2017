/*
 * $ java QuantosAs abbaba
 * Número de as: 3
 * $ java QuantosAs bcbc
 * Número de as: 0
 */

public class QuantosAs {

    public static void main(String[] args) { 
	String s = args[0];
	int as = 0;

	for (int i = 0; i < s.length(); i++) 
	    if (s.charAt(i) == 'a') as++;

	System.out.println("Número de as: " + as);
    }
}
