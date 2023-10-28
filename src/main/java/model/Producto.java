package model;

public class Producto {
    private int idProd;
    private String nombreProd;
    private int idCat;
    private String nombreCat;
    private String desProd;
    private String imagen;
    private double precio;
    private double calificacion;

    public Producto() {
        // Constructor vacío
    }
    
    public Producto(String nombreProd, int idCat, String desProd, String imagen, double precio, double calificacion) {
        this.nombreProd = nombreProd;
        this.idCat = idCat;
        this.desProd = desProd;
        this.imagen = imagen;
        this.precio = precio;
        this.calificacion = calificacion;
    }

    public Producto(int idProd, String nombreProd, int idCat, String desProd, String imagen, double precio, double calificacion) {
        this.idProd = idProd;
        this.nombreProd = nombreProd;
        this.idCat = idCat;
        this.desProd = desProd;
        this.imagen = imagen;
        this.precio = precio;
        this.calificacion = calificacion;
    }
    
    public Producto(int idProd, String nombreProd, String nombreCat, String desProd, String imagen, double precio, double calificacion) {
        this.idProd = idProd;
        this.nombreProd = nombreProd;
        this.nombreCat= nombreCat;
        this.desProd = desProd;
        this.imagen = imagen;
        this.precio = precio;
        this.calificacion = calificacion;
    }

    // Getters y setters para los campos
    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getDesProd() {
        return desProd;
    }

    public void setDesProd(String desProd) {
        this.desProd = desProd;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

	public String getNombreCat() {
		return nombreCat;
	}

	public void setNombreCat(String nombreCat) {
		this.nombreCat = nombreCat;
	}
}
