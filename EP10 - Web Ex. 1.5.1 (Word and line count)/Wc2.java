/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Ricardo Hideki Hangai Kojo
 *  Numero USP: 10295429
 *  Tarefa: Exercise 1.5.1 - Word and line count
 *  Data: 24/04/2017
 *  Baseado em: Cat.java e http://stackoverflow.com/questions/7899525/how-to-split-a-string-by-space
 *
 ******************************************************************************/

/******************************************************************************
 *
 * Nota: 9.46
 *
 * Comentários do Monitor:
 *   Não passou no teste: java Wc < small_words.txt (-0.67)
 *   Bonus teste: java Wc2 < bible_KJ.txt (0.04)
 *   Bonus teste: java Wc2 < jean.txt (0.04)
 *   Bonus teste: java Wc2 < moby.txt (0.04)
 *
 * Como rodar:
 *   javac-introcs Wc2.java
 *   java-introcs Wc2 < (caminho_do_arquivo)
 * Sendo (caminho_do_arquivo) o caminho para um arquivo de texto ".txt".
 *
*******************************************************************************/

public class Wc2 {
    public static void main(String[] args){

        // contadores
        int caracteres, palavras, linhas;

        String s = StdIn.readAll();
        String[] array_palavras = s.split("\\s+"); // separa palavras baseado no link do StackOverflow passado para o exercico
        palavras = array_palavras.length;

        char[] array_carac = s.toCharArray(); // separa o texto em um array de caracteres
        caracteres = array_carac.length;

        String[] array_aux = s.split("\n"); // quebra o texto de forma na qual cada linha fica em um index do array
        linhas = array_aux.length;

        // Saida
        StdOut.println(linhas + "\t" + palavras + "\t" + caracteres);
    }
}
