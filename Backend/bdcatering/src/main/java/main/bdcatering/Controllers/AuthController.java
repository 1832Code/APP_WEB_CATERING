package main.bdcatering.Controllers;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import main.bdcatering.Services.UsuarioService;
import main.bdcatering.Users.Usuario;

import org.springframework.validation.BindingResult;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000") // Ajusta según tu frontend
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
public ResponseEntity<?> registrar(@Valid @RequestBody Usuario usuario, BindingResult result) {
    if (result.hasErrors()) {
        Map<String, String> error = new HashMap<>();
        error.put("mensaje", "Datos inválidos");
        return ResponseEntity.badRequest().body(error);
    }

    Usuario nuevoUsuario = usuarioService.registrarUsuario(usuario);
    return ResponseEntity.ok(nuevoUsuario);
}

}
