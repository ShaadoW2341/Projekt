import Execptions.ClassNotChoosenException;

public class EnemyEasyConsts
{
    private static Enemy[] _enemyList1;
    private static Enemy[] _bossList;
    private static Enemy[] customEnemy;
    private static Enemy[] _enemyList;
    private static Enemy[] _enemyList3;

    static {
        //"Wojownik", 10, 2, 3
        //"Lucznik", 5, 1, 6
        try {
            _enemyList1 = new Enemy[]{
                    new Enemy(0, 1, 2, "Młody szczur",20,Klasa.wojownik),
                    new Enemy(9, 2, 5, "Szczur",20, Klasa.wojownik),
                    new Enemy(7, 2, 2, "Ślizgacz", 20,Klasa.lucznik),
                    new Enemy(11, 0, 3, "Nieumarły szczur", 20,Klasa.wojownik),
                    new Enemy(4, 2, 3, "Wielki pająk", 20,Klasa.lucznik),
            };
            customEnemy = new Enemy[]{
                    new Enemy(40, 3, 2, "Królowa Szczurów",200,Klasa.wojownik),
            };
            _enemyList = new Enemy[]{
                    new Enemy(10, 2, 6, "Szkielet łucznik",60,Klasa.lucznik),
                    new Enemy(7, 1, 5, "Nieumarły",50, Klasa.wojownik),
                    new Enemy(4, 2, 5, "Szkielet wojownik", 40,Klasa.wojownik),
                    new Enemy(10, 0, 1, "Harpia", 60,Klasa.lucznik),
                    new Enemy(8, 2, 3, "Wilk", 30,Klasa.wojownik),
                    new Enemy(11, 6, 8, "Piekielny Szkielet", 100,Klasa.lucznik),
            };
            _enemyList3 = new Enemy[]{
                    new Enemy(12, 3, 5, "Demoniczny Chochlik", 50,Klasa.lucznik),
                    new Enemy(20, 6, 7, "Gnoll Wojownik", 60,Klasa.wojownik),
                    new Enemy(10, 2, 15, "Goblin Zwiadowca", 50,Klasa.lucznik),
                    new Enemy(15, 5, 8, "Goblin Złodziej", 40, Klasa.wojownik),
            };
            _bossList = new Enemy[]{
                    new Enemy(50, 5, 3, "Szkieleci Hrabia",150,Klasa.wojownik),
                    new Enemy(35, 2, 7, "Gang Goblinów",250,Klasa.lucznik),
                    new Enemy(75, 4, 3, "Gnom Krzyś",20,Klasa.lucznik),

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
    public static int getEnemyHardListLength(){
        return _enemyList3.length;
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
    public static Enemy GetHardEnemy(int index)
    {
        try {
            if (index >= _enemyList3.length)
                return null;

            return new Enemy(_enemyList3[index]);

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