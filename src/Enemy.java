import Enums.CharacterStatus;
import Execptions.ClassNotChoosenException;


public class Enemy extends Postac{

    private int silaAtaku;
    private String nazwa;
    private int xp;

    public Enemy(int punktyZycia, int obrona, int silaAtaku, String nazwa, int xp, Klasa klasa) throws ClassNotChoosenException
    {
        super(punktyZycia, obrona, silaAtaku, klasa);
        this.silaAtaku = silaAtaku;
        this.nazwa = nazwa;
        this.xp = xp;
    }

    public Enemy(Enemy enemy) throws ClassNotChoosenException
    {
        super(enemy.getPureIloscZycia(), enemy.getPureObrona(), enemy.getMocAtaku(), enemy.getKlasa());
        this.silaAtaku = enemy.silaAtaku;
        this.nazwa = enemy.nazwa;;
        this.xp = enemy.xp;
    }

    public String getNazwa()
    {
        return nazwa;
    }

    public void AttackByGamer(Gracz gracz){
        int attackHp = gracz.getMocAtaku() - this.getRandomObrona();

        if (attackHp < 0)
            attackHp = 0;

        if (super.getIloscZycia() - attackHp < 0){
            setIloscZycia(0);
            return;
        }

        this.setIloscZycia(super.getIloscZycia() - attackHp); ;
    }

    public boolean isEnemyDead()
    {
        return (!status.equals(CharacterStatus.Alive));
    }

    public boolean isEnemyDeadAndGatheredXp()
    {
        return status.equals(CharacterStatus.DeadAndGathered);
    }

    public int getXp()
    {
        status = CharacterStatus.DeadAndGathered;
        return xp;
    }
}