public class DataHora {
    private Data data;
    private Hora hora;

    public DataHora(Data data, Hora hora) {
        this.data = data;
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Data: " + data + ", Hora: " + hora;
    }

    public boolean isEqual(DataHora outroObjeto) {
        Data dataOutroObjeto = outroObjeto.getData();
        Hora horaOutroObjeto = outroObjeto.getHora();
        return this.data.isEqual(dataOutroObjeto) && this.hora.isEqual(horaOutroObjeto);
    }

    public boolean isGreater(DataHora outroObjeto) {
        Data dataOutroObjeto = outroObjeto.getData();
        Hora horaOutroObjeto = outroObjeto.getHora();
        if (this.data.isGreater(dataOutroObjeto)) {
            return true;
        } else if (this.data.isEqual(dataOutroObjeto)) {
            return this.hora.isGreater(horaOutroObjeto);
        } else {
            return false;
        }
    }

    public boolean isLower(DataHora outroObjeto) {
        return !this.isEqual(outroObjeto) && !this.isGreater(outroObjeto);
    }

    public Data getData() {
        return this.data;
    }

    public Hora getHora() {
        return this.hora;
    }
}