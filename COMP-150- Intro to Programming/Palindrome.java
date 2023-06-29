import java.util.*;

public class Palindrome {
    public static void main(String[]args){
        String Phrase = "";
        String reverse = "";
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Phrase: ");
        Phrase = input.nextLine();
        input.close();

        Phrase = Phrase.replaceAll("[\\s\\p{Punct}]", "");

        for (int i = Phrase.length() - 1; i >= 0; i--){
            reverse += Phrase.charAt(i);
        }
        if (Phrase.equalsIgnoreCase(reverse)){
            System.out.println(Phrase);
            System.out.println(reverse);
            System.out.println(Phrase + " Is equal to " + reverse + " So this is a Palindrome");
            System.out.println("This is a Palindrome");
        }
        else{
            System.out.println(Phrase);
            System.out.println(reverse);
            System.out.println(Phrase + "Is not equal to " + reverse + " So this is not a Palindrome");
            System.out.println("This is not a Palindrome");
        }
        
    }
}

