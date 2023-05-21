package model;

public class Ruta {
    private String desde;
    private String hacia;
    private int tiempoNormal;
    private int tiempoLluvia;
    private int tiempoNieve;
    private int tiempoTormenta;

    private int  tiempo;

    public Ruta(String desde, String hacia, int tiempoNormal, int tiempoLluvia, int tiempoNieve, int tiempoTormenta) {
        this.desde = desde;
        this.hacia = hacia;
        this.tiempoNormal = tiempoNormal;
        this.tiempoLluvia = tiempoLluvia;
        this.tiempoNieve = tiempoNieve;
        this.tiempoTormenta = tiempoTormenta;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHacia() {
        return hacia;
    }

    public void setHacia(String hacia) {
        this.hacia = hacia;
    }

    public int getTiempoNormal() {
        return tiempoNormal;
    }

    public void setTiempoNormal(int tiempoNormal) {
        this.tiempoNormal = tiempoNormal;
    }

    public int getTiempoLluvia() {
        return tiempoLluvia;
    }

    public void setTiempoLluvia(int tiempoLluvia) {
        this.tiempoLluvia = tiempoLluvia;
    }

    public int getTiempoNieve() {
        return tiempoNieve;
    }

    public void setTiempoNieve(int tiempoNieve) {
        this.tiempoNieve = tiempoNieve;
    }

    public int getTiempoTormenta() {
        return tiempoTormenta;
    }

    public void setTiempoTormenta(int tiempoTormenta) {
        this.tiempoTormenta = tiempoTormenta;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiemo(String _tiempo) {
        if (_tiempo.equals("Normal")){
            this.tiempo = this.tiempoNormal;
        } else if (_tiempo.equals("Lluvia")) {
            this.tiempo = this.tiempoLluvia;
        } else if (_tiempo.equals("Nevado")) {
            this.tiempo = this.tiempoNieve;
        } else if (_tiempo.equals("Tormenta")) {
            this.tiempo = this.tiempoTormenta;
        }
    }

    @Override
    public String toString() {
        return "Salida: " + this.desde + " Destino: " +
                this.hacia +"h. Tiempo normal: " + this.tiempoNormal + "h. Tiempo con lluvia: " +
                this.tiempoLluvia + "h. Tiempo con nieve: " + this.tiempoNieve + "h. Tiempo con tormenta: " +
                this.tiempoTormenta + "h.";
    }
}
