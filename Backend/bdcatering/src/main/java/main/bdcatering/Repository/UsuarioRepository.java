package main.bdcatering.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import main.bdcatering.Users.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
    boolean existsByNombreUsuario(String nombreUsuario);
}
