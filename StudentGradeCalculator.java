import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        int total = 0;

        for (int i = 1; i <= subjects; i++) {
            System.out.print("Enter marks for Subject " + i + ": ");
            int marks = sc.nextInt();

            while (marks < 0 || marks > 100) {
                System.out.print("Invalid Marks. Enter again: ");
                marks = sc.nextInt();
            }

            total += marks;
        }

        double percentage = (double) total / subjects;

        String grade;

        if (percentage >= 90)
            grade = "A+";
        else if (percentage >= 80)
            grade = "A";
        else if (percentage >= 70)
            grade = "B";
        else if (percentage >= 60)
            grade = "C";
        else if (percentage >= 50)
            grade = "D";
        else
            grade = "Fail";

        System.out.println("\n----- Result -----");
        System.out.println("Total Marks : " + total);
        System.out.println("Percentage : " + percentage);
        System.out.println("Grade : " + grade);

        sc.close();
    }
}
