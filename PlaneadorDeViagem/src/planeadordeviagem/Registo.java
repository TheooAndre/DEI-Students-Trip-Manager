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
public class Registo extends JFrame{
    private JTextField textNome;
    private JTextField textNr;
    private JTextField textMont;
    private JCheckBox licenBox;
    private JCheckBox mestBox;
    private String pref;
    
    BufferedImage bi;
    
    /**
     *
     * @param listaLocal
     * @param pontosDeInteresse
     * @throws IOException
     */
    public Registo(ArrayList<Local> listaLocal, ArrayList<PontoDeInteresse> pontosDeInteresse) throws IOException {
        
        setTitle("Registo");
        
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
        registoButton.setBounds(475, 450, 100, 30);
        registoButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    int nr, mont;
                    try {
                        nr = Integer.parseInt(textNr.getText());
                    } catch (NumberFormatException e) {
                            System.out.println("numero invalido");
                            nr = -1;
                            JOptionPane.showMessageDialog(null, "Dados inseridos inválidos");
                    }
                    try {
                        mont = Integer.parseInt(textMont.getText());
                    } catch (NumberFormatException e) {
                            System.out.println("numero invalido");
                            mont = -1;
                            JOptionPane.showMessageDialog(null, "Dados inseridos inválidos");
                    }
                    
                    if((!textNome.getText().equals("")) && nr > 0 && mont > 0 && pref.equals("Licenciatura")){
                        try {
                            FicheiroAlunos f = new FicheiroAlunos();
                            f.registo(new Licenciatura(mont, textNome.getText(), nr, pref));
                        } catch (IOException | ClassNotFoundException ex) {
                            java.util.logging.Logger.getLogger(Registo.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }else if(!textNome.getText().equals("") && nr > 0 && mont > 0 && pref.equals("Mestrado")){
                        try {
                            FicheiroAlunos f = new FicheiroAlunos();
                            f.registo(new Mestrado(mont, textNome.getText(), nr, pref));
                        } catch (IOException | ClassNotFoundException ex) {
                            java.util.logging.Logger.getLogger(Registo.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else JOptionPane.showMessageDialog(null, "Dados inseridos inválidos");
                    try {
                        Login log = new Login(listaLocal, pontosDeInteresse);
                    } catch (IOException ex) {
                        Logger.getLogger(Registo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    setVisible(false);
                }
            }
        );
        
        
        
        JLabel labelNome = new JLabel("Introduza o seu nome:");
        labelNome.setForeground(Color.white);
        labelNome.setBounds(375, 150, 300, 20);
        JLabel labelNr = new JLabel("Introduza o seu número de estudante:");
        labelNr.setForeground(Color.white);
        labelNr.setBounds(375, 220, 300, 20);
        JLabel labelMont = new JLabel("Introduza o máximo que deseja gastar:");
        labelMont.setForeground(Color.white);
        labelMont.setBounds(375, 290, 300, 20);
        
        textNome = new JTextField(20);
        textNome.setBounds(375, 170, 300, 25);
        textNr = new JTextField(20);
        textNr.setBounds(375, 240, 300, 25);
        textMont = new JTextField(20);
        textMont.setBounds(375, 310, 300, 25);
        
        licenBox = new JCheckBox("Licenciatura");
        licenBox.setBounds(375, 370, 130, 20);
        mestBox = new JCheckBox("Mestrado");
        mestBox.setBounds(540, 370, 130, 20);
        
        HandlerClass handler = new HandlerClass();
        licenBox.addItemListener(handler);
        mestBox.addItemListener(handler);

        
        
        panel.setOpaque(false);
        panel.setLayout(null);
        panel.add(labelNome);
        panel.add(labelNr);
        panel.add(labelMont);
        panel.add(registoButton);
        panel.add(textNome);
        panel.add(textNr);
        panel.add(textMont);
        panel.add(licenBox);
        panel.add(mestBox);
        
        
        add(panel);
        setVisible(true);
        
    }
    
    private class HandlerClass implements ItemListener{
        
        public void itemStateChanged(ItemEvent event){

            if(licenBox.isSelected())
                pref = "Licenciatura";
            else if(mestBox.isSelected())
                pref = "Mestrado";
            else pref = "";
        }
    }
}
