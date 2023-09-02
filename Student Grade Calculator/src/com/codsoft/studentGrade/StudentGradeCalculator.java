package com.codsoft.studentGrade;



import java.util.Scanner;

class SubjectNode {
    double marks;
    SubjectNode next;

    public SubjectNode(double marks) {
        this.marks = marks;
        this.next = null;
    }
}

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        SubjectNode head = null;
        SubjectNode current = null;

        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + ": ");
            double marks = scanner.nextDouble();

            if (head == null) {
                head = new SubjectNode(marks);
                current = head;
            } else {
                current.next = new SubjectNode(marks);
                current = current.next;
            }
        }

        double totalMarks = 0;
        current = head;
        while (current != null) {
            totalMarks += current.marks;
            current = current.next;
        }

        double averagePercentage = totalMarks / numSubjects;
        String grade = calculateGrade(averagePercentage);

        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    public static String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A";
        } else if (percentage >= 80) {
            return "B";
        } else if (percentage >= 70) {
            return "C";
        } else if (percentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
