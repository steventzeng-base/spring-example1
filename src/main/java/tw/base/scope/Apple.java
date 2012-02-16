/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.base.scope;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author steven
 */
public class Apple {

    private static AtomicInteger ID_SEQ = new AtomicInteger(0);

    public final int id;

    private int live = 2;

    public Apple() {
        ID_SEQ.incrementAndGet();
        id = ID_SEQ.get();
    }
    public void eaten(){
        live -= 1;
        if (live <= 0) {
            throw new Error("!!! no apple!!");
        }
    }
}
