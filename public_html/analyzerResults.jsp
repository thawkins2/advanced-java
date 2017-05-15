<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html> 
<html>
<c:set var="pageTitle" value="Analyzer Results" scope="session" />
<c:import url="jsp/head-tag.jsp" />

<body>
  <div id="main">		

<c:import url="jsp/header.jsp" />
	
	<div id="site_content">		
	
      <c:import url="jsp/sidebar.jsp" />
           
      <c:import url="jsp/content-analyzer-reports.jsp" />

	</div><!--close site_content-->  	

	  <c:import url="jsp/footer-tag.jsp" />
	
  </div><!--close main-->
  
  <!-- javascript at the bottom for fast page loading -->
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/image_slide.js"></script>
  
</body>
</html>
