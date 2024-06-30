import Enums.PotionType;
import Execptions.ClassNotChoosenException;

import java.util.ArrayList;

public class Gracz extends Postac
{
    private String name;
    private static Gracz gracz;
    public Lvl lvl;
    public int xp;
    public int gold;
    private final ArrayList<Potion> ekwipunek = new ArrayList<>();
    private Armor armor;
    private Sword sword;

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void setSword(Sword sword){this.sword = sword;}

    public boolean canSetArmor(Armor armor){
        if(this.armor==null) return true;
        else if(this.armor.getArmorTier()< armor.getArmorTier()) return true;
        else return false;
    }
    public boolean canSetSword(Sword sword){
        if(this.sword==null) return true;
        else if(this.sword.getSwordTier()< sword.getSwordTier()) return true;
        else return false;
    }


    private Gracz(String name, int iloscZycia, int obrona, int mocAtaku, Klasa klasa) throws ClassNotChoosenException
    {
        super(iloscZycia, obrona, mocAtaku, klasa);
        this.name = name;
        lvl = new Lvl(0);
        ekwipunek.add(new Potion(PotionType.MediumHp));
    }

    public static Gracz StworzGracza(String name, int iloscZycia, int obrona, int mocAtaku, Klasa klasa) throws ClassNotChoosenException
    {
        gracz = new Gracz(name, iloscZycia, obrona,mocAtaku, klasa);
        return  gracz;
    }

    public static Gracz StworzGraczaCopy(String name, int iloscZycia,int maxHp, int obrona, int mocAtaku,int gold, int xp, Klasa klasa) throws ClassNotChoosenException
    {
        gracz = new Gracz(name, iloscZycia, obrona,mocAtaku, klasa);
        gracz.setIloscZycia(iloscZycia);
        gracz.setObrona(obrona);
        gracz.setMocAtaku(mocAtaku);
        gracz.setMaxIloscZycia(maxHp);
        gracz.gold = gold;
        gracz.xp = xp;
        return  gracz;
    }

    public void AttackByEnemy(Enemy enemy)
    {
        if (enemy == null)
            return;

        var attackHp = enemy.getMocAtaku() - this.getRandomObrona();

        if (attackHp < 0)
            attackHp = 0;

        if (super.getIloscZycia() - attackHp < 0){
            setIloscZycia(0);
            return;
        }

        this.setIloscZycia(super.getIloscZycia() - attackHp); ;
    }


    public static Gracz getGracz(){
        return gracz;
    }

    public void addXp(int xp){
        if (Lvl.isNextLevelAvalible(this.xp, this.xp + xp ))
            this.lvl = new Lvl(this.xp + xp);

        this.xp += xp;
    }

    public void addGold(int gold){
        this.gold += gold;
    }

    public int getXp(){
        return xp;
    }

    public void usePotion(PotionType typ){

        Potion selectedPotion = null;

        for (var potion: this.ekwipunek) {
            if (potion.getType().equals(typ)){
                selectedPotion = potion;
                this.setIloscZycia(this.getIloscZycia() + selectedPotion.getPowerOfPotion());
            }
        }

        if (selectedPotion == null)
            return;

        ekwipunek.remove(selectedPotion);
    }

    public String getEqDescription(){
        var sb = new StringBuilder();

        for (var i = 0; i < ekwipunek.size(); i++) {
            sb.append(ekwipunek.get(i).toString());
            if (i != ekwipunek.size() - 1)
                sb.append(", ");
        }

        return sb.toString();
    }

    public void addPotion(PotionType potionType){
        ekwipunek.add(new Potion(potionType));
    }

    public String getName()
    {
        return name;
    }
}
