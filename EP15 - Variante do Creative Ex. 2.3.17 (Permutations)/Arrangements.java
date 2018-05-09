/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Ricardo Hideki Hangai Kojo
 *  Numero USP: 10295429
 *  Tarefa: Variante do Creative Ex. 2.3.17 (Permutations)
 *  Data: 05/05/2017
 *  Baseado em: Permutations.java
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
 * Nota: 8.0
 *
 * Comentários do Monitor:
 *   Erro em tempo de execução em alguns testes: -2.0
 *
 * Como rodar:
 *   javac-introcs Arrangements.java
 *   java-introcs Arrangements <s>
 * sendo <s> a string que sofrerá os arranjos.
 *
*******************************************************************************/

import java.util.Arrays;

public class Arrangements {

    public static int index = 0;

    public  static void permutar(String s, String[] prefix_usados) { permutar("", s, prefix_usados); }
    private static void permutar(String prefix, String s, String[] prefix_usados) {

        int n = s.length();
        if (n == 0) StdOut.println(prefix);
        else {
            for (int i = 0; i < n; i++){
                String novo_prefix = prefix + s.charAt(i);
                String nova_string = s.substring(0, i) + s.substring(i+1, n);
                if (!Arrays.asList(prefix_usados).contains(novo_prefix)){
                    permutar(novo_prefix, nova_string, prefix_usados);
                    prefix_usados[index] = novo_prefix;
                    index++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String n = args[0];
        int tamanho = fatorial(n.length() + 1) - 1;
        String[] prefix_usados = new String[tamanho];
        permutar(n, prefix_usados);
    }

    public static int fatorial(int n) {
        int fat = 1;
        for (int i = 1; i <= n; i++) fat *= i;
        return fat;
    }
}