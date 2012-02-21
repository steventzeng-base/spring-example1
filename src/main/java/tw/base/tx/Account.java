/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.base.tx;

/**
 *
 * @author steven
 */
public class Account {

    private Long id;

    private String name;

    private double amount;

    public Account() {
    }

    public Account(Long id, String name, double amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", name=" + name + ", amount=" + amount + '}';
    }
}
