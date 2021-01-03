/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoarana;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import static javax.swing.JOptionPane.YES_NO_OPTION;

public class JuegoArana extends JPanel {
    public static boolean haChocado = false;
    Piedras roca = new Piedras(this);
    Insecto bicho = new Insecto();

    public JuegoArana(){
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                bicho.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        setFocusable(true);
    }
    
    @Override
    public void paint(Graphics g){
       super.paint(g);
       ImageIcon tela  = new ImageIcon(getClass().getResource("../Imagenes/tela.png"));
       g.drawImage(tela.getImage(),0,0,getWidth(),getHeight(),this);
       
       Font score = new Font("Arial",Font.BOLD,25);
       g.setFont(score);
       g.setColor(Color.blue);
       g.drawString("Puntaje "+roca.obtenerPuntos(),520,50);
       bicho.paint(g);
       roca.paint(g);
       roca.mover();
       g.dispose();
    }
    
    
    public static void main(String[] argc) {
        JFrame miVentana = new JFrame("Jugando con la araña");
        JuegoArana game = new JuegoArana();
        miVentana.add(game);
        miVentana.setSize(700, 700);
        miVentana.setVisible(true);
        miVentana.setResizable(false);
        miVentana.setLocationRelativeTo(null);
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      
        while(true){
            if(haChocado | Piedras.nivel == 5){
                if (Piedras.nivel == 5){
                   JOptionPane.showMessageDialog(null,"Ganaste");
                }
                int reiniciarJuego = JOptionPane.showConfirmDialog(null, "Perdiste, " + "Reiniciar juego?", "Perdiste", YES_NO_OPTION);
                if(reiniciarJuego == 0){
                    reiniciaValores();
                }else if (reiniciarJuego == 1){
                    System.exit(0);
                }
            }
            try {
                Thread.sleep(10);
            }catch(InterruptedException ex){
                System.out.println(ex.toString());
            }
            game.repaint();  
        }
    }
    
    public static void reiniciaValores(){
        Piedras.xRoca1 = 600;
        Piedras.yRoca1 = 700;
        Piedras.xRoca2 = 700;
        Piedras.yRoca2 = 100;
        Piedras.xRoca3 = - 20;
        Piedras.yRoca3 = 600;
        Piedras.xRoca4 = 300;
        Piedras.yRoca4 = -20;
        Insecto.x = 10;
        Insecto.y = 10;
        Piedras.nivel = 1;
        haChocado = false;
        Piedras.puntos = 0;       
    }
    
}