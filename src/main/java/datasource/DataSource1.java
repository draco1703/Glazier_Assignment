package datasource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSource1
{
    MysqlDataSource dataSource = new MysqlDataSource();
    
    public DataSource1()
    {
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("database");
        dataSource.setUser("root");
        dataSource.setPassword("admin");
    }
    
    public MysqlDataSource getDataSource()
    {
        return dataSource;
    }
}
