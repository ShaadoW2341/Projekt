import Execptions.ClassNotChoosenException;

public class EnemyEasyConsts
{
    private static Enemy[] _enemyList1;
    private static Enemy[] _bossList;
    private static Enemy[] customEnemy;
    private static Enemy[] _enemyList;

    static {
        //"Wojownik", 10, 2, 3
        //"Lucznik", 5, 1, 6
        try {
            _enemyList1 = new Enemy[]{
                    new Enemy(0, 1, 2, "Młody szczur",20,Klasa.wojownik),
                    new Enemy(10, 2, 6, "Szczur",20, Klasa.wojownik),
                    new Enemy(10, 2, 4, "Ślizgacz", 20,Klasa.lucznik),
                    new Enemy(15, 0, 4, "Nieumarły szczur", 20,Klasa.wojownik),
                    new Enemy(5, 2, 3, "Wielki pająk", 20,Klasa.lucznik),
            };
            customEnemy = new Enemy[]{
                    new Enemy(50, 5, 2, "Królowa Szczurów",200,Klasa.wojownik),
            };
            _enemyList = new Enemy[]{
                    new Enemy(10, 2, 6, "Szkielet łucznik",60,Klasa.lucznik),
                    new Enemy(7, 1, 5, "Nieumarły",50, Klasa.wojownik),
                    new Enemy(4, 2, 5, "Szkielet wojownik", 40,Klasa.wojownik),
                    new Enemy(10, 0, 1, "Harpia", 60,Klasa.lucznik),
                    new Enemy(8, 2, 3, "Wilk", 30,Klasa.wojownik),
                    new Enemy(15, 10, 15, "Goblin Zwiadowca", 50,Klasa.lucznik),
                    new Enemy(5, 6, 9, "Goblin Złodziej", 40, Klasa.wojownik),
                    new Enemy(6, 4, 5, "Demoniczny Chochlik", 50,Klasa.wojownik),
                    new Enemy(11, 6, 8, "Piekielny Szkielet", 100,Klasa.lucznik),
                    new Enemy(13, 8, 10, "Gnoll Wojownik", 60,Klasa.wojownik),
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

    public static int getBossListLength(){
        return _bossList.length;
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
    public static Enemy GetBossEnemy(int index)
    {
        try {
            if (index >= _bossList.length)
                return null;

            return new Enemy(_bossList[index]);

        } catch (ClassNotChoosenException e) {
            e.printStackTrace();
        }

        return null;
    }

}
