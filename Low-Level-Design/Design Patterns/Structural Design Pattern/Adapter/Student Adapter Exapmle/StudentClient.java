
import java.util.ArrayList;
import java.util.List;

public class StudentClient {

    List<Student> getStudentList() {
        List<Student> students = new ArrayList<>();
        CollegeStudent collegeStudent = new CollegeStudent("a", "b", "c");
        SchoolStudent schoolStudent = new SchoolStudent("x", "y", "z");
        students.add(collegeStudent);

        // here if i try to add the school student it will give error as both have different interface
        // studeents.add(schoolStudent);
        // instead we will use adapter, it will convert the school student to student interface
        students.add(new SchoolStudentAdapter(schoolStudent));
        return students;
    }
}