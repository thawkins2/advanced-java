<!DOCTYPE html> 
<html>

<head>
  <title>Free HTML5 Templates</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
  <link rel="stylesheet" type="text/css" href="css/style.css" />
  <!-- modernizr enables HTML5 elements and feature detects -->
  <script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
</head>

<body>
  <div id="main">		

    <header>
	  <div id="strapline">
	    <div id="welcome_slogan">
	      <h3>Project 3 Properties Page by <span>Tj Hawkins</span></h3>
	    </div><!--close welcome_slogan-->
      </div><!--close strapline-->	  
	  <nav>
	    <div id="menubar">
          <ul id="nav">
            <li class="current"><a href="/java112">Home</a></li>
          </ul>
        </div><!--close menubar-->	
      </nav>
    </header>
    
    <div id="slideshow_container">  
	  <div class="slideshow">
	    <ul class="slideshow">
          <li class="show"><img width="940" height="250" src="images/home_1.jpg" alt="&quot;Enter your caption here&quot;" /></li>
          <li><img width="940" height="250" src="images/home_2.jpg" alt="&quot;Enter your caption here&quot;" /></li>
        </ul> 
	  </div><!--close slideshow-->  	
	</div><!--close slideshow_container-->   
	
	<div id="site_content">		
	  
	  <div class="sidebar_container">       
	  
	  	<div class="sidebar">
        <div class="sidebar_item">
            <h2>Project 4</h2>
            <p></p>         
        </div><!--close sidebar_item--> 
      </div><!--close sidebar-->
	  
	  	<div class="sidebar">
        <div class="sidebar_item">
            <h2>Project 3</h2>
            <p><a href="/java112/request-servlet">Request Servlet</a></p>
            <p><a href="/java112/properties-servlet">Properties Servlet</a></p>
        </div><!--close sidebar_item--> 
      </div><!--close sidebar-->
        
		    <div class="sidebar">
          <div class="sidebar_item">
            <h2>Project 2</h2>
            <p><a href="/java112/FirstServlet">First Servlet</a></p>
            <p><a href="/java112/PropertiesServlet">Properties Servlet</a></p>
          </div><!--close sidebar_item--> 
        </div><!--close sidebar-->     		


       </div><!--close sidebar_container-->	
	   
	  <div id="content">
        <div class="content_item">
            <table>
                <tr><th>Property Name</th><th>Value</th></tr>
                <tr><td>Author:</td><td>${p3properties["author"]}</td></tr>
                <tr><td>Email:</td><td>${p3properties["email"]}</td></tr>
                <tr><td>Class:</td><td>${p3properties["title"]}</td></tr>
                <tr><td>Meeting:</td><td>${p3properties["time"]}</td></tr>
                <tr><td>Instructor:</td><td>${p3properties["instructor"]}</td></tr>
                <tr><td>Description:</td><td>${p3properties["description"]}</td></tr>
            </table>
		  
		    </div><!--close content_item-->
    </div><!--close content-->   
	</div><!--close site_content-->  	

    <footer>
	  <a href="index.html">Home</a> | <a href="ourwork.html">Our Work</a> | <a href="testimonials.html">Testimonials</a> | <a href="projects.html">Projects</a> | <a href="contact.html">Contact</a><br/><br/>
	  <a href="http://fotogrph.com">Images</a> |  <a href="http://www.heartinternet.co.uk/vps/">Virtual Server</a>  | website template by <a href="http://www.freehtml5templates.co.uk">Free HTML5 Templates</a>
    </footer>
	
  </div><!--close main-->
  
  <!-- javascript at the bottom for fast page loading -->
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/image_slide.js"></script>
  
</body>
</html>
