public class Funcionario extends Pessoa {
    private Data admissao;
    private double salario;

    Funcionario(String nome, int id, Data nascm, Data adm, double sal) {
        super(nome, id, nascm);
        admissao = adm;
        salario = sal;
    }

    @Override
    public String toString() {
        String resultado;
        resultado = super.toString() + "\n";
        resultado = resultado + "Data de admissao: " + admissao.toStringLong() + "\n";
        resultado = resultado + "Salário: R$ " + salario;

        return resultado;
    }

    @Override
    public double calculaEmprestimo() {
        return Math.max(0.75 * salario, 1000.0);
    }

    final public double qualSalario() {
        return salario;
    }
}