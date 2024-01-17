import java.awt.*;

public abstract class Car {
    protected final int nrDoors; // Number of doors on the car
    protected final double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected final String modelName; // The car model name
    public Car (int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
    }


    public abstract int getNrDoors();
    public abstract double getEnginePower();

    public abstract double getCurrentSpeed();

    public abstract Color getColor();

    public abstract void setColor();

    public abstract void startEngine();

    public abstract void stopEngine();

    public abstract double speedFactor();

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
}
