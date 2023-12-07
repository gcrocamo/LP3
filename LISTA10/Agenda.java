public class Agenda {
    private List<Contato> contatos;

    public Agenda() {
        contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public void listarContatos() {
        for (Contato contato : contatos) {
            System.out.println(contato.toString());
        }
    }

    public Contato buscarContato(String identificador) {
        for (Contato contato : contatos) {
            if (contato.getIdentificador().equals(identificador)) {
                return contato;
            }
        }
        return null;
    }
}
