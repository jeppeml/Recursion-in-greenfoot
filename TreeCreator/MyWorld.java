import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int tid=0;
    private double lengthFactor = 1.3;
    private double angleBetween = 40;
    private double asymmetryLow = 0;
    private double asymmetryHigh = 0;
    private double randomness = 0;
    private double startAngle = 90;
    private int iterations = 10;
    private boolean started = false;
    private int timer=0;

    Slider sliderLengthFactor;
    Slider sliderAngle;
    Slider sliderIterations;
    Slider sliderAsymmetryLow;
    Slider sliderAsymmetryHigh;
    Slider sliderRandomness;
    
    StartStopBtn ssb;
    
    public void act(){
        if(started)
        {
            timer++;
            sliderLengthFactor.move(1);
            sliderAngle.move(1);
            //sliderIterations.move(1);
            sliderAsymmetryLow.move(1);
            sliderAsymmetryHigh.move(1);
            sliderRandomness.move(1);
            update();
        }
        if(timer>=300)
        {
            int m = -300;
            sliderLengthFactor.move(m);
            sliderAngle.move(m);
            //sliderIterations.move(m);
            sliderAsymmetryLow.move(m);
            sliderAsymmetryHigh.move(m);
            sliderRandomness.move(m);
            startStopAnim();
            timer = 0;
            update();
        }
            
    }

    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 

        sliderLengthFactor = new Slider(30, 330, this);
        SliderBG bgLine = new SliderBG(300,30);
        addObject(bgLine, 170, 20);
        addObject(sliderLengthFactor, 30, 20);

        sliderAngle = new Slider(30,330,this);
        SliderBG bgLine2 = new SliderBG(300,30);
        addObject(bgLine2, 170, 50);
        addObject(sliderAngle, 30, 50);

        sliderIterations = new Slider(30,330,this);
        SliderBG bgLine3 = new SliderBG(300,30);
        addObject(bgLine3, 170, 80);
        addObject(sliderIterations, 30, 80);

        sliderAsymmetryLow = new Slider(30,330,this);
        SliderBG bgLine4 = new SliderBG(300,30);
        addObject(bgLine4, 170, 110);
        addObject(sliderAsymmetryLow, 30, 110);

        sliderAsymmetryHigh = new Slider(30,330,this);
        SliderBG bgLine5 = new SliderBG(300,30);
        addObject(bgLine5, 170, 140);
        addObject(sliderAsymmetryHigh, 30, 140);

        sliderRandomness = new Slider(30,330,this);
        SliderBG bgLine6 = new SliderBG(300,30);
        addObject(bgLine6, 170, 170);
        addObject(sliderRandomness, 30, 170);

        ssb = new StartStopBtn(this);
        addObject(ssb, 550,550);
        iterations = 10;
        randomness = 0;
        asymmetryLow = 0;
        asymmetryHigh = 0;
        drawit(startAngle,iterations);
        Greenfoot.start();
    }

    public void update(){

        // 2-181
        angleBetween = (179*(sliderAngle.getX()-30))/300+2;
        // 1,3 to 1,7
        lengthFactor = (0.4*(sliderLengthFactor.getX()-30))/300+1.3;
        // 8-20
        iterations = (12*(sliderIterations.getX()-30))/300+8;
        // 0-100
        randomness = (100*(sliderRandomness.getX()-30))/300+0;
        asymmetryLow = (100*(sliderAsymmetryLow.getX()-30))/300+0;
        asymmetryHigh = (100*(sliderAsymmetryHigh.getX()-30))/300+0;
        drawit(startAngle,iterations);
    }

    private void drawit(double angle, int iterations){
        clearScreen();
        DrawLineLAngle(0,this.getHeight()/2, angle,125,iterations);
    }

    public void DrawLineLAngle(int x1, int y1, double angle, double length, int stopIt)
    {
        int x2 = x1 + (int)(length * Math.sin((angle) * (Math.PI/180)));
        int y2 = y1 + (int)(length * Math.cos((angle) * (Math.PI/180)));
        DrawLine(x1, y1, x2, y2);

        if (stopIt>0)
        {
            stopIt -= 1;
            double thisRand = Math.floor(Math.random()*(randomness+1))/10;
            if (Math.random()>0.5) thisRand*=-1;
            if (Math.random()>0.5) thisRand=0;
            DrawLineLAngle(x2, y2, angle-(angleBetween/2)-asymmetryHigh+thisRand, length/lengthFactor, stopIt);

            thisRand = Math.floor(Math.random()*(randomness+1))/10;
            if (Math.random()>0.5) thisRand*=-1;
            if (Math.random()>0.5) thisRand=0;
            DrawLineLAngle(x2, y2, angle+(angleBetween/2)+asymmetryLow+thisRand, length/lengthFactor, stopIt);

        }
    }

    public void DrawLine(int x1, int y1, int x2, int y2)
    {   
        getBackground().setColor(new Color(0,0,0));
        getBackground().drawLine(x1, y1, x2, y2);
    }

    public void clearScreen(){
        getBackground().setColor(new Color(255,255,255));
        getBackground().fill();
    }
    
    public void startStopAnim(){
        
        started=!started;
        ssb.setStarted(started);
        timer = 0;
        if(started)
        {
            sliderLengthFactor.setLocation(
                30, 
                sliderLengthFactor.getY());
            sliderAngle.setLocation(
                30, 
                sliderAngle.getY());
            //sliderIterations.move(1);
            sliderAsymmetryLow.setLocation(
                30, 
                sliderAsymmetryLow.getY());
            sliderAsymmetryHigh.setLocation(
                30, 
                sliderAsymmetryHigh.getY());
            sliderRandomness.setLocation(
                30, 
                sliderRandomness.getY());
            update();
        }
    }
}
