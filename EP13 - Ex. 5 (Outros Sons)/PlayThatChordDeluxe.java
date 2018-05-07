/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Ricardo Hideki Hangai Kojo
 *  Numero USP: 10295429
 *  Tarefa: Ex. 5 - Outros Sons
 *  Data: 05/05/2017
 *  Baseado em: PlayThatTuneDeluxe.java
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
 *   javac-introcs PlayThatChordDeluxe.java
 *   java-introcs PlayThatChordDeluxe <extra> < <arquivo>
 * onde <extra> é uma flag para acionar cálculo alterantivo e <arquivo> é o um
 * arquivo de texto no qual estão escritas as notas a serem tocadas.
 *
*******************************************************************************/

public class PlayThatChordDeluxe {

    public static double[] sum(double[] a, double[] b, double awt, double bwt) {
        assert a.length == b.length;

        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i]*awt + b[i]*bwt;
        }
        return c;
    } 

    public static double[] wave(double hz, double duration, boolean calculo_alternativo) { 
        int n = (int) (StdAudio.SAMPLE_RATE * duration);
        double[] a = new double[n+1];
        int p = (int) (StdAudio.SAMPLE_RATE/hz);

        // Adiciona um random de -1 ate 1 nas p primeiras posicoes
        for(int i = 0; i < p; i++){
            a[i] = Math.random()*2 - 1;
        }

        if(calculo_alternativo){
            for (int i = p, j = 0; i <= n ; i++, j++){
                a[i] = .997*(2*a[j] + a[j+1])/10;
            }
        } else {
            for (int i = p, j = 0; i <= n ; i++, j++){
                a[i] = .997*(a[j] + a[j+1])/2;
            }
        }
        
        return a; 
    }

    public static double[] note(int pitch, double duration, boolean calculo_alternativo) {
        if(pitch < -49) return new double[0]; // Se o pitch for muito negativo, pausa
        double hz = 220.0 * Math.pow(2, pitch / 12.0);
        double[] a  = wave(hz, duration, calculo_alternativo);
        double[] hi = wave(2*hz, duration, calculo_alternativo);
        double[] lo = wave(hz/2, duration, calculo_alternativo);
        double[] h  = sum(hi, lo, 0.5, 0.5);
        return sum(a, h, 0.5, 0.5);
    }

    public static void main(String[] args) {
        // Argumento opcional: true para calculo de a alternativo
        boolean arg_opcional = (args.length >= 1);

        while (!StdIn.isEmpty()) {

            String linha = StdIn.readLine();

            if(!linha.isEmpty()){
                // "Limpa" linha
                linha =  linha.trim(); 
                String[] componentes = linha.split("\\s+");

                // Cria primeira nota
                int length = componentes.length;
                int pitch = Integer.parseInt(componentes[0]);
                double duration = Double.parseDouble(componentes[length - 1]);
                double[] a = note(pitch, duration, arg_opcional);
                
                // Cria as n proximas notas, somando-as
                for(int i = 1; i <= length - 2; i++){
                    pitch = Integer.parseInt(componentes[i]);
                    double[] b = note(pitch, duration, arg_opcional);
                    a = sum(a, b, 0.5, 0.5);
                }

                StdAudio.play(a);
            }
        }
    } 
}