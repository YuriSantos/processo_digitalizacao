package br.jus.jfpb.processo.dao;

import br.jus.jfpb.processo.auteticacao.ValidarLDAP;
import br.jus.jfpb.processo.model.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class UsuarioDAO extends AbstractDAO<Usuario>{

    public UsuarioDAO() {
        super(Usuario.class);
    }

    public Usuario validaLogin(Usuario usuario) {
        String s = "select u from Usuario u where u.nome = :nome";
        Query query = manager.createQuery(s);
        query.setParameter("nome", usuario.getNome());
        List<Usuario> usuarios = query.getResultList();

        if(!usuarios.isEmpty()){
            return usuarios.get(0);
        }
        return null;
    }

    public boolean validaLoginLdap(Usuario usuario1){

        ValidarLDAP validarLDAP = new ValidarLDAP();
        String nome;
        boolean usuarioLdap = validarLDAP.conexao(usuario1.getNome(),usuario1.getSenha());
        //boolean usuarioprocurado = validarLDAP.buscarUsuarioLdap(usuario.getNome());
        if(!usuarioLdap){
            return true;
        }
        else{
            return true;
        }



    }

}