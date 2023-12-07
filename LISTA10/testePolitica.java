import java.util.ArrayList;
import java.util.List;

public class testePolitica {
    public static void main(String[] args) {
        List<Pessoa> listaPoliticos = new ArrayList<>();
        
        Politico politico = new Politico("João", 1, new Data(1, 1, 1980), "ABC", 123);
        Prefeito prefeito = new Prefeito("Maria", 2, new Data(2, 2, 1970), "XYZ", 456, "Cidade A");
        Governador governador = new Governador("Carlos", 3, new Data(3, 3, 1960), "DEF", 789, "Estado B");

        listaPoliticos.add(politico);
        listaPoliticos.add(prefeito);
        listaPoliticos.add(governador);

        for (Pessoa pessoa : listaPoliticos) {
            System.out.println(pessoa.toString());
            System.out.println("------");
        }
    }
}