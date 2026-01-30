package piazada.todolist.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import piazada.todolist.aop.ParaLogar;
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
    public Map<String, String> salvar(Tarefa tarefa) {

        tarefas.add(tarefa);
        return new HashMap<>();
    }

    @ParaLogar
     public void concluir(long id) {
        for(Tarefa tarefa : tarefas) {
            if(tarefa.getId() == id) {
                tarefa.concluir();
            }
        }
    }
}
