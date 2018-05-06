/*
 * Este programa implementa a estratégia óbvia, que dá 50% de 
 * chance de vitória para Bob.
 * 
 * Uso: java BiggestNumberDumb a b T
 * 
 * onde a e b são os inteiros escolhidos por Alice (no intervalo 0..1000)
 * e T é o número de vezes que o jogo é simulado.
 *
 * Exemplos de execução:
 * 
 * $ java BiggestNumberDumb 350 700 100
 * 52 [0.52/0.020000000000000018]
 * $ java BiggestNumberDumb 350 700 10000000
 * 4999308 [0.4999308/-6.919999999999149E-5]
 * $ java BiggestNumberDumb 350 700 20000000
 * 10001725 [0.50008625/8.624999999995442E-5]
 * 
 * Com uma estratégia melhor (implementada no programa 
 * BiggestNumber.java), Bob consegue uma boa margem de vitória: 
 * 
 * $ java BiggestNumber 350 700 20000000
 * 13502316 [0.6751158/0.17511580000000004]
 * yoshi@korujinha ~/Documents/www/2017i/mac110/sink/Code/1.2.Web.9
 * $ java BiggestNumber 350 700 20000000
 * 13500565 [0.67502825/0.17502825]
 * 
 * Seu objetivo é encontrar uma tal estratégia para Bob.
 */

public class BiggestNumberDumb {

    public static void main(String[] args) {
	int a = Integer.parseInt(args[0]);
	int b = Integer.parseInt(args[1]);
	int T = Integer.parseInt(args[2]);

	int bigger;
	if (a < b) bigger = 1;
	else bigger = 0;

	int right = 0;
	for (int i = 0; i < T; i++) {
	    // Estratégia ingênua de Bob (que não é boa)
	    int choice;
	    if (Math.random() < .5) choice = 0;
	    else choice = 1;

	    // Escolha correta?
	    if (choice == bigger) right++;
	}
	// Estatística
	double f = (double)right/T;
	System.out.println(right + " [" + f + "/" + (f - .5) + "]");
    }
    
}
