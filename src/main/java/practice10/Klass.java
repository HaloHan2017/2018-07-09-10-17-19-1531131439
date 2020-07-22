package practice10;

public class Klass {
    private int number;
    private String displayName;
    private Student leader;

    public Klass(int number, Student leader) {
        this.number = number;
        this.leader = leader;
    }

    public Klass(int number) {
        this.number = number;
        this.displayName = "Class " + number;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void assignLeader(Student student) {
        if (student.getKlass() == null || this.number != student.getKlass().getNumber()) {
            System.out.print("It is not one of us.\n");
        } else {
            this.leader = student;
            appendMember(student);
        }
    }

    public Student getLeader() {
        return leader;
    }

    public void appendMember(Student student) {
        Klass newClass = new Klass(this.number, this.leader);
        student.setKlass(newClass);
    }

    public boolean isIn(Student student){
        if(student.getKlass() == null){
            return false;
        }
        return this.number == student.getKlass().getNumber();
    }
}
