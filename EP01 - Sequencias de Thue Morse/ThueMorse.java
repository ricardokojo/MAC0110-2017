/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Ricardo Hideki Hangai Kojo
 *  Numero USP: 10295429
 *  Tarefa: Exercício 1 - Sequências de Thue-Morse 
 *  Data: 23/03/2017
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
 *   javac ThueMorse.java
 *   java ThueMorse
 *
*******************************************************************************/

public class ThueMorse{
	public static void main(String args[]){
		String seq0 = "0";
		String seq1 = "1";

		//01, 10
		String seq2 = seq0 + seq1;
		String seq3 = seq1 + seq0;

		//0110, 1001
		String seq4 = seq2 + seq3;
		String seq5 = seq3 + seq2;

		//01101001, 10010110
		String seq6 = seq4 + seq5;
		String seq7 = seq5 + seq4;

		//0110100110010110, 1001011001101001
		String seq8 = seq6 + seq7;
		String seq9 = seq7 + seq6;

		//01101001100101101001011001101001, 10010110011010010110100110010110
		String seq10 = seq8 + seq9;
		String seq11 = seq9 + seq8;

		//0110100110010110100101100110100110010110011010010110100110010110
		String seq12 = seq10 + seq11;

		System.out.println(seq2);
		System.out.println(seq4);
		System.out.println(seq6);
		System.out.println(seq8);
		System.out.println(seq10);
		System.out.println(seq12);
	}
}