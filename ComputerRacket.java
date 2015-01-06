package Tennis;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ComputerRacket extends Actor{
    private double speed = 0;
    private double acceleration = 10;
    private double locationX ;
    private double locationY;
    private Court court;
    private GreenfootImage compRacket;
    private static GreenfootImage[] images;
    private double rotationAngle = -5;
    private double oldRotationAngle;
    
    public ComputerRacket(){
        compRacket = getImage();
    }
    
   
    
    public void act(){
        move();
        
        setLocation((int) (((Court) getWorld()).getComputer().getX()), (int) locationY);
        
    }
    
    
    public void addedToWorld(World world){
        court = (Court) world;
        locationX = getX();
        locationY = getY();
    }
    

    private void move(){
        if(((Court) getWorld()).getComputer().getOldAccel() > 0){
              setRotation(getRotation() - (int) Math.atan((((locationX - 400) / 300) * 180) / Math.PI));
    }else if(((Court) getWorld()).getComputer().getOldAccel() < 0){
              setRotation(getRotation() + (int) Math.atan((((locationX - 400) / 300) * 180) / Math.PI));
    }else{
        setRotation(0);
    }
}


}