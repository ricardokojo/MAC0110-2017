/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Ricardo Hideki Hangai Kojo
 *  Numero USP: 10295429
 *  Tarefa: Ex.3 Amigo Secreto (novamente)
 *  Data: 11/04/2017
 *  Baseado em:
 *    Ex.2 Amigo Secreto e AmigoSecreto.java criado para tal exercício
 *
 ******************************************************************************/

/******************************************************************************
 *
 * Nota: 9.75
 *
 * Comentários do Monitor:
 *   [EstimaPermutacoes] Saída diferente da proposta no enunciado: -0.75;
 *   Bônus (+0.5)
 *
 * Como rodar:
 *   javac EstimaPermutacoes.java
 *   java EstimaPermutacoes <nmax> <t>
 * sendo <nmax> o número máximo de pessoas no amigo secreto e <t> a quantidade de permutações aleatórias geradas por número de pessoas.
 *
*******************************************************************************/

public class EstimaPermutacoes{
    public static void main(String[] args) {
        int p_nmax = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        
        for(int i = 2; i<= p_nmax; i++){ //i e o numero de pessoas
            int cont_boas = 0;
            double porcentagem;
            
            for(int j = 1; j <= t; j++){ //j e o indice de testes
                
                //Gerador de permutacoes
                int[] perm = new int[i];
                int aux = 1;
                int index_randomico;
                while(aux <= i){
                    index_randomico = (int)(Math.random() * i); //Index randomico de 0 até i atual
                    if (perm[index_randomico] == 0){
                        if (aux <= i && aux == index_randomico) break; // se i = a[i], sai;
                        if(aux == i) {
                            if (index_randomico != 0) cont_boas++;
                            break;
                        } //para aux = i, verifica index do 0
                        perm[index_randomico] = aux;
                        aux++;
                    }
                }
            }
            
            porcentagem = (cont_boas * 100.0)/t;
            System.out.println(i + " participantes> " + cont_boas + "/" + t + " ou " + porcentagem + "%");
        }
    }
}
