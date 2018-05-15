<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: estagio.yuris
  Date: 02/05/2018
  Time: 11:21
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
    <title>Novo Processo</title>
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
                    <h3 class="box-title">Cadastro de Processo Digitalizado</h3>
                </div>

                <div class="box-body">
                    <div class="form-group">
                        <form:form action="${pageContext.request.contextPath}/processo/salvar" method="POST" modelAttribute="processo_dig">
                            <input type="hidden" name="id" value="${processo_dig.id}"/>
                            <input type="hidden" name="salvo_por" value="${usuario.nome}"/>
                            <input type="hidden" name="us_id" value="${usuario.id}"/>
                            <div>
                                <label>Número do Processo a ser digitalizado</label>
                                <form:input path="numero_processo" class="form-control"/>
                            </div>
                            <div>
                                <label>Número do Volume</label>
                                <form:input path="numero_de_volume" class="form-control" value="1"/>
                            </div>
                            <div>
                                <label>Número de Folhas</label>
                                <form:input path="numero_de_folhas" class="form-control" value="1"/>
                            </div>
                            <div class="box-footer">
                                <button type="submit" onclick="var e=this;setTimeout(function(){e.disabled=true;},0);return true;" class="btn btn-primary">Salvar</button>

                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>

    </div>

</body>
</html>
