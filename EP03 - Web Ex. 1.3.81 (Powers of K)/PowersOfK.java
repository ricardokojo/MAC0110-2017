/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Ricardo Hideki Hangai Kojo
 *  Numero USP: 10295429
 *  Tarefa: Exercise 1.3.81 - Powers Of K
 *  Data: 06/04/2017
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
 *  javac PowersOfK.java
 *  java PowersOfK <número inteiro>
 *
*******************************************************************************/

public class PowersOfK {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        long limite = Long.MAX_VALUE/k;
        
        int expoente = 0;
        long potencias = 1;

        while (potencias <= limite) {
            System.out.println(expoente + " " + potencias);
            potencias *= k;
            expoente++;
        }
        
        //o while para, mas não printa a última potência
        if (potencias > 0){
            // quando dá overflow, o número calculado é negativo ou zero
            System.out.println(expoente + " " + potencias);
        }
    }
}
