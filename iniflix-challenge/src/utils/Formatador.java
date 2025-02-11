package utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Formatador {

    public static String formatar(BigDecimal valor) {
        NumberFormat nf = NumberFormat.getCurrencyInstance( new Locale("pt", "BR") );
        return nf.format(valor);
    }

    public static String formatar(LocalDate valor) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return dtf.format(valor);
    }
}
