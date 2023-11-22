package org.example.poo.statics;

public class Demo {


    public static void main(String[] args) {


        User user = new User();
        System.out.println(user);
        User user1 = new User("Jean-Michel");
        System.out.println(user1);

        int counter = User.counter;

        Employee e = new Employee();
        System.out.println(e);
        Employee ee = new Employee("toto");
        System.out.println(ee);
    }
}
