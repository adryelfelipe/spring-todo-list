package piazada.todolist.tarefa.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import piazada.todolist.aop.ParaLogar;
import piazada.todolist.tarefa.dtos.CadastroTarefaRequest;
import piazada.todolist.tarefa.dtos.ConcluirTarefaRequest;
import piazada.todolist.tarefa.service.TarefaService;
import piazada.todolist.usuario.session.UsuarioSession;

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
    public String salvar(CadastroTarefaRequest request, Model model) {
        if(usuarioSession.getUsername() == null) {

            return("redirect:/");
        } else {
            Map<String, String> atributoErro = tarefaService.salvar(request);
            model.addAttribute("erros", atributoErro);
            model.addAttribute("tarefas", tarefaService.getTarefas());

            return "dashboard.html";
        }
    }

    @ParaLogar
    @PostMapping("/concluir")
    public String concluir(ConcluirTarefaRequest request) {
        if(usuarioSession.getUsername() == null) {

            return("redirect:/");
        } else {
            tarefaService.concluir(request);

            return("redirect:/dashboard");
        }
    }
}
