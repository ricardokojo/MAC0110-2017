/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Ricardo Hideki Hangai Kojo
 *  Numero USP: 10295429
 *  Tarefa: Exercise 1.5.16 - Spiral
 *  Data: 24/04/2017
 *
 ******************************************************************************/

/******************************************************************************
 *
 * Nota: 10.0
 *
 * Comentários do Monitor:
 *   -
 *
 * Como rodar:
 *   javac-introcs Spiral.java
 *   java-introcs Spiral
 *
*******************************************************************************/

public class Spiral {
    public static void main(String[] args){
        StdDraw.setXscale(0, 300);
        StdDraw.setYscale(0, 300);
        StdDraw.setPenRadius(0.01);
        double min = 5, max = 295;
        while(min < max){
            StdDraw.line(min, min, max, min);
            StdDraw.line(max, min, max, max);
            min += 5;
            StdDraw.line(max, max, min, max);
            StdDraw.line(min, max, min, min);
            max -= 5;
        }
    }
}
