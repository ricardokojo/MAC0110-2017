/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Ricardo Hideki Hangai Kojo
 *  Numero USP: 10295429
 *  Tarefa: Ex.2 Amigo Secreto
 *  Data: 11/04/2017
 *  Baseado em:
 *
 ******************************************************************************/

/******************************************************************************
 *
 * Nota: 9.0
 *
 * Comentários do Monitor:
 *   Saída percialmente diferente do enunciado. (-1.5)
 *   Bônus (+0.5)
 *
 * Como rodar:
 *   javac AmigoSecreto.java
 *   java AmigoSecreto <nmax> <t>
 * sendo <nmax> o número máximo de pessoas no amigo secreto e <t> a quantidade de 
 * testes rodados a cada quantidade de pessoas.
 *
*******************************************************************************/

public class AmigoSecreto{
    public static void main(String[] args) {
        int p_nmax = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        
        for(int i = 2; i<= p_nmax; i++){ //i e o numero de pessoas
            int cont_fenomeno = 0;
            double porcentagem;
            
            for(int j = 1; j <= t; j++){ //j e o indice de testes
                
                //Gerador de permutacoes
                int[] perm = new int[i];
                int aux = 1;
                int index_randomico;
                int index_zero = 0;
                while(aux <= i){
                    index_randomico = (int)(Math.random() * i); //Index randomico de 0 ate i atual
                    if (perm[index_randomico] == 0){
                        if(aux == i) {
                            index_zero = index_randomico;
                            break;
                        } //Guarda index do 0
                        perm[index_randomico] = aux;
                        aux++;
                    }
                }
                
                // Verifica fenomeno S
                // para n participantes, serao necessarios n-1 trocas;
                int aux_s1, aux_s2;
                if(index_zero != 0){
                    aux_s1 = 0;
                    for (int k = 1; k <= i - 1; k++){
                        aux_s2 = perm[aux_s1];
                        aux_s1 = aux_s2;
                        
                        if (k == i - 1) cont_fenomeno++; //caso o fenomeno aconteca
                        else if (aux_s2 == 0 || aux_s1 == index_zero) break; //caso de erro
                    }
                }
            }
            
            porcentagem = (cont_fenomeno * 100.0)/t;
            System.out.println(i + " " + porcentagem + "%");
        }
    }
}