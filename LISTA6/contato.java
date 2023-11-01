import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Contato {
    private String nomeCompleto;
    private String enderecoEmail;
    private String numeroTelefone;
    private LocalDate dataNascimento;

    public Contato(String nomeCompleto, String enderecoEmail, String numeroTelefone, LocalDate dataNascimento){
        this.nomeCompleto = nomeCompleto;
        this.enderecoEmail = enderecoEmail;
        this.numeroTelefone = numeroTelefone;
        this.dataNascimento = dataNascimento;
    }

    public void imprimindoContato(){
        System.out.println("Nome: " + nomeCompleto);
        System.out.println("Email: " + enderecoEmail);
        System.out.println("Telefone: " + numeroTelefone);
        System.out.println("Data de Nascimento: " + DateTimeFormatter.ofPattern("dd/MM/yyyy").format(dataNascimento));
    }

    public int calculandoIdade(){
        LocalDate dataAtual = LocalDate.now();
        int idade = dataAtual.getYear() - dataNascimento.getYear();

        if (dataAtual.getMonthValue() < dataNascimento.getMonthValue()
                || (dataAtual.getMonthValue() == dataNascimento.getMonthValue() && dataAtual.getDayOfMonth() < dataNascimento.getDayOfMonth()))
            idade--;

        return idade;
    }

    public String getNomeCompleto(){
        return nomeCompleto;
    }

    public String getEnderecoEmail(){
        return enderecoEmail;
    }

    public String getNumeroTelefone(){
        return numeroTelefone;
    }

    public LocalDate getDataNascimento(){
        return dataNascimento;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome completo: ");
        String nomeCompleto = scanner.nextLine();

        System.out.print("Digite o endereço de email: ");
        String enderecoEmail = scanner.nextLine();

        System.out.print("Digite o número de telefone: ");
        String numeroTelefone = scanner.nextLine();

        System.out.print("Digite a data de nascimento (no formato dd/MM/yyyy): ");
        String dataNascimentoStr = scanner.nextLine();
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Contato contato = new Contato(nomeCompleto, enderecoEmail, numeroTelefone, dataNascimento);

        System.out.println("\nInformações do contato:");
        contato.imprimindoContato();

        scanner.close();
    }
}
