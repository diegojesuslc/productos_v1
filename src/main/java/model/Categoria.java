package model;

public class Categoria {
    private int idCat;
    private String nombreCat;
    private String descCat;

    public Categoria() {
        // Constructor vacío
    }

    public Categoria(int idCat, String nombreCat, String descCat) {
        this.idCat = idCat;
        this.nombreCat = nombreCat;
        this.descCat = descCat;
    }

    // Getters y setters para los campos
    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getNombreCat() {
        return nombreCat;
    }

    public void setNombreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    }

    public String getDescCat() {
        return descCat;
    }

    public void setDescCat(String descCat) {
        this.descCat = descCat;
    }
}

