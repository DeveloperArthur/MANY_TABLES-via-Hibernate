package br.com.crud.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.OneToMany;

@Entity
@Table(name = "campus")

public class campus implements Serializable {
    
    @OneToMany
    private List<pesquisa> pesquisa;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     Long id;

    @Column(name = "FilialCodigo")
    private int FilialCodigo;
    @Column(name = "FilialNome")
    private String FilialNome;

    public int getFilialCodigo() {
        return FilialCodigo;
    }

    public void setFilialCodigo(int FilialCodigo) {
        this.FilialCodigo = FilialCodigo;
    }

    public String getFilialNome() {
        return FilialNome;
    }

    public void setFilialNome(String FilialNome) {
        this.FilialNome = FilialNome;
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
        if (!(object instanceof campus)) {
            return false;
        }
        campus other = (campus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crud.model.campus[ id=" + id + " ]";
    }
    
    public List<campus> buscarCampus(EntityManager em) {
        return em.createQuery("SELECT c FROM campus c").getResultList();
    }
    
}
