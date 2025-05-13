package main.bdcatering.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.bdcatering.Repository.UsuarioRepository;
import main.bdcatering.Users.Usuario;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Usuario registrarUsuario(Usuario usuario) {
        // Encriptar la contraseña antes de guardar
        String contraseñaEncriptada = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(contraseñaEncriptada);
        return usuarioRepository.save(usuario);
    }
}
