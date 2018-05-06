/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Ricardo Hideki Hangai Kojo
 *  Numero USP: 10295429
 *  Tarefa: Ex. 1.4.10 - ConnectFour
 *  Data: 20/04/2017
 *
 ******************************************************************************/

/******************************************************************************
 *
 * Nota: 9.0
 *
 * Comentários do Monitor:
 *   [ConnFour] Saída diferente da esperada em alguns casos (inverteu a linha e coluna da posição inicial): -1.0
 *
 * Como rodar:
 *   javac ConnFour.java
 *   java ConnFour <conf>
 * sendo <conf> a configuração N por N de "X", "O" e "*".
 *
*******************************************************************************/

public class ConnFour{
    public static void main(String args[]){
        //Entradas
        String matriz_linear = args[0];
        int n = (int) Math.sqrt(matriz_linear.length());

        // Dados da maior sequencia
        int maior_cont_seq = 0;
        String coord_seq = "", direcao_seq = "", tipo_seq = "";

        // Variaveis auxiliares para a verificacao
        int cont_seq = 1;
        String anterior = "", atual = "";

        //Verifica horizontalmente
        for(int i=0; i<= n-1; i++){
            for(int j=0; j<=n-1; j++){
                atual = "" + matriz_linear.charAt((i * n) + j); // Posicao no array como se fosse uma matriz, verificando horizontalmente

                if (atual.equals(anterior)) {
                    cont_seq++;
                } else {
                    cont_seq = 1;
                }

                if(cont_seq > maior_cont_seq){
                    maior_cont_seq = cont_seq;
                    coord_seq = "(" + i + ", " + (j - (cont_seq - 1)) + ")";
                    direcao_seq = "h";
                    tipo_seq = anterior;
                }

                anterior = atual;
            }
            anterior = "";
        }
        
        //Verifica verticalmente
        for(int i=0; i<= n-1; i++){
            for(int j=0; j<=n-1; j++){
                atual = "" + matriz_linear.charAt(i + (j * n));  // Posicao no array como se fosse uma matriz, verificando verticalmente

                if (atual.equals(anterior)) {
                    cont_seq++;
                } else {
                    cont_seq = 1;
                }

                if(cont_seq > maior_cont_seq){
                    maior_cont_seq = cont_seq;
                    coord_seq = "(" + i + ", " + (j - (cont_seq - 1)) + ")";
                    direcao_seq = "v";
                    tipo_seq = anterior;
                }

                anterior = atual;
            }
            anterior = "";
        }

        //Saida
        char[] array = matriz_linear.toCharArray();
        for(int i = 0; i <= n - 1; i++){ // Print tabular
            for(int j = 0; j <= n - 1; j++){
                System.out.print(array[(i * n) + j] + " ");
            }
            System.out.println();
        }
        System.out.println(maior_cont_seq + " / " + coord_seq + " [" + tipo_seq + " / " + direcao_seq + "]");
    }
}