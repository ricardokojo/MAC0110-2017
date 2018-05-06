/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Ricardo Hideki Hangai Kojo
 *  Numero USP: 10295429
 *  Tarefa: Exercise 1.3.26 - January 1
 *  Data: 09/04/2017
 *  Baseado em:
 *    Tomorrow.java disponibilizado no PACA para o respectivo exercício;
 *    Friday.java criado para exercicio 1.3.25
 *
 ******************************************************************************/

/******************************************************************************
 *
 * Nota: 9.9
 *
 * Comentários do Monitor:
 *   Melhore a indentação. (-0.01)
 *
 * Como rodar:
 *   javac SSCounter.java
 *   java SSCounter <dia> <mes>
 * sendo <dia> um número de 1 a 31 e <mes> um número de 1 a 12.
 * Em caso de datas inválidas, o programa retornará 0 tanto para sábados quanto para domingos.
 *
*******************************************************************************/

public class SSCounter {
    public static void main(String[] args) {
        int DIA_PROCURADO = Integer.parseInt(args[0]);
        int MES_PROCURADO = Integer.parseInt(args[1]);
        
        //Dia 01/01/1601 e segunda e inicia um novo ciclo de 400 no calendario gregoriano
        int dia = 1;
        int mes = 1;
        int ano = 1601;
        boolean anoBissexto;
        int[] DIAS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        
        int domingos = 0;
        int sabados = 0;
        int dia_da_semana = 1; // 1 = Segunda, 2 = Terca, 3 = Quarta, 4 = Quinta, 5 = Sexta, 6 = Sabado, 7 = Domingo
        
        while(ano <= 2000){ //fecha o ciclo de 400 anos
            if (ano % 400 == 0) anoBissexto = true;
            else if (ano % 100 == 0) anoBissexto = false;
            else anoBissexto = ano % 4 == 0;

            int ano_atual = ano;
            while(ano == ano_atual){
                // Verifica se e sexta-feira 13
                if(dia == DIA_PROCURADO && mes == MES_PROCURADO){
                    // Verifica se e sabado ou domingo
                    if(dia_da_semana == 6) sabados++; 
                    else if (dia_da_semana == 7) domingos++;
                }

                // Incrementa dia/mes/ano
                if (dia + 1 <= DIAS[mes] || dia == 28 && anoBissexto) { dia++; }
                else if (mes < 12) { dia = 1; mes++; }
                else { dia = 1; mes = 1; ano++; }

                //Incrementa dia da semana
                if(dia_da_semana == 7) dia_da_semana = 1;
                else dia_da_semana++;
            }
        }
        System.out.println("Saturday: " + sabados + "; Sunday: " + domingos);
    }
}