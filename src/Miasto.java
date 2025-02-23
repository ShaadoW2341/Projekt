import DbConnection.GraczRepository;
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
    private GraczRepository graczRepository = new GraczRepository();


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
                new Przygoda();
                dispose();
            }
        });
        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                var gamer = Gracz.getGracz();
                if (gamer.gold < 50){
                    JOptionPane.showMessageDialog(null, "Nie posiadasz wystarczająco złota");
                    return;
                }
                gamer.gold -= 50;
                goldValue.setText("Ilość złota: " + Gracz.getGracz().gold);
                graczRepository.UpdateGracz(gamer.getName(), gamer.gold, gamer.getObrona(),
                        gamer.getIloscZycia(), gamer.getMaxIloscZycia(), Przygoda.getKilledenemies(), gamer.xp);
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
                    Gracz.getGracz().setObrona(Gracz.getGracz().getObrona() + armor.getArmorPower());
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
                Armor armor = new Armor(10, 3);
                if(!Gracz.getGracz().canSetArmor(armor)){
                    JOptionPane.showMessageDialog(null, "Posiadasz ten pancerz albo wyższy");
                    return;
                }
                if(Gracz.getGracz().gold>=1800){
                    Gracz.getGracz().gold -= 1800;
                    Gracz.getGracz().setObrona(Gracz.getGracz().getObrona() + armor.getArmorPower());
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
                Armor armor = new Armor(6, 2);
                if(!Gracz.getGracz().canSetArmor(armor)){
                    JOptionPane.showMessageDialog(null, "Posiadasz ten pancerz albo wyższy");
                    return;
                }
                if(Gracz.getGracz().gold>=700){
                    Gracz.getGracz().gold -= 700;
                    Gracz.getGracz().setObrona(Gracz.getGracz().getObrona() + armor.getArmorPower());
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
                Sword sword = new Sword(2, 1);
                if(!Gracz.getGracz().canSetSword(sword)){
                    JOptionPane.showMessageDialog(null, "Posiadasz ten miecz albo lepszy");
                    return;
                }
                if(Gracz.getGracz().gold>=200){
                    Gracz.getGracz().gold -= 200;
                    Gracz.getGracz().setMocAtaku(Gracz.getGracz().getMocAtaku()+ sword.getSwordPower());
                    goldValue.setText("Ilość złota: " + Gracz.getGracz().gold);
                    Gracz.getGracz().setSword(sword);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Nie posiadasz wystarczająco złota");
                }
            }
        });
        swordM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sword sword = new Sword(5, 2);
                if(!Gracz.getGracz().canSetSword(sword)){
                    JOptionPane.showMessageDialog(null, "Posiadasz ten miecz albo lepszy");
                    return;
                }
                if(Gracz.getGracz().gold>=800){
                    Gracz.getGracz().gold -= 800;
                    Gracz.getGracz().setMocAtaku(Gracz.getGracz().getMocAtaku()+ sword.getSwordPower());
                    goldValue.setText("Ilość złota: " + Gracz.getGracz().gold);
                    Gracz.getGracz().setSword(sword);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Nie posiadasz wystarczająco złota");
                }
            }
        });
        swordH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sword sword = new Sword(10, 3);
                if(!Gracz.getGracz().canSetSword(sword)){
                    JOptionPane.showMessageDialog(null, "Posiadasz ten miecz albo lepszy");
                    return;
                }
                if(Gracz.getGracz().gold>=2000){
                    Gracz.getGracz().gold -= 2000;
                    Gracz.getGracz().setMocAtaku(Gracz.getGracz().getMocAtaku()+ sword.getSwordPower());
                    goldValue.setText("Ilość złota: " + Gracz.getGracz().gold);
                    Gracz.getGracz().setSword(sword);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Nie posiadasz wystarczająco złota");
                }
            }
        });

    }
}