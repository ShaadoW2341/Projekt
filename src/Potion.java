import Enums.PotionType;

public class Potion
{
    private String opis;
    private PotionType type;
    private int powerOfPotion;

    public Potion(PotionType type)
    {
        //opis
        switch (type) {
            case BigHp -> opis = "Duża mikstura hp";
            case MediumHp -> opis = "Średnia mikstura hp";
            case SmallHp -> opis = "Mała mikstura hp";
        }

        //moc elikstyru
        switch (type) {
            case BigHp -> powerOfPotion = 40;
            case MediumHp -> powerOfPotion = 25;
            case SmallHp -> powerOfPotion = 10;
        }

        this.type = type;
    }

    public PotionType getType()
    {
        return type;
    }

    public int getPowerOfPotion()
    {
        return powerOfPotion;
    }

    @Override
    public String toString()
    {
        return this.opis + " +" + this.powerOfPotion;
    }
}
