package br.jus.jfpb.processo.controller;

import br.jus.jfpb.processo.excecao.NumeroProcessoVazio;
import br.jus.jfpb.processo.model.CadastroProcesso;
import br.jus.jfpb.processo.model.Meta;
import br.jus.jfpb.processo.model.Usuario;
import br.jus.jfpb.processo.service.CadastroProcessoService;
import br.jus.jfpb.processo.service.MetaService;
import br.jus.jfpb.processo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateJdbcException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("processo")

public class CadastroProcessoController {
    @Autowired
    private CadastroProcessoService cadastroProcessoService;
    @Autowired
    private MetaService metaService;
    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(method = RequestMethod.GET, value = {"novo"})
    public String novo(ModelMap map){
        CadastroProcesso cadastroProcesso = new CadastroProcesso();

        map.addAttribute("processo_dig",cadastroProcesso);

        return "cad_digitalizado/novo";
    }

    @RequestMapping(method = RequestMethod.POST, value = {"salvar"})
    public String salvar(@ModelAttribute("processo_dig") CadastroProcesso cadastroProcesso,
                         @ModelAttribute("usuario") Usuario usuario,
                         @ModelAttribute("meta") Meta meta, RedirectAttributes rm){
        try{
            if(cadastroProcesso.getNumero_processo().equals(null) || cadastroProcesso.getNumero_processo().equals("")) throw new NumeroProcessoVazio("Número de Processo não pode ser vazio.");
            if(cadastroProcesso.temIdValido()){
                cadastroProcesso.setData_cadastro(cadastroProcesso.getData_cadastro());
                cadastroProcessoService.atualizar(cadastroProcesso);
                rm.addFlashAttribute("mensagem","Processo atualizado com sucesso");
            }
            else{
                usuario = usuarioService.buscaPorId(Long.parseLong(cadastroProcesso.getUs_id()));
                cadastroProcesso.setUsuario(usuario);
                cadastroProcessoService.inserir(cadastroProcesso);
                usuario.setSoma_alcancado(usuario.getSoma_alcancado()+1);
                usuarioService.atualizar(usuario);
                rm.addFlashAttribute("mensagem","Processo salvo com sucesso");

            }
        }catch (NumeroProcessoVazio e){
            rm.addFlashAttribute("erro",e.getMessage());
        }catch (Exception e){
            System.out.println();
            rm.addFlashAttribute("erro","Processo de número "+cadastroProcesso.getNumero_processo()+" já cadastrado");
        }

        return "redirect:/processo/novo";
    }
    @RequestMapping(method = RequestMethod.GET, value = {"listar"})
    public String listar(ModelMap map, HttpServletRequest session){
        List<CadastroProcesso> cadastroProcessos = cadastroProcessoService.listar();
        Usuario usuario = (Usuario) session.getSession().getAttribute("usuario");
        map.addAttribute("processo_dig",cadastroProcessos);
        return "/cad_digitalizado/listar";
    }

    @RequestMapping(method = RequestMethod.GET, value = {"minhas_digitalizacoes"})
    public String minhas_dig(ModelMap map, HttpServletRequest session){
        List<CadastroProcesso> cadastroProcessos;
        Usuario usuario = (Usuario) session.getSession().getAttribute("usuario");
            cadastroProcessos = cadastroProcessoService.listar2(usuario.getNome());
        map.addAttribute("processo_dig",cadastroProcessos);
        return "/cad_digitalizado/minhas_digitalizacoes";
    }

    @RequestMapping(method = RequestMethod.GET, value = {"deletar/{id}"})
    public String deletar(@PathVariable("id") Long id, RedirectAttributes rm,HttpServletRequest session){
        CadastroProcesso cadastroProcesso = cadastroProcessoService.buscaPorId(id);
        if(cadastroProcesso != null){
            try{
                Usuario usuario = (Usuario) session.getSession().getAttribute("usuario");
                usuario = usuarioService.buscaPorId(usuario.getId());
                cadastroProcessoService.excluir(cadastroProcesso);
                cadastroProcesso.setUsuario(usuario);
                System.out.println("Soma antes da subtração: "+usuario.getSoma_alcancado()+" do usuário: " + usuario.getNome());
                usuario.setSoma_alcancado(usuario.getSoma_alcancado()-1);
                usuarioService.atualizar(usuario);
                rm.addFlashAttribute("mensagem","Processo excluido com sucesso!");
            }
            catch (Exception e){
                rm.addFlashAttribute("erro","Erro ao deletar o processo");
            }
        }
        return "redirect:/processo/minhas_digitalizacoes";
    }

    @RequestMapping(method = RequestMethod.GET, value = {"atualizar/{id}"})
    public String atualizar(@PathVariable("id") Long id, ModelMap map){
        CadastroProcesso cadastroProcesso = cadastroProcessoService.buscaPorId(id);

        map.addAttribute("processo_dig",cadastroProcesso);

        return "/cad_digitalizado/novo";
    }

}
