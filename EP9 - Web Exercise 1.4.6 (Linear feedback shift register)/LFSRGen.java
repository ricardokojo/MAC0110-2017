/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Ricardo Hideki Hangai Kojo
 *  Numero USP: 10295429
 *  Tarefa: Ex. 1.4.6 - Linear feedback shift register; variante)
 *  Data: 20/04/2017
 *
 ******************************************************************************/

/******************************************************************************
 *
 * Nota: 8.75
 *
 * Comentários do Monitor:
 *   Não realiza o shift como sugerido no enunciado. (-1.25)
 *
 * Como rodar:
 *   javac LFSRGen.java
 *   java LFSRGen <semente> <tap> <num_bits>
 * sendo <semente> a sequência de bits, <tap> a posição do bit que será usado para o LFSR e <num_bits> o número de bits que serão adicionados.
 *
*******************************************************************************/

public class LFSRGen{
	public static void main(String args[]){
		String semente = args[0];
		int tap = Integer.parseInt(args[1]);
		int num_bits = Integer.parseInt(args[2]);
		String result = "";
		char a, b;

		for(int i=0;i<=num_bits-1;i++){
			//Pega o primeiro caracter e o caractere do tap
			a = semente.charAt(0);
			b = semente.charAt((semente.length()-1)-tap);

			//Remove primeiro caractere
			semente = semente.substring(1);

			//Faz o XOR, adiciona no final da semente e na string result
			if((a == '1' && b == '1') || (a == '0' && b == '0')){
				result = result + "0";
				semente = semente + "0";
			} else {
				result = result + "1";
				semente = semente + "1";
			}

		}

		System.out.println(result);
	}
}