import java.awt.*;

public abstract class Car implements Movable{
    protected final int nrDoors; // Number of doors on the car
    protected final double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected final String modelName; // The car model name
    protected double x = 0;
    protected double y = 0;
    protected int direction = 0; // 0 = Upp, 1 == Höger, 2 = Ner, 3 = Vänster

    public Car(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;


    }
    @Override
    public void move(){
        double speed = getCurrentSpeed();
        switch(direction){
            case 0:
                //Go up
                y += speed;
                break;
            case 1:
                // Go right
                x += speed;
                break;
            case 2:
                // Go down
                y -= speed;
                break;
            case 3:
                // Go left
                x -= speed;
                break;
            default:
                throw new IllegalArgumentException("Direction out of range [0,3]");
        }
    }

    @Override
    public void turnLeft() {
        direction = (direction - 1) % 4;
    }

    @Override
    public void turnRight() {
        direction = (direction + 1) % 4;
    }

    public abstract int getNrDoors();

    public abstract double getEnginePower();

    public abstract double getCurrentSpeed();

    public abstract Color getColor();

    public abstract void setColor(Color clr);

    public abstract void startEngine();

    public abstract void stopEngine();

    public abstract double speedFactor();

    public abstract void incrementSpeed(double amount);

    public abstract void decrementSpeed(double amount);

    public abstract void gas(double amount);

    public abstract void brake(double amount);
}
