package piazada.todolist.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import piazada.todolist.aop.ParaLogar;
import piazada.todolist.models.Tarefa;
import piazada.todolist.services.TarefaService;
import piazada.todolist.session.UsuarioSession;

@Controller
public class TarefaController {
    // Atributos
    private TarefaService tarefaService;
    private UsuarioSession usuarioSession;

    // Construtor
    public TarefaController(TarefaService tarefaService, UsuarioSession usuarioSession) {
        this.tarefaService = tarefaService;
        this.usuarioSession = usuarioSession;
    }

    // Endpoints
    @GetMapping("/dashboard")
    public String exibirDashboard(Model model) {
        if(usuarioSession.getUsername() == null) {

            return("redirect:/");
        } else {
            Map<String, String> atributoErro = new HashMap<>();
            model.addAttribute("erros", atributoErro);
            model.addAttribute("tarefas", tarefaService.getTarefas());

            return "dashboard.html";
        }
    }

    @ParaLogar
    @PostMapping("/salvar")
    public String salvar(Tarefa tarefa, Model model) {
        if(usuarioSession.getUsername() == null) {

            return("redirect:/");
        } else {
            Map<String, String> atributoErro = tarefaService.salvar(tarefa);
            model.addAttribute("erros", atributoErro);
            model.addAttribute("tarefas", tarefaService.getTarefas());

            return "dashboard.html";
        }
    }

    @ParaLogar
    @PostMapping("/concluir")
    public String concluir(@RequestParam Long id) {
        if(usuarioSession.getUsername() == null) {

            return("redirect:/");
        } else {
            tarefaService.concluir(id);

            return("redirect:/dashboard");
        }
    }
}
