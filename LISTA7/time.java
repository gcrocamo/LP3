package tempo;

import java.time.LocalTime;

public class Cronometro {
    private int horas;
    private int minutos;
    private int segundos;

    public Cronometro() {
        this.horas = 0;
        this.minutos = 0;
        this.segundos = 0;
    }

    public Cronometro(int horas) {
        this.horas = horas;
        this.minutos = 0;
        this.segundos = 0;
    }

    public Cronometro(int horas, int minutos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = 0;
    }

    public Cronometro(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public Cronometro(Cronometro outroCronometro) {
        this.horas = outroCronometro.horas;
        this.minutos = outroCronometro.minutos;
        this.segundos = outroCronometro.segundos;
    }

    public int getHoras() {
        return this.horas;
    }

    public int getMinutos() {
        return this.minutos;
    }

    public int getSegundos() {
        return this.segundos;
    }

    public String getTempo() {
        String resultado = this.horas + ":" + this.minutos + ":" + this.segundos;
        return resultado;
    }

    public boolean isAm() {
        return (this.horas < 12);
    }

    public int cron(Cronometro horario) {
        int tempo = this.tempoParaSeg() - horario.tempoParaSeg();
        if (tempo < 0)
            tempo += 24 * 3600;
        return tempo;
    }

    private int tempoParaSeg() {
        return this.horas * 3600 + this.minutos * 60 + this.segundos;
    }

    public void addTime(int secs) {
        this.addTime(0, 0, secs);
    }

    public void addTime(int m, int s) {
        this.addTime(0, m, s);
    }

    public void addTime(int h, int m, int s) {
        this.horas += h;
        this.minutos += m;
        this.segundos += s;

        if (this.segundos >= 60) {
            int minutosExtras = this.segundos / 60;
            this.minutos += minutosExtras;
            this.segundos = this.segundos % 60;
        }

        if (this.minutos >= 60) {
            int horasExtras = this.minutos / 60;
            this.horas += horasExtras;
            this.minutos = this.minutos % 60;
        }

        if (this.horas >= 24) {
            this.horas = this.horas % 24;
        }
    }

    public void addTime(Cronometro outroCronometro) {
        this.addTime(outroCronometro.getHoras(), outroCronometro.getMinutos(), outroCronometro.getSegundos());
    }

    public static Cronometro diffTime(Cronometro t1, Cronometro t2) {
        int horas = Math.abs(t1.getHoras() - t2.getHoras());
        int minutos = Math.abs(t1.getMinutos() - t2.getMinutos());
        int segundos = Math.abs(t1.getSegundos() - t2.getSegundos());

        return new Cronometro(horas, minutos, segundos);
    }

    public static Cronometro diffTime(Cronometro t1) {
        LocalTime now = LocalTime.now();
        int horas = Math.abs(t1.getHoras() - now.getHour());
        int minutos = Math.abs(t1.getMinutos() - now.getMinute());
        int segundos = Math.abs(t1.getSegundos() - now.getSecond());

        return new Cronometro(horas, minutos, segundos);
    }

    public static boolean isAm(Cronometro t) {
        return (t.horas < 12);
    }

    public static boolean isPm(Cronometro t) {
        return (t.horas >= 12);
    }
}
