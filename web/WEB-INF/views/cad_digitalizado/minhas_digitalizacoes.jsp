<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%--
  Created by IntelliJ IDEA.
  User: estagio.yuris
  Date: 10/05/2018
  Time: 09:18
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
                    <th>Data</th>
                    <th>Número do Processo</th>
                    <th>Número do Volume</th>
                    <th>Número de Folhas</th>
                    <th>Digitalizado por</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>

                </thead>
                <c:forEach items="${processo_dig}" var="processo">
                    <tr>
                        <td><fmt:formatDate pattern="dd/MM/yyyy" value="${processo.data_cadastro.time}"/></td>
                        <td>${processo.numero_processo}</td>
                        <td>${processo.numero_de_volume}</td>
                        <td>${processo.numero_de_folhas}</td>
                        <td>${processo.salvo_por}</td>
                        <td class="col-xs-1"><a href="mostrar/${processo.id}" class="fa fa-2x fa-eye"></a></td>

                        <td class="col-xs-1">
                            <a href="atualizar/${processo.id}" class="fa fa-2x fa-edit"></a>

                        </td>
                        <td class="col-xs-1">
                            <a href="deletar/${processo.id}" onclick="return confirm('Deseja excluir o registro?')"class="fa fa-2x fa-trash"></a>

                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</div>

</body>
</html>

