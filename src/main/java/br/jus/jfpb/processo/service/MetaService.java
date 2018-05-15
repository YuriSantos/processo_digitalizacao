package br.jus.jfpb.processo.service;

import br.jus.jfpb.processo.dao.MetaDAO;
import br.jus.jfpb.processo.model.Meta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MetaService {
    protected EntityManager manager;

    @Autowired
    private MetaDAO metaDAO;

    public void inserir(Meta meta){
        metaDAO.inserir(meta);
    }

    public void atualizar(Meta meta){
        metaDAO.atualizar(meta);
    }

    public void excluir(Meta meta){
        metaDAO.excluir(meta);
    }

    public Meta buscaPorId(Long id){
        Meta meta = null;
        meta = metaDAO.buscarPorID(id);
        return meta;
    }

    public List<Meta> listar() {return metaDAO.listar();}
}
