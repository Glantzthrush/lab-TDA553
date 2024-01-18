import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.*;
public class testCar {

    Saab95 saab = new Saab95();
    Volvo240 volvo = new Volvo240();
    @Before
    public void init(){

    }
    @Test
    public void testVolvoChangeColor(){
        volvo.setColor(Color.red);
        assertTrue(volvo.getColor().equals(Color.red));
    }
    @Test
    public void testSaabChangeColor(){
        saab.setColor(Color.black);
        assertTrue(saab.getColor().equals(Color.black));
    }
    @Test
    public void testTurnLeftThenMove(){
        saab.turnLeft();
        saab.move();
        assertTrue(Math.abs(saab.x + 1) < 0.0001);
    }
    @Test
    public void testTurnRightThenMove(){
        saab.turnRight();
        saab.move();
        assertTrue(Math.abs(saab.x - 1) < 0.0001);
    }
    @Test
    public void testTurnRightThenLeft(){
        saab.turnRight();
        saab.turnLeft();
        assertTrue(saab.direction == 1);
    }
    @Test
    public void testDriveInCircle(){
        for(int i = 0; i < 3; i++){
            saab.move();
            saab.turnRight();
        }
        assertTrue(saab.direction == 0 && Math.abs(saab.x - 1) < 0.0001 &&
                                                  Math.abs(saab.y - 1) < 0.0001);
    }
    @Test
    public void testRotateCircle(){
        for(int i = 0; i < 3; i++) {
            saab.turnRight();
        }
        assertTrue(saab.direction == 0);
    }
    @Test
    public void wrongAmountGas(){
        volvo.gas(-1);


    }
}
