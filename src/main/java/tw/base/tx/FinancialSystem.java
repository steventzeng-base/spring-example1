package tw.base.tx;

/**
 * 薪資發放系統
 * @author steven
 */
public interface FinancialSystem {
    /**
     * 發薪資
     */
    void salarying();

    /**
     * 設定公司賬戶
     * @param companyId 
     */
    void setCompanyId(Long companyId);

    /**
     * 進行交易
     * @param from
     * @param to
     * @param amount 
     */
    void transfer(Long from, Long to, double amount);

    void salarying(double salary);

    public void setEmpoyeesIds(long... ids);
}
