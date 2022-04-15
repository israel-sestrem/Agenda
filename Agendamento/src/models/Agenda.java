package models;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Agenda {

    private ArrayList<Contato> contatos = new ArrayList<Contato>(5);
    
    private boolean contatoExiste = false;
    
    public Agenda(ArrayList<Contato> contatos){
        this.contatos = contatos;
    }
    
    public Agenda(){
        
    }
    
    public ArrayList getContatos(){
        return contatos;
    }
    
    public boolean getContatoExiste(){
        return contatoExiste;
    }
    
    public void adicionarContato(Contato contato){
        contatos.add(contato);
        JOptionPane.showMessageDialog(null, "Contato adicionado com sucesso!");
    }
    
    public void atualizarContato(int id, String nome, String telefone, String email){
        for(Contato contato : contatos){
            if( contato.getId() == id ){
                if ( !nome.equals("") ){
                    contato.setNome(nome);
                }
                if ( !telefone.equals("") ){
                    contato.setTelefone(telefone);
                }
                if ( !email.equals("") ){
                    contato.setEmail(email);
                }
                JOptionPane.showMessageDialog(null, "Contato de " + contato.getNome() + " atualizado com sucesso!");
                return;
            }
        }
    }
    
    public void deletarContato(int id){
        for(Contato contato : contatos){
            if ( contato.getId() == id ){
                contatos.remove(contato);
                JOptionPane.showMessageDialog(null, "Contato de " + contato.getNome() + " removido com sucesso!");
                return;
            }
        }
    }
    
    public boolean idExiste(int id){
        for(Contato contato : contatos){
            if ( contato.getId() == id ){
                return true;
            }
        }
        return false;
    }
    
    public String consultarContato(String nome){
        for(Contato contato : contatos){
            if ( contato.getNome().equalsIgnoreCase(nome) ){
                contatoExiste = true;
                return "O contato " + nome + " existe na lista.";
            }
        }
        contatoExiste = false;
        return "O contato " + nome + " não existe na lista.";
    }

    @Override
    public String toString() {
        String string = "";
        
        for( Contato contato : contatos ){
            string += "id: " + contato.getId(); 
            string += ", nome: " + contato.getNome();
            string += ", telefone: " + contato.getTelefone();
            string += ", email: " + contato.getEmail();
            string += "\n";
        }
        return !string.equals("") ? string : "Não foram encontrados contatos.";
    }
    
}
