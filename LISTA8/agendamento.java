public class Agendamento {
    private Data data;
    private Hora hora;
    private Contato contato;

    public Agendamento(Data data, Hora hora, Contato contato) {
        this.data = data;
        this.hora = hora;
        this.contato = contato;
    }

    public void imprimeAgendamento() {
        System.out.println("Agendamento:");
        System.out.println("Data: " + data.toString());
        System.out.println("Hora: " + hora.toString());
        System.out.println("Contato: " + contato.toString());
    }


public static void main(String[] args) {
    Data data = new Data(10, 11, 2023);
    Hora hora = new Hora(10, 30);
    Contato contato = new Contato("João", "joao@gmail.com", "123456789");

    Agendamento agendamento = new Agendamento(data, hora, contato);

    agendamento.imprimeAgendamento();
}
}