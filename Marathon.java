import java.util.*;
public class Marathon {
    public static void main(String[] args){
        String inputS = "";
        int towns = 0;
        String Town1S = "";
        String Town2S = "";
        String DistanceS = "";
        String Whilecheck = "no";
        int IRemember = 0;
        int Distance = 0;
        int Town1 = 0;
        int Town2 = 0;
        int Start = 0;
        int Finish = 0;
        int Current = 0;
        int roads = 0;
        //Variables



        Scanner input = new Scanner(System.in);
        towns = 52;
        //Roads
        System.out.println("How many roads are there?");
        Whilecheck = "no";
        while(Whilecheck == "no"){
            do {
                try {
                    roads = input.nextInt();
                    if (roads > 100) {
                        System.out.println("The maximum number of roads is 100");
                        System.out.println("How many roads are there?");
                    } else if (roads < 1) {
                        System.out.println("The minimum number of roads is 1");
                        System.out.println("How many roads are there?");
                    } else {
                        Whilecheck = "yes";
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a whole number.");
                    input.nextLine(); // consume the invalid input
                }
            } while (Whilecheck.equals("no"));
            
            
            input.nextLine(); // consume newline character
            int[][] roadarray = new int[roads][3];
            //Instructions
            System.out.println("Please enter the towns and distance seperated by commas");
            System.out.println("In the following order Town1, Town2, Distance");
            System.out.println("For example: T1,T2,5");
            IRemember=0;
            for (int i = 0;  i < roads; i++) {
                i = IRemember;
                Whilecheck = "no";
                while(Whilecheck == "no"){
                    System.out.println("Enter input for road " + (i+1) + " of " + roads);
                    try{
                    inputS = input.nextLine();
                    System.out.println("");
                    System.out.println(inputS);
                    //split the input at , and remove spaces
                    inputS = inputS.replaceAll("\\s+","");
                    if (inputS.matches("[SFT]\\d+|(T\\d+)|([SFT]\\s\\d+)|(T\\d+\\s\\d+)")) {
                        System.out.println("Invalid input. Please enter S, F, a number, or T followed by a number.");
                    } else {
                        String[] parts = inputS.split(",");
                        if (parts.length >= 3) {
                        Town1S = parts[0];
                            Town1S = Town1S.replaceAll("\\s+","");
                            Town1S = Town1S.replaceAll("(?i)T","");
                            if(Town1S.equalsIgnoreCase("S")) {
                                Town1 = 0;
                            } else {
                                Town1 = Integer.parseInt(Town1S);
                            }

                        Town2S = parts[1];
                            Town2S = Town2S.replaceAll("\\s+","");
                            Town2S = Town2S.replaceAll("(?i)T","");
                            if(Town2S.equalsIgnoreCase("F")) {
                                Town2 = towns-1;
                            } else {
                                Town2 = Integer.parseInt(Town2S);
                            } 
                        DistanceS = parts[2];
                            DistanceS = DistanceS.replaceAll("\\s+","");
                            Distance = Integer.parseInt(DistanceS);

                            //Testing purposes 
                            /*  System.out.println(Town1S);
                                System.out.println(Town2S);
                                System.out.println(Distance);
                                System.out.println("");
                                System.out.println("Town1: " + Town1);
                                System.out.println("Town2: " + Town2);
                                System.out.println("Distance: " + Distance);
                                System.out.println("");
                                System.out.println(""); */
                            //End testing purposes
                            IRemember++;
                        Whilecheck = "yes";
                            } else {
                                System.out.println("Invalid input, Please enter input in the format 'Town1, Town2, Distance'");
                                Whilecheck = "no";
                                if(i > 0){
                                    i--;
                                }
                            }
        
                        roadarray[i][0] = Town1;
                        roadarray[i][1] = Town2;
                        roadarray[i][2] = Distance;    
                        Whilecheck = "yes";
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter S, F, a number, or T followed by a number.");
                        Whilecheck = "no";
                    }
                }   
            }

        Start = 0;
        Finish = (towns-1);

        int[] distances = new int[towns];
        for (int i = 0; i < towns; i++){
            if (i == Start){
                distances[i] = 0;
            } else {
                distances[i] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < roads; i++){
            Current = distances[roadarray[i][0]] + roadarray[i][2];
            if (Current < distances[roadarray[i][1]]){
                distances[roadarray[i][1]] = Current;
            }
        }
        Current = Finish;
        //Path to finish
        if (distances[Finish] == Integer.MAX_VALUE){
            System.out.println("No path found");
            System.exit(0);
            } 
        System.out.print("Path: F");
        while (Current != Start) {
            for (int i = 0; i < roads; i++) {
                if (roadarray[i][1] == Current) {
                    if (distances[Current] == distances[roadarray[i][0]] + roadarray[i][2]) {
                        Current = roadarray[i][0];
                        //print the current town
                        if (Current == 0) {
                            System.out.print("<-S");
                        } else {
                            System.out.print("<-T" + Current);
                        }
                    }
                }
            }
        }  
        //Calculations and outputs
        System.out.println();
        System.out.println( "The shortest distance from Start to finish" + " is " + distances[Finish] + "km"); 
        double d = (double) (distances[Finish]);
        double time = d/17;
        double RoundedTime = Math.round(time * 100) / 100.0;
        System.out.println("At a speed of 17km/hr the run would have taken " + RoundedTime +" hours, or " + (RoundedTime*60) + " minutes"); 
        }
    }
}

