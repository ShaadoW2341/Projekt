import Execptions.ClassNotChoosenException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WyborKlasy extends JFrame {
    private Gracz gracz;
    private JPanel panel1;
    private JButton wojownikButton;
    private JButton lucznikButton;
    private JTextField nameCharacter;
    private static String playerName;
    int width = 600, height = 400;


    private void savePlayerName(String name) {
        this.playerName = name;
    }

    public static String getPlayerName(){
        return playerName;
    }

    public WyborKlasy() {
        this.setLocationRelativeTo(null);
        this.setSize(width,height);
        this.setContentPane(this.panel1);
        this.setVisible(true);
        lucznikButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gracz = Gracz.StworzGracza(30000, 2, 8, Klasa.lucznik);
                    String name = nameCharacter.getText();
                    savePlayerName(name);
                    if(name.equals(null)||name.equals(""))return;
                } catch (ClassNotChoosenException ex) {
                    throw new RuntimeException(ex);
                }
                new Projekt();
                dispose();
            }
        });
        wojownikButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gracz = Gracz.StworzGracza(30, 4, 6, Klasa.wojownik);
                    String name = nameCharacter.getText();
                    savePlayerName(name);
                    if(name.equals(null)||name.equals("")) return;
                } catch (ClassNotChoosenException ex) {
                    throw new RuntimeException(ex);

                }
                new Projekt();
                dispose();
            }
        });
    }
}
