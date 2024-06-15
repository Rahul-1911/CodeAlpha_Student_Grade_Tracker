import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        ArrayList<Double> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Enter student grades. Type 'done' to finish:");

        // Reading grades
        while (true) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                double grade = Double.parseDouble(input);
                grades.add(grade);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric grade or 'done' to finish.");
            }
        }

        // Check if grades are entered
        if (grades.isEmpty()) {
            System.out.println("No grades entered.");
            return;
        }

        // Compute average, highest and lowest scores
        double sum = 0;
        double highest = grades.get(0);
        double lowest = grades.get(0);

        for (double grade : grades) {
            sum += grade;
            if (grade > highest) {
                highest = grade;
            }
            if (grade < lowest) {
                lowest = grade;
            }
        }

        double average = sum / grades.size();

        System.out.println("Grades Summary:");
        System.out.printf("Average Grade: %.2f\n", average);
        System.out.printf("Highest Grade: %.2f\n", highest);
        System.out.printf("Lowest Grade: %.2f\n", lowest);
    }
}
