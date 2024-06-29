public class Klasa {
    private String name;
    private int basicHP;
    private int basicDEF;
    private int basicATK;


    public Klasa(String name, int basicHP, int basicDEF, int basicATK) {
        this.name = name;
        this.basicHP = basicHP;
        this.basicDEF = basicDEF;
        this.basicATK = basicATK;
    }

    public String getName() {
        return name;
    }

    public int getBasicHP() {
        return basicHP;
    }

    public int getBasicDEF() {
        return basicDEF;
    }

    public int getBasicATK() {
        return basicATK;
    }

    static Klasa wojownik = new Klasa("Wojownik", 10, 2, 3);
    static Klasa lucznik = new Klasa("Lucznik", 8, 1, 5);

}
