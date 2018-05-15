package br.jus.jfpb.processo.service;

import br.jus.jfpb.processo.dao.CadastroProcessoDAO;
import br.jus.jfpb.processo.model.CadastroProcesso;
import br.jus.jfpb.processo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CadastroProcessoService {
    protected EntityManager manager;

    @Autowired
    private CadastroProcessoDAO cadastroProcessoDAO;

    public void inserir(CadastroProcesso cadastroProcesso){
        cadastroProcessoDAO.inserir(cadastroProcesso);
    }

    public void atualizar(CadastroProcesso cadastroProcesso){
        cadastroProcessoDAO.atualizar(cadastroProcesso);
    }

    public void excluir(CadastroProcesso cadastroProcesso){
        cadastroProcessoDAO.excluir(cadastroProcesso);
    }

    public CadastroProcesso buscaPorId(Long id){
        CadastroProcesso cadastroProcesso = null;
        cadastroProcesso = cadastroProcessoDAO.buscarPorID(id);
        return cadastroProcesso;
    }

    public List<CadastroProcesso> listar(){
        return cadastroProcessoDAO.listar();
    }

    public List<CadastroProcesso> listar2(String nome){return cadastroProcessoDAO.listar2(nome);}

    public List producao(){return cadastroProcessoDAO.producao();}
}
