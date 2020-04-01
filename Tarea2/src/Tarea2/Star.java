/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea2;

import java.awt.Graphics;

/**
 *
 * @author leandroramirez
 */
public class Star extends Item{
        
    private int direction;
    private Game game;
    
    public Star(int x, int y, int direction, int width, int height, Game game) {
        super(x, y, width, height);
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.game = game;
    }


    public int getDirection() {
        return direction;
    }


    public void setDirection(int direction) {
        this.direction = direction;
    }

    
    @Override
    public void tick() {
        //falling from the sky
        setY(getY()+1);
        
        /**
        if (getY() + 80 >= game.getHeight()) {
            setY(game.getHeight() - 80);
        }
        else if (getY() <= -20) {
            setY(-20);
        }
        **/
        
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.star, getX(), getY(), getWidth(), getHeight(), null);
    }
}
