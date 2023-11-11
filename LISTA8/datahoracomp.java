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
        return this.data.ehIgual(outroObjeto.data) && this.hora.ehIgual(outroObjeto.hora);
    }

    public boolean isGreater(DataHora outroObjeto) {
        if (this.data.ehMaior(outroObjeto.data)) {
            return true;
        } else if (this.data.ehIgual(outroObjeto.data)) {
            return this.hora.ehMaior(outroObjeto.hora);
        } else {
            return false;
        }
    }

    public boolean isLower(DataHora outroObjeto) {
        return !this.isEqual(outroObjeto) && !this.isGreater(outroObjeto);
    }
}