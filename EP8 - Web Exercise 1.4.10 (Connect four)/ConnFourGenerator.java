/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Ricardo Hideki Hangai Kojo
 *  Numero USP: 10295429
 *  Tarefa: Ex. 1.4.10 - ConnectFourGenerator
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
 *   javac ConnFourGenerator.java
 *   java ConnFourGenerator <n> <print>
 * sendo <n> o número de linhas e colunas da matriz e <print> a forma como ela é exibida na saída: 0 para tabular e 1 para linear.
 *
*******************************************************************************/

public class ConnFourGenerator{
    public static void main(String args[]){
        int n = Integer.parseInt(args[0]);
        int print = Integer.parseInt(args[1]);
        
        String[][] matriz = new String[n][n];
        
        // Gerador
        for(int i = 0; i <= n - 1; i++){
            for(int j = 0; j <= n - 1; j++){
                int random = (int)(Math.random() * 3) + 1; // Numero aleatorio de 1 a 3
                if (random == 1) matriz[i][j] = "X";
                if (random == 2) matriz[i][j] = "O";
                if (random == 3) matriz[i][j] = "*";
            }
        }
 
        // Saida
        if (print == 0){
            // Tabular
            for(int i = 0; i <= n - 1; i++){
                for(int j = 0; j <= n - 1; j++){
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }
        } else if (print == 1){
            // Linear
            for(int i = 0; i <= n - 1; i++) {
                for(int j = 0; j <= n - 1; j++){
                    System.out.print(matriz[i][j]);
                }
            }
            System.out.println();
        }
        
    }
}