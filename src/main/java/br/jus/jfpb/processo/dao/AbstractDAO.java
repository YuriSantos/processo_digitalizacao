package br.jus.jfpb.processo.dao;



import br.jus.jfpb.processo.model.AbstractEntity;
import br.jus.jfpb.processo.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class AbstractDAO<T extends AbstractEntity> {

    @PersistenceContext
    protected EntityManager manager;

    private Class<T> classe;

    public AbstractDAO(Class<T> classe){
        this.classe = classe;
    }

    public void inserir(T entidade) {manager.persist(entidade);}

    public void atualizar(T entidade) {manager.merge(entidade);}

    public void excluir(T entidade){
        entidade = manager.find(classe, entidade.getId());
        manager.remove(entidade);
    }

    public T buscarPorID(Long id){
        return manager.find(classe, id);
    }

    public List<T> listar(){
        Query query = manager.createQuery("select e from "+classe.getSimpleName()+" e");
        return query.getResultList();
    }
    public List<T> busca_usuario(Usuario usuario){
        Query query = manager.createQuery("select e from "+classe.getSimpleName()+" e where e.nome = "+ usuario.getNome());
        return query.getResultList();
    }

    public List<T> listar2(String nome){
        Query query = manager.createQuery("select e from "+classe.getSimpleName()+" e where e.salvo_por = '"+nome+"'");
        return query.getResultList();
    }

    public List producao(){
        Query query = manager.createQuery("select e.salvo_por, count (e) from "+classe.getSimpleName()+" e group by e.salvo_por ");

        return query.getResultList();
    }

}
