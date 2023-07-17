import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Miguel Castro
 */
public class Streams {

    public static void main(String[] args) {

        // Stream (fluxo de dados)

        IntStream.range(0, 5)
                .filter(e -> e % 2 == 0)
                .forEach((e) -> System.out.println(e));

        System.out.println("************************");

        List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        lista.stream()
                // filtra dados de forma personalizada.
                .filter(e -> e % 2 == 0)
                // transformando dados, lembrando que este método não modifica os dados da lista
                // original.
                .map(e -> e * 2)
                // percorre os dados da lista.
                .forEach(e -> System.out.println(e));

        System.out.println("************************");

        // Collect = trabalha com objetos mutáveis.
        List<Integer> listaModificada = lista.stream()
                .filter(e -> e % 2 == 0)
                // armazena os dados modificados da lista orignal em uma nova lista.
                .collect(Collectors.toList());
        System.out.println(listaModificada);

        System.out.println("************************");

        Map<Integer, List<Integer>> listaAgrupada = lista.stream()
                // agrupa os dados dados da lista.
                // neste caso agrupada pelo resto da divisão por 3.
                // o resultado fica: {0=[3, 6, 9], 1=[1, 4, 7, 10], 2=[2, 5, 8]}
                // onde:
                // 0{[3, 6, 9]} resto da divisão igual a 0
                // 1{[1, 4, 7, 10]} resto da divisão igual a 1
                // 2{[2, 5, 8]} resto da divisão igual a 2
                .collect(Collectors.groupingBy(e -> e % 3));
        System.out.println(listaAgrupada);

        System.out.println("************************");

        String listaConvertidaString = lista.stream()
                // transforma os dados da lista em string.
                .map(e -> String.valueOf(e))
                // retorna uma nova lista convertida em uma única string.
                .collect(Collectors.joining(";"));
        System.out.println(listaConvertidaString);

        System.out.println("************************");

        // Reduce = trabalha com objetos imutáveis.
        Optional<Integer> listaReduce = lista.stream()
                // transforma todos os elementos da lista em um único elemento.
                // neste caso ele faz a soma de todos os elementos para trasformar em um único
                // elemento.
                .reduce((n1, n2) -> n1 + n2);
        System.out.println(listaReduce.get());
    }
}
