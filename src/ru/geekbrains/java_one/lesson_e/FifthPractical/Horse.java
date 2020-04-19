package ru.geekbrains.java_one.lesson_e.FifthPractical;

public class Horse extends Animal {

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
            System.out.println("Horse has ran");
        else System.out.println("Horse hasn't ran");
    }
    @Override
    void swim(int distance){
        if (distance <= MAX_SWIM_DISTANCE)
            System.out.println("Horse has swam");
        else System.out.println("Horse hasn't swam");
    }
    @Override
    void jump(double height){
        if (height <= MAX_HEIGHT_JUMP)
            System.out.println("Horse has jumped");
        else System.out.println("Horse hasn't jumped");
    }
}
