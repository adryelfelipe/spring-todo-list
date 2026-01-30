package piazada.todolist.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import piazada.todolist.aop.ParaLogar;
import piazada.todolist.dtos.CadastroTarefaRequest;
import piazada.todolist.dtos.ConcluirTarefaRequest;
import piazada.todolist.models.Tarefa;

@Service
public class TarefaService {
    // Atributos
    private static List<Tarefa> tarefas = new ArrayList<>();

    // Getters
    public List<Tarefa> getTarefas() {
        
        return tarefas;
    }

    // Metodos
    @ParaLogar
    public Map<String, String> salvar(CadastroTarefaRequest request) {
        Tarefa tarefa = new Tarefa(request.nome());
        tarefas.add(tarefa);
        return new HashMap<>();
    }

    @ParaLogar
     public void concluir(ConcluirTarefaRequest request) {
        for(Tarefa tarefa : tarefas) {
            if(tarefa.getId() == request.id()) {
                tarefa.concluir();
            }
        }
    }
}
