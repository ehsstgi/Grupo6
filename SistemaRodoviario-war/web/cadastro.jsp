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
                        <p>Acesso ao cadastro</p>
                        <form action="./LoginServlet" method="post">

                            <p>Login:
                                <input type="text" name="nome"  />
                            </p>
                            <p>Senha:
                                <input type="password" name="senha" />
                            </p>
                            <input type="submit" name="entrarButton" value="Entrar" >
                            <br />
                            <a href="redirecionaSenha.jsp"> Esqueci minha senha</a><br />
                            <a href="cadastro.jsp"> Cadastro</a>
                        </form>
                </tr>
            </table>
            <div id="wrapper" width="210">
                <div id="navMenu">
                    <ul><li><a href="home.jsp">Home</a></li></ul>
                    <ul><li><a href="dados.jsp">Meus Dados</a></li></ul>
                    <ul><li><a href="">Meu Cadastro</a>
                            <ul><li><a href="#"> Histórico de Compras</a></li>
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
                <th width="468" height="509" scope="col">
                    <form action="./ClienteServlet" method="post">
                        <div class="form">

                            <b>CADASTRO DE CLIENTE</b>
                            <BR />
                            <b>NOME:</b>
                            <input type="text" name="nomeCliente" />
                            <BR />
                            <b>CPF:</b>
                            <input type="text" name="cpfCliente" />
                            <BR />
                            <b>Usuário:</b>
                            <input type="text" name="usuarioCliente" />
                            <BR />
                            <b>Senha:</b>
                            <input type="password" name="senhaCliente" />
                            <BR />
                            <b>Data de Nascimento:</b>
                            <input type="text" name="datanascCliente" maxlength="10" onkeypress='return SomenteNumero(event)' onkeyup="Formatadata(this,event)"/>
                            <BR />
                            <b>RG:</b>
                            <input type="text" name="rgCliente" onkeypress='return SomenteNumero(event)' />
                            <BR />
                            <b>Endereço:</b>
                            <input type="text" name="enderecoCliente" />
                            <BR />
                            <b>Complemento:</b>
                            <input type="text" name="complementoEnd" />
                            <BR />
                            <b>Cidade:</b>
                            <input type="text" name="cidadeCliente" />
                            <BR />
                            <b>Estado:</b>
                            <input type="text" name="estadoCliente" />
                            <BR />
                            <b>Telefone Res:</b>
                            <input type="text" name="telCliente" onkeypress='return SomenteNumero(event)' />
                            <BR />
                            <b>Telefone Cel:</b>
                            <input type="text" name="celCliente" onkeypress='return SomenteNumero(event)' />
                            <BR />
                            <b>Email:</b>
                            <input type="text" name="emailCliente" />
                            <BR />
                            <b>Cartão de Crédito:</b>
                            <input type="text" name="cartaoCliente" />
                            <BR />
                            <div style="clear: both"></div>
                            <input type="submit" name="cadastraClienteButton" value="Cadastrar">
                            <input type="reset" value="Limpar">
                            <BR />
                            <% if (session.getAttribute("valida") != null) {%>
                            <%= session.getAttribute("valida")%>
                            <% }%>
                        </div> 
                    </form>

                </th>
                <th width="274" scope="col">
                    <p>Seja Bem Vindo!</p>

                    <img src=busao.jpg  />
                    </tr>
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
