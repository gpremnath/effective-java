/**
 * Created by premnath on 8/12/15.
 */
public class OuterClass {

    private String message="hello outer";

    private class inner {

       String message="hello inner";

        public void printMessage(String message){
            System.out.println(message);
            System.out.println(this.message);
            System.out.println(OuterClass.this.message);
        }
    }


    public static void main(String args[]){

        OuterClass outer= new OuterClass();
        OuterClass.inner inner= outer.new inner();
        inner.printMessage("hello method");
    }

}
