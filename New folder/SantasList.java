//Exan #2
import java.io.*;
import java.util.*;

public class SantasList {
    public static void main(String[] args) {
        int Coal = 0;
        int Pony = 0;
        int Bicycle = 0;
        String joinedWords = "";

        ArrayList<String> lines = new ArrayList<>();
            //read file and put into an array
        try (BufferedReader br = new BufferedReader(new FileReader("List.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ShoppingList.txt"))) {
            writer.write("Santa's Shopping List:");
            writer.newLine();
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //output array
        String[] arr = lines.toArray(new String[0]);
        
        for (int i = 0; i < arr.length; i++) {
            //System.out.println(arr[i]);
            String[] words = arr[i].split(" ");
            for (int ii = 0; ii < words.length; ii++) {
                if (words[ii].equalsIgnoreCase("Bad")) {
                    words[ii] = "Coal";
                    words[ii - 3] = words[ii - 1]+ ",";
                    words[ii-1] = "";
                    Coal++;
                } else if (words[ii].equalsIgnoreCase("Good" )) {
                    if (words[ii - 3].equalsIgnoreCase("F")) {
                        words[ii] = "Pony";
                        words[ii - 3] = words[ii - 1] + ",";
                        words[ii-1] = "";
                        Pony++;
                    } else if (words[ii - 3].equalsIgnoreCase("M")) {
                        words[ii] = "Bicycle";
                        words[ii - 3] = words[ii - 1]+ ",";
                        words[ii-1] = "";
                        Bicycle++;
                    }
                }

            }
            //added a bunch to stop out of bounds error
            String[] NewArr = new String[arr.length+1];
            int lastValidIndex = -1;

            joinedWords = String.join(" ", words);
            //System.out.println(joinedWords);

            for (int ii = 0; ii < 1; ii++) {
                joinedWords = String.join(" ", words);
                NewArr[ii] = joinedWords.trim();
                lastValidIndex = ii; 
            }
            //System.out.println(NewArr[i]);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("ShoppingList.txt", true))) {
                for (int ii = 0; ii <= lastValidIndex; ii++) {
                    writer.write(NewArr[ii]);
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ShoppingList.txt", true))) {
            writer.newLine();
            writer.newLine();
            writer.write("Things to buy:");
            writer.newLine();
            writer.write("Lumps of Coal: " + Coal);
            writer.newLine();
            writer.write("Ponies: " + Pony);
            writer.newLine();
            writer.write("Bicycles: " + Bicycle);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Shopping list created!");
    }
 }

 /*
Santa’s list gets longer every year and he is having trouble keeping track of what he is going to bring each boy and girl. 
This year he has gone high-tech and kept a list of names along with whether the child was good or bad on his computer. 
However, he now needs to know how many toys and how many lumps of coal he needs to buy and for which children. 
He has hired you to write a program that will read in his list (it’s saved in a file called List.txt) and produce another text file called ShoppingList.txt 
that he can use for delivering gifts and to give the elves so they know how to pack his toy bag.

The List.txt file is formatted so that each line has the following format:

Gender FirstName LastName Status
Gender will be either an “F” or a “M” and Status will be either “Good” or “Bad” An example List.txt file would be formatted as follows:

M Jack Frost Bad
F CindyLou Who Good
M Rudolph Rednose-Reindeer Good

The ShoppingList.txt file should be formatted such that each line has “lastName, firstName toyName” where toyName is “Coal” if the status of the child is “Bad”,
toyName is “Pony” if the gender of the child is “F” and the status of the child is “Good”, and the toyName should be “Bicycle” 
if the gender of the child is “M” and the status of the child is “Good”. In addition, the last three lines of the file should print the number of lumps of coal, bicycles, and ponies to buy.
An example resulting ShoppingList.txt file for the above List.txt should be:

Frost, Jack Coal
Who, CindyLou Pony
Rednose-Reindeer, Rudolph Bicycle

Lumps of Coal: 1
Bicycles: 1
Ponies: 1

In order to do this you should create a complete class called SantasHelper which will read List.txt and produce ShoppingList.txt. 
Do not make any assumptions about the length of the list, but you can assume that it is formatted correctly. 
If the List.txt file does not exist, you should catch any exception that might be thrown.
 
 */