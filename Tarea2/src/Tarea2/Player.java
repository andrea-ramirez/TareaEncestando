/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea2;

import java.awt.Graphics;
import static java.awt.event.KeyEvent.VK_UP;

/**
 *
 * @author antoniomejorado
 */
public class Player extends Item{

    private int direction;
    private Game game;
    private boolean suelto;
    private int vel0;
    private int x0;
    private int y0;
    long time;
    
    public Player(int x, int y, int direction, int width, int height, Game game) {
        super(x, y, width, height);
        this.direction = 1;
        this.game = game;
        this.suelto = false;
        this.vel0 = 0;
        this.time = System.nanoTime();
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }


    @Override
    public void tick() {
        
        if(!suelto){
            
            if(game.getMouseManager().buttonDown(1)){
                setX(game.getMouseManager().getX());
                setY(game.getMouseManager().getY());
                if(game.getMouseManager().getX()<(game.getWidth()/6)){
                    int sp = -1*(game.getMouseManager().getX()-(game.getWidth()/6));
                    game.setSpeed(sp);
                    vel0 = sp/1000;
                    x0 = getX();
                    y0 = getY();
                    if(game.getMouseManager().isReleased(1)){
                        System.out.println("esta suelto");
                        suelto = true;
                        time = System.nanoTime();
                    }
                }
            }

        }else{
            long now = (long) ((System.nanoTime() - time)/1000000);
                
            setX((int) (x0 + (vel0*(0.525322)*now)));
            setY((int) (y0 - ((vel0*(0.850904)*now)-(4.905*now*now))));
            System.out.println((getY()));
            
        }
        

        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, getX(), getY(), getWidth(), getHeight(), null);
    }
    

}