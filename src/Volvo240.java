import java.awt.*;

import static java.lang.System.out;

public class Volvo240 extends Car{

    public final static double trimFactor = 1.25;
    private double currentSpeed; // The current speed of the car
    
    public Volvo240(){
        super(4,Color.black,100,"Volvo240");
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
    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
    @Override
    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
        if(currentSpeed > enginePower){
            currentSpeed = enginePower;
        }
    }
    @Override
    public void decrementSpeed(double amount){
        if (getCurrentSpeed() > enginePower){
            currentSpeed = enginePower;
        }
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
        if (currentSpeed < 0){
            currentSpeed = 0;
        }

    }

    // TODO fix this method according to lab pm
    @Override
    public void gas(double amount){
        if(amount < 0 || amount > 1){
            throw new IllegalArgumentException("Wrong gas amount. Insert amount between 0 and 1");
        }
        double oldSpeed = currentSpeed;
        incrementSpeed(amount);
        if(oldSpeed > currentSpeed){

        }

    }
    // TODO fix this method according to lab pm
    @Override
    public void brake(double amount){
        if(amount < 0 || amount > 1){
            throw new IllegalArgumentException("Wrong break amount. Insert amount between 0 and 1");
        }
        decrementSpeed(amount);
    }

}
