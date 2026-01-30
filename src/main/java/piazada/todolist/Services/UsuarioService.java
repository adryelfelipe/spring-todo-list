package piazada.todolist.services;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import piazada.todolist.aop.ParaLogar;
import piazada.todolist.dtos.CadastroUsuarioRequest;
import piazada.todolist.dtos.LoginUsuarioRequest;
import piazada.todolist.models.Usuario;

@Service
public class UsuarioService {

    // Métodos
    @ParaLogar
    public Map<String, String> salvar(CadastroUsuarioRequest request) {
        Map<String, String> atributoErros = new HashMap<>();
        atributoErros.put("username", "tá vazio");

        return new HashMap<>();
    }

    @ParaLogar
    public Map<String, String> realizarLogin(LoginUsuarioRequest request) {
        
        return new HashMap<>();
    }
}
