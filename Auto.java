package Tennis;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public abstract class Auto extends Actor{
    public void act(){
    }
    
    public void addedToWorld(World world){
    }
    
    public double getBallX(){
        if (this instanceof Ball){
            Ball b = (Ball) this;
            return b.getX();
    }else{
        return 0;
    }
}
    
    public double getBallY(){
        Ball b = (Ball) this;
        return b.getY();
    }
}