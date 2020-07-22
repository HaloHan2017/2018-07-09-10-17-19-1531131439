package practice07;

public class Teacher extends Person {
    private Klass klass;

    public String introduce() {
        StringBuilder introduce = new StringBuilder(super.introduce());
        introduce.append(" I am a Teacher. ");
        if (klass == null) {
            introduce.append("I teach No Class.");
        } else {
            introduce.append("I teach Class ");
            introduce.append(klass.getNumber());
            introduce.append(".");
        }
        return introduce.toString();
    }

    public String introduceWith(Student student) {
        if (student.getKlass().getNumber() == klass.getNumber()) {
            return super.introduce() + " I am a Teacher. I teach " + student.getName() + ".";
        }
        return super.introduce() + " I am a Teacher. I don't teach " + student.getName() + ".";
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }
}
