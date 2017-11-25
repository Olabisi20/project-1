/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Graphics2D;

/**
 *
 * @author Olabisi
 */
public class Score implements Observer {
 public int score =0;
    @Override
    public void update(int n) {
        score=n;
    }
    public void render (Graphics2D g2){
        g2.drawString("Score: " + score, 550, 50);
    }
}
