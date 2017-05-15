<div>
<h2>Search Employee Database</h2>
    <form method="GET" action="/java112/search-results">
      <input type="text" name="searchTerm"></input>
      <br></br>
      <input type="radio" name="searchType" value="firstName" checked="checked">First Name</input>
      <br></br>
      <input type="radio" name="searchType" value="lastName">Last Name</input>
      <br></br>
      <input type="radio" name="searchType" value="employeeId">Employee ID</input>
      <br></br>
      <input type="submit" id="submitSearch" value="Submit"></input>
    </form>
</div>