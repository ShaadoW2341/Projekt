import java.util.ArrayList;

public class Lvl
{

    private int level;
    private static ArrayList<Integer> points = new ArrayList<Integer>();

    public Lvl(int xp){
        level = GetLvl(xp);
        if (level != 0)
            points.add(1);
    }

    public static boolean isNextLevelAvalible(int oldXp, int newXp){
        return  GetLvl(oldXp) < GetLvl(newXp);
    }

    public int getPoints(){
        return points.size();
    }

    public boolean isUsed()
    {
        return points.size() == 0;
    }

    public void setIsUsed()
    {
        if (points.size() > 0)
            points.remove(points.size() - 1);
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
