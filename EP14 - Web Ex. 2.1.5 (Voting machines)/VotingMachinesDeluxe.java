/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Ricardo Hideki Hangai Kojo
 *  Numero USP: 10295429
 *  Tarefa: Web Ex. 2.1.5 - Voting Machines Deluxe
 *  Data: 11/05/2017
 *  
 *
 * DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS 
 * PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO  
 * PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE, 
 * FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS 
 * AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 * DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

/******************************************************************************
 *
 * Nota: 8.75
 *
 * Comentários do Monitor:
 *   Não passou no teste: java-introcs VotingMachinesDeluxe 100 0.6 10000 (-0.25)
 *   Não passou no teste: java-introcs VotingMachinesDeluxe 20 0.6 10000 (-0.25)
 *   Não passou no teste: java-introcs VotingMachinesDeluxe 20 0.75 10000 (-0.25)
 *   Não passou no teste: java-introcs VotingMachinesDeluxe 20 0.8 10000 (-0.25)
 *   Não passou no teste: java-introcs VotingMachinesDeluxe 20 1 10000 (-0.25)
 *
 * Como rodar:
 *   javac-introcs VotingMachinesDeluxe.java
 *   java-introcs VotingMachinesDeluxe <n> <a> <t>
 * sendo <n> o número de votantes, <a> a porcentagem de votantes que escolheram o candidato A (em decimal) e <t> a quantidade de testes a serem rodados.
 *
*******************************************************************************/

public class VotingMachinesDeluxe{
	public static void main(String[] args){
		int n = Integer.parseInt(args[0]);
		double a = Double.parseDouble(args[1]);
		int t = Integer.parseInt(args[2]);

		double f = 0; // variavel procurada
		double aux_menor = 0; // auxiliares
		double aux_maior = 1;
		double temp_f = .5; // f temporario
		double p = 0; // probabilidade
		int erros = 0;

		// Calculo de votos para A e B (sem erro da urna)
		int votos_a = (int) (n * a);
		int votos_b = n - votos_a;

		for(int i = 0; i <= t-1; i++){
			for(int j = 0; j <= t-1; j++){
				if(verifica_votacao(n, a, temp_f, votos_a)) erros++;
			}

			p = (double) erros/t;
			if(p <= 0.03){
				// p aceitavel
				f = temp_f;
				aux_menor = temp_f;
				temp_f = (temp_f + aux_maior)/2;
			} else {
				// p inaceitavel
				aux_maior = temp_f;
				temp_f = (temp_f + aux_menor)/2;
			}

			if(Math.abs(f - temp_f) < 1e-4) break; // Se as 4 primeiras casas decimais forem as mesmas duas vezes seguidas, encerra o loop (margem de erro)
			erros = 0;
		}

		// Saida
		StdOut.println(f);
	}

	// Aplica a aleatoriedade e contabiliza os votos novamente
	public static boolean verifica_votacao(int n, double a, double f, int votos_a){
		int novos_votos_a = 0;
		int novos_votos_b = 0;

		for(int i = 0; i <= n - 1; i++){		
			double random = Math.random();

			// Computando votos de A
			if(i < votos_a-1){
				if (random < f) novos_votos_b++;
				else novos_votos_a++;
			} else {
				// Computando votos de B
				if (random < f) novos_votos_a++;
				else novos_votos_b++;
			}
		}

		return (novos_votos_b > novos_votos_a);
	}
}