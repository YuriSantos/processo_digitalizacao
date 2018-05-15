package br.jus.jfpb.processo.controller;

import br.jus.jfpb.processo.dao.CadastroProcessoDAO;
import br.jus.jfpb.processo.model.CadastroProcesso;
import br.jus.jfpb.processo.model.Producao;
import br.jus.jfpb.processo.model.Usuario;
import br.jus.jfpb.processo.service.CadastroProcessoService;
import br.jus.jfpb.processo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DigitometroController {
    @Autowired
    private UsuarioService usuarioService;

    public int i = 0;

    private Producao producao;
    @RequestMapping("inicio")
    public String listar(ModelMap map, HttpServletRequest session){
        List<Usuario> usuarios = usuarioService.listar();
        map.addAttribute("producao",usuarios);
        return "inicio";
    }
}
