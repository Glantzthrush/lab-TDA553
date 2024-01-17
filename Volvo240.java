import java.awt.*;

public class Volvo240 extends Car{

    public final static double trimFactor = 1.25;
    private double currentSpeed; // The current speed of the car
    
    public Volvo240(double trimFactor, double currentSpeed){
        super(4,Color.black,100,"Volvo240");
        this.currentSpeed = currentSpeed;
        stopEngine();
    }
    @Override
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

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
    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
    @Override
    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }
    @Override
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
