package piazada.todolist.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import piazada.todolist.Services.UsuarioService;
import piazada.todolist.models.Usuario;



@Controller
public class UsuarioController {
    // Atributos
    private UsuarioService usuarioService;

    // Construtor
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Endpoints
    @GetMapping("/")
    public String retornarHome() {
        return "home.html";
    }

    @GetMapping("/cadastro")
    public String retornarCadastro(Model model) {
        Map<String,String> atributoErro = new HashMap<>();  
        model.addAttribute("erros", atributoErro);

        return "cadastro.html";
    }

    @PostMapping("/cadastro")
    public String salvarUsuario(Usuario usuario, Model model) {
        Map<String,String> atributoErro = usuarioService.salvarUsuario(usuario);  
        if(!atributoErro.isEmpty()) {
            model.addAttribute("erros", atributoErro);
            model.addAttribute("username", usuario.getUsername());
            model.addAttribute("senha", usuario.getSenha());

            return "cadastro.html";
        } else {

            return "redirect:/";
        }
    }
}
