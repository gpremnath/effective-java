import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by premnath on 6/11/15.
 */
public class GenericLessons implements Expe <String> {

    public static void main (String args[]){

        Collection<? super Shape> c = new ArrayList();
        c.add(new Circle());

        List <? extends Shape> shapes= (List<? extends Shape>) new Canvas().createShapes();//new ArrayList();
        /*Circle circle=new Circle();
        shapes.add(circle);
        Rectangle rectangle=new Rectangle();
        shapes.add(rectangle);*/
        Canvas canvas=new Canvas();
        canvas.drawAll(shapes);

    }

    @Override
    public <T extends String> void test() {

    }
}

interface Expe <T>  {

      <T extends  String> void test ();

 }

 abstract class Shape {
    public abstract void draw(Canvas c);
}

 class Circle extends Shape {
    private int x, y, radius;
    public void draw(Canvas c) {
        System.out.println("Drawing circle");
    }
}

 class Rectangle extends Shape {
    private int x, y, width, height;
    public void draw(Canvas c) {
        System.out.println("Drawing Rectangle");
    }
}

 class Canvas {
    public void draw(Shape s) {
        s.draw(this);
    }

     public void drawAll(List<? extends Shape> shapes) {
         for (Shape s: shapes) {
             s.draw(this);
         }
     }


     public List <? super Shape> createShapes(){
         List <? super Shape> l=new ArrayList();
         Rectangle r =new Rectangle();
         Circle c=new Circle();
         l.add(c);
         l.add(r);
      return l;
     }
}