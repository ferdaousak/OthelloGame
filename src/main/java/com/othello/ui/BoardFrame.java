/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.othello.ui;

import com.othello.classes.OthelloGame;
import com.othello.entities.Case;
import com.othello.entities.CaseValue;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author macbookpro
 */
public class BoardFrame extends javax.swing.JFrame {

    /**
     * Creates new form BoardFrame
     */
    
    public static int WIDTH = 700, HEIGHT = 655;
    private OthelloGame gamedata;
    private BoardPanel boardpanel;
    
    public BoardFrame(Case[][] board)
    {    	
        initComponents();
        
        this.jPanel1.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        boardpanel = new BoardPanel(board,null);
        this.jPanel1.add(boardpanel,BorderLayout.CENTER);
    }
    public BoardFrame(Case[][] board, OthelloGame game)
    {
        initComponents();
        
        this.jPanel1.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        gamedata = game;
        
        boardpanel = new BoardPanel(board, gamedata);
        boardpanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.jPanel1.add(boardpanel,BorderLayout.CENTER);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel1.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jMenu1.setText("Jeu");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Sauvegarder");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Abandonner");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Aide");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    	String gamename = (String)JOptionPane.showInputDialog("Veuillez saisir un nom : ");
    	if(gamename!=null)
    		gamedata.setName(gamename);
    	
    	gamedata.setStatefromBoard(boardpanel.getBoard());
    	gamedata.savegame();
    	
    	System.out.println("saving game :");
    	System.out.println(gamedata);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BoardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BoardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BoardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BoardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Case[][] defaultBoard = new Case[8][8];
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        defaultBoard[i][j] = new Case(i,j);
                    }
                }
                
                // Adding the initial pieces
                defaultBoard[3][3].setValue(CaseValue.WHITE);
                defaultBoard[3][4].setValue(CaseValue.BLACK);
                defaultBoard[4][3].setValue(CaseValue.BLACK);
                defaultBoard[4][4].setValue(CaseValue.WHITE);
                
                JFrame frame = new BoardFrame(defaultBoard);
                frame.setSize(new Dimension(WIDTH, HEIGHT));
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
