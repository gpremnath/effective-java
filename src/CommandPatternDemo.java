import java.util.ArrayList;
import java.util.List;

/**
 * Created by premnath on 6/12/15.
 * Command pattern is a data driven design pattern and falls under behavioral pattern category.
 * A request is wrapped under an object as command and passed to invoker object.
 * Invoker object looks for the appropriate object which can handle this command
 * and passes the command to the corresponding object which executes the command.
 *
 */
public class CommandPatternDemo {

    public static void main(String args[]){

        Item makeItem =new Item();
        makeItem.name="make item";
        makeItem.partNumber=1;

        Item breakItem =new Item();
        breakItem.name="break item";
        breakItem.partNumber=2;

        action makeAction=new MakeAction(makeItem);
        action breakAction=new BreakAction(breakItem);

        Worker worker =new Worker();
        worker.addAction(makeAction);
        worker.addAction(breakAction);

        worker.doWork();

    }



}

interface action {

    public void executeAction();

}


class MakeAction implements action{

    private Item item;

 public MakeAction(Item item){

     this.item=item;
 }

    @Override
    public void executeAction() {
        item.make();
    }
}

class BreakAction implements action{

    private Item item;

    public BreakAction(Item item){

        this.item=item;
    }

    @Override
    public void executeAction() {
        item.breaking();
    }
}

class Worker {
    List<action> actions= new ArrayList<>();

    public void addAction(action action){

        actions.add(action);
    }

    public void doWork(){

        for(action act:actions)
            act.executeAction();
    }
}

class Item {

    protected String name;
    protected Integer partNumber;


    public void make(){
        System.out.println("Making item"+name+"with "+partNumber);

    }

    public void breaking(){
        System.out.println("Breaking item"+name+"with "+partNumber);

    }

}
