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
        return this.data.isEqual(outroObjeto.data) && this.hora.isEqual(outroObjeto.hora);
    }

    public boolean isGreater(DataHora outroObjeto) {
        if (this.data.isGreater(outroObjeto.data)) {
            return true;
        } else if (this.data.isEqual(outroObjeto.data)) {
            return this.hora.isGreater(outroObjeto.hora);
        } else {
            return false;
        }
    }

    public boolean isLower(DataHora outroObjeto) {
        return !this.isEqual(outroObjeto) && !this.isGreater(outroObjeto);
    }
}