import com.google.gson.Gson;
import java.util.Scanner;
import static java.lang.Thread.sleep;

public class AppController {
    static Gson gson = new Gson();
    static JsonFormatter jsonAsJava;
    static String exchangeFromCode;
    static String exchangeToCode;
    static float amount;
    static Scanner scan = new Scanner(System.in);

    public static void runExchangeApp() {
        // Starting program
        try {sleep(1000);} catch (InterruptedException e) {throw new RuntimeException(e);}
        System.out.println("Would you like me to show you our list of currency codes? (answer Y: yes, or N: no)");

        // Printing codes
        if(scan.next().equals("Y")) {
            ApiController codesGetter = new ApiController();
            jsonAsJava = gson.fromJson(codesGetter.getCodes(), JsonFormatter.class);
            jsonAsJava.getSupportedCodesMap().forEach((code, currency) -> System.out.println("Code: " + code + " - Currency: " + currency));
            try {sleep(3000);} catch (InterruptedException e) {throw new RuntimeException(e);}
        }

        // Getting input data
        System.out.println("\nThen enter amount with currency code, press enter, and finally currency to exchange");
        amount = scan.nextFloat();
        exchangeFromCode = scan.next();
        exchangeToCode = scan.next();
        System.out.println("You are exchanging " + amount + " " + exchangeFromCode + " to " + exchangeToCode + "\n");
        try {sleep(2000);} catch (InterruptedException e) {throw new RuntimeException(e);}

        // Processing data
        ApiController exchangeOperation = new ApiController();
        jsonAsJava = gson.fromJson(exchangeOperation.getExchange(exchangeFromCode, exchangeToCode, amount), JsonFormatter.class);

        // Setting output data
        System.out.println("Result: " + amount + " " + exchangeFromCode + " is equivalent to " + jsonAsJava.getConversionResult() + " " + exchangeToCode + "\n");
        try {sleep(2000);} catch (InterruptedException e) {throw new RuntimeException(e);}


        // To loop
        System.out.println("Would you like to do another exchange? (answer Y: yes, or N: no)");
        if(scan.next().equals("Y"))
            runExchangeApp();
        else {
            System.out.println("\nThanks for using Currency Exchange App, see you next time");
            try {sleep(2000);} catch (InterruptedException e) {throw new RuntimeException(e);}

        }
    }
}
