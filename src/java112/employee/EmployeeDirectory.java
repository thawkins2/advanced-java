package java112.employee;


import java.io.*;
import java.sql.*;
import java.util.*;


/**
 * Main Class for employee package. Receives responses from servlets and calls
 * appropriate method for querying the database. Returns array of employees to
 * be displayed in the JSP pages.
 * @author Thomas Hawkins
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
     * @param properties Property variable
     */
    public EmployeeDirectory(Properties properties) {
        this();
        this.properties = properties;
    }


    /**
     * Main method for the EmployeeDirectory class. Takes in a search term, type
     * , and calls the main query method to get results.
     * @param searchTerm Varaible that will search the database
     * @param searchType Variable that will determine query used
     * @return completedSearch ArrayList of employees found
     */
    public List searchEmployeeDatabase(String searchTerm, String searchType) {

        List completedSearch = null;

        completedSearch = queryDatabase(searchType, searchTerm);

        return completedSearch;
    }


    /**
     * Method takes in form data from servlet and creates query to add new employee
     * record.
     * @param firstName First name for new employee
     * @param lastName Last name for new employee
     * @param socialSecurityNumber New employee ssn
     * @param department New employee department
     * @param roomNumber New employee room number
     * @param phoneNumber New employee phone number
     * @return result number of rows created
     */
    public Integer addEmployeeRecord(String firstName, String lastName,
    String socialSecurityNumber, String department,
    String roomNumber, String phoneNumber) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int result = 0;

        try {

            connection = getConnection(connection);

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

            result = statement.executeUpdate();
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
        return result;
    }


    /**
     * Opens the databse connection to be used for querying.
     * @param connection database connection
     * @return connection Open database connection
     */
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


    /**
     * Main query method. Calls methods for opening database connection and preparing
     * query for use. Sets search object data and calls the method to build the employee
     * array list.
     * @param searchType What column we will query for the database
     * @param searchTerm Data that will be queryed against the search type
     * @return search.getQueryResults() ArrayList of Employees queryed
     */
    private List queryDatabase(String searchType, String searchTerm) {
        Connection connection = null;
        PreparedStatement statement = null;
        Search search = new Search();
        ResultSet resultSet = null;
        String queryString = null;

        try {
            connection = getConnection(connection);

            queryString = getQueryString(searchType);

            statement = connection.prepareStatement(queryString);
            statement.setString(1, searchTerm + "%");

            resultSet = statement.executeQuery();

            if (resultSet != null) {
                search = buildEmployeeList(resultSet, search);
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
        return search.getQueryResults();
    }


    /**
     * Uses the search type to select the proper query string for execution.
     * @param searchType Used to select proper query string
     * @return queryString Query string to be prepared for execution
     */
    private String getQueryString(String searchType) {
        String queryString;

        if (searchType.equals("employeeId")) {
            queryString = "SELECT * FROM employees WHERE emp_id LIKE ?";
        } else if (searchType.equals("firstName")) {
            queryString = "SELECT * FROM employees WHERE first_name LIKE ?";
        } else {
            queryString = "SELECT * FROM employees WHERE last_name LIKE ?";
        }


        return queryString;
    }


    /**
     * Uses the search type to select the proper query string for execution.
     * @param resultSet Data retrieved from query execution
     * @param search Search object for creating employee list
     * @return search Finished search object
     */
    private Search buildEmployeeList(ResultSet resultSet, Search search) {
        try {
            search.setFoundEmployees(true);

            while (resultSet.next()) {
                Employee employee = new Employee();

                String employee_id = resultSet.getString("emp_id");
                System.out.println(employee_id);
                employee.setEmployeeId(employee_id);
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setSocialSecurityNumber(resultSet.getString("ssn"));
                employee.setDepartment(resultSet.getString("dept"));
                employee.setRoomNumber(resultSet.getString("room"));
                employee.setPhoneNumber(resultSet.getString("phone"));

                search.addEmployee(employee);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return search;
    }
}

