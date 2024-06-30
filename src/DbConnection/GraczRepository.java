package DbConnection;

import java.sql.PreparedStatement;

public class GraczRepository
{
    private final DbConnection _connection;

    public GraczRepository(){
        _connection = new DbConnection();
        _connection.Connect();
    }

    public GraczDbDto GetGracz(String gracz){
        try {

            var sql = "Select * From gracz WHERE Nazwa = \"" + gracz + "\"";
            var queryResult = _connection.statement.executeQuery(sql);

            GraczDbDto dto = null;

            while (queryResult.next()){

                dto = new GraczDbDto();

                dto.name = queryResult.getString(1);
                dto.hp = queryResult.getInt(2);
                dto.maxHp = queryResult.getInt(3);
                dto.defence = queryResult.getInt(4);
                dto.xp = queryResult.getInt(5);
                dto.killedEnemies = queryResult.getInt(6);
                dto.gold = queryResult.getInt(7);
            }

            return dto;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void CreateGracz(String nazwa, int gold, int defence, int hp, int maxHp, int killedEnemies, int xp){
        try {

            String sqlInsert = "INSERT INTO gracz " +
                    "(Nazwa, Gold, Defence, Hp, MaxHp, KilledEnemies, XP) " +
                    "VALUES " +
                    "('" + nazwa +  "', " + gold +", " + defence + ", " + hp + ", " +
                    maxHp + ", " + killedEnemies + ", " + xp + ")";

            var queryResult = _connection.statement.execute(sqlInsert);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public boolean UpdateGracz(String nazwa, int gold, int defence, int hp, int maxHp, int killedEnemies, int xp){
        try {

            String sqlUpdate = "UPDATE gracz " +
                    "SET Defence = " + defence + ", " +
                    "Gold = " + gold + ", Hp = " + hp + ", MaxHp = " + maxHp + ", " +
                    "KilledEnemies = " + killedEnemies + ", XP = " + xp + " " +
                    "WHERE Nazwa = \"" + nazwa + "\"";

            _connection.statement.execute(sqlUpdate);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return false;
    }
}
