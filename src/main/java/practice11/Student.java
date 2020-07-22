package practice11;

public class Student extends Person {
    private Klass klass;

    public String introduce() {
        String str = "I am at Class %s.";
        if (klass != null && klass.getLeader() != null && (this.id == klass.getLeader().getId())) {
            str = "I am Leader of Class %s.";
        }
        return super.introduce() + String.format(" I am a Student. " + str, klass.getNumber());
    }

    public Student(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }
}