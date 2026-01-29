package piazada.todolist.models;

public class Usuario {
    // Atributos
    private String username;
    private String senha;

    // Construtor
    public Usuario(String username, String senha) {
        this.username = username;
        this.senha = senha;
    }

    // Getters e Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
