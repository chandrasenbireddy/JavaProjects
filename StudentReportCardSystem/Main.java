package JavaProjects.StudentReportCardSystem;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] gradSubjects = {"Advanced Math", "Research Methods", "Thesis Writing"};
        String[] subjects = {"Math", "Science", "History"};
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer,Student> ugStudents = new HashMap<>();
        HashMap<Integer,GraduateStudent> gStudents = new HashMap<>();
        boolean running = true;
        while (running){
            System.out.println("1. Create Undergraduate Student");
            System.out.println("2. Create Graduate Student");
            System.out.println("3. print report card");
            System.out.println("4. Save report card to file");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch(choice) {
                case 1:
                    System.out.println("Enter ID:");
                    int ugId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter Name:");
                    String ugName = scanner.nextLine().trim().replaceAll("^'+|'+$", "");
                    int[] ugMarks = new int[subjects.length];
                    for(int i = 0; i < subjects.length; i++) {
                        System.out.println("Enter marks for " + subjects[i] + ":");
                        ugMarks[i] = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                    }
                    Student ugStudent = new Student(ugId, ugName, subjects, ugMarks);
                    ugStudents.put(ugStudent.getId(),ugStudent);
                    ugStudent.printReportCard();
                    break;
                case 2:
                    System.out.println("Enter ID:");
                    int gId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter Name:");
                    String gName = scanner.nextLine().trim().replaceAll("^'+|'+$", "");
                    int[] gMarks = new int[gradSubjects.length];
                    for(int i = 0; i < gradSubjects.length; i++) {
                        System.out.println("Enter marks for " + gradSubjects[i] + ":");
                        gMarks[i] = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                    }
                    System.out.println("Enter Thesis Title:");
                    String thesisTitle = scanner.nextLine().trim().replaceAll("^'+|'+$", "");
                    System.out.println("Enter Advisor Name:");
                    String advisorName = scanner.nextLine().trim().replaceAll("^'+|'+$", "");
                    GraduateStudent gStudent = new GraduateStudent(gId, gName, gradSubjects, gMarks, thesisTitle, advisorName);
                    gStudents.put(gStudent.getId(),gStudent);
                    gStudent.printReportCard();
                    break;
                case 3:
                    System.out.println("Enter 1 for Undergraduate, 2 for Graduate:");
                    int type = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if(type == 1) {
                        System.out.println("Enter Student id to print report card:");
                        int printId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        boolean found = false;
                        if(ugStudents.containsKey(printId)) {
                            ugStudents.get(printId).printReportCard();
                            found = true;
                        }
                        if(!found) {
                            System.out.println("Student with Id " + printId + " not found.");
                        }
                    }
                    else if(type == 2) {
                        System.out.println("Enter Student id to print report card: ");
                        int printId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        boolean found = false;
                        if(gStudents.containsKey(printId)) {
                            gStudents.get(printId).printReportCard();
                            found = true;
                        }
                        if(!found) {
                            System.out.println("Student with id " + printId + " not found.");
                        }
                    }
                    else {
                        System.out.println("Invalid type.");
                    }
                    break;
                case 4:
                    System.out.println("Enter 1 for Undergraduate, 2 for Graduate:");
                    int saveType = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if(saveType == 1) {
                        System.out.println("Enter student id to save report card:");
                        int saveId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.println("Enter file name to save report card:");
                        String fileName = scanner.nextLine().trim().replaceAll("^'+|'+$", "");
                        boolean found = false;
                        if(ugStudents.containsKey(saveId)) {
                            ugStudents.get(saveId).saveReportCardToFile(fileName);
                            found = true;
                        }
                        if(!found) {
                            System.out.println("Student with id " + saveId + " not found.");
                        }
                    }
                    else if (saveType == 2) {
                        System.out.println("Enter student id to save report card:");
                        int saveId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.println("Enter file name to save report card:");
                        String fileName = scanner.nextLine().trim().replaceAll("^'+|'+$", "");
                        boolean found = false;
                        if(gStudents.containsKey(saveId)) {
                            gStudents.get(saveId).saveReportCardToFile(fileName);
                            found = true;
                        }
                        if(!found) {
                            System.out.println("Student with id " + saveId + " not found.");
                        }
                    }
                    else {
                        System.out.println("Invalid Type.");
                    }
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
        scanner.close();
    }
}
