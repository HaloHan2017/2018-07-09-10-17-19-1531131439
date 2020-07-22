package practice04;

public class Worker extends Person {
    public String introduce() {
        return super.introduce() + " I am a Worker. I have a job.";
    }

    public Worker(String name, int age) {
        super(name, age);
    }
}
