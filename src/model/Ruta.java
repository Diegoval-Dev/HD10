package model;

public class Ruta {
    private String desde;
    private String hacia;
    private String tiempoNormal;
    private String tiempoLluvia;
    private String tiempoNieve;
    private String tiempoTormenta;

    public Ruta(String desde, String hacia, String tiempoNormal, String tiempoLluvia, String tiempoNieve, String tiempoTormenta) {
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

    public String getTiempoNormal() {
        return tiempoNormal;
    }

    public void setTiempoNormal(String tiempoNormal) {
        this.tiempoNormal = tiempoNormal;
    }

    public String getTiempoLluvia() {
        return tiempoLluvia;
    }

    public void setTiempoLluvia(String tiempoLluvia) {
        this.tiempoLluvia = tiempoLluvia;
    }

    public String getTiempoNieve() {
        return tiempoNieve;
    }

    public void setTiempoNieve(String tiempoNieve) {
        this.tiempoNieve = tiempoNieve;
    }

    public String getTiempoTormenta() {
        return tiempoTormenta;
    }

    public void setTiempoTormenta(String tiempoTormenta) {
        this.tiempoTormenta = tiempoTormenta;
    }

    @Override
    public String toString() {
        return "Salida: " + this.desde + " Destino: " +
                this.hacia +"h. Tiempo normal: " + this.tiempoNormal + "h. Tiempo con lluvia: " +
                this.tiempoLluvia + "h. Tiempo con nieve: " + this.tiempoNieve + "h. Tiempo con tormenta: " +
                this.tiempoTormenta + "h.";
    }
}
