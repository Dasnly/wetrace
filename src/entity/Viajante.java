package entity;

public class Viajante {
    
    protected Long id;
    protected String nome;
    protected String cpf;
    protected String email;
    protected String senha;
    protected String idviajante;
    
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;

    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    } 
    public String getNome() { 
        return nome;
    } 
    public void setNome(String nome) { 
        this.nome = nome;
    } 
    public String getSenha() { 
        return senha;
    } 
    public void setSenha(String senha) { 
        this.senha = senha;
    } 

    public String getIdviajante() {
        return idviajante;
    }

    public void setIdviajante(String idviajante) {
        this.idviajante = idviajante;
    }

}