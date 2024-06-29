import Enums.PotionType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inventory extends JFrame {
    private JLabel gamerXp;
    private JLabel gamerHp;
    private JLabel postacHP;
    private JLabel gamerDef;
    private JLabel postacDEF;
    private JLabel gamerAttack;
    private JLabel postacATK;
    private JLabel xpField;
    private JButton Back;
    private JPanel panel1;
    private JTextPane eq;
    private JButton bigHpButton;
    private JButton hpButton;
    private JButton ATKbutton;
    private JButton DEFbutton;
    private JButton button4;
    private JLabel lvl;
    private JLabel lvlLabel;
    private JButton mediumHpButton;
    private JButton smallHpButton;
    private JLabel goldValue;
    private JLabel enemyCounter;
    private JLabel Stats;
    int width = 600, height = 400;

    public Inventory() {
        this.setLocationRelativeTo(null);
        this.setSize(width, height);
        this.setVisible(true);
            this.setContentPane(this.panel1);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(width, height);
            SetUIForGamer();

        hpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var gamer = Gracz.getGracz();
                if(gamer.lvl.isUsed()){
                    JOptionPane.showMessageDialog(null, "Zużyłeś już punkt Lvl");
                    return;
                }
                gamer.lvl.setIsUsed();
                gamer.setMaxIloscZycia(gamer.getMaxIloscZycia() + 10);
                gamer.setIloscZycia(gamer.getIloscZycia()+10);
                SetUIForGamer();
            }
        });
        ATKbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var gamer = Gracz.getGracz();
                if(gamer.lvl.isUsed()){
                    JOptionPane.showMessageDialog(null, "Zużyłeś już punkt Lvl");
                    return;
                }
                gamer.lvl.setIsUsed();
                gamer.setMocAtaku(gamer.getMocAtaku() + 1);
                SetUIForGamer();
            }
        });
        DEFbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var gamer = Gracz.getGracz();
                if(gamer.lvl.isUsed()){
                    JOptionPane.showMessageDialog(null, "Zużyłeś już punkt Lvl");
                    return;
                }
                gamer.lvl.setIsUsed();
                gamer.setObrona(gamer.getObrona() + 1);
                SetUIForGamer();
            }
        });

        smallHpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var gamer = Gracz.getGracz();
                gamer.usePotion(PotionType.SmallHp);
                SetUIForGamer();
            }
        });

        mediumHpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var gamer = Gracz.getGracz();
                gamer.usePotion(PotionType.MediumHp);
                SetUIForGamer();
            }
        });

        bigHpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var gamer = Gracz.getGracz();
                gamer.usePotion(PotionType.BigHp);
                SetUIForGamer();
            }
        });
            Back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Projekt();
                    dispose();
                }
            });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Punkty LVL można użyć do ulepszania swoich statystyk.");
            }
        });

        goldValue.setText("Ilość złota: " + Gracz.getGracz().gold);
    }


    private void  SetUIForGamer(){
        var gamer = Gracz.getGracz();
        eq.setText(gamer.getEqDescription());
        lvlLabel.setText("Punkty LVL: " + gamer.lvl.getPoints());
        gamerXp.setText(String.valueOf(gamer.getXp()));
        gamerHp.setText(String.valueOf(String.valueOf(gamer.getIloscZycia())) + "/" + String.valueOf(gamer.getMaxIloscZycia()));
        gamerAttack.setText(String.valueOf(gamer.getMocAtaku()));
        gamerDef.setText(String.valueOf(gamer.getObrona()));
        enemyCounter.setText("Zabici przeciwnicy: " + String.valueOf(Projekt.getKilledenemies()));
        Stats.setText(WyborKlasy.getPlayerName());
    }
}

