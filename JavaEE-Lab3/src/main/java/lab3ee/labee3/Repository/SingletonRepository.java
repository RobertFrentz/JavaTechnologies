package lab3ee.labee3.Repository;

import lab3ee.labee3.Model.Exam;
import lab3ee.labee3.Model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SingletonRepository {

    private static SingletonRepository repository = new SingletonRepository();
    private Connection connection;

    private SingletonRepository(){
        try {
            String url = "jdbc:postgresql://localhost:5432/JavaEE";
            String user = "postgres";
            String password = "student";
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection completed.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static SingletonRepository getInstance(){
        if(repository == null){
            repository = new SingletonRepository();
        }
        return repository;
    }

    public  List<Student> getStudents(){
        ResultSet rs;
        PreparedStatement pst;
        String stm = "select * from students";
        List<Student> students = new ArrayList<>();

        try {
            pst = repository.connection.prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while(rs.next()) {
                Student student = new Student();
                student.setName(rs.getString(1));
                student.addExam(rs.getString(2));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(students.toString());
        return students;
    }

    public  List<Exam> getExams(){
        ResultSet rs;
        PreparedStatement pst;
        String stm = "select * from exams";
        List<Exam> exams = new ArrayList<>();

        try {
            pst = repository.connection.prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while(rs.next()) {
                Exam exam = new Exam();
                exam.setName(rs.getString(1));
                exam.setStartingTime(rs.getDate(2));
                exam.setDuration(rs.getString(3));
                exams.add(exam);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(exams.toString());
        return exams;
    }
}
