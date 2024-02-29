package org.example;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    final short BLOCK_WIDTH = 800;
    final short BLOCK_HEIGHT = 800;
    final short BLOCK_SIZE = 8;
    final short COLOR_COUNT = 4;
    Color[] bColors = new Color[COLOR_COUNT];

    void color_pick() {
        bColors[0] = Color.RED;
        bColors[1] = Color.GREEN;
        bColors[2] = Color.BLUE;
        bColors[3] = Color.BLACK;
    }
    public Window() {
        setSize(BLOCK_WIDTH, BLOCK_HEIGHT + 35);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        color_pick();
        JButton updateButton = new JButton("Update");
        updateButton.setBounds(BLOCK_WIDTH / 2 - 50, BLOCK_HEIGHT + 10, 100, 30);
        updateButton.addActionListener((arg0) -> repaint());
        add(updateButton, BorderLayout.SOUTH);
        setVisible(true);
        validate();
    }
    public void drawBlock(Graphics g, Color color, Point pos) {
        g.setColor(color);
        g.fillRect(pos.x, pos.y, BLOCK_SIZE, BLOCK_SIZE);
    }
    @Override
    public void paint(Graphics g) {
        long start = System.currentTimeMillis();
        Point bPoint = new Point(0, 28);
        while(bPoint.getY() < BLOCK_HEIGHT) {
            while(bPoint.getX() < BLOCK_WIDTH) {
                drawBlock(g, bColors[(int) (Math.random() * COLOR_COUNT)], bPoint);
                bPoint.x += BLOCK_SIZE;
            }
            bPoint.x = 0;
            bPoint.y += BLOCK_SIZE;
        }
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("Прошло времени, мс: " + elapsed);
    }
}
