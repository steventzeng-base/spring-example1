/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.base.tx;

/**
 *
 * @author steven
 */
public class SalaryingTransferError extends Error {

    @Override
    public String getMessage() {
        return "公司現金不足，無法支應員工薪水 ";
    }
}
