package com.joaoneto.workshopmongo.repositorios;

import com.joaoneto.workshopmongo.dominio.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends MongoRepository<Usuario, String> {
}
