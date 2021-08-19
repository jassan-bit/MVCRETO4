package modelo.vo;

public class Requerimiento_3Vo {
    private Integer idProyecto;
    private String material;
    

    public Requerimiento_3Vo() {
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return idProyecto + " " + material;
    }

}
