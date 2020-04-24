package ru.geekbrains.java_one.lesson_e.FifthPractical;

public class Cat extends Animal {

    public void setMAX_RUN_DISTANCE(int MAX_RUN_DISTANCE) {
        this.MAX_RUN_DISTANCE = MAX_RUN_DISTANCE;
    }

    public void setMAX_SWIM_DISTANCE(int MAX_SWIM_DISTANCE) {
        this.MAX_SWIM_DISTANCE = MAX_SWIM_DISTANCE;
    }

    public void setMAX_HEIGHT_JUMP(double MAX_HEIGHT_JUMP) {
        this.MAX_HEIGHT_JUMP = MAX_HEIGHT_JUMP;
    }

    @Override
   void run(int distance){
       if (distance <= MAX_RUN_DISTANCE)
           System.out.println("Cat has ran");
       else System.out.println("Cat hasn't ran");
   }
   @Override
   void swim(int distance){
       System.out.println("Cat can't swim");
   }
   @Override
   void jump(double height){
        if (height <= MAX_HEIGHT_JUMP)
            System.out.println("Cat has jumped");
        else System.out.println("Cat hasn't jumped");
   }
}
