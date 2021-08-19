package modelo.vo;

public class Requerimiento_2Vo {
    private Integer idProyecto;
    private String proveedor;

    public Requerimiento_2Vo() {
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String material) {
        this.proveedor = material;
    }

    @Override
    public String toString() {
        return idProyecto + " " + proveedor;
    }

}