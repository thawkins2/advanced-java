package java112.employee;

import java.util.*;
import java.io.*;
import java.sql.*;

/**
All sql stuff done here ONLY. JDBC select example, but break it up.
class and connection in one method. no try with resources. connection is connection
to database. 
 * @author Your Name Here
 * class EmployeeDirectory
 */
public class EmployeeDirectory {
    
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private Properties properties;
    
    /**
     * Constructor for EmployeeDirectory
     */
    public EmployeeDirectory() {
        
    }
    
    /**
     * Properties constructor for EmployeeDirectory
     @param properties Property variable
     */
    public EmployeeDirectory(Properties properties) {
        this();
        this.properties = properties;
    }
    
    public void processQuery() {
  
        
  
        try {
            statement = connection.createStatement();
  
            String name = "Smith";
            String queryString = "SELECT emp_id, first_name, last_name"
                    + " FROM employees " + "WHERE last_name like '"
                    + name + "%'";
  
            System.out.println("queryString: " + queryString);
  
            resultSet = statement.executeQuery(queryString);
  
            System.out.println();
  
            while (resultSet.next()) {
                String employeeId = resultSet.getString("emp_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                System.out.println(" Row: " + employeeId + " "
                            + firstName + " " + lastName);
            }
  
            System.out.println();
  
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columns = resultSetMetaData.getColumnCount();
            String nameOne = resultSetMetaData.getColumnName(1);
            String typeOne = resultSetMetaData.getColumnTypeName(1);
            String labelOne = resultSetMetaData.getColumnLabel(1);
            System.out.println(" Column count : " + columns);
            System.out.println(" Column 1 name : " + nameOne);
            System.out.println(" Column 1 type : " + typeOne);
            System.out.println(" Column 1 label name : " + labelOne);
  
            System.out.println();
  
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
  
                if (statement != null) {
                    statement.close();
                }
  
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
    
    public void addEmployeeRecord() {
        try {
            Employee employee  = new Employee();
            
            String firstName = employee.getFirstName();
            String lastName = employee.getLastName();
            String socialSecurityNumber = employee.getSocialSecurityNumber();
            String department = employee.getDepartment();
            String roomNumber = employee.getRoomNumber();
            String phoneNumber = employee.getPhoneNumber();
            
            connection = getConnection();
            
            //statement = connection.createStatement();
            
            String queryString = "INSERT INTO employees "
            + "(first_name, last_name, ssn, dept, room, phone)"
            + "values ( ?, ?, ?, ?, ?, ? )";
            
            PreparedStatement preparedQuery = connection.prepareStatement(queryString);
            preparedQuery.setString(1, firstName);
            preparedQuery.setString(2, lastName);
            preparedQuery.setString(3, socialSecurityNumber);
            preparedQuery.setString(4, department);
            preparedQuery.setString(5, roomNumber);
            preparedQuery.setString(6, phoneNumber);
            
            preparedQuery.executeQuery();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
  
                if (statement != null) {
                    statement.close();
                }
  
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
    
    private Connection getConnection() {
        try {
            Class.forName(properties.getProperty("db.driver"));
  
            connection = DriverManager.getConnection(
                    properties.getProperty("db.url"),
                    properties.getProperty("db.username"),
                    properties.getProperty("db.password"));
            
        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        }
        return connection;
    }
    
    
}