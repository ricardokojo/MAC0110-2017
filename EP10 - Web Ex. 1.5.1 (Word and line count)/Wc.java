/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Ricardo Hideki Hangai Kojo
 *  Numero USP: 10295429
 *  Tarefa: Exercise 1.5.1 - Word and line count
 *  Data: 24/04/2017
 *  Baseado em: CharCount.java e LineCount.java
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
 *   javac-introcs Wc.java
 *   java-introcs Wc < (caminho_do_arquivo)
 *
 * Sendo (caminho_do_arquivo) o caminho para um arquivo de texto ".txt".
 *
*******************************************************************************/

public class Wc {
    public static void main(String[] args){

        // contadores
        int caracteres = 0, palavras = 0, linhas = 0;
        boolean ultimo_caract = false; // true para ultimo caractere valido (nao branco); false para ultimo caractere branco

        // loop contador
        while (StdIn.hasNextChar()) {
            char c = StdIn.readChar();

            if (c == '\n') linhas++;

            // contador de palavras
            if (Character.isWhitespace(c) || c == '\t' || c == '\n') {
                if(ultimo_caract) { // se o ultimo caractere for nao branco e o atual for branco
                    palavras++;
                    ultimo_caract = false;
                }
            } else { // ultimo caractere valido (nao branco)
                ultimo_caract = true;
            }

            caracteres++;
        }

        // Saida
        StdOut.println(linhas + "\t" + palavras + "\t" + caracteres);
    }
}
