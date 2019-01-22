package br.com.crud.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.OneToMany;

@Entity
@Table(name = "curso")

public class curso implements Serializable {
    
    @OneToMany
    private List<pesquisa> pesquisa;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CursoCodigo")
    private int CursoCodigo;
    @Column(name = "CursoNome")
    private String CursoNome;

    public int getCursoCodigo() {
        return CursoCodigo;
    }

    public void setCursoCodigo(int CursoCodigo) {
        this.CursoCodigo = CursoCodigo;
    }

    public String getCursoNome() {
        return CursoNome;
    }

    public void setCursoNome(String CursoNome) {
        this.CursoNome = CursoNome;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof curso)) {
            return false;
        }
        curso other = (curso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crud.model.curso[ id=" + id + " ]";
    }
    
    public List<curso> buscarCurso(EntityManager em) {
        return em.createQuery("SELECT c FROM curso c").getResultList();
    }

}
