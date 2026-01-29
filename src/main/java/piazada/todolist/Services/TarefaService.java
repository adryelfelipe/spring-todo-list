package piazada.todolist.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import piazada.todolist.models.Tarefa;

import org.springframework.stereotype.Service;

@Service
public class TarefaService {
    // Atributos
    private static List<Tarefa> tarefas = new ArrayList<>();

    // Getters
    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    // Metodos
    public Map<String, String> salvar(Tarefa tarefa) {
        tarefas.add(tarefa);
        return new HashMap<>();
    }

     public void concluirTarefa(long id) {
        for(Tarefa tarefa : tarefas) {
            if(tarefa.getId() == id) {
                tarefa.concluir();
            }
        }
    }
}
