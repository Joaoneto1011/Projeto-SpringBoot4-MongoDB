package com.joaoneto.workshopmongo.repositorios;

import com.joaoneto.workshopmongo.dominio.Post;
import com.joaoneto.workshopmongo.dominio.Usuario;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioPost extends MongoRepository<Post, String> {

    @Query("{ 'titulo':  {$regex: ?0, $options:  'i' } }")
    List<Post> findByTitulo(String texto);

    List<Post> findByTituloContainingIgnoreCase(String texto);
}
