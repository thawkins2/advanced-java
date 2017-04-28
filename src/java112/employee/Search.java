package java112.employee;

import java.util.*;

/**
 * @author Thomas Hawkins
 * class Search
 */
public class Search {
    
    private String searchType;
    private String searchTerm;
    private List<Object> queryResults;
    private boolean foundEmployees;
    
    /**
     * Constructor for Search
     */
    public Search() {
        
    }
    
	/**
	 * Returns the value of searchType.
	 */
	public String getSearchType() {
		return searchType;
	}


	/**
	 * Sets the value of searchType.
	 * @param searchType The value to assign searchType.
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}


	/**
	 * Returns the value of searchTerm.
	 */
	public String getSearchTerm() {
		return searchTerm;
	}


	/**
	 * Sets the value of searchTerm.
	 * @param searchTerm The value to assign searchTerm.
	 */
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}


	/**
	 * Returns the value of queryResults.
	 */
	public List<Object> getQueryResults() {
		return queryResults;
	}


	/**
	 * Sets the value of queryResults.
	 * @param queryResults The value to assign queryResults.
	 */
	public void setQueryResults(List<Object> queryResults) {
		this.queryResults = queryResults;
	}


	/**
	 * Returns the value of foundEmployees.
	 */
	public boolean getFoundEmployees() {
		return foundEmployees;
	}


	/**
	 * Sets the value of foundEmployees.
	 * @param foundEmployees The value to assign foundEmployees.
	 */
	public void setFoundEmployees(boolean foundEmployees) {
		this.foundEmployees = foundEmployees;
	}
	
	public void addEmployee(Employee employee) {
	    
    }
}