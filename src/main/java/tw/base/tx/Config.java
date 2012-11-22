/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.base.tx;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author steven
 */
@Configuration
//@ImportResource("/tx.xml")
@EnableTransactionManagement
public class Config {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setName("bankDB").setType(EmbeddedDatabaseType.H2).addDefaultScripts().build();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public AccountDAO accountDAO() {
        return new AccountDAOImpl(dataSource());
    }

    @Bean
    public HistroyDAO histroyDAO() {
        return new HistoryDAOImpl(dataSource());
    }

    @Bean
    public FinancialSystem financialSystem() {
        return new FinancialSystemImpl(accountDAO(), histroyDAO());
    }
}
