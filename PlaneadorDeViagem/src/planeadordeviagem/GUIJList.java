package planeadordeviagem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author limeiro
 */
public class GUIJList extends JFrame {

    private JList prefList;
    private JList viagemList;
    private String prefPonto = "";
    private ArrayList<String> nomesPontos = new ArrayList();
    private ArrayList<String> nomesViagem = new ArrayList();
    private int numberPonto, numberViagem;
    private ArrayList<Percurso> viagens = new ArrayList();
    private JScrollPane scroll, scrollViagem;
    private BufferedImage bi;
    DefaultListModel <String> model = new DefaultListModel<>();
    
    /**
     *
     * @param arrayPontos
     * @param arrayLocais
     * @param montMax
     * @throws IOException
     */
    public GUIJList(ArrayList<PontoDeInteresse> arrayPontos, ArrayList<Local> arrayLocais, int montMax) throws IOException {

        for (int i = 0; i < arrayPontos.size(); i++) {
            nomesPontos.add(arrayPontos.get(i).getNome());
        }
        bi = ImageIO.read(new File("/home/etiandro/Downloads/PlaneadorDeViagem/src/planeadordeviagem/Backbround.jpg"));
        
        
        prefList = new JList(nomesPontos.toArray());
        prefList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scroll = new JScrollPane(prefList);
        scroll.setBounds(50, 70, 300, 450);

        prefList.addListSelectionListener(
                new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                numberPonto = prefList.getSelectedIndex();
                if(numberPonto != -1){
                    prefPonto = nomesPontos.get(numberPonto);
                    System.out.println(prefPonto);
                    System.out.println(numberPonto);
                }
            }
        }
        );
        
        /**
         * Esta função tem como finalidade por a imagem que esta na variavel bi como background
         */
        
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bi, 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        /**
         * esta função dá funcionalidade ao geraButton, ao escolher um ponto de preferência, ao carregar no botão "Gerar" o programa escolhe aleatoriamente 10 percursos.
         */
        
        JButton geraButton = new JButton("Gerar");
        geraButton.setBounds(150, 550, 80, 30);
        geraButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
                int i = 0, j = 0, k = 0;
                viagens.removeAll(viagens);
                
                /**
                 * o While para se encontrar 10 percursos ou se ao fim de 300 tentativas de gerar percursos nao conseguir encontrar 10 percursos
                 */
                while (i < 10 && k < 300) {
                    Percurso newPercurso = new Percurso();
                    if (!prefPonto.equals("")) {
                        
                        while (j < 3) {
                            newPercurso.escolheLocal(arrayLocais);
                            j++;
                        }
                        j = 0;
                        newPercurso.escolhePontosDeInteresse(arrayPontos);
                        k++;
                        
                        newPercurso.setCustoViagem();
                        newPercurso.setPref();
                        
                        /**
                         * So aceita a viagem se esta tiver um museu, o custo ser menor que o montante que o aluno está disposto a pagar e se contiver o ponto de interesse que o aluno de lincenciatura queria visitar
                         */
                        if (newPercurso.findMuseu() == 1 && newPercurso.verificaPref(prefPonto) == 1 && newPercurso.getCustoViagem() < montMax) { //falta ver se o custo é inferior
                            viagens.add(newPercurso);
                            
                            i++;
                        }
                    }
                }              
                /**
                 * este algoritmo faz com que a JList faça o update e mostre os novos percursos
                 */
                
                model.removeAllElements();
            
                for(Percurso viagem : viagens) {
                    nomesViagem.add(viagem.printOutput());
                    model.addElement(viagem.printOutput());           
                }
                viagemList.removeAll();
                viagemList.setModel(model);
                panel.updateUI();
            }
        }
        );
        
        /**
         * definimos a uma JList para mostrar os percusos, que é atualizada nas linhas anteriores
         */
        
        viagemList = new JList();
        viagemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollViagem = new JScrollPane(viagemList);
        scrollViagem.setBounds(500, 70, 250, 200);
        panel.add(scrollViagem);
        
        /**
         * sempre que clicamos num percurso na JList "viagemList" aparece uma textArea com as especificações da viagem, os pontos de interesse
         */
        
        viagemList.addListSelectionListener(
                new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                numberViagem = viagemList.getSelectedIndex();
                String Specs;
                if(numberViagem != -1){
                    System.out.println(numberViagem);
                    Specs = viagens.get(numberViagem).specsLocal();
                
                    // create a JTextArea
                    JTextArea textArea = new JTextArea(50, 50);
                    textArea.setText(Specs);
                    textArea.setEditable(false);

                     // wrap a scrollpane around it
                    JScrollPane scrollPane = new JScrollPane(textArea);

                    // display them in a message dialog
                    JOptionPane.showMessageDialog(null, scrollPane);
                }
            }
        }
        );
        
        /**
         * ao clicar no menorButton, o programa ordena as viagens por menor custo
         */
        
        JButton menorButton = new JButton("Por menor custo");
        menorButton.setBounds(800, 100, 160, 30);
        menorButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
                /**
                 * se estiver 10  5  11  7
                 * 
                 * adicionamos o 5 antes do 10, fica 5  10  5  11  7
                 * 
                 * retiramos o 5 depois do 10, fica 5  10   11   7 
                 * 
                 * se fizermos alguma alteração voltamos ao inicio, quando chegarmos ao fim sem alterar nada, temos o array ordenado
                 * 
                 */
                
                int i = 1;
                while( i == 1){
                    for(int j = 0; j < viagens.size()-1 ; j++){
                        if(viagens.get(j).getCustoViagem() > viagens.get(j+1).getCustoViagem()){
                            viagens.add(j, viagens.get(j+1));
                            viagens.remove(j+2);
                            j = 0;
                        }
                    }
                    i = 0;
                }
                /**
                 * faz update das viagens ordenadas
                 */
                model.removeAllElements();
            
                for(Percurso viagem : viagens) {
                    nomesViagem.add(viagem.printOutput());
                    model.addElement(viagem.printOutput());           
                }
                viagemList.removeAll();
                viagemList.setModel(model);
                panel.updateUI();
            }
        }
        );
        
        /**
         * esta função é semelhante à anterior mas ordena de ordem decrescente de custo
         */
        
        JButton maiorButton = new JButton("Por maior custo");
        maiorButton.setBounds(800, 150, 160, 30);
        maiorButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
                int i = 1;
                while( i == 1){
                    for(int j = 0; j < viagens.size()-1 ; j++){
                        if(viagens.get(j).getCustoViagem() < viagens.get(j+1).getCustoViagem()){
                            viagens.add(j, viagens.get(j+1));
                            viagens.remove(j+2);
                            j = 0;
                        }
                    }
                    i = 0;
                }
                
                model.removeAllElements();
            
                for(Percurso viagem : viagens) {
                    nomesViagem.add(viagem.printOutput());
                    model.addElement(viagem.printOutput());           
                }
                viagemList.removeAll();
                viagemList.setModel(model);
                panel.updateUI();
            }
        }
        );
        
        /**
         * esta função é semelhante às anteriores mas ordena por popularidade
         */
        
        JButton popButton = new JButton("Por popularidade");
        popButton.setBounds(800, 200, 160, 30);
        popButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
                int i = 1;
                while( i == 1){
                    for(int j = 0; j < viagens.size()-1 ; j++){
                        if(viagens.get(j).getPref() < viagens.get(j+1).getPref()){
                            viagens.add(j, viagens.get(j+1));
                            viagens.remove(j+2);
                            j = 0;
                        }
                    }
                    i = 0;
                }
                
                model.removeAllElements();
            
                for(Percurso viagem : viagens) {
                    nomesViagem.add(viagem.printOutput());
                    model.addElement(viagem.printOutput());           
                }
                viagemList.removeAll();
                viagemList.setModel(model);
                panel.updateUI();
            }
        }
        );
        
        /**
         * ao carregar no botão escolher viagem, guarda a viagem escolhida, aumenta as preferencias da variavel prefCount e volta à pagina do login
         */
        
        JButton escolheButton = new JButton("Escolhe");
        escolheButton.setBounds(500, 300, 160, 30);
        escolheButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                GuardarDados g = new GuardarDados();
                try {
                    g.guardar(nomesViagem, viagens);
                    //
                } catch (IOException ex) {
                    Logger.getLogger(GUIJList.class.getName()).log(Level.SEVERE, null, ex);
                }
                arrayPontos.get(numberViagem).prefCount += 1;
                //
                PlaneadorDeViagem p;
                try {
                    p = new PlaneadorDeViagem();
                    p.actualizarFicheiroPDI(arrayPontos);
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(GUIJList.class.getName()).log(Level.SEVERE, null, ex);
                }
                //
                setVisible(false);
           
            }
        }
        );
        
        
        /**
         * adiciona tudo o que criamos ao panel
         */

        

        setTitle("Planeador de Viagens");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JLabel labelViagem = new JLabel("Percursos Gerados:");
        labelViagem.setForeground(Color.white);
        labelViagem.setBounds(500, 40, 200, 20);
        JLabel label = new JLabel("Pontos de Preferência");
        label.setForeground(Color.white);
        label.setBounds(50, 40, 200, 20);

        panel.setLayout(null);
        panel.add(label);
        panel.add(labelViagem);
        panel.add(geraButton);
        panel.add(escolheButton);
        panel.add(menorButton);
        panel.add(maiorButton);
        panel.add(popButton);
        panel.add(scroll);
        add(panel);
        setVisible(true);
    }
    
}
