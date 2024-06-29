package Execptions;

public abstract class CustomExcepiton extends  Exception
{
    public String wiadomosc = "";
    public CustomExcepiton(String wiadomosc){
        this.wiadomosc = wiadomosc;
    }
}
