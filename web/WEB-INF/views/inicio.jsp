<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--
  Created by IntelliJ IDEA.
  User: estagio.yuris
  Date: 02/05/2018
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value ="/bower_components/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css" />
    <!-- Font Awesome -->
    <link href="<c:url value ="/bower_components/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="<c:url value ="/bower_components/Ionicons/css/ionicons.min.css"/>" rel="stylesheet" type="text/css" />
    <title>Digitalização de Processos</title>
</head>
<body>
<c:if test="${mensagem != null}">
    <div class="alert alert-success alert-dismissible">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
        <h4><i class="icon fa fa-check"></i>${mensagem}</h4>
    </div>
</c:if>

<c:if test="${erro != null}">
    <div class="alert alert-danger alert-dismissible">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
        <h4><i class="icon fa fa-ban"></i>${erro}</h4>
    </div>
</c:if>
<c:import url="${request.contextPath}/menu"/>
<div class="row">
    <div class="col-xs-12">
        <div class="box box-primary">
            <div class="box-header with-border">
                <h3 class="box-title">digitalizações</h3>
            </div>

            <table id="tabela" class="table table-striped">
                <thead>
                <tr>
                    <th>Nome</th>
                    <th>Total Realizado</th>
                    <th></th>

                </tr>

                </thead>
                <c:forEach items="${producao}" var="producao">
                    <tr>
                        <td>${producao.nome}</td>
                        <td>${producao.soma_alcancado}</td>

                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</div>

</body>
</html>



