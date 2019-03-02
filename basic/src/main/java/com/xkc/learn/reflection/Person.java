package com.xkc.learn.reflection;

class Person {
    private String name;
    private int age;
    protected float salary;
    double bound;
    public String addr = "Nanjing";


    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Person(String name, int age, float salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    private Person(double bound, String addr) {
        this.bound = bound;
        this.addr = addr;
    }

    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }

    void sayGreet() {
        System.out.println("Greet");
    }

    private void sayGood() {
        System.out.println("Good");
    }

    private void sayGood(String name) {
        System.out.println("Good " + name + " " + age);
    }

    private static void method() {
        System.out.println("static");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", bound=" + bound +
                ", addr='" + addr + '\'' +
                '}';
    }
}
