//Exam #1

import java.util.*;
public class GradesCount {
    public static void main (String[] args) {
        //Variables
        int total = 0;
        int A = 0;
        int B = 0;
        int C = 0;
        int D = 0;
        int F = 0;
        int Grade = 0;

        //Input
        System.out.println("Please enter a Grade between 0 to 100 or -1 to quit: ");
        Scanner input = new Scanner(System.in);
        Grade = input.nextInt();
        ArrayList<Integer> AGrades = new ArrayList<Integer>();
        //Add Grades to the appropriate int
        while (Grade != -1) {
            if (Grade >= 90 && Grade <= 100) {
                A++;
                AGrades.add(Grade);
            } else if (Grade >= 80 && Grade <= 89) {
                B++;
            } else if (Grade >= 70 && Grade <= 79) {
                C++;
            } else if (Grade >= 60 && Grade <= 69) {
                D++;
            } else if (Grade >= 0 && Grade <= 59) {
                F++;
            } else {
                System.out.println("Invalid Grade");
                total--;
            }
            total++;
            System.out.println("Please enter a Grade between 0 to 100 or -1 to quit: ");
            Grade = input.nextInt();
        }
        input.close();
        //Outputs
        System.out.println("");
        System.out.println("Total number of Grades = " + total);
        System.out.println("Number of A = " + A + " Number of B = " + B + " Number of C = " + C + " Number of D = " + D);
        System.out.println("Number of F = " + F);
        //print out 'A's
        System.out.print("The A Grades are: ");
          for (int i = 0; i < AGrades.size(); i++) {
            if (i == AGrades.size() - 1) {
                System.out.print(AGrades.get(i));
            } else {
                System.out.print(AGrades.get(i) + ", ");
            }
        }
    }
}
    /*Write a class, call it GradesCount, to read a list of Grades from the keyboard (integer numbers in the range 0 to 100).
 Prompt the user with “Please enter a Grade between 0 to 100 or -1 to
 quit: ” each time before reading the next integer. Store each Grade in a A, B, C, D or F Vector as follows:
  90 to 100 = A, 80 to 89 = B, 70 to 79 = C, 60 to 69 = D, and 0 to 59 = F. 
 (Hint: You cannot store ints as Vector elements, but you can store Integers.)

Output the total number of Grades entered, the number of A, B, C, D and F, and a list of the A’s. For example, if the input is...

38
86
92
55
83
42
90
-1

then the output should be:
Total number of Grades = 7
Number of A = 2 Number of B = 2 Number of C = 0 Number of D = 0
Number of F = 3
The A Grades are: 92, 90 */