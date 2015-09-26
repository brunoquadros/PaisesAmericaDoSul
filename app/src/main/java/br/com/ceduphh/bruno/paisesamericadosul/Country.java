package br.com.ceduphh.bruno.paisesamericadosul;

public class Country {


    private final String name;
    private final String capital;
    private final int flag;

    public Country(String name, String capital, int flag) {
        this.name = name;
        this.capital = capital;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public int getFlag() {
        return flag;
    }
}

