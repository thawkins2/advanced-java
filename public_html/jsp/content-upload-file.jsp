<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<div>
<form method="POST" action="/java112/upload-file-servlet" enctype="multipart/form-data" >
    File:
    <input type="file" name="file" id="file" />
    <br/>
    <input type="submit" value="Upload" name="upload" id="upload" />
</form>
    <h2>${uploadFile}</h2>
</div>