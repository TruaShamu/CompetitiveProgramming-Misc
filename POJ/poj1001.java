import java.math.BigDecimal;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            BigDecimal decimal = sc.nextBigDecimal();
            int b = sc.nextInt();
            decimal = decimal.pow(b);
            String exponentString = decimal.stripTrailingZeros().toPlainString();
            if (exponentString.startsWith("0.")) {
                exponentString = exponentString.substring(1);
            }
            System.out.println(exponentString);
        }
        sc.close();
    }
}
