package test;

import model.Ruta;
import model.txtReader;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class txtReaderTest {

    @org.junit.jupiter.api.Test
    void returnArr() {
        txtReader txt = new txtReader();
        ArrayList<Ruta> arr = new ArrayList<>();
        arr = txt.returnArr();
        assertEquals("Salida: Guatemala Destino: AntiguaGuatemalah. Tiempo normal: 1h. Tiempo con lluvia: 2h. Tiempo con nieve: 3h. Tiempo con tormenta: 4h.",arr.get(0).toString());

    }
}