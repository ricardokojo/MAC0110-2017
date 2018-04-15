/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Ricardo Hideki Hangai Kojo
 *  Numero USP: 10295429
 *  Tarefa: Exercise 1.2.9 - Guess the biggest number
 *  Data: 06/04/2017
 *  Baseado em BiggestNumberDumb.java disponibilizado no PACA
 *
 ******************************************************************************/

/******************************************************************************
 *
 * Nota: 10.0
 *
 * Comentários do Monitor:
 * - 
 *
 * Como rodar:
 *   javac BiggestNumberDumbResposta.java
 *   java BiggestNumberDumbResposta <a> <b> <T>
 * sendo <a> e <b> números inteiros de 0 a 1000 e <T> a quantidade de testes a serem rodados.
 *
*******************************************************************************/

public class BiggestNumberDumb {
    
    public static void main(String[] args) {
	int a = Integer.parseInt(args[0]);
	int b = Integer.parseInt(args[1]);
	int T = Integer.parseInt(args[2]);

	int bigger;
	if (a < b) bigger = 1; //carta A = 0; carta B = 1; 
	else bigger = 0;

	int right = 0;
	for (int i = 0; i < T; i++) {
	    // Bob pega uma carta aleatória e verifica seu valor;
	    int choice, valor;
	    if (Math.random() < .5){
                choice = 0;
                valor = a;
            }
	    else {
                choice = 1;
                valor = b;
            }

            int random = (int)(Math.random()*1001); // Número aleatório de 0 a 1000;
                
            //Se o número gerado aletóriamente for maior que a carta escolhida, troca de carta;
            if (valor == 0 || random > valor){
                if (choice == 0) choice = 1;
                else choice = 0;
            }

	    // Escolha correta?
	    if (choice == bigger) right++;
	}
	// Estatística
	double f = (double)right/T;
	System.out.println(right + " [" + f + "/" + (f - .5) + "]");
    }
    
}
