public class Main {
    public static void main(String[] args) {
        Course java = new Course(101);
        java.addStudent(1001);
        java.addStudent(1002);
        java.addStudent(1003);
        java.addStudent(1004);
        java.addStudent(1005);
        java.addStudent(1006);
        java.addStudent(1007);

        Student Ahmed = new Student(240124976);
        Ahmed.addcourse(101);
        Ahmed.addcourse(102);
        Ahmed.addcourse(103);
        Ahmed.addcourse(104);

        University computerScience = new University();
        computerScience.addCourse(101);
        computerScience.addCourse(102);
        computerScience.addCourse(103);
        computerScience.addCourse(104);
        computerScience.addCourse(105);

        computerScience.addStudent(240124976);
        computerScience.addStudent(240124975);
        computerScience.addStudent(240124972);
        computerScience.addStudent(240124973);

        computerScience.enrollmentStudent(240124976, 101);
        computerScience.enrollmentStudent(240124976, 107);//no course has id 107 but the course of 107 has been added to student 240124976
        computerScience.enrollmentStudent(240124976, 103);
        computerScience.enrollmentStudent(240124976, 102); 

        System.out.println(computerScience.getLastCourseAdded()); //105
        System.out.println(computerScience.getLastStudentAdded());//240124973

        computerScience.isFullCourse(101);//The course has not full
        computerScience.isFullCourse(107);//do not print any thing

        computerScience.isNormallStudent(240124976); //this student has normal
        computerScience.isNormallStudent(240); // do not print any thing

        computerScience.listCoursesByStudent(240124976); //101,107,103,102
        computerScience.listStudentsByCourse(101); //240124976 
        computerScience.listStudentsByCourse(107);//do not print any thing 

        computerScience.removeCourse(101); //logical error
        computerScience.listCoursesByStudent(240124976); //103,102

        computerScience.removeEnrollment(240124976, 101);
        computerScience.listStudentsByCourse(101); //1001,1002...1007

        computerScience.sortCourseById(240124976);
        computerScience.listCoursesByStudent(240124976); //101,102,103

        computerScience.removeStudent(240124976);
        computerScience.listStudentsByCourse(101); //1001,1002...1007

        computerScience.sortStudentsById(101);
        computerScience.listStudentsByCourse(101);
    }
}
