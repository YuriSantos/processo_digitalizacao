package br.jus.jfpb.processo.dao;

import br.jus.jfpb.processo.model.CadastroProcesso;
import org.springframework.stereotype.Repository;

@Repository
public class CadastroProcessoDAO extends AbstractDAO<CadastroProcesso> {
    public CadastroProcessoDAO(){super(CadastroProcesso.class);}
}
