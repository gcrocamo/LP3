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
    private char nivel;

    public AlunoPosGraduacao(String nome, String matricula, LocalDate dataAdmissao, int semestre,
                             String orientador, String tituloProjeto, char nivel) {
        super(nome, matricula, dataAdmissao, semestre);
        this.orientador = orientador;
        this.tituloProjeto = tituloProjeto;
        this.nivel = nivel;
    }

    @Override
    public void imprimirDados() {
        super.imprimirDados();
        System.out.println("Orientador: " + orientador);
        System.out.println("Título do Projeto: " + tituloProjeto);
        System.out.println("Nível: " + nivel);
    }

    @Override
    protected boolean isRegular() {
        long mesesDiferenca = ChronoUnit.MONTHS.between(dataAdmissao, LocalDate.now());

        if (nivel == 'M') {
            return mesesDiferenca < 24;
        } else if (nivel == 'D') {
            return mesesDiferenca < 48;
        }

        return false;
    }
}

public class ProgramaAlunos {
    public static void main(String[] args) {
        // Exemplo de aluno de graduação
        Aluno aluno = new Aluno("João", "12345", LocalDate.of(2021, 9, 1), 4);
        System.out.println("Aluno de Graduação:");
        aluno.imprimirDados();
        System.out.println("Mensalidade: R$ " + aluno.calcularMensalidade());
        System.out.println();

        // Exemplo de aluno de pós-graduação
        AlunoPosGraduacao posGraduacao = new AlunoPosGraduacao("Maria", "54321", LocalDate.of(2020, 8, 1), 12,
                "Dr. Silva", "Pesquisa sobre Machine Learning", 'M');
        System.out.println("Aluno de Pós-Graduação:");
        posGraduacao.imprimirDados();
        System.out.println("Mensalidade: R$ " + posGraduacao.calcularMensalidade());
    }
}
