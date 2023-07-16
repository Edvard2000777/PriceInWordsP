import java.util.Scanner;

public class PriceInWords {
    private static final String[] units = {
            "", "один", "два", "три", "четыре", "пять",
            "шесть", "семь", "восемь", "девять", "десять",
            "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать",
            "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"
    };

    private static final String[] tens = {
            "", "", "двадцать", "тридцать", "сорок", "пятьдесят",
            "шестьдесят", "семьдесят", "восемьдесят", "девяносто"
    };

    private static final String[] hundreds = {
            "", "сто", "двести", "триста", "четыреста", "пятьсот",
            "шестьсот", "семьсот", "восемьсот", "девятьсот"
    };

    private static final String[] largeUnits = {
            "", "тысяч", "миллионов", "миллиардов", "триллионов"
    };

    public static String convertToWords(long number) {
        if (number == 0) {
            return "ноль";
        }

        if (number < 0) {
            return "минус " + convertToWords(Math.abs(number));
        }

        StringBuilder words = new StringBuilder();

        int unitIndex = 0;

        while (number > 0) {
            if (number % 1000 != 0) {
                String currentWords = convertToWordsUnderThousand((int)(number % 1000), unitIndex);
                if (unitIndex > 0) {
                    currentWords += " " + largeUnits[unitIndex];
                }
                words.insert(0, currentWords + " ");
            }
            number /= 1000;
            unitIndex++;
        }

        return words.toString().trim();
    }

    private static String convertToWordsUnderThousand(int number, int unitIndex) {
        StringBuilder words = new StringBuilder();

        if ((number / 100) > 0) {
            words.append(hundreds[number / 100]).append(" ");
            number %= 100;
        }

        if (number > 0) {
            if (number < 20) {
                words.append(getUnits(number, unitIndex)).append(" ");
            } else {
                words.append(tens[number / 10]).append(" ");
                if ((number % 10) > 0) {
                    words.append(getUnits(number % 10, unitIndex)).append(" ");
                }
            }
        }

        return words.toString().trim();
    }
    private static String getUnits(int number, int unitIndex) {
        if (unitIndex == 1 && number == 1) {
            return "одна";
        } else if (unitIndex == 1 && number == 2) {
            return "две";
        } else {
            return units[number];
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = scanner.nextInt();
        scanner.close();

        String priceInWords = convertToWords(number) + " рублей";
        System.out.println(priceInWords);
    }
}
