package br.jus.jfpb.processo.service;

import br.jus.jfpb.processo.dao.UsuarioDAO;
import br.jus.jfpb.processo.auteticacao.ValidarLDAP;
import br.jus.jfpb.processo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;
    private ValidarLDAP validarLDAP;

    public Usuario validaLogin(Usuario usuario){
        return usuarioDAO.validaLogin(usuario);

    }

    public void inserir (Usuario usuario){
        usuarioDAO.inserir(usuario);
    }

    public void atualizar (Usuario usuario){
        usuarioDAO.atualizar(usuario);
    }

    public List<Usuario> busca_usuario(Usuario usuario){
        return usuarioDAO.busca_usuario(usuario);
    }

    public List<Usuario> listar(){
        return usuarioDAO.listar();
    }

    public Usuario buscaPorId(Long id){
        Usuario usuario = null;
        usuario = usuarioDAO.buscarPorID(id);
        return usuario;
    }
}