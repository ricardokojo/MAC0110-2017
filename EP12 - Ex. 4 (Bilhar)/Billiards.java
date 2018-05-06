/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Ricardo Hideki Hangai Kojo
 *  Numero USP: 10295429
 *  Tarefa: Ex. 5 - Outros Sons
 *  Data: 05/05/2017
 *  Baseado em: MouseFollower.java, OneSimpleAttractor.java, BouncingBall.java
 *
 ******************************************************************************/

/******************************************************************************
 *
 * Nota: 9.0
 *
 * Comentários do Monitor:
 *   Não funciona ao clicar na bola ou não previne divisão por 0. (-1.0)
 *
 * Como rodar:
 *   javac-introcs Billiards.java
 *   java-introcs Billiards
 *
*******************************************************************************/

public class Billiards {
    public static void main(String[] args) {

        StdDraw.enableDoubleBuffering();
        StdDraw.clear(StdDraw.LIGHT_GRAY);

        // Variaveis iniciais
        double rx = 0, ry = 0;
        double vx = 0, vy = 0;
        double radius = .05;

        double atrito = 0.98;
        double dist = 0;
        double dist_x = 0, dist_y = 0;
        double f = 0, fx = 0, fy = 0;

        // Config do canvas
        StdDraw.setXscale(-1.0, +1.0);
        StdDraw.setYscale(-1.0, +1.0);

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(0, 0, radius);
        StdDraw.show();

        while (true) {
            StdDraw.clear();

            // Mouse click
            if (StdDraw.mousePressed()) {
                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();

                // Distancia x e y a partir da bolinha
                dist_x = rx - x; dist_y = ry - y;
                // Teorema de Pitagoras
                dist = Math.sqrt(dist_x*dist_x + dist_y*dist_y);

                f = .01/(dist*dist); // forca inversamente proporcional a distancia
                fx = f * (dist_x/dist); // seno
                fy = f * (dist_y/dist); // cosseno
                vx += fx; vy += fy;

                // Fundo branco
                StdDraw.setPenColor(StdDraw.WHITE);
            } else {
                // Fundo cinza
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            }

            StdDraw.filledSquare(0.0, 0.0, 1.0);
            
            // Calculo do atrito
            vx = atrito * vx;
            vy = atrito * vy;

            // Trecho do Bouncing Ball
            if (Math.abs(rx + vx) + radius > 1.0) vx = -vx;
            if (Math.abs(ry + vy) + radius > 1.0) vy = -vy;
            rx = rx + vx;
            ry = ry + vy;

            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(rx, ry, radius);
            StdDraw.show(10);
        }
    }
}