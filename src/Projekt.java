import Enums.CharacterStatus;
import Execptions.CustomExcepiton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Projekt extends JFrame{
    private JPanel panel1;
    private JProgressBar enemyHpBar;
    private JButton Atak;
    private JButton newEnemy;
    private JButton Inventory;
    private JLabel Hp;
    private JLabel przeciwnik;
    private JLabel postacATK;
    private JLabel postacDEF;
    private JLabel xpField;
    private JLabel postacHP;
    private JLabel gamerXp;
    private JLabel gamerHp;
    private JLabel gamerAttack;
    private JLabel gamerDef;
    private JButton miastoButton;
    private JLabel DEF;
    private JLabel enemyClass;
    private JLabel Stats;
    private static int killedenemies;
    int width = 600, height = 400;
    private static Enemy enemy1;

    public Projekt()
    {
        this.setLocationRelativeTo(null);
        this.setSize(width,height);
        this.setVisible(true);
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);

        if (enemy1 == null)
            enemy1 = EnemyEasyConsts.GetEnemy(0);

        if (enemy1 != null&&(enemy1.isEnemyDead()||enemy1.isEnemyDeadAndGatheredXp())){
            newEnemy.setText("Następny przeciwnik");
        }

        SetUIForNewEnemy();
        SetUIForGamer();

        if(killedenemies>=5&&enemy1.isEnemyDead()){
            miastoButton.setEnabled(true);
        }

        Atak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               enemy1.AttackByGamer(Gracz.getGracz());

               if (enemy1.isEnemyDead() && !enemy1.isEnemyDeadAndGatheredXp()){
                   int xp = enemy1.getXp();
                   Random random = new Random();
                   int iloscZlota = random.nextInt(20)+10;
                   przeciwnik.setText(enemy1.getNazwa()+ " wypuścił "+ iloscZlota + " złota");
                   Gracz.getGracz().addXp(xp);
                   Gracz.getGracz().addGold(iloscZlota);
                   enemysKilled();
                   if(killedenemies>=6){
                       miastoButton.setEnabled(true);
                       if(killedenemies==6)
                       JOptionPane.showMessageDialog(null, "Teraz możesz odwiedzić miasto!");
                   }
                   newEnemy.setText("Następny Przeciwnik");
               }

               else if (!enemy1.isEnemyDead()){
                   Gracz gracz = Gracz.getGracz();
                   gracz.AttackByEnemy(enemy1);
                   miastoButton.setEnabled(false);

                   if (!gracz.getStatus().equals(CharacterStatus.Alive)){
                       SetUIForGamer();
                       JOptionPane.showMessageDialog(null, "Umarłeś");
                       enemy1 = null;
                       new WyborKlasy();
                       dispose();
                       return;
                   }
               }

               SetUIForGamer();

               enemyHpBar.setValue(enemy1.getIloscZycia());
               Hp.setText("Hp: " + enemy1.getIloscZycia());
            }
        });
        newEnemy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gracz gracz = Gracz.getGracz();
                    newEnemy.setText("Uciekaj");
                if(!enemy1.isEnemyDead() && enemy1.getKlasa() == Klasa.lucznik) {
                    gracz.AttackByEnemy(enemy1);
                    if (!gracz.getStatus().equals(CharacterStatus.Alive)){
                        SetUIForGamer();
                        JOptionPane.showMessageDialog(null, "Umarłeś");
                        enemy1 = null;
                        new WyborKlasy();
                        dispose();
                        return;
                    }
                    SetUIForGamer();
                    enemy1 = GenerateNewEnemy1();
                    SetUIForNewEnemy();

                }
                else{
                    enemy1 = GenerateNewEnemy1();
                    SetUIForNewEnemy();
                }
            }
        });
        Inventory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inventory inventory = new Inventory();
                dispose();
            }
        });
        miastoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Miasto miasto = new Miasto();
                dispose();
            }
        });
    }

    private void  SetUIForNewEnemy(){
        przeciwnik.setText(enemy1.getNazwa());
        enemyClass.setText(enemy1.getKlasa().getName());
        Hp.setText("Hp: " + enemy1.getIloscZycia());
        DEF.setText(enemy1.getObrona()+ " :DEF ");
        enemyHpBar.setMaximum(enemy1.getMaxIloscZycia());
        enemyHpBar.setValue(enemy1.getIloscZycia());
    }

    private void  SetUIForGamer(){
        var gamer = Gracz.getGracz();
        gamerXp.setText(String.valueOf(gamer.getXp()));
        gamerHp.setText(String.valueOf(String.valueOf(gamer.getIloscZycia())) + "/" + String.valueOf(gamer.getMaxIloscZycia()));
        gamerAttack.setText(String.valueOf(gamer.getMocAtaku()));
        gamerDef.setText(String.valueOf(gamer.getObrona()));
        Stats.setText(WyborKlasy.getPlayerName());
    }

    private Enemy GenerateNewEnemy1(){
        Random random = new Random();
        int wylosowanaLiczba = random.nextInt(EnemyEasyConsts.getEnemyList1Length());
        if(killedenemies<5) {
            return EnemyEasyConsts.GetEnemy(wylosowanaLiczba);
        } else if (killedenemies==5) {
            return boss1();
        }
        else {
            int wylosowanaMidLiczba = random.nextInt(EnemyEasyConsts.getEnemyListLength());
            return EnemyEasyConsts.GetMidEnemy(wylosowanaMidLiczba);
        }
    }
    private Enemy boss1(){
        return EnemyEasyConsts.GetCustomEnemy(0);
    }

    private void enemysKilled()
    {
        killedenemies++;
    }

    public static int getKilledenemies() {
        return killedenemies;
    }
}
