import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Deposit {
    private double amount; 

    public Deposit(double a) {
        amount = a;

    }
    public double getAmount() {
        return amount;
    }

    public void welcoming() {
        System.out.println("Welcome to the deposit section of the bank!");
        System.out.println("If you would like to Create a new file, please enter (1).");
        System.out.println("If you would like to deposit from an existing file, please enter (2).");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 1) {
            createFile();
        }
        else if (choice == 2) {
            askAmount();
        }
    }

    public void askAmount() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter you deposit: ");
        amount = input.nextDouble(); // This is where the user will input the amount they want to deposit.
        writeAmount(amount);
    }

    public void createFile() {
        try {
            File newFile = new File("C:/Users/ryanr/Desktop/Homework/java my balls/textfiles/depositlist.txt");
                if (newFile.createNewFile()) {
                    System.out.println("File created: " + newFile.getName());
                } else {
                    System.out.println("File already exists.");

                }

        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void writeAmount(double a) {
        amount = a;
     
        try {
            FileWriter addAmount = new FileWriter("C:/Users/ryanr/Desktop/Homework/java my balls/textfiles/depositlist.txt", true);

            addAmount.write("$" + Double.toString(amount) + "\n");
            addAmount.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void totalAmount() {
        try {
            FileWriter totalAmount = new FileWriter("C:/Users/ryanr/Desktop/Homework/java my balls/textfiles/depositlist.txt", true);
            Scanner newFile = new Scanner("C:/Users/ryanr/Desktop/Homework/java my balls/textfiles/depositlist.txt");

            while (newFile.hasNextLine()) {
                String line = newFile.nextLine();
                if (line.startsWith("$")) {
                    double value = Double.parseDouble(line);
                    amount += value;

                    totalAmount.write("Total: $" + Double.toString(amount) + "\n");
                }
            }

            newFile.close();
            totalAmount.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
       
}