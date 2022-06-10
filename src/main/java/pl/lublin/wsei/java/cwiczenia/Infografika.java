package pl.lublin.wsei.java.cwiczenia;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Infografika {
    public String title;
    public String strona;
    public String grafika;
    public String miniatura;
    public String szerokosc;
    public String wysokosc;

    public void print() {
        System.out.println("Infografika:");
        System.out.println("tytul: " + title);
        System.out.println("Adres strony: " + strona);
        System.out.println("Adres grafiki: " + grafika);
        System.out.println("Adres miniatry: " + miniatura);
        System.out.println("Rozmiary: " + szerokosc + "X" + wysokosc);
    }
    public Infografika(String tekst) {

        Pattern pat = Pattern.compile("<title><!\\[CDATA\\[(.*)\\]\\]");
        Matcher m = pat.matcher(tekst);
        if (m.find())
            title = m.group(1);
        else
            title = "";

        pat = Pattern.compile("<link>(.*)</link>");
        m = pat.matcher(tekst);
        if (m.find())
            strona = m.group(1);
        else
            strona = "";

        pat = Pattern.compile("url=\"(.*)\" type");
        m = pat.matcher(tekst);
        if (m.find())
            grafika = m.group(1);
        else
            grafika = "";

        pat = Pattern.compile("<media:thumbnail url=\"(.*)\"");
        m = pat.matcher(tekst);
        if (m.find())
            miniatura = m.group(1);
        else
            miniatura = "";

        pat = Pattern.compile("width=\"(.*)\" height");
        m = pat.matcher(tekst);
        if (m.find())
            szerokosc = String.valueOf(Integer.parseInt(m.group(1)));
        else
            szerokosc = String.valueOf(0);

        pat = Pattern.compile("height=\"(.*)\"");
        m = pat.matcher(tekst);
        if (m.find())
            wysokosc = String.valueOf(Integer.parseInt(m.group(1)));
        else
            wysokosc = String.valueOf(0);

    }
}
