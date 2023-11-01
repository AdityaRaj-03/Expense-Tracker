import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Expense> expenses = new ArrayList<>();
        Map<String, Double> expenseCategories = new HashMap<>();

        while (true) {
            System.out.println("Expense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. Generate Report");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline character
                    System.out.print("Enter the category: ");
                    String category = scanner.nextLine();
                    expenses.add(new Expense(amount, category));

                    // Update the category totals
                    expenseCategories.put(category, expenseCategories.getOrDefault(category, 0.0) + amount);
                    break;
                case 2:
                    generateExpenseReport(expenses, expenseCategories);
                    break;
                case 3:
                    System.out.println("Exiting the Expense Tracker. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void generateExpenseReport(List<Expense> expenses,
     Map<String, Double> expenseCategories) {
        System.out.println("Expense Report:");
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
        
        System.out.println("\nCategory Totals:");
        for (String category : expenseCategories.keySet()) {
            System.out.println(category + ": " + expenseCategories.get(category));
        }
    }
}

class Expense {
    private double amount;
    private String category;

    public Expense(double amount, String category) {
        this.amount = amount;
        this.category = category;
    }

    public String toString() {
        return "Expense: " + amount + " | Category: " + category;
    }
}
