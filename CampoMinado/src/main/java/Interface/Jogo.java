/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;

/**
 *
 * @author ArthurGiuvannucci
 */
public class Jogo extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Jogo.class.getName());

   //LOCAL ONDE CRIAMOS NOSSAS VARIAVEIS, antes do construtor
    
    //JButton precisa da importação da sua biblioteco
    //btnCampos e o nome da variavel - (voce que escolhe)
    //matriz co - 10 linhas e 10 
    JButton [][] btnCampos = new JButton [10][10];// Estrutura: {tipo da variavel[][] nome da variavel = new tipo da variavel [10][10];}
    
    //MATRIZ PARA QUARDAR AS BOMBAS - true p/ bomba, false p/ numero
    boolean [][] bombas = new boolean [10][10];
    
    //MATRIZ PARA GUARDAR OS CAMPOS QUE FORAM ABERTOS
    boolean [][] abertos = new boolean [10][10];
    
    int quatidadeBombas = 25;
    
    boolean jogoEncerrado= false;
    
    
    
    public Jogo() {
        initComponents();// contrutor da calsse, ele e quem da o inicio de tudo, SEM ELE A TELA NAO FUNCIONA.
        CriarTabuleiro();
        
    }

    // CRIAR FUNÇÕES/ METODOS 
    
    public void CriarTabuleiro(){
    
        //Definir que o painel será dividido em 10 linhas e 10 colunas  
        painelCampo.setLayout(new GridLayout(100,100,20,20));//GridLayout divide o painle em linhas e colunas. ex: 10 linhas e 10 colunas.
       
        for (int colunas= 0; colunas<=9; colunas ++){
            for (int linha=0;linha<=9;linha ++){
                //váriavel botão para guardar os dados provisorios 
                JButton botao= new JButton();
                botao.setFont(new Font ("Arial",Font.BOLD,16));// fonte 
                botao.setBackground(new Color(198,43,43));//cor de fundo
                botao.setForeground(Color.WHITE);//cor de texto
                
                //Remover marcas do butão que vem por padrão
                botao.setFocusPainted(false);
                botao.setEnabled(false);
                
                //adicionar o botõa dentro da matriz
                btnCampos [linha][colunas]= botao;
                //adicionar a matriz detro do painel
                painelCampo.add(botao);
                
            }//fim do 2° for 
        }//fim do 1° for 
       
    
    
    
    
    
    
    }// fim do metodo criar tabuleiro
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        tfTempo = new javax.swing.JTextField();
        painelCampo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setBackground(new java.awt.Color(0, 0, 0));
        titulo.setFont(new java.awt.Font("Old English Text MT", 1, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(204, 51, 0));
        titulo.setText("   Campo Minado ");

        btnIniciar.setBackground(new java.awt.Color(0, 0, 0));
        btnIniciar.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciar.setText("INICIAR");

        tfTempo.setEditable(false);
        tfTempo.setBackground(new java.awt.Color(0, 0, 0));
        tfTempo.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        tfTempo.setForeground(new java.awt.Color(204, 0, 51));
        tfTempo.setText("  00:00");

        painelCampo.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout painelCampoLayout = new javax.swing.GroupLayout(painelCampo);
        painelCampo.setLayout(painelCampoLayout);
        painelCampoLayout.setHorizontalGroup(
            painelCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 776, Short.MAX_VALUE)
        );
        painelCampoLayout.setVerticalGroup(
            painelCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painelCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 309, Short.MAX_VALUE)
                        .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(152, 152, 152)
                        .addComponent(tfTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(248, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Jogo().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JPanel painelCampo;
    private javax.swing.JTextField tfTempo;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
