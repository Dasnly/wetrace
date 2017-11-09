/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

    
    public class Usuario {
        
    protected String cpf;
    protected String email;
    protected String nome;    
    protected String senha;
    protected Long id;

    public Usuario(String cpf, String email, String nome, String senha, Long id) {
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.id = id;
    }
    
    public Usuario (String cpf, String email, String nome, String senha){
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }
    
    public Usuario (Long id){
        this.id = id;
    }
    
    public Usuario (){
        
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    
}

    

