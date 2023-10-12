//teste
package Data;

import java.util.Scanner;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    private boolean verificacaoData(int dia, int mes, int ano) {
        if (mes < 1 || mes > 12)
            return false;

        int diasPorMes[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (dia < 1 || dia > diasPorMes[mes - 1]) {
            if (mes == 2 && dia == 29 && ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0))
                return true;
            else
                return false;
        }

        return true;
    }

    public void impressaoData() {
        System.out.printf("%02d/%02d/%04d\n", dia, mes, ano);
    }

    public void impressaoDataExtenso() {
        String meses[] = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        System.out.printf("%02d de %s de %04d\n", dia, meses[mes - 1], ano);
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public void setDia(int dia) {
        if (verificacaoData(dia, mes, ano))
            this.dia = dia;
    }

    public void setMes(int mes) {
        if (verificacaoData(dia, mes, ano))
            this.mes = mes;
    }

    public void setAno(int ano) {
        if (verificacaoData(dia, mes, ano))
            this.ano = ano;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int novoDia, novoMes, novoAno;

        do {
            System.out.print("Digite o dia: ");
            novoDia = scanner.nextInt();

            System.out.print("Digite o mês: ");
            novoMes = scanner.nextInt();

            System.out.print("Digite o ano: ");
            novoAno = scanner.nextInt();

            if (novoMes < 1 || novoMes > 12) {
                System.out.println("Mês inválido. O mês deve estar entre 1 e 12. Por favor, tente novamente.");
            }

            if (novoDia <= 1 || novoDia >= 30) {
                System.out.println("Dia inválido. O dia deve estar entre 1 e 30. Por favor, tente novamente.");
            }

            if (novoAno <= 0) {
                System.out.println("Ano inválido. O ano deve ser maior que zero. Por favor, tente novamente.");
            }
        } while (novoMes < 1 || novoMes > 12 || novoDia <= 0 || novoDia >= 31 || novoAno <= 0);

        Data data = new Data(novoDia, novoMes, novoAno);
        data.impressaoData();
        data.impressaoDataExtenso();

        scanner.close();
    }

}
