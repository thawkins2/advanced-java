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
    
    public Object searchEmployeeDatabase(String searchTerm, String searchType) {
        
        Object completedSearch;
        
        if (searchType == "1") {
            completedSearch = searchById(searchTerm);
        } else if (searchType == "2") {
            completedSearch = searchByFirstName(searchTerm);
        } else {
            completedSearch = searchByLastName(searchTerm);
        }
        
        return completedSearch;
    }
    
    public void addEmployeeRecord() {
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            Employee employee  = new Employee();
            
            String firstName = employee.getFirstName();
            String lastName = employee.getLastName();
            String socialSecurityNumber = employee.getSocialSecurityNumber();
            String department = employee.getDepartment();
            String roomNumber = employee.getRoomNumber();
            String phoneNumber = employee.getPhoneNumber();
            
            connection = getConnection(connection);
            
            //Try normal also when time allows
            //statement = connection.createStatement();
            
            String queryString = "INSERT INTO employees "
            + "(first_name, last_name, ssn, dept, room, phone)"
            + "values ( ?, ?, ?, ?, ?, ? )";
            
            statement = connection.prepareStatement(queryString);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, socialSecurityNumber);
            statement.setString(4, department);
            statement.setString(5, roomNumber);
            statement.setString(6, phoneNumber);
            
            statement.executeQuery();
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
    
    private Connection getConnection(Connection connection) {
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
    
    private Object searchById(String searchTerm) {
        Connection connection = null;
        PreparedStatement statement = null;
        Search search = new Search();
        ResultSet resultSet = null;
        
        try {
            connection = getConnection(connection);
            
            String queryString = "SELECT * FROM employees WHERE emp_id = ?";
            
            statement = connection.prepareStatement(queryString);
            statement.setString(1, searchTerm);
            
            resultSet = statement.executeQuery();
            
            if (resultSet != null) {
                search.setFoundEmployees(true);
                
                while(resultSet.next()) {
                    System.out.println(resultSet.getString("emp_id"));
                }
            } else {
                search.setFoundEmployees(false);
            }
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
        
        return search;
    }
    
    private Object searchByFirstName(String searchTerm) {
        Connection connection = null;
        PreparedStatement statement = null;
        Search search = new Search();
        ResultSet resultSet = null;
        
        try {
            connection = getConnection(connection);
            
            String queryString = "SELECT * FROM employees WHERE first_name = ?";
            
            statement = connection.prepareStatement(queryString);
            statement.setString(1, searchTerm);
            
            resultSet = statement.executeQuery();
            
            if (resultSet != null) {
                search.setFoundEmployees(true);
                
                while(resultSet.next()) {
                    System.out.println(resultSet.getString("emp_id"));
                }
            } else {
                search.setFoundEmployees(false);
            }
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
        
        return search;
    }
    
    private Object searchByLastName(String searchTerm) {
        Connection connection = null;
        PreparedStatement statement = null;
        Search search = new Search();
        ResultSet resultSet = null;
        
        try {
            connection = getConnection(connection);
            
            String queryString = "SELECT * FROM employees WHERE last_name = ?";
            
            statement = connection.prepareStatement(queryString);
            statement.setString(1, searchTerm);
            
            resultSet = statement.executeQuery();
            
            if (resultSet != null) {
                search.setFoundEmployees(true);
                
                while(resultSet.next()) {
                    System.out.println(resultSet.getString("emp_id"));
                }
            } else {
                search.setFoundEmployees(false);
            }
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
        
        return search;
    }
}