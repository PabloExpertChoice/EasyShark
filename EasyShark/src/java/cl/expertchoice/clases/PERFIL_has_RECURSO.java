package cl.expertchoice.clases;

/**
 *
 * @author jhonncard
 */
public class PERFIL_has_RECURSO {
    private int id;
    private int idPerfil;
    private int idRecurso;

    public PERFIL_has_RECURSO(int id, int idPerfil, int idRecurso) {
        this.id = id;
        this.idPerfil = idPerfil;
        this.idRecurso = idRecurso;
    }

    public PERFIL_has_RECURSO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }
    
    
}
