/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.base.scope;

/**
 *
 * @author steven
 */
public class Vendor {
    public final AppleForm form;

    public Vendor(AppleForm form) {
        this.form = form;
    }
    public void sell(){
        System.out.println(String.format("selling apple #%02d", form.get().id));
    }
}
