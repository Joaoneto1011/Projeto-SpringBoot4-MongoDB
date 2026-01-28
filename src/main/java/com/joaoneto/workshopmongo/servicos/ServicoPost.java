package com.joaoneto.workshopmongo.servicos;

import com.joaoneto.workshopmongo.dominio.Post;
import com.joaoneto.workshopmongo.dominio.Usuario;
import com.joaoneto.workshopmongo.dto.DtoUsuario;
import com.joaoneto.workshopmongo.repositorios.RepositorioPost;
import com.joaoneto.workshopmongo.repositorios.RepositorioUsuario;
import com.joaoneto.workshopmongo.servicos.excecao.ExcecaoParaObjetoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoPost {

    @Autowired
    private RepositorioPost repositorioPost;

    public Post findById(String id) {
      return repositorioPost.findById(id)
              .orElseThrow(() ->
                      new ExcecaoParaObjetoNaoEncontrado("Objeto nao encontrado")
              );
    }

    public List<Post> findbyTitulo(String texto) {
        return repositorioPost.findByTituloContainingIgnoreCase(texto);
    }
}