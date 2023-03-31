import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;
import java.util.Locale;

public class MathStuff {
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        MathStuff interest = new MathStuff();
        BigDecimal balance = (interest.calculate("10000", "0.08", 10, "1000"));
        System.out.println(moneyFormatter.format(balance));
    }

    public BigDecimal calculate(String principal, String rate, int year, String contribution){
        BigDecimal a = BigDecimal.ONE.add(new BigDecimal(rate)).pow(year);
        BigDecimal c = a.subtract(BigDecimal.ONE);
        MathContext mc = new MathContext(10);
        BigDecimal d = c.divide(new BigDecimal(rate,mc));
        BigDecimal e = d.multiply(new BigDecimal(contribution));
        BigDecimal f = e.add((new BigDecimal(principal)).multiply(a));
        return f;
    }

}
