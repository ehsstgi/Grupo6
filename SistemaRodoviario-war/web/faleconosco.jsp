<%-- 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="estilo.css">
        <title>MackTrans</title>
        <script language="javascript" src="funcoes.js"></script>
    </head>
    <body>

        <div align="center">
            <table width="1000" height="115" border="1" bgcolor="#FFF" >
                <tr>
                    <th width="268" height="109" scope="col">
                        <div align="left">          
                            <div align="center"><img src=mack.jpg width="225" height="225" /></div>
                        </div> 
                    </th>
                    <th width="268" height="109" scope="col">
                        <div align="left">
                            <div align="left">
                                <font size="32"><center><font color="#FF0000"> MackTrans</font></center></font>
                            </div>
                        </div> 
                    </th>
                    <th width="274" scope="col">
                        <form action="./LoginServlet" method="post">
                            <% if (session.getAttribute("nome") != null) {%>
                            <%="Bem Vindo: "%>
                            <BR />
                            <%= session.getAttribute("nome")%>
                            <% } else {%>
                            <%="Faça o login"%>  
                            <%}%>
                        </form>
                </tr>
            </table>
            <div id="wrapper" width="210">
                <div id="navMenu">
                    <ul><li><a href="home.jsp">Home</a></li></ul>
                    <ul><li><a href="dados.jsp">Meus Dados</a></li></ul>
                    <ul><li><a href="">Meu Cadastro</a>
                            <ul><li><a href="historico.jsp"> Histórico de Compras</a></li>
                            </ul>
                        </li></ul>
                    <ul><li><a href="">Consulta e Compra</a>
                            <ul><li><a href="comprarPassagem.jsp"> Comprar Passagem</a></li>
                                <li><a href="retirarPassagem.jsp"> Retirar Passagem</a></li>
                            </ul>
                        </li></ul>
                    <ul><li><a href="faleconosco.jsp">Fale Conosco</a></li></ul>
                    <br class="clearFloat" />
                </div>
            </div>

            <table width="1000" height="115" border="1" bgcolor="#FFF" >
                <tr>
                    <th width="468" height="509" scope="col">
                        <div align="left">
                            <form action="./ViagemServlet" method="post">
                                <center>    
                                    <p><b><h1>Projeto Interdisciplinar II</h1></b></p>
                                    <p>
                                        Nomes:
                                    </p>
                                    <p>
                                        Anderson Morino 30974917
                                        <BR />
                                        Marcelo 30933714
                                        <BR />
                                        Thiago Sato 30916240
                                        <BR />
                                </center>
                            </form>
                        </div> 
                    </th>

            </table>

            <table width="1000" height="100" border="1">
                <th scope="row" width="1000" height="100" border="1"><img src="cartoes.jpg"  /></th>
            </table>

            <table width="1000" height="87" border="1" bgcolor="#f5f5f5">
                <tr>
                    <th scope="col"> <font size=3>Contrato de Transporte Rodoviario - Trabalhe Conosco - Vendas Corporativas - Investidores - Sala de Imprensa
                            Privacidade e Segurança - Dicas de Segurança MackTrans Fidelidade

                            © 2012 MackTrans Rodoviario S.A. Proibida reprodução total ou parcial sem autorização

                        </font>
                    </th>
                </tr>
            </table>

        </div>

    </body>


</html>
