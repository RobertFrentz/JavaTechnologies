package lab3ee.Utils;

import lab3ee.Entities.Exam;
import lab3ee.Entities.Resource;
import lab3ee.Entities.Student;

import java.util.ArrayList;
import java.util.List;

public class DataMapper {

    public static List<lab3ee.Model.Exam> ExamsToModel(List<Exam> examEntities){
        List<lab3ee.Model.Exam> result = new ArrayList<>();
        for (Exam exam : examEntities) {
            result.add(ExamToModel(exam));
        }
        return result;
    }

    public static List<Exam> ExamsToEntity(List<lab3ee.Model.Exam> examModels){
        List<Exam> result = new ArrayList<>();
        for (lab3ee.Model.Exam examModel : examModels) {
            result.add(ExamToEntity(examModel));
        }
        return result;
    }

    public static lab3ee.Model.Exam ExamToModel(Exam exam) {
        return new lab3ee.Model.Exam(
                exam.getName(),
                exam.getStartingTime(),
                exam.getDuration());
    }

    public static Exam ExamToEntity(lab3ee.Model.Exam examEntity) {
        return new Exam(
                examEntity.getName(),
                examEntity.getStartingTime(),
                examEntity.getDuration());
    }

    public static List<lab3ee.Model.Student> StudentsToModel(List<Student> studentsEntities){
        List<lab3ee.Model.Student> result = new ArrayList<>();
        for (Student student : studentsEntities) {
            result.add(StudentToModel(student));
        }
        return result;
    }

    public static List<Student> StudentsToEntity(List<lab3ee.Model.Student> studentsModel){
        List<Student> result = new ArrayList<>();
        for (lab3ee.Model.Student studentModel : studentsModel) {
            result.add(StudentToEntity(studentModel));
        }
        return result;
    }

    public static lab3ee.Model.Student StudentToModel(Student student){
        return new lab3ee.Model.Student(
                student.getName(),
                ExamsToModel(student.getExams())
        );
    }

    public static Student StudentToEntity(lab3ee.Model.Student studentModel){
        return new Student(
                studentModel.getName(),
                ExamsToEntity(studentModel.getExamsList())
        );
    }

    public static List<lab3ee.Model.Resource> ResourcesToModel(List<lab3ee.Entities.Resource> resourcesEntities){
        List<lab3ee.Model.Resource> result = new ArrayList<>();
        for (lab3ee.Entities.Resource resourceEntity : resourcesEntities) {
            result.add(ResourceToModel(resourceEntity));
        }
        return result;
    }

    public static List<lab3ee.Entities.Resource> ResourcesToEntity(List<lab3ee.Model.Resource> resourcesModel){
        List<lab3ee.Entities.Resource> result = new ArrayList<>();
        for (lab3ee.Model.Resource resourceModel : resourcesModel) {
            result.add(ResourceToEntity(resourceModel));
        }
        return result;
    }

    public static lab3ee.Model.Resource ResourceToModel(lab3ee.Entities.Resource resourceEntity){
        return new lab3ee.Model.Resource(
                resourceEntity.getName(),
                resourceEntity.getQuantity(),
                resourceEntity.getExam(),
                ""
        );
    }

    public static lab3ee.Entities.Resource ResourceToEntity(lab3ee.Model.Resource resourceModel){
        return new lab3ee.Entities.Resource(
                resourceModel.getName(),
                resourceModel.getQuantity(),
                resourceModel.getExam()
        );
    }
}
