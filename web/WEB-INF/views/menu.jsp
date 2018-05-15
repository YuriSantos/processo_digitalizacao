<%--
  Created by IntelliJ IDEA.
  User: estagio.yuris
  Date: 04/05/2018
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="main-header">
    <div class="navbar-custom-menu">
        <div id="header">


        </div>
        <ul class="nav navbar-nav">
            <li><a href='${pageContext.request.contextPath}/processo/listar'>Processos Digitalizados</a></li>
            <li><a href='${pageContext.request.contextPath}/processo/novo' >Processos Novos</a></li>
            <li><a href='${pageContext.request.contextPath}/processo/minhas_digitalizacoes' >Minhas Digitalizações</a></li>
            <li><a href='${pageContext.request.contextPath}/saindo'>Logout</a></li>
            <li><a>${usuario.nome}</a></li>
        </ul>
    </div>
</header>
