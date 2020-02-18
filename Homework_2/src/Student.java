public class Student extends Person {
    private String name = "Steve";
    protected String surName = "Jobs";
    String a = "aaaa";
    public int age = 30;

    public int studentAge() {
        return age;
    }

    private String studentName() {
        return name;
    }

    protected String studentSurname() {
        return surName;
    }

    void print() {
    }
}
