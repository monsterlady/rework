
import java.util.Scanner;

public class Race {
    public static void main(String[] args) {
        new Race().run();
    }
    private void run() {
        int NumofCandidates = 6;
        String[] NameofCandidates = new String[NumofCandidates];
        boolean[] DroppedHorse = new boolean[NumofCandidates];
        double[] ResultofCandidates = new double[NumofCandidates];
        int low = 0;
        int high = 3;
        int Chancetodrop = 23;
        double averageTime = 0;
        boolean isNameAdded = false;
        boolean isAverageAdded = false;

        PrintMenu();
        int Choose = getValidInput(low, high);

        while (Choose != 0) if (Choose == 1) {
            for (int i = 0; i < NameofCandidates.length; i++) {
                System.out.println("Horse " + (i + 1) + " Name : ");
                String eachname;
                eachname = getValidName();
                NameofCandidates[i] = eachname;
            }
            for (int i = 0; i < ResultofCandidates.length; i++) {
                int dropchance = (int) (Math.random() * 100);
                if (dropchance < Chancetodrop) {
                    DroppedHorse[i] = true;
                } else {
                    double grade = Math.random() * (30 - 10) + 10;
                    ResultofCandidates[i] = grade;
                }
            }
            PrintMenu();
            Choose = getValidInput(low, high);
            isNameAdded = true;

        } else if (Choose == 2) {
            if (isNameAdded) {
                int finishedHorse = 0;
                double totalTime = 0;
                for (int i = 0; i < DroppedHorse.length; i++) {
                    if (!DroppedHorse[i]) {
                        finishedHorse++;
                        totalTime += ResultofCandidates[i];
                        System.out.println(NameofCandidates[i] + ": " + ResultofCandidates[i]);
                    } else {
                        System.out.println(NameofCandidates[i] + ": " + "Dropped!");
                    }
                }
                averageTime = totalTime / finishedHorse;
                System.out.println("The average time is: " + averageTime);
                PrintMenu();
                Choose = getValidInput(low, high);
                isAverageAdded = true;
            } else {
                System.out.println("You have to run Choose 1 before running Choose 2");
                Choose = getValidInput(low, high);
            }

        } else if (Choose == 3) {
            if (isAverageAdded) {
                int nameofFestest = 0;
                StringBuilder slowerthanAVERAGE = new StringBuilder();
                double festestHorse = ResultofCandidates[0];
                for (int i = 0; i < DroppedHorse.length; i++) {
                    if (festestHorse > ResultofCandidates[i] && !DroppedHorse[i]) {
                        festestHorse = ResultofCandidates[i];
                        nameofFestest = i;
                    }
                    if (!DroppedHorse[i] && ResultofCandidates[i] > averageTime) {
                        slowerthanAVERAGE.append(NameofCandidates[i]).append(" ");
                    }
                }
                System.out.println(slowerthanAVERAGE + " are slower than average time \n" + NameofCandidates[nameofFestest] + " is the festest man");
                PrintMenu();
                Choose = getValidInput(low, high);
            } else {
                System.out.println("You have to run Choose 1 before running Choose 3");
                Choose = getValidInput(low, high);
            }
        }
    }
    private void PrintMenu () {
        System.out.println("__________________________________");
        System.out.println("1.Run the race");
        System.out.println("2.Show the result");
        System.out.println("3.Average time");
        System.out.println("0.Quit");
        System.out.println("_______________________________________");
    }
    private int getValidInput ( int low, int high){
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        while (input > high || input < low) {
            System.out.println("Invaild Input, Try again!");
            input = scanner.nextInt();
        }
        return input;
    }
    private String getValidName () {
        int lowestboundary = 1;
        int largestboundary = 15;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        while (str.length() > largestboundary || str.length() < lowestboundary) {
            System.out.println("Valid Input, Please try again!");
            str = scanner.nextLine();
        }
        return str;
    }

}

