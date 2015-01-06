package Tennis;




import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.awt.Color;

public class Ball extends Auto{
    private double speed = 0;
    private double acceleration = -14;
    private double oldAcceleration;
    private double locationX;
    private double locationY;
    private Court court;
    private GreenfootImage ball;
    private double angle = (Math.PI * 3.1/ 2);
    private double courtLeft = 150;
    private double courtRight = 550;
    private double courtBottom = 550;
    private double courtTop = 20;
    private double oldAngle;
    private int pScore = 0;
    private int cScore = 0;
    
    public Ball(){
        ball = getImage();
    }
    
   
    
    public void act(){
        moveBall();
        
        setLocation((int) locationX, (int) locationY);
        
    }
//     public double getBallX(){
//         return locationX;
//     }
//     
//     public double getBallY(){
//         return locationY;
//     }
    
    public void addedToWorld(World world){
        court = (Court) world;
        locationX = getX();
        locationY = getY();
    }
    
    private boolean isHitRacket(){
        int bottomBall = getY() + 10;
        int topBall = getY() - 10;
        int rightRacket = ((((Court) getWorld()).getRacket().getX()) + 100);
        int leftRacket = ((((Court) getWorld()).getRacket().getX()));
        int rightCompRacket = ((((Court) getWorld()).getComputerRacket().getX()) + 100);
        int leftCompRacket = ((((Court) getWorld()).getComputerRacket().getX()));
        int racketY = (((Court) getWorld()).getRacket().getY());
        int compRacketY = (((Court) getWorld()).getComputerRacket().getY());
        //acceleration = acceleration * -1;
        return (((bottomBall >= (racketY - 10)) && (bottomBall <= (racketY + 10)) && 
                    ((getX() <= rightRacket) && (getX() >= leftRacket)))   ||
               ((topBall <= (compRacketY + 10)) && (topBall >= (compRacketY - 10)) &&
                    ((getX() <= rightCompRacket) && (getX() >= leftCompRacket))));
        
        
        
        
//         Color backColor = court.getColorAt(50, 200);
//         Color topColor = court.getColorAt(getX(), getY() - 20);
//         Color bottomColor = court.getColorAt(getX(), getY() + 20);
//         return (bottomColor.equals(Color.BLACK));
    }
    
    private boolean ifHitRacket(){
        if(isHitRacket()){
            //acceleration = acceleration * -1;
            return true;
        }else{
            return false;
        }
    }
    
    
    private void moveBall(){
        if(pScore == 5) {
            ball = ((Court)getWorld()).getPlayer().getPlayer();
            locationX = 350;
            locationY = 300;
            acceleration = 0;
            setImage(ball);
        }else if(cScore == 5){
            ball = ((Court)getWorld()).getComputer().getBaby();
            locationX = 350;
            locationY = 300;
            acceleration = 0;
            setImage(ball);
        }else if ((locationY > 560) ){
            
            locationX = 350 + (acceleration * Math.cos((Math.PI * 3.1/ 2)));
            locationY = 300 + (acceleration * Math.sin((Math.PI * 3.1/ 2)));
            cScore = cScore + 1;
            setImage(ball);
        }else if((locationY < 20)){
            locationX = 350 + (acceleration * Math.cos((Math.PI * 3.1/ 2)));
            locationY = 300 + (acceleration * Math.sin((Math.PI * 3.1/ 2)));
            pScore = pScore + 1;
            setImage(ball);
            
         }else if((getX() == 350) && (getY() == 300)){
             acceleration = -15;
             angle = (Math.PI * 3.1/ 2);
             locationX = getX() + (acceleration * Math.cos(angle));
             locationY = getY() + (acceleration * Math.sin(angle));
             setImage(ball);
        }else if(this.hitLSide() || this.hitRSide()){
            angle = (Math.PI * 3.1/ 2);
            locationX = 350 + (acceleration * Math.cos((angle)));
            locationY = 300 + (acceleration * Math.sin((angle)));
            setImage(ball);
            if(getY() < 300){
                pScore = pScore + 1;
            }else{
                cScore = cScore + 1;
            };
        }else if (isHitRacket()){
            this.bounceRacket();

        }else{
            locationX = getX() + (acceleration * Math.cos(angle));
            locationY = getY() + (acceleration * Math.sin(angle));
            setImage(ball);
}
        }
    
