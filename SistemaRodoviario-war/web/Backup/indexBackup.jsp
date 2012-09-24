<%-- 
    Document   : index
    Created on : 01/04/2012, 15:49:52
    Author     : Marcelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form  action="./ClientServlet" method="post" action="">
          <label>NOME:
	    <input type="text" name="nome"/>
          </label>
            <BR />
          <label>SENHA:
	    <input type="text" name="senha"/>
          </label>
            <BR />      
           <input type="submit" name="cadastra" value="OK" />
        </form>
          
            
            
    </body>
</html>
