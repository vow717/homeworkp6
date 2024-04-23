import javax.swing.*;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Map;
public class StreamTest {
    private static final List<Student> STUDENTS = create();
    private static final String CLAZZ1 = "软件1班";
    private static final String CLAZZ2 = "软件2班";
    private static List<Student> create() {
        Student s1 = new Student(2018008, "张扬", CLAZZ2, 66);
        Student s2 = new Student(2018005, "刘飞", CLAZZ1, 92);
        Student s3 = new Student(2018007, "李明", CLAZZ2, 42);
        Student s4 = new Student(2018006, "赵勇", CLAZZ2, 56);
        Student s5 = new Student(2018002, "王磊", CLAZZ1, 81);
        Student s6 = new Student(2018010, "牛娜", CLAZZ1, 78);
        List<Student> students = new ArrayList<>();
        students.add(s1);students.add(s2);students.add(s3);
        students.add(s4);students.add(s5);students.add(s6);
        return students;
    }
    public static void main(String[] args) {
        System.out.print("成绩小于等于60分的学生:");
        // 调用实现方法测试

    }
// 实现方法
    public static List<Student> getStudentsByScore(int lessScore){
        return STUDENTS.stream()
                .filter(student -> student.getScore()<=lessScore)
                .toList();
    }

    public static List<Student> getStudentsByClazzAndScore(String clazz,int lessScore){
        return STUDENTS.stream()
                .filter(student -> student.getScore()==lessScore)
                .filter(student -> student.getClazz().equals(clazz))
                .toList();
    }
    public static String getStudentsNameByClazzAndScore(String clazz,int lessScore){
        return STUDENTS.stream()
                .filter(student -> student.getScore()==lessScore)
                .filter(student -> student.getClazz().equals(clazz))
                .map(student -> student.getName())
                .toString();
    }
    public static List<Student>getSortStudentsByScore(){
        return STUDENTS.stream()
                .sorted(Comparator.comparing(student -> student.getScore()))
                .toList();
    }

    public static List<Student> getStudentsByclazzAndScoreAndSort(String clazz,int lessScore) {
        return STUDENTS.stream()
                .filter(student -> student.getClazz().equals(clazz) && student.getScore()<=lessScore)
                .sorted(Comparator.comparing((Student student) -> student.getScore()).reversed())
                .toList();
    }
    public static int getStudentsNumberByclazzAndScoreAndSort(String clazz, int lessScore) {
        Optional<Integer>result=STUDENTS.stream()
                .filter(student -> student.getClazz().equals(clazz) && student.getScore()<=lessScore)
                .sorted(Comparator.comparing((Student student) -> student.getScore()).reversed())
                .map(student -> student.getNumber())
                .findFirst();
        return result.orElse(-1);
    }
    public static Map<Integer,Integer> getStudentsMapByclazzAndScore(String clazz, int lessScore) {
        return STUDENTS.stream()
                .filter(student -> student.getClazz().equals(clazz) && student.getScore()<=lessScore)
                .collect(Collectors.toMap(student  -> student.getNumber(),student -> student.getScore()));

    }

}
