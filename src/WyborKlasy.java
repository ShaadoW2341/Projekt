import DbConnection.GraczRepository;
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
    private GraczRepository repo = new GraczRepository();

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

                    String name = nameCharacter.getText();
                    savePlayerName(name);
                    if(name.equals(null)||name.equals(""))return;

                    var graczDb = repo.GetGracz(name);

                    if (graczDb == null){
                        gracz = Gracz.StworzGracza(name, 30000, 2, 8, Klasa.lucznik);
                        repo.CreateGracz(name, gracz.gold,gracz.getObrona(), gracz.getIloscZycia(), gracz.getMaxIloscZycia(), 0, gracz.getXp());
                    }
                    else {
                        Przygoda.setKilledenemies(graczDb.killedEnemies);
                        gracz = Gracz.StworzGraczaCopy(graczDb.name,graczDb.hp,graczDb.maxHp, graczDb.defence, 6, graczDb.gold, graczDb.xp, Klasa.wojownik);
                    }

                } catch (ClassNotChoosenException ex) {
                    throw new RuntimeException(ex);
                }
                new Przygoda();
                dispose();
            }
        });
        wojownikButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nameCharacter.getText();
                    savePlayerName(name);
                    if(name.equals(null)||name.equals("")) return;

                    var graczDb = repo.GetGracz(name);

                    if (graczDb == null){
                        gracz = Gracz.StworzGracza(name,30, 4, 6, Klasa.wojownik);
                        repo.CreateGracz(name, gracz.gold,gracz.getObrona(), gracz.getIloscZycia(), gracz.getMaxIloscZycia(), 0, gracz.getXp());
                    }
                    else {
                        Przygoda.setKilledenemies(graczDb.killedEnemies);
                        gracz = Gracz.StworzGraczaCopy(graczDb.name,graczDb.hp,graczDb.maxHp, graczDb.defence, 6, graczDb.gold, graczDb.xp, Klasa.wojownik);
                    }
                } catch (ClassNotChoosenException ex) {
                    throw new RuntimeException(ex);

                }
                new Przygoda();
                dispose();
            }
        });
    }
}
