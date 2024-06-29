public class Lvl
{
    private int level;
    private boolean isUsed;

    public Lvl(int xp){
        level = GetLvl(xp);
        if (level == 0)
            isUsed = true;
        else
            isUsed = false;
    }

    public static boolean isNextLevelAvalible(int oldXp, int newXp){
        return  GetLvl(oldXp) < GetLvl(newXp);
    }

    public int getLvl(){
        return level;
    }

    public boolean isUsed()
    {
        return isUsed;
    }

    public void setIsUsed()
    {
        isUsed = true;
    }


    private static int GetLvl(int xp){
        var tmpXp = xp;
        var firstLevel = 100;
        var multiplayer = 1.25;
        var nextLevel = 0;

        while(tmpXp > 0){
            tmpXp -= firstLevel;
            firstLevel *= multiplayer;

            if (tmpXp >= 0)
                nextLevel++;
        }

        return nextLevel;
    }
}
