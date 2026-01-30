package piazada.todolist.usuario.service;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import piazada.todolist.aop.ParaLogar;
import piazada.todolist.usuario.dtos.CadastroUsuarioRequest;
import piazada.todolist.usuario.dtos.LoginUsuarioRequest;
import piazada.todolist.usuario.model.Usuario;

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
