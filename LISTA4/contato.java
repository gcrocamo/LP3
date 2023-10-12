//teste
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Contato {
    private String nomeCompleto;
    private String enderecoEmail;
    private String numeroTelefone;
    private LocalDate dataNascimento;

    // Inicializar contato
    public void inicializandoContato(String nomeCompleto, String enderecoEmail, String numeroTelefone, LocalDate dataNascimento){
        this.nomeCompleto = nomeCompleto;
        this.enderecoEmail = enderecoEmail;
        this.numeroTelefone = numeroTelefone;
        this.dataNascimento = dataNascimento;
    }

    // Imprimir contato
    public void imprimindoContato(){
        System.out.println("Nome: " + nomeCompleto);
        System.out.println("Email: " + enderecoEmail);
        System.out.println("Telefone: " + numeroTelefone);
        System.out.println("Data de Nascimento: " + DateTimeFormatter.ofPattern("dd/MM/yyyy").format(dataNascimento));
    }

    // Calcular idade
    public int calculandoIdade(){
        LocalDate dataAtual = LocalDate.now();
        int idade = dataAtual.getYear() - dataNascimento.getYear();

        if (dataAtual.getMonthValue() < dataNascimento.getMonthValue()
                || (dataAtual.getMonthValue() == dataNascimento.getMonthValue() && dataAtual.getDayOfMonth() < dataNascimento.getDayOfMonth()))
            idade--;

        return idade;
    }

    // Getters
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

    // Setters
    public void setNomeCompleto(String nomeCompleto){
        this.nomeCompleto = nomeCompleto;
    }

    public void setEnderecoEmail(String enderecoEmail){
        this.enderecoEmail = enderecoEmail;
    }

    public void setNumeroTelefone(String numeroTelefone){
        this.numeroTelefone = numeroTelefone;
    }

    public void setDataNascimento(LocalDate dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Contato contato = new Contato();

        System.out.print("Digite o nome completo: ");
        String nomeCompleto = scanner.nextLine();
        contato.setNomeCompleto(nomeCompleto);

        System.out.print("Digite o endereço de email: ");
        String enderecoEmail = scanner.nextLine();
        contato.setEnderecoEmail(enderecoEmail);

        System.out.print("Digite o número de telefone: ");
        String numeroTelefone = scanner.nextLine();
        contato.setNumeroTelefone(numeroTelefone);

        System.out.print("Digite a data de nascimento (no formato dd/MM/yyyy): ");
        String dataNascimentoStr = scanner.nextLine();
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        contato.setDataNascimento(dataNascimento);

        System.out.println("\nInformações do contato:");
        contato.imprimindoContato();

        scanner.close();
    }
}
