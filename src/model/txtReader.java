package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class txtReader {
    //URL DEL ARCHIVO A LEER, FAVOR DE MODIFICAR ANTES DE USAR.
    //D:\EstructuraDeDatosUVG\DiccionarioArbolesBinarios\src\words.txt

    public String fileURL;
    public ArrayList<Ruta> rutas = new ArrayList<>();

    public txtReader(String path){
        this.fileURL = path;
    }

    public txtReader() {
        this.fileURL = "src/model/ciudades.txt";
    }

    /**
     * Funcion para leer el documento de texto
     * @return ArrayList con una linea de cada elemento
     */
    public ArrayList<Ruta> returnArr(){
        try {
            File myObj = new File(fileURL);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] line = myReader.nextLine().split(" ");
                rutas.add(new Ruta(line[0].trim(),line[1].trim(),line[2].trim(),line[3].trim(),line[4].trim(),line[5].trim()));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            //ERROR
        }
        return rutas;
    }
}
