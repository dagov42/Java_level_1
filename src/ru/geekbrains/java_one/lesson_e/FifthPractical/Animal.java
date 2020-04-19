package ru.geekbrains.java_one.lesson_e.FifthPractical;

import javax.swing.*;

public abstract class Animal {

    public int MAX_RUN_DISTANCE;
    public int MAX_SWIM_DISTANCE;
    public double MAX_HEIGHT_JUMP;

    abstract void run(int distance);
    abstract void swim(int distance);
    abstract void jump(double height);

    public abstract void setMAX_RUN_DISTANCE(int i);

    public abstract void setMAX_SWIM_DISTANCE(int i);

    public abstract void setMAX_HEIGHT_JUMP(double v);
}
