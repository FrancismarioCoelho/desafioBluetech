package br.com.bluetech.api.bluetech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bluetech.api.bluetech.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
