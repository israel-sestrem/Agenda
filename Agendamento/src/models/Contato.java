package models;

public class Contato {
    
    private static int contador = 0;
    
    private int id;
    private String nome;
    private String telefone;
    private String email;
    
    public Contato(String nome, String telefone, String email){
        contador++;
        id = contador;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
    
    public Contato(){
        contador++;
        id = contador;
    }
    
    public int getId(){
        return id;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getTelefone(){
        return telefone;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }

    @Override
    public String toString() {
        return "Contato{id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + '}';
    }
    
}
