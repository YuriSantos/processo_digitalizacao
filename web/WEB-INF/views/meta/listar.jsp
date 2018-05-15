<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: estagio.yuris
  Date: 04/05/2018
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Digitalização de Processos</title>
</head>
<body>
    <div class="row">
        <div class="col-xs-12">
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">Metas</h3>
                </div>

                <table id="tabela" class="table table-striped">
                    <thead>
                    <tr>
                        <th>usuario</th>
                        <th>meta</th>
                    </tr>

                    </thead>
                    <c:forEach items="${metas}" var="meta">
                        <tr>
                            <td>${meta.usuario.nome}</td>
                            <td>${meta.meta_alcancada}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

    </div>

</body>
</html>