    private boolean hitLSide(){
        return (locationX <= courtLeft);
    }
    private boolean hitRSide(){
        return (locationX >= courtRight);
    }
    
    private boolean hitTopBottom(){
        return (locationY <= courtTop) ||
        (locationY >= courtBottom);
    }
    
    public double getAngle(){
        return angle;
    }
    
//     private void bounceRacket(){
//         if((isHitRacket()) && (getY() > 400)){
//             oldAcceleration = acceleration;
//             acceleration = oldAcceleration;
//             double RA = ((Court)getWorld()).getRacket().getRotation();
//             oldAngle = angle * 180 / Math.PI;
//             angle = (360 - (2 * RA) - oldAngle) * Math.PI / 180;
//             locationY = getY() + (acceleration * Math.sin(angle));
//             setImage(ball);
//             }else{
//                 double CRA = ((Court)getWorld()).getComputerRacket().getRotation();
//                 oldAngle = angle * 180 / Math.PI;
//                 angle = (360 -(2 * CRA) - oldAngle) * Math.PI / 180;
//                 locationY = getY() + (acceleration * Math.sin(angle));
//                 setImage(ball);
//             }
//         }
    
    private void bounceRacket(){
        if ((isHitRacket()) && (getY() > 300)){
            double A = (90 + ((Court)getWorld()).getRacket().getRotation());
            angle = ((((A - (angle * 180 / Math.PI)) + 180 + A) * Math.PI / 180) - Math.PI);
            oldAcceleration = acceleration;
            acceleration = oldAcceleration * -1;
            locationY = getY() - 30 -(acceleration + Math.sin(angle));
            setImage(ball);
//         }else if((isHitRacket()) && (getY() < 400)){
//             oldAngle = angle;
//             oldAcceleration = acceleration;
//             acceleration = oldAcceleration;
//             double RA = (Math.abs( ((Court)getWorld()).getComputerRacket().getRotation()));
//             double A = 90 - RA;
//             double B = A - oldAngle;
//             double C = 2 * B + oldAngle;
//             angle = 180 + C;
//             locationY = getY() + (acceleration + Math.sin(angle));
//             setImage(ball);
            
        } else if ((isHitRacket()) && (getY() < 300)){
            double A = (90 + ((Court)getWorld()).getComputerRacket().getRotation());
            angle = ((((A - (angle * 180 / Math.PI)) + 180 + A) * Math.PI / 180));
            oldAcceleration = acceleration ;
            acceleration = oldAcceleration ;
            locationY = getY() + 30 + (acceleration + Math.sin(angle));
            setImage(ball);
        }else{
            locationY = getY() - (acceleration + Math.sin(angle));
            setImage(ball);
    }
}
            
    private void bounceWall(){
        if (this.hitLSide()){
            double oldAngle = angle;
            angle = Math.PI - oldAngle;
            locationX = getX() + (acceleration + Math.cos(angle));
            setImage(ball);
        }else if(this.hitRSide()){
            double oldAngle = angle;
            angle = Math.PI - oldAngle;
            locationX = getX() - (acceleration + Math.cos(angle));
            setImage(ball);
        }else if(this.hitTopBottom()){
            locationY = getY() - (acceleration * Math.sin(angle));
            setImage(ball);
        }else{
            //(please work)(!!)
            locationX = getX() - (acceleration + Math.cos(angle));
            setImage(ball);
        }
    } 

        
    
    //private void processKeys(){
      //  if(Greenfoot.isKeyDown("left")){
      //      location = getX() - acceleration;
      //      setImage(person);
      //  }elise if(Greenfoot.isKeyDown("right")){
      //      location = getX() + acceleration;
      //      setImage(person);
    ///    }else{
     //       setImage(person);
    //    }
   // }
}
