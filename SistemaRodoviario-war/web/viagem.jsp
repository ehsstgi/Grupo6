<%-- 
--%>


<%@page import="sistemarodoviario.OnibusSessionBeanRemote"%>
<%@page import="sistemarodoviario.jpa.Onibus"%>
<%@page import="sistemarodoviario.jpa.Assento"%>

<%@page import="java.util.List" %>
<%@page import="java.util.LinkedList" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="onibusBean" class="sistemarodoviario.OnibusSessionBean" scope="session"  />
<jsp:setProperty name="user" property="*"/>  

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
                <th width="1000" height="509" scope="col">
                    <b>ESCOLHA SEU ASSENTO:</b>
                    <img src=onibus.jpg width="800" height="200"  />
                    <BR />
                    <h5>Primeiramente, verifique a disponibilidade na tabela...</h5>

                    <form action="./ViagemServlet" method="post">

                        <table border=”1″  bgcolor="gray" align="center">


                            <%  List listaAssentos = (List) session.getAttribute("valores");

                                if (listaAssentos != null) {

                            %>   
                            <tr>
                                <th>ID_ASSENTO</th>
                                <th>DISPONIBILIDADE</th>
                                <th>LOCAL ASSENTO</th>
                            </tr>
                            <%  for (int i = 0; i < listaAssentos.size(); i++) {
                                    Assento temp = new Assento();
                                    temp = (Assento) listaAssentos.get(i);
                            %>
                            <tr>
                                <th>  <%= temp.getId()%></th>
                                <th>  <%= temp.getLocalAssento()%></th>
                                <% if (temp.isDisponibilidadeAssento() == false) {%>
                                <th> <font color="green"> Disponível</font></th>
                                <% } else {%>
                                <th> <font color="red">  Não Disponível</font></th>
                                <% }%>
                            </tr>
                            <% }
                                }%>

                            <input type="submit" name="verificaAssentoOnibus" value="Verificar Disponibilidade">
                            <BR />
                        </table>
                    </form>
                    <form action="./ViagemServlet" method="post">
                        <BR />
                        <b>ESCOLHA A DISPONIBILIDADE:</b>
                        <input type="text" name="assentoOnibus" onkeypress='return SomenteNumero(event)'/>
                        <input type="submit" name="selecionaAssento" value="OK">
                        <BR />
                        <% if (session.getAttribute("validaCompraeAssento") != null) {%>
                        <BR />
                        <%= session.getAttribute("validaCompraeAssento")%>
                        <%}%>
                    </form>
                </th>

            </table>

            <table width="1000" height="100" border="1">
                <th scope="row" width="1000" height="100" border="1"><img src=cartoes.jpg  /></th>
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
