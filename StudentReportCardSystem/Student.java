package JavaProjects.StudentReportCardSystem;

import java.io.FileWriter;

public class Student {
    private int id;
    private String name;
    private String[] subjects;
    private int[] marks;

    public Student(int id, String name, String[] subjects, int[] marks) {
        this.id = id;
        this.name = name;
        this.subjects = subjects;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String[] getSubjects() {
        return subjects;
    }
    public int[] getMarks() {
        return marks;
    }

    public double calculateAverage() {
        int total = 0;
        for(int mark: marks) {
            total += mark;
        }
        return (double) total / marks.length;
    }
    public char determineGrade() {
        double avg = calculateAverage();
        if(avg >= 90) return 'A';
        else if(avg >= 80) return 'B';
        else if(avg >= 70) return 'C';
        else if(avg >= 60) return 'D';
        else return 'F';
    }
    public void printReportCard() {
        System.out.println(getReportCardAsString().toString());
    }
    public StringBuilder getReportCardAsString() {
        StringBuilder report = new StringBuilder();
        report.append("Report card for " + name + " (ID: " + id + ")\n");
        report.append("Subjects and Marks:\n");
        report.append("-------------------\n");
        for(int i = 0; i < subjects.length; i++) {
            report.append(subjects[i] + ": " + marks[i] + "\n");
            report.append("-------------------\n");
        }
        report.append("Average: " + String.format("%.2f" , calculateAverage()) + "\n");
        report.append("Grade: " + determineGrade() + "\n");
        return report;
    }
    public void saveReportCardToFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(getReportCardAsString().toString());
            System.out.println("Report card saved to " + fileName);
            }
        catch (Exception e) {
            System.out.println("Erroe saving report card: " + e.getMessage());
        }
    }
}
