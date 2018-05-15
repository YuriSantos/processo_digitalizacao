package br.jus.jfpb.processo.controller;

import br.jus.jfpb.processo.model.Meta;
import br.jus.jfpb.processo.service.MetaService;
import br.jus.jfpb.processo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("meta")
public class MetaController {
    @Autowired
    private MetaService metaService;
    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(method = RequestMethod.GET, value = {"listar"})
    public String listar(ModelMap map){

        List<Meta> metas = metaService.listar();
        map.addAttribute("metas", metas);

        return "/meta/listar";
    }

    public void salvar(@ModelAttribute("metas") Meta meta, HttpServletRequest request) {
        try {
            if (meta.temIdValido()) {
                System.out.println("ok");
                metaService.atualizar(meta);
            } else {
                metaService.inserir(meta);
            }
        } catch (Exception e) {

        }
    }

    public static int calcular(Meta meta){
        int meta2 =meta.getMeta_alcancada() +1;
        meta.setMeta_alcancada(meta2);
        return meta2;
    }
}
