public class Cronometro {
    private int horas;
    private int minutos;
    private int segundos;

    public Cronometro(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    private boolean validarTempo(int horas, int minutos, int segundos){
        return validarHora(horas) && validarMinOuSeg(minutos) && validarMinOuSeg(segundos);
    }

    private boolean validarHora(int horas){
        return (horas>=0) && (horas<25);
    }

    private boolean validarMinOuSeg(int parametro){
        return (parametro>=0) && (parametro<61);
    }

    //Getters
    public int getHoras() {
        return this.horas;
    }
    
    public int getMinutos() {
        return this.minutos;
    }

    public int getSegundos() {
        return this.segundos;
    }
    
    public String getTempo(){
        String resultado = this.horas + ":" + this.minutos + ":" + this.segundos;
        return resultado;
    }

    public void setTempo(int horas, int minutos, int segundos){
        if (validarTempo(horas, minutos, segundos)) {
            this.horas = horas;
            this.minutos = minutos;
            this.segundos = segundos;
        }
        else{
            this.horas = 0;
            this.minutos = 0;
            this.segundos = 0;
        }
    }

    
    public void imprimirTempo(){
        System.out.println(getTempo());
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

    public void addSeconds(int secs) {
        this.horas += secs/3600;
        this.minutos += (secs%3600)/60;
        this.segundos += (secs%3600)%60;

        if (this.segundos > 59) {
            this.segundos -= 60;
            this.minutos += 1;
        }
        if (this.minutos > 59) {
            this.minutos -= 60;
            this.horas += 1;
        }
        if (this.horas > 23) {
            this.horas -= 24;
        }
    }

    public static void main(String args[]) {
        Cronometro cronometro1 = new Cronometro(22, 59, 59);
        Cronometro cronometro2 = new Cronometro(12, 0, 15);

        System.out.println(cronometro1.isAm());
        System.out.println(cronometro1.cron(cronometro2));
        cronometro1.addSeconds(3601);
        cronometro1.imprimirTempo();
    }
}
