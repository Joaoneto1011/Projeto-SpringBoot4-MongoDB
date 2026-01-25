package com.joaoneto.workshopmongo.servicos;

import com.joaoneto.workshopmongo.dominio.Usuario;
import com.joaoneto.workshopmongo.dto.DtoUsuario;
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

    public Usuario insert(Usuario obj) {
        return repositorio.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        repositorio.deleteById(id);
    }

    public Usuario update(Usuario obj) {
        Usuario novoObj = findById(obj.getId());
        updateData(novoObj, obj);
        return repositorio.save(novoObj);
    }

    private void updateData(Usuario novoObj, Usuario obj) {
        novoObj.setNome(obj.getNome());
        novoObj.setEmail(obj.getEmail());
    }

    public Usuario fromDTO(DtoUsuario objDto) {
        return new Usuario(objDto.getId(), objDto.getNome(), objDto.getEmail());
    }
}
