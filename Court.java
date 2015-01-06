package Tennis;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.awt.Color;

public class Court extends World{
    private Color courtColor = Color.GREEN;
    
    private Ball ball;
    private Computer computer;
    private Racket racket;
    private ComputerRacket computerRacket;
    private Player player;
    
    public Court(){
        super(700, 575, 1);
        
        getBackground().setColor(courtColor);
        this.getBackground().fillRect(0, 0, 800, 600);
        getBackground().setColor(Color.WHITE);
        this.getBackground().fillRect(150, 25, 5, 520);
        this.getBackground().fillRect(545, 25, 5, 520);
        this.getBackground().fillRect(150, 545, 400, 5);
        this.getBackground().fillRect(150, 25, 400, 5);
        this.getBackground().fillRect(150, 420, 400, 5);
        this.getBackground().fillRect(150, 165, 400, 5);
        this.getBackground().fillRect(350, 165, 5, 255);
        getBackground().setColor(Color.GRAY);
        this.getBackground().fillRect(150, 297, 400, 6);
        this.computerRacket = new ComputerRacket();
        addObject(this.computerRacket, 350, 60);
        this.ball = new Ball();
        this.computer = new Computer();
        this.racket = new Racket();
        addObject(this.racket, 350, 500);
        this.player = new Player();
        addObject(this.player, 350, 500);
        addObject(this.computer, 350, 60);
        addObject(this.ball, 350, 300);
       
    }
    public Racket getRacket(){
        return racket;
    }
    public Player getPlayer(){
        return player;
    }
    public ComputerRacket getComputerRacket(){
        return computerRacket;
    }
    public Ball getBall(){
        return ball;
    }
    
    public Computer getComputer(){
        return computer;
    }
    
    public Color getCourtColor(){
        return courtColor;
    }
}