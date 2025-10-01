package JavaProjects.StudentReportCardSystem;

public class GraduateStudent extends Student {
    private String thesisTitle;
    private String advisorName;
    
    public GraduateStudent(int id, String name, String[] subjects, int[] marks, String thesisTitle, String advisorName) {
        super(id, name, subjects, marks);
        this.thesisTitle = thesisTitle;
        this.advisorName = advisorName;
    }
    @Override
    public StringBuilder getReportCardAsString() {
        StringBuilder report = super.getReportCardAsString();
        report.append("Thesis title: " + thesisTitle + "\n");
        report.append("Advisor: " + advisorName + "\n");
        return report;
    }
}
