package it.academy.model;

import it.academy.util.HibernateSessionUtil;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlConnection;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BaseTest {

    private final static Logger log = Logger.getLogger(BaseTest.class.getName());

    private IDatabaseConnection connection;
    private IDataSet dataSet;
    public Session session;

    @org.junit.Before
    public void setUp() {

        HibernateSessionUtil hibernateUtil = new HibernateSessionUtil("hibernate.cfg.test.xml");
        session = hibernateUtil.getSessionFactory().openSession();
    }

    @org.junit.After
    public void tearDown() {
        session.close();
    }

    public void cleanInsert(String resourceName) {
        try {
            if (connection == null) {
                connection = new MySqlConnection(
                        MySqlDataSource.getTestConnection(),
                        "task123_test");
            }
            dataSet = new FlatXmlDataSetBuilder().build(BaseTest.class
                    .getResourceAsStream(resourceName));
            DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
        } catch (SQLException | DatabaseUnitException e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public void deleteDataset() {
        try {
            DatabaseOperation.DELETE.execute(connection, dataSet);
            connection.close();
        } catch (SQLException | DatabaseUnitException e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}

class MySqlDataSource {

    private final static Logger log = Logger.getLogger(MySqlDataSource.class.getName());
    private static Properties properties = new Properties();

    static {
        try {
            properties.load(MySqlDataSource.class
                    .getResourceAsStream("/shop_test.ds.properties"));
            Class.forName(properties.getProperty("jdbc.drivers"));
        } catch (ClassNotFoundException | IOException e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public static Connection getTestConnection() throws SQLException {
        return DriverManager.getConnection(
                properties.getProperty("url"),
                properties
        );
    }

}
