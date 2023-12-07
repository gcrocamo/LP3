public class ProgramaAgenda {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        PessoaFisica pessoaFisica = new PessoaFisica("João Silva", "123.456.789-00",
                "Rua A, 123", new Data(1, 1, 1980), "123456789", "joao@example.com");

        PessoaJuridica pessoaJuridica = new PessoaJuridica("Empresa XYZ", "12.345.678/0001-99",
                "Av. B, 456", 1000000.0, "987654321", "empresa@example.com");

        agenda.adicionarContato(pessoaFisica);
        agenda.adicionarContato(pessoaJuridica);

        System.out.println("Listagem de Contatos:\n");
        agenda.listarContatos();

        String cpfBuscar = "123.456.789-00";
        Contato contatoEncontrado = agenda.buscarContato(cpfBuscar);

        if (contatoEncontrado != null) {
            System.out.println("\nContato encontrado:\n" + contatoEncontrado.toString());
        } else {
            System.out.println("\nContato não encontrado para o CPF: " + cpfBuscar);
        }
    }
}