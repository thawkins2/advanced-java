<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html> 
<html>
<c:set var="pageTitle" value="Employee Search" scope="session" />
<c:import url="jsp/head-tag.jsp" />

<body>
  <div id="main">		

<c:import url="jsp/header.jsp" />
    
    <div id="slideshow_container">  
	  <div class="slideshow">
	    <ul class="slideshow">
          <li class="show"><img width="940" height="250" src="images/home_1.jpg" alt="&quot;Enter your caption here&quot;" /></li>
          <li><img width="940" height="250" src="images/home_2.jpg" alt="&quot;Enter your caption here&quot;" /></li>
        </ul> 
	  </div><!--close slideshow-->  	
	</div><!--close slideshow_container-->   
	
	<div id="site_content">		
	
      <c:import url="jsp/sidebar.jsp" />
           
      <c:import url="jsp/content-search-results.jsp" />

	</div><!--close site_content-->  	

	  <c:import url="jsp/footer-tag.jsp" />
	
  </div><!--close main-->
  
  <!-- javascript at the bottom for fast page loading -->
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/image_slide.js"></script>
  
</body>
</html>
