import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("password generator");
        System.out.println("------------------");
        System.out.println("how long should the password be?");

        int length = scanner.nextInt();
        String characters = characterRange();
        System.out.println("password with " + length + " characters");
        System.out.println(generator(length, characters));

    }

    private static String generator(int length, String characters){
        StringBuilder pswrd = new StringBuilder();
        Random random = new Random();

        for(int i = 0; i < length; i++){
            pswrd.append(characters.charAt(random.nextInt(characters.length())));
        }
        return pswrd.toString();
    }

    private static String characterRange(){
        StringBuilder characters = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        System.out.println("do you want lowercase letters? (y/n)");
        String input =  scanner.nextLine();
        if(input.equals("y")){
            characters.append("abcdefghijklmnopqrstuvwxyz");
        }

        System.out.println("do you want uppercase letters? (y/n)");
        input =  scanner.nextLine();
        if(input.equals("y")){
            characters.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }

        System.out.println("do you want special characters like '?!@$*'? (y/n)");
        input =  scanner.nextLine();
        if(input.equals("y")){
            characters.append("?!@$*");
        }

        return characters.toString();
    }
}
