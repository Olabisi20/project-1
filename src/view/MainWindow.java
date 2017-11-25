package view;

import controller.ButtonListener;
import controller.KeyController;
import controller.Main;
import controller.MouseController;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {
    public static JButton startGame;
    public static JButton quitButton;
   // public static JButton addUfoButton;
    public static MouseController mouseController;

    public MainWindow() {

        Container c = getContentPane();
      
        c.add(Main.gamePanel, "Center");

        JPanel southPanel = new JPanel();
        //startGame = new JButton("Start Game");
        //southPanel.add(startGame);
        
       
        
       // addUfoButton = new JButton("Add UFO");
       // southPanel.add(addUfoButton);
        
        quitButton = new JButton("Quit Game");
        southPanel.add(quitButton);
        c.add(southPanel, "South");
        
        

        ButtonListener buttonListener = new ButtonListener();
       // startGame.addActionListener(buttonListener);
        //addUfoButton.addActionListener(buttonListener);
        quitButton.addActionListener(buttonListener);

        mouseController = new MouseController();
        Main.gamePanel.addMouseListener(mouseController);
        Main.gamePanel.addMouseMotionListener(mouseController);

        KeyController keyListener = new KeyController();
        Main.gamePanel.addKeyListener(keyListener);
        Main.gamePanel.setFocusable(true);
        // just have one Component "true", the rest must be "false"
        //startGame.setFocusable(false);
        //addUfoButton.setFocusable(false);
        quitButton.setFocusable(false);
    }

    

}
