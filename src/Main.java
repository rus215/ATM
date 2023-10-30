import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM(
                new LinkedHashMap<>() {{
                    put(5000, 4);
                    put(1000, 23);
                    put(500, 6);
                    put(100, 9);
                    put(50, 10);
                }}
        );
        System.out.printf("В банкомате было %s\n", atm.getBanknotes().toString());
        System.out.println("=".repeat(60));

        int sum = 1250;
        Map<Integer, Integer> cashe = atm.getCashe(sum);

        System.out.printf("Сумма %d может быть выдана %s\n", sum, cashe.toString());
        System.out.println("=".repeat(60));
        System.out.printf("В банкомате осталось %s", atm.getBanknotes().toString());
    }
}