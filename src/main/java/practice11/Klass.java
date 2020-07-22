package practice11;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int number;
    private String displayName;
    private Student leader;
    private List<JoinListener> joinListeners;

    public void registerJoinListeners(JoinListener joinListener){
        joinListeners.add(joinListener);
    }

    public Klass(int number, Student leader) {
        this.number = number;
        this.leader = leader;
    }

    public Klass(int number) {
        this.number = number;
        this.displayName = "Class " + number;
        joinListeners = new ArrayList<>();
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
            student.setKlass(this);
            notifyAll(student);
        }
    }

    private void notifyAll(Student student) {
        joinListeners.forEach(joinListener -> {
            joinListener.update(student);
        });
    }

    public Student getLeader() {
        return leader;
    }

    public void appendMember(Student student) {
        student.setKlass(this);
        notifyAll(student);
    }

    public boolean isIn(Student student){
        if(student.getKlass() == null){
            return false;
        }
        return this.number == student.getKlass().getNumber();
    }
}
