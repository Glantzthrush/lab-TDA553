import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;
    
    public Saab95(){
        super(2,Color.red,125,"Saab95");
        this.turboOn = false;
        stopEngine();
    }

    @Override
    public int getNrDoors(){
        return nrDoors;
    }
    @Override
    public double getEnginePower(){
        return enginePower;
    }
    @Override
    public double getCurrentSpeed(){
        return currentSpeed;
    }
    @Override
    public Color getColor(){
        return color;
    }
    @Override
    public void setColor(Color clr){
	    color = clr;
    }
    @Override
    public void startEngine(){
	    currentSpeed = 0.1;
    }
    @Override
    public void stopEngine(){
	    currentSpeed = 0;
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
    @Override
    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }
    @Override
    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
    
    // TODO fix this method according to lab pm
    @Override
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    @Override
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
