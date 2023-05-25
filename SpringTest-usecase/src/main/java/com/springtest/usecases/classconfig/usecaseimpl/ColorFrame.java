package com.springtest.usecases.classconfig.usecaseimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

@Component
public class ColorFrame extends JFrame {

    /**
     * Инжект контекса чтобы получить из него бин класса Color
     */
    @Autowired
    private ApplicationContext context;

    public  ColorFrame(){
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace(){
        Random random = new Random();
        setLocation(random.nextInt(1200), random.nextInt(700));
        getContentPane().setBackground(context.getBean(Color.class));
        repaint();
    }
}
