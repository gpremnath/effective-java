/**
 * Created by premnath on 12/11/15.
 *
 * Intent
 * --------
 * Provide a surrogate or placeholder for another object to control access to it.
 * Use an extra level of indirection to support distributed, controlled, or intelligent access.
 * Add a wrapper and delegation to protect the real component from undue complexity.
 * ----------------------------------------------------------------------------------
 * Problem
 * ---------
 * You need to support resource-hungry objects, and you do not want to instantiate such objects unless
 * and until they are actually requested by the client.
 *
 */
public class ProxyPatternDemo {

    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        //image will be loaded from disk
        image.display();
        System.out.println("");

        //image will not be loaded from disk
        image.display();
    }

}

interface Image {
    void display();
}

class RealImage implements Image{
    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
    }
}

class ProxyImage implements Image{
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }

}