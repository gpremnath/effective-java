/**
 * Created by premnath on 15/11/15
 *
 * Bridge is used when we need to decouple an abstraction from its implementation so that the two can vary independently.
 * This pattern involves an interface which acts as a bridge which
 * makes the functionality of concrete classes independent from  interface implementer classes.
 * Both types of classes can be altered structurally without affecting each other
 * .
 */
public class BridgePatternDemo {

    public static void main(String[] args) {
        Form redCircle = new CircularForm(100,100, 10, new RedCircle());
        Form greenCircle = new CircularForm(100,100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}

// Step 1
/*
* Create a bridge interface
*
* */


interface DrawAPI {
    public void drawCircle(int radius, int x, int y);
}

class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}

class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}


abstract class Form {
    protected DrawAPI drawAPI;

    protected Form(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }
    public abstract void draw();
}

class CircularForm extends Form {
    private int x, y, radius;

    public CircularForm(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        drawAPI.drawCircle(radius,x,y);
    }
}