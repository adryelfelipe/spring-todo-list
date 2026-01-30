package piazada.todolist.tarefa.model;

public class Tarefa {
    // Atributos
    private String titulo;
    private boolean concluida;
    private static long quantidadeTarefas = 0;
    private long id;

    // Construtor
    public Tarefa(String titulo) {
        this.titulo = titulo;
        this.concluida = false;
        quantidadeTarefas++;
        id = quantidadeTarefas;
    }

    // Setters e Getters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public boolean isConcluida() {
        return this.concluida;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Methodos
    public void concluir() {
        this.concluida = true;
    }
}
