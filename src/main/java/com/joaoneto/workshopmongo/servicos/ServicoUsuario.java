package com.joaoneto.workshopmongo.servicos;

import com.joaoneto.workshopmongo.dominio.Usuario;
import com.joaoneto.workshopmongo.repositorios.RepositorioUsuario;
import com.joaoneto.workshopmongo.servicos.excecao.ExcecaoParaObjetoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoUsuario {

    @Autowired
    private RepositorioUsuario repositorio;

    public List<Usuario> findAll() {
        return repositorio.findAll();
    }

    public Usuario findById(String id) {
      return repositorio.findById(id)
              .orElseThrow(() ->
                      new ExcecaoParaObjetoNaoEncontrado("Objeto nao encontrado")
              );
    }
}
