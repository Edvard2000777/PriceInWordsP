import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PriceInWordsTest {
    @Test
    public void testConvertToWords(){
        Assertions.assertEquals("ноль", PriceInWords.convertToWords(0));
        Assertions.assertEquals("пять", PriceInWords.convertToWords(5));
        Assertions.assertEquals("три", PriceInWords.convertToWords(3));
        Assertions.assertEquals("сорок пять", PriceInWords.convertToWords(45));
        Assertions.assertEquals("двадцать один", PriceInWords.convertToWords(21));
        Assertions.assertEquals("сто одиннадцать", PriceInWords.convertToWords(111));
        Assertions.assertEquals("пятьсот сорок два", PriceInWords.convertToWords(542));
    }
}
