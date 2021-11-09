package lab3ee.Utils;

import java.util.ArrayList;
import java.util.List;

public class DataMapper {

    public static List<lab3ee.Model.Exam> ExamsToModel(List<lab3ee.Entities.Exam> examEntities){
        List<lab3ee.Model.Exam> result = new ArrayList<>();
        for (lab3ee.Entities.Exam examEntity : examEntities) {
            result.add(ExamToModel(examEntity));
        }
        return result;
    }

    public static List<lab3ee.Entities.Exam> ExamsToEntity(List<lab3ee.Model.Exam> examModels){
        List<lab3ee.Entities.Exam> result = new ArrayList<>();
        for (lab3ee.Model.Exam examModel : examModels) {
            result.add(ExamToEntity(examModel));
        }
        return result;
    }

    public static lab3ee.Model.Exam ExamToModel(lab3ee.Entities.Exam examEntity) {
        return new lab3ee.Model.Exam(
                examEntity.getName(),
                examEntity.getStartingTime(),
                examEntity.getDuration());
    }

    public static lab3ee.Entities.Exam ExamToEntity(lab3ee.Model.Exam examEntity) {
        return new lab3ee.Entities.Exam(
                examEntity.getName(),
                examEntity.getStartingTime(),
                examEntity.getDuration());
    }
}
