package piazada.todolist.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import piazada.todolist.aop.ParaLogar;
import piazada.todolist.dtos.CadastroUsuarioRequest;
import piazada.todolist.dtos.LoginUsuarioRequest;
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

    @ParaLogar
    @PostMapping("/cadastro")
    public String salvar(CadastroUsuarioRequest request, Model model) {
        Map<String,String> atributoErro = usuarioService.salvar(request);  
        if(!atributoErro.isEmpty()) {
            model.addAttribute("erros", atributoErro);
            model.addAttribute("username", request.username());
            model.addAttribute("senha", request.senha());

            return "cadastro.html";
        } else {

            return "redirect:/";
        }
    }

    @GetMapping("/login")
    public String exibirLogin(Model model){
        Map<String,String> atributoErro = new HashMap<>();  
        model.addAttribute("erros", atributoErro);
        
        return "login.html";
    }

    @ParaLogar
    @PostMapping("/login")
    public String realizarLogin(LoginUsuarioRequest request, Model model) {
        Map<String,String> atributoErro = usuarioService.realizarLogin(request);
        if(!atributoErro.isEmpty()) {
            model.addAttribute("erros", atributoErro);

            return "login.html";
        } else {
            usuarioSession.setUsername(request.senha());

            return "redirect:/dashboard";
        }
    }
}
