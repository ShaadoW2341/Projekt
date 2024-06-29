import Execptions.ClassNotChoosenException;

public class EnemyEasyConsts
{
    private static Enemy[] _enemyList1;
    private static Enemy[] _bossList;
    private static Enemy[] customEnemy;
    private static Enemy[] _enemyList;

    static {
        try {
            _enemyList1 = new Enemy[]{
                    new Enemy(3, 2, 1, "Młody szczur",20,Klasa.wojownik),
                    new Enemy(7, 1, 6, "Szczur",20, Klasa.wojownik),
                    new Enemy(4, 2, 4, "Ślizgacz", 20,Klasa.lucznik),
                    new Enemy(10, 0, 1, "Nieumarły szczur", 20,Klasa.wojownik),
                    new Enemy(8, 2, 3, "Wielki pająk", 20,Klasa.lucznik),
            };
            customEnemy = new Enemy[]{
                    new Enemy(10, 2, 1, "Królowa Szczurów",20,Klasa.wojownik),
            };
            _enemyList = new Enemy[]{
                    new Enemy(3, 2, 1, "Szkielet łucznik",20,Klasa.lucznik),
                    new Enemy(7, 1, 6, "Nieumarły",20, Klasa.wojownik),
                    new Enemy(4, 2, 4, "Szkielet wojownik", 20,Klasa.wojownik),
                    new Enemy(10, 0, 1, "Harpia", 20,Klasa.lucznik),
                    new Enemy(8, 2, 3, "Wilk", 20,Klasa.wojownik),
            };
            _bossList = new Enemy[]{
                    new Enemy(10, 2, 1, "Szczur",20,Klasa.wojownik),
                    new Enemy(10, 2, 1, "Szczur",20,Klasa.wojownik),
                    new Enemy(10, 2, 1, "Szczur",20,Klasa.wojownik),

            };
        } catch (ClassNotChoosenException e) {
            e.printStackTrace();
        }
    }


    public static int getEnemyList1Length(){
        return _enemyList1.length;
    }

    public static int getEnemyListLength(){
        return _enemyList.length;
    }

    public static Enemy GetCustomEnemy(int index)
    {
        try {
            if (index >= customEnemy.length)
                return null;

            return new Enemy(customEnemy[index]);

        } catch (ClassNotChoosenException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Enemy GetEnemy(int index)
    {
        try {
        if (index >= _enemyList1.length)
            return null;

        return new Enemy(_enemyList1[index]);

        } catch (ClassNotChoosenException e) {
            e.printStackTrace();
        }

        return null;
    }
    public static Enemy GetMidEnemy(int index)
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
