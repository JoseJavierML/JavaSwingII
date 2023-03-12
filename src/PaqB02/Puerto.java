package PaqB02;

public class Puerto {
    private static int FILAS = 10;
    private static int COLUMNAS = 12;

    //matriz de contenedores
    private Contenedor[][] hubs = new Contenedor[FILAS][COLUMNAS];

    //constructor de hub

    public Puerto(Contenedor[][] hubs) {
        this.hubs = hubs;
    }


    //desapilar contenedor

    public Contenedor desapilarContenedor(int columna) {
        for (int i = 0; i < FILAS; i++) {
            Contenedor contenedor = hubs[i][columna];
            if (contenedor != null) {
                hubs[i][columna] = null;
            }
        }
        return null;
    }

    public Contenedor apilarContenedor(Contenedor contenedor) {

        int p = contenedor.getPrioridad();

        if (p == 1) {
            for (int i = FILAS; i > 0; i--) {
                if (hubs[i][1] == null) {
                    hubs[i][1] = contenedor;
                }
            }
        } else if (p == 2) {
            for (int i = FILAS; i > 0; i--) {
                if (hubs[i][2] == null) {
                    hubs[i][2] = contenedor;
                }
            }
        } else {
            for (int j = 3; j < COLUMNAS; j++) {
                for (int i = FILAS; i > 0; i--) {
                    if (hubs[i][j] == null) {
                        hubs[i][j] = contenedor;
                    }
                }
            }
        }

        return null;
    }

    public void mostrarDatos(int id) {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (hubs[i][j].getIdContenedor() == id) {
                    System.out.println("Id:" + hubs[i][j].getIdContenedor() + " Pais:" + hubs[i][j].getPais_procedencia() + " Peso:" + hubs[i][j].getPesoContenedor() + " Inspeccionado:" + hubs[i][j].isInspeccionado() + " Prioridad:" + hubs[i][j].getPrioridad() + " Descripcion:" + hubs[i][j].getDescripcion_contenido() + " E.enviadora:" + hubs[i][j].getEmpresa_enviadora() + " E.recibidora:" + hubs[i][j].getEmpresa_recibidora());
                }
            }
        }
    }

    public String toString() {
        String s=" ";
        return s;
    }

    public int cuentaContenedores(String pais) {
        int contador = 0;

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if(hubs[i][j].getPais_procedencia()==pais){
                    contador++;
                }
            }
        }
        return contador;
    }
}
