/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.base.tx;

/**
 *
 * @author steven
 */
public class TransferError extends Error {

    @Override
    public String getMessage() {
        return "帳戶現金不足";
    }
}
