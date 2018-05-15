package br.jus.jfpb.processo.controller;

import br.jus.jfpb.processo.model.Usuario;
import br.jus.jfpb.processo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;

@Resource
@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @RequestMapping(method = RequestMethod.GET, value = {"listar"})
    public String list(ModelMap map){
        List<Usuario> usuarios = usuarioService.listar();

        map.addAttribute("lista_usuario",usuarios);

        return "usuarios/listar";
    }

    @RequestMapping(method = RequestMethod.GET, value = {"editar"})
    public String novo(ModelMap map){
        Usuario usuario = new Usuario();

        map.addAttribute("lista_usuario",usuario);

        return "/usuarios/editar";
    }

    @RequestMapping(method = RequestMethod.POST, value = {"salvar"})
    public String salvar (@ModelAttribute("lista_usuario") Usuario usuario, RedirectAttributes rm){

        try{
            if(usuario.temIdValido()){
                usuarioService.atualizar(usuario);
                rm.addFlashAttribute("sucesso","Usuário elevado com sucesso!");
            }
            else{
                usuarioService.inserir(usuario);
                rm.addFlashAttribute("sucesso","Cadastro salvo com sucesso!");
            }
        }
        catch (Exception e){
            rm.addFlashAttribute("erro","Erro ao atualizar o usuário!");
        }

        return "redirect:/usuarios/listar";
    }

    @RequestMapping(method = RequestMethod.GET, value = {"atualizar/{id}"})
    public String atualizar(@PathVariable("id") Long id, ModelMap map, RedirectAttributes rm) throws Exception{
        Usuario usuario = usuarioService.buscaPorId(id);

        map.addAttribute("lista_usuario",usuario);

        return "/usuarios/editar";
    }

}
