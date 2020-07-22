package practice08;

public class Teacher extends Person {
    private Klass klass;

    public String introduce() {
        StringBuilder introduce = new StringBuilder(super.introduce());
        introduce.append(" I am a Teacher. ");
        if (klass == null) {
            introduce.append("I teach No Class.");
        } else {
            introduce.append(String.format("I teach Class %s.", klass.getNumber()));
        }
        return introduce.toString();
    }

    public String introduceWith(Student student) {
        String str = "I don't teach %s.";
        if (student.getKlass().getNumber() == klass.getNumber()) {
            str = "I teach %s.";
        }
        return super.introduce() + String.format(" I am a Teacher. " + str, student.getName());
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }
}
