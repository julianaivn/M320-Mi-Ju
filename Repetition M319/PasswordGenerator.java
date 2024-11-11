import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("password generator");
        System.out.println("------------------");
        System.out.println("how long should the password be?");

        int length = scanner.nextInt();
        System.out.println("password with " + length + " characters");
        System.out.println(generator(length));

    }

    public static String generator(int length){
        StringBuilder pswrd = new StringBuilder();
        Random random = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvw0123456789?!@$*";

        for(int i = 0; i < length; i++){
            pswrd.append(characters.charAt(random.nextInt(characters.length())));
        }
        return pswrd.toString();
    }
}
