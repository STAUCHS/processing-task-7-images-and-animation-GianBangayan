import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

  // Create Image Variables
  PImage imgTenisCourt;
  PImage imgTenisRaquet;
  PImage imgTenisBall;

  // define and ball starting position
  float fltBallX = 20;
  float fltBallY = 80;

  // define raquet variables
  float fltRaquetX = 0;
  float fltRaquetY = 0;
  float fltAngle = 0;

  //Speed Variable for Tennis Ball
  float speedBallY = 2;
  float speedBallX = 2;


  //set window size
  public void settings() {
    size(400, 250);
  }

  public void setup() {
    //Define Images 
    imgTenisBall = loadImage("tensBal.png");
    imgTenisRaquet = loadImage("tensRaket.png");
    imgTenisCourt = loadImage("tensCort.png");
    background(imgTenisCourt);
  }

  public void draw() {
    //draw background
    background(imgTenisCourt);  

    // draw objects
    image(imgTenisBall, fltBallX, fltBallY);
    image(imgTenisRaquet, fltRaquetX, fltRaquetY);
    image(imgTenisRaquet, fltRaquetX + 350, 225 - fltRaquetY);
    
    //Change Ball positions
    fltBallX += speedBallX;
    fltBallY += speedBallY;
    
    //draw Ball shadow
    ellipse(fltBallX+22, fltBallY+100, 40, 40);
    fill(200);

    //Check for collsisions, and make it bounce when touching a wall 
    if(fltBallX > width - imgTenisBall.width || fltBallX < 0){
      speedBallX *= -1;
      speedBallY *= 1;
    }
    if(fltBallY > height - imgTenisBall.height || fltBallY < 0){
      speedBallY *= -1;
      speedBallX *= 1;
    }

    //Make raquet follow an oval path
    fltRaquetY = sin(fltAngle) * 100 + 110;
    fltRaquetX = cos(fltAngle) * 50 + 10;
    fltAngle -= 0.05;
  }

}