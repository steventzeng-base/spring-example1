/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.base.scope;

/**
 *
 * @author steven
 */
public class Person {

    private final String name;

    private final Apple apple;

    public Person(String name, Apple apple) {
        this.name = name;
        this.apple = apple;
    }

    public String getName() {
        return name;
    }

    public void eating() {
        apple.eaten();
        System.out.println(String.format("%s eating apple #%d", name, apple.id));
    }
}
