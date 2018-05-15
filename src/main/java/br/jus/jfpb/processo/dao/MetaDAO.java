package br.jus.jfpb.processo.dao;

import br.jus.jfpb.processo.model.Meta;
import org.springframework.stereotype.Repository;

@Repository
public class MetaDAO extends AbstractDAO<Meta>{
    public MetaDAO(){super(Meta.class);}
}
