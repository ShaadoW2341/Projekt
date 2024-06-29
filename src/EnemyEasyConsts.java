import Execptions.ClassNotChoosenException;

public class EnemyEasyConsts
{
    private static Enemy[] _enemyList1;
    private static Enemy[] _bossList;

    static {
        try {
            _enemyList1 = new Enemy[]{
                    new Enemy(10, 2, 1, "Młody szczur",20,Klasa.wojownik),
                    new Enemy(7, 2, 6, "Szczur",20, Klasa.wojownik),
                    new Enemy(10, 2, 15, "Ślizgacz", 20,Klasa.lucznik),
                    new Enemy(11, 2, 3, "Nieumarły szczur", 20,Klasa.lucznik),
                    new Enemy(12, 2, 13, "Wielki pająk", 20,Klasa.wojownik),
            };
            new Enemy(10, 2, 1, "Królowa szczurów",20,Klasa.wojownik);
            _bossList = new Enemy[]{
                    new Enemy(10, 2, 1, "Szczur",20,Klasa.wojownik),
                    new Enemy(10, 2, 1, "Szczur",20,Klasa.wojownik),
                    new Enemy(10, 2, 1, "Szczur",20,Klasa.wojownik),

            };
        } catch (ClassNotChoosenException e) {
            e.printStackTrace();
        }
    }


    public static int getEnemyListLength(){
        return _enemyList1.length;
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
}
