package practice07;

public class Student extends Person {
    protected Klass klass;

    public String introduce() {
        return super.introduce() + " I am a Student. I am at Class " + klass + ".";
    }

    public Student(String name, int age, Klass klass) {
        super(name,age);
        this.klass = klass;
    }
}
