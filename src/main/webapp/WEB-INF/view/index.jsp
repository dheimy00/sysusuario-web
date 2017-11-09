<html lang="en" ng-app="crudApp">
    <head>
        <title>${title}</title>
          <link href="${pageContext.request.contextPath}/static/css/cadastroUsuario.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/static/css/app.css" rel="stylesheet"/>
       <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js" ></script>
           <script src="${pageContext.request.contextPath}/static/js/cadastroUsuario.js" ></script>
    </head>
    <body>
 
        <div ui-view></div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js" ></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-ui-router.min.js" ></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/localforage.min.js" ></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/ngStorage.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app/UsuarioService.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app/UsuarioController.js"></script>
    </body>
</html>