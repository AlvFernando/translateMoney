import translatemoney.TranslateRupiah;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Testing translate money");
        Integer input = 9011;
        TranslateRupiah translateRupiah = new TranslateRupiah(input);
        System.out.println(translateRupiah.translate());
    }
}
