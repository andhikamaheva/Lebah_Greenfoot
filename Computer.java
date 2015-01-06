package Tennis;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


import java.awt.Color;

public class Computer extends Auto{
    private double speed = 0;
    private double acceleration = 10;
    private double location;
    private double oldAcceleration;
    private Court court;
    private GreenfootImage baby;
    //private Ball ball;
    
    public Computer(){
        baby = getImage();
    }
    public GreenfootImage getBaby(){
        return baby;
    }
    
    public void act(){
        
        move();
        
        setLocation((int) location, getY());
        
    }
    
    
    
    public void addedToWorld(World world){
        court = (Court) world;
        
        location = getX();
    }
    
    
    
    private void move(){
        if(((Court)getWorld()).getBall().getX() > this.getX() + 50){
            oldAcceleration = acceleration;
            location = getX() + oldAcceleration;
            setImage(baby);
        }else if(getBallX() < this.getX() + 50){
            oldAcceleration = acceleration * -1;
            location = this.getX() + oldAcceleration;
            setImage(baby);
        }else{
            setImage(baby);
        }
        
        
    }
    public double getOldAccel(){
        return oldAcceleration;
    }
}