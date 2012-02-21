/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.base.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author steven
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        AccountDAO dao = applicationContext.getBean(AccountDAO.class);
        listData(dao);
        //新增一筆資料
        dao.addNewOne(new Account(null, "Tony", 10000));
        listData(dao);
        try {
            //新增兩筆資料，沒有 transaction，其中一筆成功，但另一筆失敗
            dao.addNewOne(new Account(null, "richlMan", 10000000));
            dao.addNewOne(new Account(null, "poolMan", -10));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        listData(dao);

        try {
            //新增兩筆資料，有 transaction，任一筆失敗都會造成失敗
            dao.addMoreNew(new Account(null, "richlMan2", 10000000), new Account(null, "poolMan2", -10));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        listData(dao);
        printLine();
        //transaction 的傳播示範，交易由 financialSystem 開始，傳播至 accountdao
        System.out.println("FinancilaSystem");
        printLine();
        FinancialSystem financialSystem = applicationContext.getBean(FinancialSystem.class);
        financialSystem.setCompanyId(1L);
        financialSystem.salarying();
        listData(dao);
        printLine();
        System.out.println("salary bonus");
        //轉帳失敗，全部交易 rollback
        try {
            financialSystem.salarying(20000);
        } catch (SalaryingTransferError e) {
            System.out.println(e.getMessage());
        }
        listData(dao);
        printLine();
        System.out.println("salary bonus little");
        //當全部成功時，才全部 commit
        try {
            financialSystem.salarying(10000);
        } catch (SalaryingTransferError e) {
            System.out.println(e.getMessage());
        }
        listData(dao);
        printLine();
    }

    private static void listData(AccountDAO dao) {
        printLine();
        for (Account account : dao.listAll()) {
            System.out.println(account);
        }
    }

    private static void printLine() {
        for (int i = 0; i < 40; i++) {
            System.out.print("=");
        }
        System.out.println();
    }
}
