import Enums.PotionType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Miasto extends JFrame {
    private JPanel panel1;
    private JButton Back;
    private JTabbedPane tabbedPane1;
    private JButton button1;
    private JButton armorL;
    private JButton armorH;
    private JButton armorM;
    private JButton Save;
    private JButton PotionS;
    private JButton PotionH;
    private JButton swordL;
    private JButton swordH;
    private JButton swordM;
    private JButton PotionM;
    private JLabel goldValue;
    int width = 600, height = 400;


    public Miasto() {
        this.setLocationRelativeTo(null);
        this.setSize(width, height);
        this.setVisible(true);
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        goldValue.setText("Ilość złota: " + Gracz.getGracz().gold);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Projekt();
                dispose();
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Witaj w mieście tutaj kupisz pancerz, zbroje oraz mikstury. Możesz również zapisać grę w katedrze.");
            }
        });
        armorL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Armor armor = new Armor(3, 1);
                if(!Gracz.getGracz().canSetArmor(armor)){
                    JOptionPane.showMessageDialog(null, "Posiadasz ten pancerz albo wyższy");
                    return;
                }
                if(Gracz.getGracz().gold>=100){
                    Gracz.getGracz().gold -= 100;
                    Gracz.getGracz().setObrona(Gracz.getGracz().getObrona() + 3);
                    goldValue.setText("Ilość złota: " + Gracz.getGracz().gold);
                    Gracz.getGracz().setArmor(armor);

                }
                else{
                    JOptionPane.showMessageDialog(null, "Nie posiadasz wystarczająco złota");
                }
            }
        });
        armorH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Gracz.getGracz().gold>=1800){
                    Gracz.getGracz().gold -= 1800;
                    Gracz.getGracz().setObrona(Gracz.getGracz().getObrona() + 10);
                    goldValue.setText("Ilość złota: " + Gracz.getGracz().gold);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Nie posiadasz wystarczająco złota");
                }
            }
        });
        armorM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Gracz.getGracz().gold>=700){
                    Gracz.getGracz().gold -= 700;
                    Gracz.getGracz().setObrona(Gracz.getGracz().getObrona() + 6);
                    goldValue.setText("Ilość złota: " + Gracz.getGracz().gold);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Nie posiadasz wystarczająco złota");
                }
            }
        });
        PotionS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Gracz.getGracz().gold>=25){
                    Gracz.getGracz().addPotion(PotionType.SmallHp);
                    Gracz.getGracz().gold -= 25;
                    goldValue.setText("Ilość złota: " + Gracz.getGracz().gold);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Nie posiadasz wystarczająco złota");
                }
            }
        });
        PotionH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Gracz.getGracz().gold>=90){
                    Gracz.getGracz().addPotion(PotionType.BigHp);
                    Gracz.getGracz().gold -= 90;
                    goldValue.setText("Ilość złota: " + Gracz.getGracz().gold);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Nie posiadasz wystarczająco złota");
                }
            }
        });
        PotionM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Gracz.getGracz().gold>=50){
                    Gracz.getGracz().addPotion(PotionType.MediumHp);
                    Gracz.getGracz().gold -= 50;
                    goldValue.setText("Ilość złota: " + Gracz.getGracz().gold);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Nie posiadasz wystarczająco złota");
                }
            }
        });
        swordL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Gracz.getGracz().gold>=200){
                    Gracz.getGracz().gold -= 200;
                    Gracz.getGracz().setMocAtaku(Gracz.getGracz().getMocAtaku()+2);
                    goldValue.setText("Ilość złota: " + Gracz.getGracz().gold);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Nie posiadasz wystarczająco złota");
                }
            }
        });
        swordM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Gracz.getGracz().gold>=800){
                    Gracz.getGracz().gold -= 800;
                    Gracz.getGracz().setMocAtaku(Gracz.getGracz().getMocAtaku()+5);
                    goldValue.setText("Ilość złota: " + Gracz.getGracz().gold);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Nie posiadasz wystarczająco złota");
                }
            }
        });
        swordH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Gracz.getGracz().gold>=2000){
                    Gracz.getGracz().gold -= 2000;
                    Gracz.getGracz().setMocAtaku(Gracz.getGracz().getMocAtaku()+10);
                    goldValue.setText("Ilość złota: " + Gracz.getGracz().gold);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Nie posiadasz wystarczająco złota");
                }
            }
        });

    }
}