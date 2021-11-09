/*
package lab3ee.Repository;

import jakarta.annotation.Resource;
import lab3ee.Model.Exam;
import lab3ee.Model.Student;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SingletonRepository {

    private static SingletonRepository repository;
    private Connection connection;

    @Resource(name = "jdbc/db")
    private DataSource dataSource;

    private SingletonRepository() {
        try {
*/
/*            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/JavaEE";
            String user = "postgres";
            String password = "student";
            connection = DriverManager.getConnection(url, user, password);*//*

            connection = dataSource.getConnection();
            //System.out.println(connection.toString());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static SingletonRepository getInstance() {
        if (repository == null) {
            repository = new SingletonRepository();
        }
        return repository;
    }

    public List<Student> getStudents() {
        ResultSet rs;
        PreparedStatement pst;
        String stm = "select * from lab3.students";
        List<Student> students = new ArrayList<>();

        try {
            pst = repository.connection.prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while (rs.next()) {
                Student student = new Student();
                student.setName(rs.getString(1));
                student.addExam(rs.getString(2));
                System.out.println(student.toString());
                students.add(student);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(students.toString());
        return students;
    }

    public List<Exam> getExams() {
        ResultSet rs;
        PreparedStatement pst;
        String stm = "select * from lab3.exams";
        List<Exam> exams = new ArrayList<>();

        try {
            pst = repository.connection.prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while (rs.next()) {
                Exam exam = new Exam();
                exam.setName(rs.getString(1));
                exam.setStartingTime(rs.getDate(2));
                exam.setDuration(rs.getString(3));
                System.out.println(exam.toString());
                exams.add(exam);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exams;
    }
}
*/
