package piazada.todolist.services;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import piazada.todolist.models.Usuario;

@Service
public class UsuarioService {
    public Map<String, String> salvar(Usuario usuario) {
        return new HashMap<>();
    }

    public Map<String, String> realizarLogin(Usuario usuario) {
        return new HashMap<>();
    }
}
