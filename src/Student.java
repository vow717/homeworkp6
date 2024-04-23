public class Student {
    private int number;
    private String name;
    private String clazz;
    private int score;

    public Student(int number, String name, String clazz, int score) {
        this.number = number;
        this.name = name;
        this.clazz = clazz;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public int getScore() {
        return this.score;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
