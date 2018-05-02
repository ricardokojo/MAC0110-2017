/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Ricardo Hideki Hangai Kojo
 *  Numero USP: 10295429
 *  Tarefa: Ex.3 Amigo Secreto (novamente) - Permutações Boas
 *  Data: 11/04/2017
 *  Baseado em:
 *    Ex.2 Amigo Secreto e AmigoSecreto.java criado para tal exercício
 *    Ex.3 Amigo Secreto (Novamente) e EstimaPermutacoes.
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
 *   javac PermutacoesBoas.java
 *   java PermutacoesBoas <N>
 *
 * sendo <N> o número de elementos da permutação.
 *
*******************************************************************************/

public class PermutacoesBoas {
    public static void main(String[] args) {
        int n = 4;
        
        int[] perm = new int[n];
        boolean perm_ok = false;
        int aux = 1;
        int index_randomico;
        
        //Gerador de permutacoes
        while(perm_ok == false){
            while(aux <= n){
                index_randomico = (int)(Math.random() * n); //Index randomico de 0 até i atual
                if (perm[index_randomico] == 0){
                    if (aux <= n && aux == index_randomico) break; // se i = a[i], sai;
                    if(aux == n) {
                        if (index_randomico != 0) perm_ok = true;
                        break;
                    } //para aux = i, verifica index do 0
                    perm[index_randomico] = aux;
                    aux++;
                }
            }
            
            if(perm_ok == false){ //se perm nao valida, cria outra
                perm = new int[n];
                aux = 1;
            }
        }
        
        // Print
        String print = "";
        for(int i = 0; i <= n - 1; i++){
            print = print + perm[i] + " ";
        }
        System.out.println(print);
    }
}
