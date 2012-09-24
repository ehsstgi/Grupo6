<%-- 
--%>

<%@page import="sistemarodoviario.jpa.Cliente"%>
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
                    <ul><li><a href="#">Meu Cadastro</a>
                            <ul><li><a href="historico.jsp"> Histórico de Compras</a></li>
                            </ul>
                        </li></ul>
                    <ul><li><a href="">Consulta e Compra</a>
                            <ul><li><a href="compraPassagem.jsp"> Comprar Passagem</a></li>
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
                        <form action="./ClienteDadosServlet" method="post">
                            <br />
                            <h2> Verifique seus dados... </h2>
                            <input type="submit" name="verificaDadosCliente" value="Verificar Meus Dados">
                            <BR />
                            <table border=”1″  bgcolor="gray" align="center">

                                <p>
                                    <%  Cliente cliente = (Cliente) session.getAttribute("cliente");

                                        if (cliente != null) {

                                    %>   
                                <tr>
                                    <th>Nome:</th>
                                    <th>Data de Nascimento:</th>
                                    <th>CPF:</th>
                                    <th>RG:</th>
                                    <th>Usuario:</th>
                                    <th>Email:</th>
                                    <th>End:</th>
                                    <th>Complemento:</th>
                                    <th>Cidade:</th>
                                    <th>Estado:</th>
                                    <th>Telefone:</th>
                                    <th>Celular:</th>
                                </tr>
                                <tr>
                                    <th>  <%= cliente.getNomeCliente()%></th>
                                    <th><%= cliente.getDataCliente()%></th>
                                    <th>  <%= cliente.getCpfCliente()%></th>
                                    <th>  <%= cliente.getRgCliente()%></th>
                                    <th>  <%= cliente.getUsuarioCliente()%></th>
                                    <th>  <%= cliente.getEmailCliente()%></th>
                                    <th>  <%= cliente.getEndCliente()%></th>
                                    <th>  <%= cliente.getComplementoEnd()%></th>
                                    <th>  <%= cliente.getCidadeCliente().getNomeCidade()%></th>
                                    <th>  <%= cliente.getEstadoCliente().getNomeEstado()%></th>
                                    <th>  <%= cliente.getTelCliente()%></th>
                                    <th>  <%= cliente.getCelCliente()%></th>
                                </tr>
                                <%   }%>

                                </p>
                            </table>
                        </form>
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
