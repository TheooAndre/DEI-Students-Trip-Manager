/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planeadordeviagem;

import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 *
 * @author limeiro
 */
public class Login extends JFrame{
    
    private JTextField textNome;
    private JTextField textNr;
    private String pref;
    private BufferedImage bi;
    
    /**
     *
     * @param listaLocal
     * @param pontosDeInteresse
     * @throws IOException
     */
    public Login(ArrayList<Local> listaLocal, ArrayList<PontoDeInteresse> pontosDeInteresse) throws IOException {
        
        setTitle("Login");
        
        bi = ImageIO.read(new File("/home/etiandro/Downloads/PlaneadorDeViagem/src/planeadordeviagem/RegBack.jpg"));
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bi, 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        //background = new JLabel("", img, JLabel.CENTER);
        //background.setBounds(0,0, 1000, 800);

        
        JButton registoButton = new JButton("Registar");
        registoButton.setBounds(550, 300, 100, 30);
        registoButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    try {    
                        Registo reg = new Registo(listaLocal, pontosDeInteresse);
                    } catch (IOException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    setVisible(false);
                }
            }
        );
        
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(400, 300, 100, 30);
        loginButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    try {
                        int nr;
                        try {
                            nr = Integer.parseInt(textNr.getText());
                        } catch (NumberFormatException e) {
                            System.out.println("numero invalido");
                            nr = -1;
                            JOptionPane.showMessageDialog(null, "Dados inseridos inválidos");
                        }
                        FicheiroAlunos f = new FicheiroAlunos();
                        if( f.loginCheck((textNome.getText()), nr) == 1){
                            int montMax = f.getCustoMont();
                            GUIJList gui = new GUIJList(pontosDeInteresse, listaLocal, montMax);
                            setVisible(false);
                        }else if( f.loginCheck((textNome.getText()), nr) == 2){
                            try {
                                int montMax = f.getCustoMont();
                                GUIMestrado gui = new GUIMestrado(pontosDeInteresse, listaLocal, montMax);
                                setVisible(false);
                            } catch (IOException ex) {
                                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } catch (IOException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        );
        
        
        
        JLabel labelNome = new JLabel("Introduza o seu nome:");
        labelNome.setForeground(Color.white);
        labelNome.setBounds(375, 150, 300, 20);
        JLabel labelNr = new JLabel("Introduza o seu número de estudante:");
        labelNr.setForeground(Color.white);
        labelNr.setBounds(375, 220, 300, 20);
        
        textNome = new JTextField(20);
        textNome.setBounds(375, 170, 300, 25);
        textNr = new JTextField(20);
        textNr.setBounds(375, 240, 300, 25);

        
        
        panel.setOpaque(false);
        panel.setLayout(null);
        panel.add(labelNome);
        panel.add(labelNr);
        panel.add(registoButton);
        panel.add(loginButton);
        panel.add(textNome);
        panel.add(textNr);
        
        add(panel);
        setVisible(true);
        
    }
}

