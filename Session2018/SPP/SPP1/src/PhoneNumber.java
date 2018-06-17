public class PhoneNumber {

    private String number;
    private String fio;
    private String passport;
    private String tarif;
    private int balance;

    public void setFio(String fio)
    {
        this.fio = fio;
    }

    public String getFio()
    {
        return this.fio;
    }

    public void setPassport(String passport)
    {
        this.passport = passport;
    }

    public String getPassport()
    {
        return this.passport;
    }

    public void setTarif(String tarif)
    {
        this.tarif = tarif;
    }

    public String getTarif()
    {
        return this.tarif;
    }

    public void setBalance(int balance)
    {
        this.balance = balance;
    }

    public int getBalance()
    {
        return this.balance;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getNumber()
    {
        return this.number;
    }

    public String getStringBalance()
    {
        return Integer.toString(this.balance) + " BYN";
    }

}
