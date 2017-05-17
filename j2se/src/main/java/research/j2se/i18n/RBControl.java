package research.j2se.i18n;
import java.util.*;
 
public class RBControl {
    public static void main(String[] args) {
    test(Locale.CHINA);
    test(new Locale("zh", "HK"));
    test(Locale.TAIWAN);
    test(Locale.CANADA);
    }
 
    private static void test(Locale locale) {
    ResourceBundle rb = ResourceBundle.getBundle("i18n/RBControl", locale,
         new ResourceBundle.Control() {
         @Override
         public List<Locale> getCandidateLocales(String baseName, Locale locale) {
             if (baseName == null)
             throw new NullPointerException();
             if (locale.equals(new Locale("zh", "HK"))) {
             return Arrays.asList(
                 locale,
                 Locale.TAIWAN,
                 // no Locale.CHINESE here
                 Locale.ROOT);
             } else if (locale.equals(Locale.TAIWAN)) {
             return Arrays.asList(
                 locale,
                 // no Locale.CHINESE here
                 Locale.ROOT);
             }
             return super.getCandidateLocales(baseName, locale);
         }
         });
    System.out.println("locale: " + locale);
    System.out.println("\tregion: " + rb.getString("region"));
    System.out.println("\tlanguage: " + rb.getString("language"));
    }
}