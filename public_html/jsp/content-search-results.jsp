<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div><h2>Number of Results: ${rows}</h2></div>
<div>
    <table>
        <tr>
          <th>Employee Id</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Social Security</th>
          <th>Department</th>
          <th>Room Number</th>
          <th>Phone Number</th>
        </tr>
        <c:forEach items="${results}" var="employee">
            <tr>
              <td><c:out value="${employee.employeeId}" /></td>
              <td><c:out value="${employee.firstName}" /></td>
              <td><c:out value="${employee.lastName}" /></td>
              <td><c:out value="${employee.socialSecurityNumber}" /></td>
              <td><c:out value="${employee.department}" /></td>
              <td><c:out value="${employee.roomNumber}" /></td>
              <td><c:out value="${employee.phoneNumber}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>