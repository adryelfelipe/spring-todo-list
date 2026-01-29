package piazada.todolist.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import piazada.todolist.models.Usuario;
import piazada.todolist.services.UsuarioService;
import piazada.todolist.session.UsuarioSession;

@Controller
public class UsuarioController {
    // Atributos
    private UsuarioService usuarioService;
    private UsuarioSession usuarioSession;

    // Construtor
    public UsuarioController(UsuarioService usuarioService, UsuarioSession usuarioSession) {
        this.usuarioService = usuarioService;
        this.usuarioSession = usuarioSession;
    }

    // Endpoints
    @GetMapping("/")
    public String exibirIndex() {
        
        return "index.html";
    }

    @GetMapping("/cadastro")
    public String exibirCadastro(Model model) {
        Map<String,String> atributoErro = new HashMap<>();  
        model.addAttribute("erros", atributoErro);

        return "cadastro.html";
    }

    @PostMapping("/cadastro")
    public String salvar(Usuario usuario, Model model) {
        Map<String,String> atributoErro = usuarioService.salvar(usuario);  
        if(!atributoErro.isEmpty()) {
            model.addAttribute("erros", atributoErro);
            model.addAttribute("username", usuario.getUsername());
            model.addAttribute("senha", usuario.getSenha());

            return "cadastro.html";
        } else {

            return "redirect:/";
        }
    }

    @GetMapping("/login")
    public String retornarLogin(Model model){
        Map<String,String> atributoErro = new HashMap<>();  
        model.addAttribute("erros", atributoErro);
        
        return "login.html";
    }

    @PostMapping("/login")
    public String realizarLogin(Usuario usuario, Model model) {
        Map<String,String> atributoErro = usuarioService.realizarLogin(usuario);
        if(!atributoErro.isEmpty()) {
            model.addAttribute("erros", atributoErro);

            return "login.html";
        } else {
            usuarioSession.setUsername(usuario.getSenha());

            return "redirect:/dashboard";
        }
    }
}
