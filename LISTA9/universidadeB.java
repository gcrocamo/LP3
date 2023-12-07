import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Aluno {
    protected String nome;
    protected String matricula;
    protected LocalDate dataAdmissao;
    protected int semestre;
    protected double mensalidadeBase = 700.00;

    public Aluno(String nome, String matricula, LocalDate dataAdmissao, int semestre) {
        this.nome = nome;
        this.matricula = matricula;
        this.dataAdmissao = dataAdmissao;
        this.semestre = semestre;
    }

    public void imprimirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Data de Admissão: " + dataAdmissao);
        System.out.println("Semestre: " + semestre);
    }

    public double calcularMensalidade() {
        double mensalidade = mensalidadeBase;

        if (!isRegular()) {
            mensalidade += 0.2 * mensalidadeBase;
        }

        return mensalidade;
    }

    protected boolean isRegular() {
        long mesesDiferenca = ChronoUnit.MONTHS.between(dataAdmissao, LocalDate.now());
        return mesesDiferenca >= semestre;
    }
}

class AlunoPosGraduacao extends Aluno {
    private String orientador;
    private String tituloProjeto;

    public AlunoPosGraduacao(String nome, String matricula, LocalDate dataAdmissao, int semestre,
                             String orientador, String tituloProjeto) {
        super(nome, matricula, dataAdmissao, semestre);
        this.orientador = orientador;
        this.tituloProjeto = tituloProjeto;
    }

    @Override
    public void imprimirDados() {
        super.imprimirDados();
        System.out.println("Orientador: " + orientador);
        System.out.println("Título do Projeto: " + tituloProjeto);
    }

    @Override
    protected boolean isRegular() {
        long mesesDiferenca = ChronoUnit.MONTHS.between(dataAdmissao, LocalDate.now());
        return mesesDiferenca < 24;
    }
}

class AlunoMestrado extends AlunoPosGraduacao {
    public AlunoMestrado(String nome, String matricula, LocalDate dataAdmissao, int semestre,
                         String orientador, String tituloProjeto) {
        super(nome, matricula, dataAdmissao, semestre, orientador, tituloProjeto);
    }

    @Override
    protected boolean isRegular() {
        return super.isRegular();
    }
}

class AlunoDoutorado extends AlunoPosGraduacao {
    public AlunoDoutorado(String nome, String matricula, LocalDate dataAdmissao, int semestre,
                           String orientador, String tituloProjeto) {
        super(nome, matricula, dataAdmissao, semestre, orientador, tituloProjeto);
    }

    @Override
    protected boolean isRegular() {
        return super.isRegular();
    }
}

public class ProgramaAlunos {
    public static void main(String[] args) {
        AlunoMestrado alunoMestrado = new AlunoMestrado("Joana", "67890", LocalDate.of(2022, 3, 1), 12,
                "Dr. Oliveira", "Pesquisa sobre Inteligência Artificial");
        System.out.println("Aluno de Mestrado:");
        alunoMestrado.imprimirDados();
        System.out.println("Mensalidade: R$ " + alunoMestrado.calcularMensalidade());
        System.out.println();

        AlunoDoutorado alunoDoutorado = new AlunoDoutorado("Carlos", "13579", LocalDate.of(2021, 9, 1), 24,
                "Dr. Santos", "Pesquisa sobre Redes Neurais");
        System.out.println("Aluno de Doutorado:");
        alunoDoutorado.imprimirDados();
        System.out.println("Mensalidade: R$ " + alunoDoutorado.calcularMensalidade());
    }
}
