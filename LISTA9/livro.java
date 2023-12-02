class Livro {
    protected String titulo;
    protected String autor;
    protected int nroPaginas;
    protected int anoPublicacao;

    public Livro(String titulo, String autor, int nroPaginas, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.nroPaginas = nroPaginas;
        this.anoPublicacao = anoPublicacao;
    }

    @Override
    public String toString() {
        return "Livro: " + titulo + " | Autor: " + autor + " | Número de Páginas: " + nroPaginas +
                " | Ano de Publicação: " + anoPublicacao;
    }

    public boolean isOlder(int outroAno) {
        return anoPublicacao < outroAno;
    }
}

class LivroBiblioteca extends Livro {
    protected boolean emprestado;
    protected String dataDevolucao;

    public LivroBiblioteca(String titulo, String autor, int nroPaginas, int anoPublicacao) {
        super(titulo, autor, nroPaginas, anoPublicacao);
    }

    @Override
    public String toString() {
        return super.toString() + " | Empréstimo: " + (emprestado ? "Sim" : "Não") +
                (emprestado ? " | Data de Devolução: " + dataDevolucao : "");
    }

    public boolean isAvailable() {
        return !emprestado;
    }

    public void borrow(String dataDevolucao) {
        if (!emprestado) {
            this.emprestado = true;
            this.dataDevolucao = dataDevolucao;
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("Livro indisponível para empréstimo.");
        }
    }
}

class LivroLivraria extends Livro {
    protected double preco;
    protected int estoque;

    public LivroLivraria(String titulo, String autor, int nroPaginas, int anoPublicacao, double preco, int estoque) {
        super(titulo, autor, nroPaginas, anoPublicacao);
        this.preco = preco;
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return super.toString() + " | Preço: " + preco + " | Estoque: " + estoque;
    }

    public boolean isAvailable() {
        return estoque > 0;
    }

    public void sell() {
        if (estoque > 0) {
            estoque--;
            System.out.println("Livro vendido com sucesso!");
        } else {
            System.out.println("Livro fora de estoque.");
        }
    }
}

public class ProgramaLivros {
    public static void main(String[] args) {
        LivroBiblioteca livroBiblioteca = new LivroBiblioteca("Java Programming", "John Doe", 500, 2022);
        System.out.println("Livro da Biblioteca: " + livroBiblioteca.toString());
        System.out.println("Disponível para empréstimo? " + livroBiblioteca.isAvailable());
        livroBiblioteca.borrow("2023-01-01");
        System.out.println("Após empréstimo: " + livroBiblioteca.toString());

        LivroLivraria livroLivraria = new LivroLivraria("Clean Code", "Robert Martin", 400, 2008, 39.99, 10);
        System.out.println("\nLivro da Livraria: " + livroLivraria.toString());
        System.out.println("Disponível para venda? " + livroLivraria.isAvailable());
        livroLivraria.sell();
        System.out.println("Após venda: " + livroLivraria.toString());
    }
}
