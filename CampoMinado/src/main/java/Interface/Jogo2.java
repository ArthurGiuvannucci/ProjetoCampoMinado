/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author ArthurGiuvannucci
 */
public class Jogo2 extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Jogo2.class.getName());

    JButton [][] btnCampos = new JButton [10][10];// Estrutura: {tipo da variavel[][] nome da variavel = new tipo da variavel [10][10];}
    
    //MATRIZ PARA QUARDAR AS BOMBAS - true p/ bomba, false p/ numero
    boolean [][] bombas = new boolean [10][10];
    
    //MATRIZ PARA GUARDAR OS CAMPOS QUE FORAM ABERTOS
    boolean [][] abertos = new boolean [10][10];
    
    int quantidadeBombas = 15;
    int quantidadeCasasAbertas= 0;
    boolean jogoEncerrado= false;
    int segundosPassados= 0;
    Timer cronometro;
    
    public Jogo2() {
        initComponents();
     painelCampo.setPreferredSize(new Dimension(800,600));// setPreferredSize pode defirnir o tamanho do tabuleiro 
        CriarTabuleiro();
        
       
    }

    // CRIAR FUNÇÕES/ METODOS  
    
    public void CriarTabuleiro(){
    
        //Definir que o painel será dividido em 10 linhas e 10 colunas  
        painelCampo.setLayout(new GridLayout(10,10,2,2));//GridLayout divide o painle em linhas e colunas. ex: 10 linhas e 10 colunas.
       
        for (int colunas= 0; colunas<=9; colunas ++){
            for (int linha=0;linha<=9;linha ++){
                //váriavel botão para guardar os dados provisorios 
                JButton botao= new JButton();
                botao.setFont(new Font ("Arial",Font.BOLD,16));// fonte 
                botao.setBackground(new Color(75,72,72));//cor de fundo
                botao.setForeground(Color.WHITE);//cor de texto
                
                //Remover marcas do butão que vem por padrão
                botao.setFocusPainted(false); 
                botao.setEnabled(false);
                
             final int linhaSelecionada = linha;   
             final int colunaSelecionada = colunas;
           //         
                botao.addActionListener((ActionEvent Evento)->{
                       abrirBotao(linhaSelecionada,colunaSelecionada);
                });
                
                //adicionar o botõa dentro da matriz
                btnCampos [linha][colunas]= botao;
                //adicionar a matriz detro do painel
                painelCampo.add(botao);
                
            }//fim do 2° for 
        }//fim do 1° for 
       
    
    
    
    
    
    
    }// fim do metodo criar tabuleiro
    
    public void AdicionarBombas(){
        //Criar variavel Ramdom para gerar valores aleatorios 
        Random sorteador = new Random();
        int sorteadorAdicionadas = 0;
        
        while (sorteadorAdicionadas < quantidadeBombas){
            //sortear o n° da linha e coluna que vai fiacr a bomaba 
            int linhas = sorteador.nextInt(10);
            int coluna = sorteador.nextInt (10);
            //VERIFICA SE NÃO EXISTE BOMBA ADICIOANDA NO LOCAL 
            if (!bombas [linhas][coluna]){
             //ADICIONAR A BOMBA NA MATRIX
             bombas [linhas][coluna]= true; 
                     sorteadorAdicionadas++;
             }
        }
        
        
        
    }//FIM DO ADICIONAR BOMBAS
    
    public void IniciarJogo(){
    //CAMAR O METODO adicionarBombas
   LimparJogo();
    AdicionarBombas();
    IniciarCronometro();
    //deppois percisamos iniciara os botoes do jogo
    for (int coluna =0; coluna <= 9; coluna++){
         for (int linhas = 0; linhas<= 9; linhas++ ){
             JButton botao= btnCampos [linhas][coluna];
             //deixar os botoes visiveis e clicaveis 
             botao.setEnabled(true); 
             
             
         }//fim do segundo for
    }  // fim do primeiro for 
   btnIniciar.setText ("REINICIAR");
   
    }// fim do iniciarJogo
    
    public void abrirBotao (int linha, int coluna){
    //verificar se o jogo foi finalizado 
    if (jogoEncerrado) return; 
    
    //verificar se o botao ja foi aberto     
    if (abertos [linha][coluna]) return;
    
    /*se o jogo ainda estiver rodando e o botao ainda nao estiver sido aberto- entao vamos abrir o botao*/
    abertos [linha][coluna]=true;
    quantidadeCasasAbertas ++;
    
    JButton botao = btnCampos[linha][coluna];
    //se o botao tiver uma bomba, entao vamos motrar a bomba a ele
        if (bombas[linha][coluna]){
            ImageIcon imgBomba = new ImageIcon(getClass().getResource("/assets/bomb.png"));  
          //colocar a imagem dentro do botao 
            botao.setIcon(imgBomba);
            FinalizarJogo (false);
        }else {
              ImageIcon imgBandeira = new ImageIcon(getClass().getResource("/assets/flag.png"));
               botao.setIcon(imgBandeira);
               return;
        } 
    }//fim do metodo abrirBotao
    
    //ESSE METODO INFORMA QUANTO A PESSOA PERDE OU GANHA O JOGO
    public void FinalizarJogo (boolean venceu){
        MostrarBombas();
        jogoEncerrado=true; // Vamos informar que o jogo acabou
        cronometro.stop();
        //verificar se a pessoa venceu ou nao 
        if (venceu){
             JOptionPane.showMessageDialog(this,"Parabéns vôce venceu!");// showMessageDialog abre uma tela de visualização com o resultado programado
          LimparJogo();    
        }else {
             JOptionPane.showMessageDialog(this,"Ops, vôce perdeu o jogo!");// this serve para 
             LimparJogo();
        }
    
    
    
    }; // FIM DO FinalizarJogo
    
    public void VerificarVitoria (){
    //armazena a quantidade de casas com bandeiras
    int casaSemBomba=100 - quantidadeBombas; 
    //se a pessoa abrir todas as bandeiras e não abriu nenhuma bomba
    //então ela venceu o jogo, e o finlizarJogo imprime a mensagem
    if (quantidadeCasasAbertas == casaSemBomba){
        FinalizarJogo (true);        
       
      }
    
    }
    
    public void IniciarCronometro(){
    //zerar cronometro caso tenha tido um jogo anterior 
    if (cronometro != null ){
      cronometro.stop();
     }
     
     segundosPassados = 0;
     tfTempo.setText ("00:00");//tfTempo e o nome da caixa do cronometro
     
     //converter oo tempo em minutos e segundos
     //cronometro conta de 1 em 1 segundo, e vai conerter
     cronometro = new Timer (1000, Evento -> {
      segundosPassados++; 
      int minutos = segundosPassados / 60;
      int horas = minutos / 60;
      int segundo = segundosPassados % 60;
      //mostrar o tempo dentor da variavel
      tfTempo.setText(String.format("%02d:%02d:%02d",horas, minutos, segundosPassados));
      
     });
     cronometro.start();
     
    }
    
    public void LimparJogo (){
        quantidadeCasasAbertas = 0; 
     for (int coluna =0; coluna <= 9; coluna ++){
        for (int linha= 0; linha <= 9; linha ++){
         bombas [linha][coluna] = false;
         abertos [linha][coluna]= false;
         
         //limpesa dos botoes 
        JButton botao = btnCampos [linha][coluna];
        botao.setIcon(null);
     
        }//fimm do 2° for
        
   }//fim do 1° for
     jogoEncerrado = false;
  AdicionarBombas();
  IniciarCronometro();
  
    }//fim LimparJogo
    
    public void MostrarBombas (){
        for (int coluna=0; coluna<=9;coluna++){
        for (int linha= 0; linha <=9; linha ++){
            
            
    JButton botao = btnCampos[linha][coluna];
    //se o botao tiver uma bomba, entao vamos motrar a bomba a ele
        if (bombas[linha][coluna]){
            ImageIcon imgBomba = new ImageIcon(getClass().getResource("/assets/bomb.png"));  
          //colocar a imagem dentro do botao 
            botao.setIcon(imgBomba);
           
        }
        }//2° for
    }//1° for
    }//mostrarBombas
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        painelCampo = new javax.swing.JPanel();
        btnIniciar = new javax.swing.JButton();
        tfTempo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        titulo.setBackground(new java.awt.Color(0, 0, 0));
        titulo.setFont(new java.awt.Font("Old English Text MT", 1, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(204, 51, 0));
        titulo.setText("   Campo Minado ");

        painelCampo.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout painelCampoLayout = new javax.swing.GroupLayout(painelCampo);
        painelCampo.setLayout(painelCampoLayout);
        painelCampoLayout.setHorizontalGroup(
            painelCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        painelCampoLayout.setVerticalGroup(
            painelCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );

        btnIniciar.setBackground(new java.awt.Color(0, 0, 0));
        btnIniciar.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciar.setText("INICIAR");
        btnIniciar.addActionListener(this::btnIniciarActionPerformed);

        tfTempo.setEditable(false);
        tfTempo.setBackground(new java.awt.Color(0, 0, 0));
        tfTempo.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        tfTempo.setForeground(new java.awt.Color(204, 0, 51));
        tfTempo.setText("  00:00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 914, Short.MAX_VALUE)
                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152)
                .addComponent(tfTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelCampo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelCampo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        // TODO add your handling code here:
        IniciarJogo();
    }//GEN-LAST:event_btnIniciarActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new Jogo2().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JPanel painelCampo;
    private javax.swing.JTextField tfTempo;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
