public class Main {
    public static void main(String[] args) {
        // Utilizando polimorfismo de subclasse
        System.out.println("Polimorfismo de Subclasse:");
        Pessoa pessoa = new Pessoa("João", 1, new Data(1, 1, 1990));
        Funcionario funcionario = new Funcionario("Maria", 2, new Data(2, 2, 1980), new Data(3, 3, 2010), 5000.0);
        ChefeDeDepartamento chefe = new ChefeDeDepartamento("Carlos", 3, new Data(3, 3, 1970), new Data(4, 4, 2005), 8000.0, "TI", new Data(5, 5, 2015));

        calcularEmprestimo(pessoa);
        calcularEmprestimo(funcionario);
        calcularEmprestimo(chefe);

        // Utilizando polimorfismo de classe
        System.out.println("\nPolimorfismo de Classe:");
        calcularEmprestimo(pessoa);
        calcularEmprestimo(funcionario);
        calcularEmprestimo(chefe);
    }

    // Polimorfismo de subclasse
    private static void calcularEmprestimo(Pessoa pessoa) {
        System.out.println("Empréstimo para " + pessoa.getClass().getSimpleName() + ": R$ " + pessoa.calculaEmprestimo());
    }

    // Polimorfismo de classe
    private static void calcularEmprestimo2(Pessoa pessoa) {
        System.out.println("Empréstimo para " + pessoa.getClass().getSimpleName() + ": R$ " + Pessoa.calculaEmprestimo(pessoa));
    }
}
