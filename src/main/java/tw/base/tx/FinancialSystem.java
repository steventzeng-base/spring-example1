/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.base.tx;

/**
 *
 * @author steven
 */
public interface FinancialSystem {
    void salarying();

    void setCompanyId(Long companyId);

    Long getCompanyId();

    void transfer(Long from, Long to, double amount);

    void salarying(double salary);
}
