package org.example;

import com.github.lalyos.jfiglet.FigletFont;
import org.example.models.Maison;
import org.example.models.Person;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String asciiArt = FigletFont.convertOneLine("Hello World");
        System.out.println(asciiArt);

        Person person = new Person();
        Person person1 = new Person(2);

        person.setId(1);
        person.setLastname("toto");
        person.setFirstname("titi");

        person1.setLastname("toto");
        person1.setFirstname("titi");

        System.out.println(person.getId());
        System.out.println(person);
        System.out.println(person1.equals(person));

        Maison maison = new Maison(4);
    }
}