package Tennis;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.awt.Color;

public class Player extends Actor{
    private double speed = 0;
    private double acceleration = 10;
    private double location;
    private Court court;
    private GreenfootImage person;
    
    public Player(){
        person = getImage();
    }
    public GreenfootImage getPlayer(){
        return person;
    }
    
    public void act(){
        processKeys();
        
        setLocation((int) location, getY());
        
    }
    
    public void addedToWorld(World world){
        court = (Court) world;
        location = getX();
    }
    
    private void processKeys(){
        if(Greenfoot.isKeyDown("left")){
            location = getX() - acceleration;
            setImage(person);
        }else if(Greenfoot.isKeyDown("right")){
            location = getX() + acceleration;
            setImage(person);
        }else{
            setImage(person);
        }
    }
}