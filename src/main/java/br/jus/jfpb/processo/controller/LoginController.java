package br.jus.jfpb.processo.controller;


import br.jus.jfpb.processo.auteticacao.ValidarLDAP;
import br.jus.jfpb.processo.model.Usuario;
import br.jus.jfpb.processo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UsuarioService usuarioService;
    @RequestMapping("/entrar")
    public String loginPage(ModelMap map, HttpServletRequest session){
        System.out.println("Executando login");
        Usuario usuario = new Usuario();
        map.addAttribute("usuario", usuario);
        if(session.getSession().getAttribute("usuario") != null){
            if(usuario.isAdministrador()){
                System.out.println("Admin");
                return "redirect:/inicio";
            }else{
                System.out.println("não é Admin");
                return "redirect:/processo/listar";
            }

        }
        else {
            return "login";
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String login(@ModelAttribute(value = "usuario") Usuario usuario, HttpSession sessao,RedirectAttributes rm){
        Usuario usuarioaut = new Usuario();

        boolean usuarioBD = validaLoginLdap(usuario);


        if ((!usuarioBD)) {
            System.out.println(usuarioBD);
            rm.addFlashAttribute("mensagem","Login incorreto, tente novamente");
            return "redirect:/entrar";
        }
        if(usuarioService.validaLogin(usuario)==null){
            usuario.setSenha(null);
            usuarioService.inserir(usuario);
            usuarioaut = usuarioService.validaLogin(usuario);
        }else{
            usuarioaut = usuarioService.validaLogin(usuario);
        }

        sessao.setAttribute("usuario", usuarioaut);
        sessao.setMaxInactiveInterval(100000000);
        rm.addFlashAttribute("mensagem","Login realizado com sucesso");
        if(usuarioaut.isAdministrador()){
            System.out.println("Admin");
            return "redirect:/inicio";
        }else{
            System.out.println("não é Admin");
            return "redirect:/processo/listar";
        }

        /*if(usuarioBD == null){
            System.out.println("Sessão testanda!");
            return "redirect:/entrar";
        }*/
//    public String login(@ModelAttribute(value = "usuario") Usuario usuario, HttpSession sessao,RedirectAttributes rm){
//
//        Usuario usuarioBD = usuarioService.validaLogin(usuario);
//
//
//
//        if ((usuarioBD == null)) {
//            System.out.println(usuarioBD);
//
//            rm.addFlashAttribute("mensagem","Login incorreto, tente novamente");
//            return "redirect:/entrar";
//
//
//        }
//        sessao.setAttribute("usuario", usuario);
//        rm.addFlashAttribute("mensagem","Login realizado com sucesso");
//        return "redirect:/inicio";
//
//        /*if(usuarioBD == null){
//            System.out.println("Sessão testanda!");
//            return "redirect:/entrar";
//        }
//
//        return "redirect:/inicio";*/

    }

    @RequestMapping(method = RequestMethod.GET, value = "/saindo")
    public String sairSessao(HttpSession sessao) {

        sessao.invalidate();
        return "redirect:/entrar";

    }

    public boolean validaLoginLdap(Usuario usuario1){

        ValidarLDAP validarLDAP = new ValidarLDAP();
        String nome;
        boolean usuarioLdap = validarLDAP.conexao(usuario1.getNome(),usuario1.getSenha());
        //boolean usuarioprocurado = validarLDAP.buscarUsuarioLdap(usuario.getNome());
        if(!usuarioLdap){
            System.out.println("não" + usuario1.getNome());
            return false;
        }
        else{
            System.out.println("Sim" + usuario1.getNome());
            return true;
        }
    }

/*
    @RequestMapping(method = RequestMethod.GET, value = {"/","/telaLogin"})
    public String loginPage(ModelMap map) {
        Usuario usuario = new Usuario();
        map.addAttribute("usuario", usuario);
        return "login";
    }
    /*

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String logar(@ModelAttribute(value = "usuario") Usuario usuario, HttpSession sessao) {

        Usuario usuarioBD = usuarioService.validaLogin(usuario);

        if (usuarioBD == null) {

            return "redirect:/telaLogin";
        }
        sessao.setAttribute("usuario", usuarioBD);
        sessao.setMaxInactiveInterval(100000000);

        return "redirect:/menu";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/saindo")
    public String sairSessao(HttpSession sessao) {

        sessao.invalidate();
        return "redirect:/telaLogin";

    }
    */
}
