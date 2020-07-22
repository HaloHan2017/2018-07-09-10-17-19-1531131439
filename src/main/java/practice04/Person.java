package practice04;

public class Person {
    protected String name;
    protected int age;

    public String introduce() {
        return "My name is " + name + ". I am " + age + " years old.";
    }

    public String basicIntroduce() {
        return "My name is " + name + ". I am " + age + " years old.";
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
