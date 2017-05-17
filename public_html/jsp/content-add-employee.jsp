<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div><h2>Add New Employee</h2></div>

<div>
    <h3>${success}</h3>
    <% session.removeAttribute("success"); %>
    <form method="POST" action="/java112/add-new-employee">
        <input type="text" name="firstName">First Name</input>
        <br></br>
        <input type="text" name="lastName">Last Name</input>
        <br></br>
        <input type="text" name="socialSecurityNumber">Social Security Number</input>
        <br></br>
        <input type="text" name="department">Department</input>
        <br></br>
        <input type="text" name="roomNumber">Room Number</input>
        <br></br>
        <input type="text" name="phoneNumber">Phone Number</input>
        <br></br>
        <input type="submit" id="submitSearch" value="Submit"></input>
    </form>
</div>