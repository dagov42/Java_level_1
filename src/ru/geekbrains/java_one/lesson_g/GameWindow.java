package ru.geekbrains.java_one.lesson_g;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private static final int WIN_WIDTH = 507;
    private static final int WIN_HEIGHT = 555;
    private static final int WIN_POS_X = 650;
    private static final int WIN_POS_Y = 250;
    private SettingsWindow settingsWindow;
    private Map map;

    GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Задаем размер и положение окна
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setLocation(WIN_POS_X, WIN_POS_Y);
        // Заголовок формы
        setTitle("Tic Tac Toe");
        setResizable(false);
        // Кнопки для начала и завершения игры
        JButton btnStart = new JButton("<html><body><p style=\"color:White\">Start new game</p></body></html>");
        btnStart.setBackground(Color.GREEN);
        JButton btnExit = new JButton("<html><body><p style=\"color:White\">Exit game</p></body></html>");
        btnExit.setBackground(Color.RED);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(true);
            }
        });
        // Добавляем обработчик событий для закрытия формы
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        // Создаём панель для кнопок табличного стиля
        JPanel panelBottom = new JPanel(new GridLayout(1, 2));
        // Привязываем кнопки к панели
        panelBottom.add(btnStart);
        panelBottom.add(btnExit);
        map = new Map();
        // this ссылается на текущий объект GW, который мы передаем в SW
        settingsWindow = new SettingsWindow(this);

        add(panelBottom, BorderLayout.SOUTH);
        add(map);
        setVisible(true);
    }

    void startGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        map.startNewGame(gameMode, fieldSizeX, fieldSizeY, winLength);
    }
}
