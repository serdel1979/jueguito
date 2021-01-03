/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoarana;

import java.awt.Graphics;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;

public class Piedras {

    public static int xRoca1 = 600, yRoca1 = 700;
    public static int xRoca2 = 700, yRoca2 = 100;
    public static int xRoca3 = 20, yRoca3 = 600;
    public static int xRoca4 = 300, yRoca4 = 20;

    public static int puntos = 0;
    public JuegoArana j;
    public static int nivel = 1;
    int incremento = 2;

    Area r1, r2, r3, r4, rocaArea;
    int inicioy = 0;
    int iniciox = 0;
    int finy = 700;
    int finx = 700;

    //constructor
    public Piedras(JuegoArana j2) {
        this.j = j2;
    }

    
    

    public void paint(Graphics g){
        ImageIcon piedra = new ImageIcon(getClass().getResource("../imagenes/piedra.png"));
        
        if (nivel >= 1){
            g.drawImage(piedra.getImage(), xRoca1, yRoca1, 48,48,null);
        }
        if (nivel >= 2){
            g.drawImage(piedra.getImage(), xRoca2, yRoca2, 48,48,null);
        }
        if (nivel >= 3){
            g.drawImage(piedra.getImage(), xRoca3, yRoca3, 48,48,null);
        }
        if (nivel >= 4){
            g.drawImage(piedra.getImage(), xRoca4, yRoca4, 48,48,null);
        }  
    }
    
    public boolean choque(){
        Area areaPersonaje = new Area(j.bicho.getBoundsbicho());
        areaPersonaje.intersect(getBoundsPiedra());
        return !areaPersonaje.isEmpty();
    }
    
    public void mover(){
        if(choque()){
            j.haChocado = true;
        }
        if(j.bicho.llegaFinal()){
            nivel ++;
            Insecto.x = 10;
            Insecto.y = 10;
        }
        if (nivel >= 1){
            if(yRoca1 == -20){
                yRoca1 = 700;
                xRoca1 = (int)(Math.random()*(finx-iniciox)+iniciox);
                puntos++;
            }else{
                yRoca1 = yRoca1 - incremento;
            }
        }
        
        if (nivel >= 2){
            if(yRoca2 == -20){
                yRoca2 = 700;
                xRoca2 = (int)(Math.random()*(finx-iniciox)+iniciox);
                puntos++;
            }else{
                yRoca2 = yRoca2 - incremento;
            }
        }
        
        if (nivel >= 3){
            if(yRoca3 == -20){
                yRoca3 = 700;
                xRoca3 = (int)(Math.random()*(finx-iniciox)+iniciox);
                puntos++;
            }else{
                yRoca3 = yRoca3 - incremento;
            }
        }
        
        if (nivel >= 3){
            if(yRoca4 == -20){
                yRoca4 = 700;
                xRoca4 = (int)(Math.random()*(finx-iniciox)+iniciox);
                puntos++;
            }else{
                yRoca4 = yRoca4 - incremento;
            }
        }
    }
    
    public int obtenerPuntos(){
        return puntos;
    }
    
    public Area getBoundsPiedra(){
        Ellipse2D piedra1, piedra2, piedra3, piedra4;
        piedra4 = new Ellipse2D.Double(xRoca1, yRoca1, 48, 48);
        r4 = new Area(piedra4);
        rocaArea = r4; 
        
        if(nivel >= 1){
            piedra1 = new Ellipse2D.Double(xRoca2, yRoca2, 48, 48);
            r1 = new Area(piedra1);
            rocaArea.add(r1);
        }
        if(nivel >= 2){
            piedra2 = new Ellipse2D.Double(xRoca2, yRoca2, 48, 48);
            r2 = new Area(piedra2);
            rocaArea.add(r2);
        }
        if(nivel >= 3){
            piedra3 = new Ellipse2D.Double(xRoca3, yRoca3, 48, 48);
            r3 = new Area(piedra3);
            rocaArea.add(r3);
        }
        if(nivel >= 4){
            piedra4 = new Ellipse2D.Double(xRoca4, yRoca4, 48, 48);
            r4 = new Area(piedra4);
            rocaArea.add(r4);
        }
        return rocaArea;
    }
}
