package br.jus.jfpb.processo.auteticacao;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
    /*
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object controller) throws Exception {
        //....
        String uri = request.getRequestURI();
        if(uri.endsWith("entrar") ||
                uri.endsWith("login") ||
                uri.contains("bootstrap") ||
                uri.contains("bower_components") ||
                uri.contains("dist") ||
                uri.contains("plugins") ||
                uri.contains("vendor") ||
                uri.endsWith("estatistica") ||
                uri.endsWith("total")){
            return true;
        }

        if(request.getSession().getAttribute("usuario") != null) {
            return true;
        }


        response.sendRedirect("entrar");
        return false;
    }*/
}