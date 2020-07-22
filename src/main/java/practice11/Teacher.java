package practice11;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person implements JoinListener {
    private Collection<Klass> classes;

    public String introduce() {
        StringBuilder introduce = new StringBuilder(super.introduce());
        introduce.append(" I am a Teacher. ");
        if (classes == null || classes.isEmpty()) {
            introduce.append("I teach No Class.");
        } else {
            List<Integer> numbers = classes.stream().map(Klass::getNumber).collect(Collectors.toList());
            introduce.append(String.format("I teach Class %s.", getFormatNumberStr(numbers)));
        }
        return introduce.toString();
    }

    private String getFormatNumberStr(List<Integer> numbers) {
        StringBuilder result = new StringBuilder();
        for (Integer number : numbers) {
            result.append(number);
            result.append(", ");
        }
        return result.toString().substring(0, result.length() - 2);
    }

    public String introduceWith(Student student) {
        String str = "I don't teach %s.";
        if (isTeaching(student)) {
            str = "I teach %s.";
        }
        return super.introduce() + String.format(" I am a Teacher. " + str, student.getName());
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, Collection<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
        classes.forEach(cls -> {
            cls.registerJoinListeners(this);
        });
    }

    public Collection<Klass> getClasses() {
        return classes;
    }

    public void setClasses(Collection<Klass> classes) {
        this.classes = classes;
    }

    public boolean isTeaching(Student student) {
        if (student.getKlass() == null) {
            return false;
        }
        return classes.contains(student.getKlass());
    }

    @Override
    public void update(Student student) {
        String result = "I am %s. I know %s has joined Class %s.\n";
        if (student.getKlass().getLeader() != null) {
            result = "I am %s. I know %s become Leader of Class %s.\n";
        }
        System.out.print(String.format(result, this.name, student.getName(), student.getKlass().getNumber()));
    }
}
