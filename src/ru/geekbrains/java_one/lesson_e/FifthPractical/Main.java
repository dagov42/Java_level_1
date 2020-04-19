package ru.geekbrains.java_one.lesson_e.FifthPractical;

public class Main {
    public static int distanceToRun = 100;
    public static int distanceToSwim = 500;
    public static int heightToJump = 5;

    //                cat, dog, horse, bird
    static int[] maxRun = {200, 500, 1500, 15};
    static int[] maxSwim = {0, 10, 100, 0};
    static double[] maxJump = {2, 0.5, 3, 0.2};


    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Horse horse = new Horse();
        Bird bird = new Bird();


        Animal[] zoo = {cat, dog, horse, bird};
        for (int i = 0; i < zoo.length; i++) {
            zoo[i].setMAX_RUN_DISTANCE(maxRun[i]);
            zoo[i].setMAX_SWIM_DISTANCE(maxSwim[i]);
            zoo[i].setMAX_HEIGHT_JUMP(maxJump[i]);
            zoo[i].run(distanceToRun);
            zoo[i].swim(distanceToSwim);
            zoo[i].jump(heightToJump);
        }
    }
}
