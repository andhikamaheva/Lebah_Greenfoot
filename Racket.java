package Tennis;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;
import java.awt.Color;

public class Racket extends Actor{
    private double speed = 0;
    private double acceleration = 10;
    private double locationX;
    private double locationY;
    private Court court;
    private GreenfootImage racket;
    private static GreenfootImage[] images;
    private double rotationAngle = -5;
    private double oldRotationAngle;
    
//     private void rotateRacket(){
//         if (rotationAngle == -90){
//             double rotationAngle = 0;
//         }else if(rotationAngle < 0){
//             double oldRotationAngle = rotationAngle;
//             rotationAngle = oldRotationAngle - 5;
//         }else{
//             rotationAngle = 0;
//         }
//     }
//     private double getRotationAngle(){
//         return rotationAngle;
//     }
    
   

//  private void rotate(){
//         if (rotationAngle == -90){
//             double rotationAngle = 0;
//         }else if (rotationAngle < 0){
//             double oldRotationAngle = rotationAngle;
//             this.setRotation(-5);
//             
//             rotationAngle = oldRotationAngle - 5;
//             this.rotate();
//         }else{
//             setImage(racket);
//         }
//     }
    
//       private void drawRacket(){
//           this.getImage().drawLine(500, 400, 530, 400);
//               }
     
     
              
     public Racket(){
         racket = getImage();
         
     }
//     public Racket(){
//         racket = (drawLine(500, 400, 530, 400)
//               && drawLine(500, 401, 530, 401)
//               && drawLine(500, 402, 530, 402)
//               && drawLine(500, 403, 530, 403)
//               && drawLine(500, 404, 530, 404)
//               && drawLine(500, 405, 530, 405)
//               && drawLine(500, 406, 530, 406) 
//               && drawLine(500, 407, 530, 407)
//               && drawLine(500, 408, 530, 408)
//               && drawLine(500, 409, 530, 409));
//     }
    
    public void act(){
        move();
        
        setLocation((int) locationX, (int) locationY);
        
    }
    
    
    public void addedToWorld(World world){
        court = (Court) world;
        locationX = getX();
        locationY = getY();
    }
    
    
    
//     private boolean hitBottom(){
//         return (locationY >= courtBottom);
//     }
//     private boolean hitTop(){
//         return (locationY <= courtTop);
//     }
//     
//     
//     public double getAngle(){
//         return angle;
//     }
//     private void bounceRacket(){
//         if (this.hitLSide()){
//             double oldAngle = angle;
//             angle = Math.PI - oldAngle;
//             locationX = getX() - (acceleration + Math.cos(angle));
//             setImage(ball);
//         }else if(this.hitRSide()){
//             double oldAngle = angle;
//             angle = Math.PI - oldAngle;
//             locationX = getX() + (acceleration + Math.cos(angle));
//             setImage(ball);
//         }else if(this.hitTopBottom()){
//             locationY = getY() - (acceleration * Math.sin(angle));
//             setImage(ball);
//         }else{
//             //(please work)(!!)
//             locationX = getX() - (acceleration + Math.cos(angle));
//             setImage(ball);
//         }
//     } 
//     
    
private void move(){
    
        processKeys();
    }

    private void initializeRotation(){
        if((rotationAngle < 0) && (rotationAngle > -90)){
            setRotation(getRotation() - 5);
        }else{
            setImage(this.racket);
        }
    }

private void processKeys(){
        if(Greenfoot.isKeyDown("left") && Greenfoot.isKeyDown("up")){
            locationX = getX() - acceleration;
            setRotation(getRotation() - 5);
            oldRotationAngle = rotationAngle;
            rotationAngle = oldRotationAngle - 5;
        }else if(Greenfoot.isKeyDown("left") && Greenfoot.isKeyDown("down")){
            locationX = getX() - acceleration;
            setRotation(getRotation() + 5);
            oldRotationAngle = rotationAngle;
            rotationAngle = oldRotationAngle + 5;
        }else if(Greenfoot.isKeyDown("left")){
            locationX = getX() - acceleration;
            setImage(racket);
        }else if(Greenfoot.isKeyDown("right") && Greenfoot.isKeyDown("down")){
            locationX = getX() + acceleration;
            setRotation(getRotation() + 5);
            oldRotationAngle = rotationAngle;
            rotationAngle = oldRotationAngle + 5;
        }else if(Greenfoot.isKeyDown("right") && Greenfoot.isKeyDown("up")){
            locationX = getX() + acceleration;
            setRotation(getRotation() - 5);
            oldRotationAngle = rotationAngle;
            rotationAngle = oldRotationAngle - 5;
        }else if(Greenfoot.isKeyDown("right")){
            locationX = getX() + acceleration;
            setImage(racket);
//         }else if(Greenfoot.isKeyDown("space")){
//             locationY = getY() - acceleration;
        }else if(Greenfoot.isKeyDown("up")){
            
            setRotation(getRotation() - 5);
            oldRotationAngle = rotationAngle;
            rotationAngle = oldRotationAngle - 5;
        }else if(Greenfoot.isKeyDown("down")){
            setRotation(getRotation() + 5);
            oldRotationAngle = rotationAngle;
            rotationAngle = oldRotationAngle + 5;
        
//          }else if(rotationAngle < 0){
//              this.setRotation((int) rotationAngle);
//              this.rotateRacket();
//              setImage(racket);
        }else{
            setImage(racket);
        }
        
    }
}