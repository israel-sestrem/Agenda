package controller;

import models.Contato;
import models.Agenda;
import javax.swing.JOptionPane;

public class Agendamento {
    
    public static void main(String[] args) {

        Agenda agenda = new Agenda();

        String opcao;
        
        do{
            opcao = menu();

            switch(opcao){
                case "1":
                    adicionarContato(agenda);
                    break;
                case "2":
                    atualizarContato(agenda);
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, agenda);
                    break;
                case "4":
                    deletarContato(agenda);
                    break;
                case "5":
                    String nome = getNome();
                    JOptionPane.showMessageDialog(null, agenda.consultarContato(nome));
                    break;
                case "6":
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Valor inválido");
                    break;
            }
        } while ( !opcao.equals("6") );
        
        JOptionPane.showMessageDialog(null, "Obrigado por utilizar meu sistema. Volte sempre.\n"
                                          + "Desenvolvedor: Israel Ricardo Sestrem.");
        
    }
    
    public static String menu(){
        String opcao = JOptionPane.showInputDialog("1 - Adicionar contato\n"
                                                 + "2 - Atualizar contato\n"
                                                 + "3 - Exibir contatos\n"
                                                 + "4 - Deletar contato\n"
                                                 + "5 - Verificar contato\n"
                                                 + "6 - Sair\n"
                                                 + "\nInforme a opção desejada: ");
        
        return opcao;
    }
    
    public static void adicionarContato(Agenda agenda){   
        
        if ( agenda.getContatos().size() == 5 ){
            JOptionPane.showMessageDialog(null, "Lista está cheia!");
            return;
        }
        
        String nome = getNome();
        
        agenda.consultarContato(nome);
        if( agenda.getContatoExiste() ){
            JOptionPane.showMessageDialog(null, "Este contato já existe!");
            return;
        }
        
        String telefone = getTelefone();
        
        String email = getEmail();
        
        Contato contato = new Contato();
        
        contato.setNome(nome);
        contato.setTelefone(telefone);
        contato.setEmail(email);
        
        agenda.adicionarContato(contato);
    }
    
    public static void atualizarContato(Agenda agenda){
        
        int id = verificaId(agenda);
        
        if ( id == 0 ){
            return;
        }
        
        String msg = "Deixe em branco para não alterar.";
        
        String nome = JOptionPane.showInputDialog(msg + "\n"
                                               + "\nInforme o novo nome: ");
        
        agenda.consultarContato(nome);
        if( agenda.getContatoExiste() ){
            JOptionPane.showMessageDialog(null, "Este contato já existe!");
            return;
        }
        
        String telefone = JOptionPane.showInputDialog(msg + "\n"
                                                   + "\nInforme o novo telefone: "); 
        
        String email = JOptionPane.showInputDialog(msg + "\n"
                                                   + "\nInforme o novo email: "); 
        
        agenda.atualizarContato(id, nome, telefone, email);
    }
    
    public static void deletarContato(Agenda agenda){
        int id = verificaId(agenda);
        
        if ( id == 0 ){
            return;
        }
        
        agenda.deletarContato(id);
    }
    
    public static String getNome(){
        String nome = JOptionPane.showInputDialog("Informe o nome do contato: ");
        
        return nome;
    }
    
    public static String getTelefone(){
        String telefone = JOptionPane.showInputDialog("Informe o telefone do contato: ");
        
        return telefone;
    }
    
    public static String getEmail(){
        String email = JOptionPane.showInputDialog("Informe o email do contato: ");
        
        return email;
    }
    
    public static int verificaId(Agenda agenda){
        try{
            
            int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do contato: "));

            if ( agenda.idExiste(id) ){
                return id;
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Você precisa informar um valor inteiro");
            return 0;
        }
        JOptionPane.showMessageDialog(null, "O id informado não existe.");
        return 0;
    }
    
}
