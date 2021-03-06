/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unb.cic.lp.gol.UI;

import javax.swing.JButton;

import com.google.inject.Guice;
import com.google.inject.Injector;

import br.unb.cic.lp.MementoGol.*;
import br.unb.cic.lp.gol.Cell;
import br.unb.cic.lp.gol.GameControllerModule;
import br.unb.cic.lp.gol.GameEngine;
import br.unb.cic.lp.gol.Statistics;

import java.util.concurrent.TimeUnit;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author macel
 */
public class GUI extends javax.swing.JFrame {
	
	private static final long serialVersionUID = -2664928061594794745L;
	private GameEngine engine;
	private Statistics statistics;
	private Cell[][] board;
	private boolean flag;
	private Originator originator;
	private Caretaker caretaker;
	private Injector injector;
	private GameControllerModule module;
	
    /**
     * Creates new form GUI
     */
    public GUI() {
		statistics = new Statistics();
		
		module = new GameControllerModule();
		injector = Guice.createInjector( module );
		engine = injector.getInstance(GameEngine.class);
		engine.setStatistics(statistics);
		
		board = new Cell[engine.getHeight()][engine.getWidth()];
    	Cells =  new CellButton[engine.getHeight()][engine.getWidth()];
    	
        for(int i =0 ; i< engine.getHeight() ; i++){
        	for(int j =0 ; j< engine.getWidth() ; j++){
            	Cells[i][j] = new CellButton();
            	Cells[i][j].reset();
            	board[i][j] = new Cell();
            }
        }   
        originator = new Originator(engine.getHeight(), engine.getWidth());
		caretaker = new Caretaker();
		
        initComponents();
    }


    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        RevivedCellsText = new javax.swing.JLabel();
        KilledCellsText = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	RuleActionPerformed(evt);
            }
        });
        
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	RuleActionPerformed(evt);
            }
        });
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	RuleActionPerformed(evt);
            }
        });
        jCheckBoxMenuItem4 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	RuleActionPerformed(evt);
            }
        });
        
        jCheckBoxMenuItem5 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	RuleActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jInternalFrame1.setVisible(true);

        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Stop");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });


        jButton3.setText("Next Generation");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Dynamic");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Return");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Statistics");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setLayout(new java.awt.GridLayout(40, 60));

        jButton7.setText("Reset");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel1.setText("Revided Cells :");

        jLabel2.setText("Killed Cells:");

        RevivedCellsText.setText("RC");

        KilledCellsText.setText("KC");

        jMenu1.setText("Regras");

        jCheckBoxMenuItem1.setText("Conway");
        jMenu1.add(jCheckBoxMenuItem1);

        jCheckBoxMenuItem2.setText("High Life");
        jMenu1.add(jCheckBoxMenuItem2);

        jCheckBoxMenuItem3.setText("Life with out Death");
        jMenu1.add(jCheckBoxMenuItem3);

        jCheckBoxMenuItem4.setText("Seeds");
        jMenu1.add(jCheckBoxMenuItem4);
        
        jCheckBoxMenuItem5.setText("Diamoeba");
        jMenu1.add(jCheckBoxMenuItem5);

        jMenuBar1.add(jMenu1);

        jInternalFrame1.setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(KilledCellsText)
                                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(RevivedCellsText))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addGap(111, 111, 111)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(RevivedCellsText))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(KilledCellsText))
                        .addGap(83, 83, 83))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
        );
        
        
        //Adding Cells
        for(int i =0 ; i< engine.getHeight() ; i++){
        	for(int j =0 ; j< engine.getWidth() ; j++){
        		jPanel1.add(Cells[i][j]);
            }
        }  

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
  
        for(int i =0 ; i< engine.getHeight() ; i++){
        	for(int j =0 ; j< engine.getWidth() ; j++){
        		if(Cells[i][j].getBackground() == Color.BLACK){
					board[i][j].revive();
				}
				else
					board[i][j].kill();
            }
        } 
        engine.setCells(board);
        flag = true;
    	Thread t = new Thread(new computeNGeneration());
    	t.start();
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    	flag = false;
    	update(engine.getCells());
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        for(int i =0 ; i< engine.getHeight() ; i++){
        	for(int j =0 ; j< engine.getWidth() ; j++){
        		if(Cells[i][j].getBackground() == Color.BLACK){
					board[i][j].revive();
				}
				else
					board[i][j].kill();
            }
        } 
        engine.setCells(board);
        
    	originator.set(engine.getCells());
		caretaker.add(originator.saveToMemento());
        
        engine.nextGeneration();
    	update(engine.getCells());
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
    	for(int i =0 ; i< engine.getHeight() ; i++){
        	for(int j =0 ; j< engine.getWidth() ; j++){
        		if(Cells[i][j].getBackground() == Color.BLACK){
					board[i][j].revive();
				}
				else
					board[i][j].kill();
            }
        } 
        engine.setCells(board);
        flag = true;
    	Thread t = new Thread(new computeNGeneration());
    	t.start();
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		engine.setCells(originator.restoreFromMemento(caretaker.get()));
		update(engine.getCells());
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
    	//SHOW STATISTICS 
        showStatistics();
    }
    
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
    	for(int i =0 ; i< engine.getHeight() ; i++){
        	for(int j =0 ; j< engine.getWidth() ; j++){
        		Cells[i][j].setBackground(Color.WHITE);
            }
        }   
    }
    
    private void RuleActionPerformed(ActionEvent evt){
    	if(evt.getSource().equals(jCheckBoxMenuItem1)){
    		jCheckBoxMenuItem1.setState(true);
    		jCheckBoxMenuItem2.setState(false);
    		jCheckBoxMenuItem3.setState(false);
    		jCheckBoxMenuItem4.setState(false);
    		jCheckBoxMenuItem5.setState(false);
    		module.setRule(1);
    		engine = injector.getInstance(GameEngine.class);
    		engine.setStatistics(statistics);
    	}
    	else if(evt.getSource().equals(jCheckBoxMenuItem2)){
    		jCheckBoxMenuItem1.setState(false);
    		jCheckBoxMenuItem2.setState(true);
    		jCheckBoxMenuItem3.setState(false);
    		jCheckBoxMenuItem4.setState(false);
    		jCheckBoxMenuItem5.setState(false);
    		module.setRule(2);
    		engine = injector.getInstance(GameEngine.class);
    		engine.setStatistics(statistics);
    	}
    	else if(evt.getSource().equals(jCheckBoxMenuItem3)){
    		jCheckBoxMenuItem1.setState(false);
    		jCheckBoxMenuItem2.setState(false);
    		jCheckBoxMenuItem3.setState(true);
    		jCheckBoxMenuItem4.setState(false);
    		jCheckBoxMenuItem5.setState(false);
    		module.setRule(3);
    		engine = injector.getInstance(GameEngine.class);
    		engine.setStatistics(statistics);
    	}
    	else if(evt.getSource().equals(jCheckBoxMenuItem4)){
    		jCheckBoxMenuItem1.setState(false);
    		jCheckBoxMenuItem2.setState(false);
    		jCheckBoxMenuItem3.setState(false);
    		jCheckBoxMenuItem4.setState(true);
    		jCheckBoxMenuItem5.setState(false);
    		module.setRule(4);
    		engine = injector.getInstance(GameEngine.class);
    		engine.setStatistics(statistics);
    	}
    	else if(evt.getSource().equals(jCheckBoxMenuItem5)){
    		jCheckBoxMenuItem1.setState(false);
    		jCheckBoxMenuItem2.setState(false);
    		jCheckBoxMenuItem3.setState(false);
    		jCheckBoxMenuItem4.setState(false);
    		jCheckBoxMenuItem5.setState(true);
    		module.setRule(5);
    		engine = injector.getInstance(GameEngine.class);
    		engine.setStatistics(statistics);
    	}
    	else 
    		return;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
               
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel KilledCellsText;
    private javax.swing.JLabel RevivedCellsText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem4;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem5;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private CellButton[][] Cells;
    // End of variables declaration//GEN-END:variables
    
    
    private void update(Cell[][] Ngeneration){
    	for(int i =0 ; i< engine.getHeight() ; i++){
        	for(int j =0 ; j< engine.getWidth() ; j++){
        		if(Ngeneration[i][j].isAlive()){
        			board[i][j].revive();
					Cells[i][j].setBackground(Color.BLACK);
				}
				else{
					board[i][j].kill();
					Cells[i][j].setBackground(Color.WHITE);
				}
            }
        } 
    }
    
    private class computeNGeneration extends Thread{
    	public void run(){
    		while(engine.numberOfAliveCells() != 0 & flag){
    	    	originator.set(engine.getCells());
    			caretaker.add(originator.saveToMemento());
            	engine.nextGeneration();
            	update(engine.getCells());
            	try {
    				TimeUnit.MILLISECONDS.sleep(250);
    			} catch (InterruptedException e) {
        			System.out.println(e.getMessage());
    			}
            }
    	}
    }
    
    private class CellButton extends JButton implements ActionListener{

		private static final long serialVersionUID = 1L;
		private int count;

		public CellButton(){
    		super();
    		addActionListener(this);
			count = 0;
    	}
    	
		public void reset(){
			this.setBackground(Color.WHITE );
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(count == 0){
				this.setBackground(Color.BLACK);		
			}else{
				this.setBackground(Color.WHITE);
			}
			count++;
			count %= 2;
		}
    	
    }
    
    private void showStatistics(){
        RevivedCellsText.setText(Integer.toString(statistics.getRevivedCells()));
        KilledCellsText.setText(Integer.toString(statistics.getKilledCells()));
    }
   
}
