import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 *
 * @author Miguel Castro
 */
public class MethodReference {

    private static Integer multiplicaPorDois(Integer i) {
        return i * 2;
    }

    public static void main(String[] args) {

        // Method Reference (::)

        IntStream.range(0, 5)
                .forEach(System.out::println);

        System.out.println("************************");

        // métodos estáticos
        IntStream.range(0, 5)
                .map(MethodReference::multiplicaPorDois)
                .forEach(System.out::println);

        System.out.println("************************");

        // construtores
        List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5);
        lista.stream()
                .map((e) -> new BigDecimal(e))
                .forEach(System.out::println);

        System.out.println("************************");

        // várias instâncias
        lista.stream()
                // a cada iteração instância um novo valor.
                .map(Integer::doubleValue)
                .forEach(System.out::println);

        System.out.println("************************");

        // única instância
        BigDecimal dois = new BigDecimal(2);
        lista.stream()
                // realiza a transformação em uma única instância do objeto.
                .map(BigDecimal::new)
                .map(dois::multiply)
                .forEach(System.out::println);
    }
}
