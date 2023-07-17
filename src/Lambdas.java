/**
 *
 * @author Miguel Castro
 */
public class Lambdas {
    public static void main(String[] args) {

        // conceito SAM (Single Abstract Method)
        // Qualquer interface que tenha apenas um método abstrato.

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Execução sem lambda!");
            }
        }).run();

        System.out.println("************************");

        new Thread(() -> System.out.println("Execução com lambda!")).run();
    }
}
