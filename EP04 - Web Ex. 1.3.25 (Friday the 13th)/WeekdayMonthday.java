/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Ricardo Hideki Hangai Kojo
 *  Numero USP: 10295429
 *  Tarefa: Exercise 1.2.25 - Friday the 13th
 *  Data: 09/04/2017
 *  Baseado em Tomorrow.java disponibilizado no PACA para o respectivo exercício
 *
 ******************************************************************************/

/******************************************************************************
 *
 * Nota: 8.5
 *
 * Comentários do Monitor:
 *   Saída percialmente diferente do enunciado. (-1.5)
 *   (basicamente eu esquece de escrever "Resposta: ", só printei o número)
 *
 * Como rodar:
 *   javac WeekdayMonthday.java
 *   java WeekdayMonthday <dia_da_semana> <dia_do_mes>
 * sendo <dia_da_semana> um número de 1 a 7: 1 = segunda, 2 = terça, 3 = quarta, 4 = quinta, 5 = sexta, 6 = sábado e 7 = domingo
 * e <dia_do_mes> o número do dia procurado.
 *
*******************************************************************************/

public class WeekdayMonthday {
    public static void main(String[] args) {
        //Dia 01/01/1601 e segunda e inicia um novo ciclo de 400 no calendario gregoriano
        int DIA_DA_SEMANA_PROCURADO = Integer.parseInt(args[0]);
        int DIA_PROCURADO = Integer.parseInt(args[1]);
        
	int dia = 1;
	int mes = 1;
	int ano = 1601;
        boolean anoBissexto;
        int[] DIAS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        
        int dias_consecutivos = 0;
        int dias_consecutivos_max = 0;
        int dia_da_semana = 1; // 1 = Segunda, 2 = Terca, 3 = Quarta, 4 = Quinta, 5 = Sexta, 6 = Sabado, 7 = Domingo
        
        if(DIA_DA_SEMANA_PROCURADO>0 && DIA_DA_SEMANA_PROCURADO<=7 && DIA_PROCURADO>0 && DIA_PROCURADO<=31){
            while(ano <= 2000){ //fecha o ciclo de 400 anos
                if (ano % 400 == 0) anoBissexto = true;
                else if (ano % 100 == 0) anoBissexto = false;
                else anoBissexto = ano % 4 == 0;

                int ano_atual = ano;
                while(ano == ano_atual){

                    // Verifica se e sexta-feira 13
                    if(dia == DIA_PROCURADO && dia_da_semana == DIA_DA_SEMANA_PROCURADO){
                        if(dias_consecutivos > dias_consecutivos_max) dias_consecutivos_max = dias_consecutivos;
                        dias_consecutivos = 0;
                    } else {
                        dias_consecutivos++;
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
            System.out.println(dias_consecutivos_max);
        }
        else {
            System.out.println("?");
        }
    }
}