import Execptions.ClassNotChoosenException;

public class EnemyEasyConsts
{
    private static Enemy[] _enemyList;

    static {
        try {
            _enemyList = new Enemy[]{
                    new Enemy(10, 2, 1, "Bartek",100,Klasa.wojownik),
                    new Enemy(7, 2, 6, "Goblin Wojownik",50, Klasa.wojownik),
                    new Enemy(10, 2, 15, "Kobold Łucznik", 150,Klasa.lucznik),
                    new Enemy(11, 2, 3, "Troll Szaman", 60,Klasa.lucznik),
                    new Enemy(12, 2, 13, "Szkielet Rycerz", 40,Klasa.wojownik),
            };
        } catch (ClassNotChoosenException e) {
            e.printStackTrace();
        }
    }

    public static int getEnemyListLength(){
        return _enemyList.length;
    }

    public static Enemy GetEnemy(int index)
    {
        try {
        if (index >= _enemyList.length)
            return null;

        return new Enemy(_enemyList[index]);

        } catch (ClassNotChoosenException e) {
            e.printStackTrace();
        }

        return null;
    }
}
