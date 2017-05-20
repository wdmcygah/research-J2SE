package research.j2se.i18n;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
 
public class SimpleDateFormatDemo {
 
   static public void displayDate(Locale currentLocale) {
 
      Date today;
      String result;
      SimpleDateFormat formatter;
 
      formatter = new SimpleDateFormat("EEE d MMM yy", currentLocale);
      today = new Date();
      result = formatter.format(today);
 
      System.out.println("Locale: " + currentLocale.toString());
      System.out.println("Result: " + result);
   }
 
 
   static public void displayPattern(String pattern, Locale currentLocale) {
 
      Date today;
      SimpleDateFormat formatter;
      String output;
 
      formatter = new SimpleDateFormat(pattern, currentLocale);
      today = new Date();
      output = formatter.format(today);
 
      System.out.println(pattern + "   " + output);
   }
 
   static public void main(String[] args) {
 
      Locale[] locales = {
          new Locale("fr","FR"),
          new Locale("de","DE"),
          new Locale("en","US")
      };
 
      for (int i = 0; i < locales.length; i++) {
         displayDate(locales[i]);
         System.out.println();
      }
 
      String[] patterns = {
         "dd.MM.yy",
         "yyyy.MM.dd G 'at' hh:mm:ss z",
         "EEE, MMM d, ''yy",
         "h:mm a",
         "H:mm",
         "H:mm:ss:SSS",
         "K:mm a,z",
         "yyyy.MMMMM.dd GGG hh:mm aaa",
         "F"
      };
 
      for (int k = 0; k < patterns.length; k++) {
         displayPattern(patterns[k], new Locale("en","US"));
         System.out.println();
      }
 
      System.out.println();
      
   }
}