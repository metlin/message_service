package ru.metlin.message_service.registration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.apache.commons.dbcp.BasicDataSource;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

  /*  @Bean(name = "dataSource")
    public BasicDataSource myDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
    //    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
     //   dataSource.addConnectionProperty("url", "jdbc:mysql://localhost:3306/ms_db");
      //  dataSource.addConnectionProperty("username", "message_service");
      //  dataSource.addConnectionProperty("password", "1111");

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/ms_db");
        dataSource.setUsername("message_service");
        dataSource.setPassword("1111");

        return dataSource;
    }
*/

}
