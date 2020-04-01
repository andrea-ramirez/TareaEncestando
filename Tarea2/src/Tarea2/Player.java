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
    //private boolean wall;

    
    public Player(int x, int y, int direction, int width, int height, Game game) {
        super(x, y, width, height);
        this.direction = 1;
        this.game = game;
        //this.wall = false;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }


    @Override
    public void tick() {
        
        // moving player depending on flags
        if (game.getKeyManager().up) {
           setY((getY() - 1)*direction);
        }
        if (game.getKeyManager().down) {
           setY((getY() + 1)*direction);
        }
        if (game.getKeyManager().left) {
           setX((getX() - 1)*direction);
        }
        if (game.getKeyManager().right) {
           setX((getX() + 1)*direction);
        }
        
        // reset x position and y position if colision with wall
        //right
        if (getX() + 60 >= game.getWidth()) {
            setX(game.getWidth() - 60);
            //wall = true;
            
        }//left
        else if (getX() <= -30) {
            setX(-30);
            //wall = true;
            setDirection(0);
        }
        if (getY() + 80 >= game.getHeight()) {
            setY(game.getHeight() - 80);
            //wall = true;
        }
        else if (getY() <= -20) {
            setY(-20);
            //wall = true;
        }

        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, getX(), getY(), getWidth(), getHeight(), null);
    }
    

}