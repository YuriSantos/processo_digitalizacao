<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js" type="text/javascript"></script>

    <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.16/js/jquery.dataTables.js"></script>
    <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/plug-ins/1.10.16/i18n/Portuguese-Brasil.json"></script>


    <title>Digitalização de Processos</title>
</head>
<body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
                </tr>

                </thead>
                <c:forEach items="${processo_dig}" var="processo">
                    <tr>
                        <td><fmt:formatDate pattern="dd/MM/yyyy" value="${processo.data_cadastro.time}"/></td>
                        <td>${processo.numero_processo}</td>
                        <td>${processo.numero_de_volume}</td>
                        <td>${processo.numero_de_folhas}</td>
                        <td>${processo.salvo_por}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</div>

</body>
<script type="text/javascript">
    $(document).ready(function() {
        $('#tabela').DataTable({
            "bJQueryUI": true,
            "oLanguage": {
                "sEmptyTable": "Nenhum registro encontrado",
                "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                "sInfoEmpty": "Mostrando 0 até 0 de 0 registros",
                "sInfoFiltered": "(Filtrados de _MAX_ registros)",
                "sInfoPostFix": "",
                "sInfoThousands": ".",
                "sLengthMenu": "_MENU_ resultados por página",
                "sLoadingRecords": "Carregando...",
                "sProcessing": "Processando...",
                "sZeroRecords": "Nenhum registro encontrado",
                "sSearch": "Pesquisar",
                "oPaginate": {
                    "sNext": "Próximo",
                    "sPrevious": "Anterior",
                    "sFirst": "Primeiro",
                    "sLast": "Último"
                },
                "oAria": {
                    "sSortAscending": ": Ordenar colunas de forma ascendente",
                    "sSortDescending": ": Ordenar colunas de forma descendente"
                }
            }
        });
    });
</script>
</html>
