/**
 * Created by premnath on 4/11/15.
 */
public class BuilderPatternDemo {

    public static void main (String args[]){

        Meals meals=new Meals.MealBuilder().chicken("chicken")
                .mutton("mutton")
                .rice("rice")
                .sambar("sambar")
                .vegcurry("vegcurry").build();

    }
}

class Meals{

    private String rice;
    private String chicken;
    private String mutton;
    private String sambar;
    private String vegcurry;
    private String vegkabab;

    static class MealBuilder{
        public MealBuilder rice(String rice) {
            this.rice = rice;
            return this;
        }

        public MealBuilder chicken(String chicken) {
            this.chicken = chicken;
            return this;
        }

        public MealBuilder mutton(String mutton) {
            this.mutton = mutton;
            return this;
        }

        public MealBuilder sambar(String sambar) {
            this.sambar = sambar;
            return this;
        }

        public MealBuilder vegcurry(String vegcurry) {
            this.vegcurry = vegcurry;
            return this;
        }

        public MealBuilder vegkabab(String vegkabab) {
            this.vegkabab = vegkabab;
            return this;
        }

        private String rice;
        private String chicken;
        private String mutton;
        private String sambar;
        private String vegcurry;
        private String vegkabab;
        Meals build(){

            return new Meals(this);
        }

    }


     private Meals (MealBuilder mealBuilder){
             chicken = mealBuilder.chicken;
             mutton = mealBuilder.mutton;
             rice = mealBuilder.rice;
             vegcurry=mealBuilder.vegcurry;
             sambar=mealBuilder.sambar;
             vegkabab=mealBuilder.vegkabab;
         }




}