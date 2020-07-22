package practice06;

public class Teacher extends Person {
    protected Integer klass;

    public String introduce() {
        StringBuilder introduce = new StringBuilder(super.introduce());
        introduce.append(" I am a Teacher. ");
        if(klass == null){
            introduce.append("I teach No Class.");
        }else {
            introduce.append("I teach Class ");
            introduce.append(klass);
            introduce.append(".");
        }
        return introduce.toString();
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, Integer klass) {
        super(name, age);
        this.klass = klass;
    }

    public Integer getKlass() {
        return klass;
    }

    public void setKlass(Integer klass) {
        this.klass = klass;
    }
}
