package BE;

import BE.GradeInfo;
import BE.Person;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private String education;
    private List<GradeInfo> gradeReport = new ArrayList<>();

    public Student(int id, String name, String education) {
        super(id,name);
        this.education = education;


    }

    public String getEducation() {
        return education;
    }

    public List<GradeInfo> getGradeReport() {
        return gradeReport;
    }

public double getAverageGrade(){
        double sum = 0;
        for (GradeInfo gi : gradeReport) {
            sum += gi.getGrade();
        }
        return  sum/gradeReport.size();
}

public int getGrade(String subject) {
    for (GradeInfo gi : gradeReport) {
        if (gi.getSubject().equals(subject))
            return gi.getGrade();
    }
    throw new RuntimeException("No such subject");
}


public void addGrade(GradeInfo gradeInfo) {
        gradeReport.add(gradeInfo);

}


    public String toString(){
        return super.toString() + "    " + education + "   " + getAverageGrade();
    }

}
