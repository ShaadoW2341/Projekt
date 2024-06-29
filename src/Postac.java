import Enums.CharacterStatus;
import Execptions.ClassNotChoosenException;

import java.util.Random;

public class Postac {
    private Klasa klasa;
    private int iloscZycia;
    private int maxIloscZycia;
    private int obrona;
    private int mocAtaku;
    protected CharacterStatus status;

    private int pureiloscZycia;
    private int pureObrona;
    private int pureMocAtaku;

    public Postac(int iloscZycia, int obrona, int mocAtaku, Klasa klasa) throws ClassNotChoosenException
    {
        if(klasa == null)
            throw new ClassNotChoosenException();

        pureiloscZycia = iloscZycia;
        pureObrona = obrona;
        pureMocAtaku = mocAtaku;

        this.status = CharacterStatus.Alive;
        this.klasa = klasa;
        this.iloscZycia = iloscZycia + klasa.getBasicHP();
        this.maxIloscZycia = this.iloscZycia;
        this.obrona = obrona + klasa.getBasicDEF();
        this.mocAtaku = mocAtaku + klasa.getBasicATK();
    }

    public Klasa getKlasa(){
        return klasa;
    }

    public int getPureIloscZycia() {
        return pureiloscZycia;
    }
    public int getMaxIloscZycia() {
        return maxIloscZycia;
    }

    public int getPureObrona() {
        return pureObrona;
    }

    public int getIloscZycia() {
        return iloscZycia;
    }

    public void setMaxIloscZycia(int iloscZycia) {
        this.maxIloscZycia = iloscZycia;
    }

    public void setIloscZycia(int iloscZycia) {
        if (iloscZycia <= 0 && status.equals(CharacterStatus.Alive))
            this.status = CharacterStatus.Dead;
        if (iloscZycia > maxIloscZycia){
            this.iloscZycia = maxIloscZycia;
            return;
        }

        this.iloscZycia = iloscZycia;
    }

    public int getObrona() {
        return obrona;
    }

    public void setObrona(int obrona) {
        this.obrona = obrona;
    }

    public int getMocAtaku() {
        return mocAtaku;
    }

    public CharacterStatus getStatus() {
        return status;
    }

    public void setMocAtaku(int mocAtaku) {
        this.mocAtaku = mocAtaku;
    }

    public int getRandomObrona(){
        Random random = new Random();
        int minObrona = obrona/2;
        return random.nextInt(obrona - minObrona + 1) + minObrona;
    }

}
