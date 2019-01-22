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
import javax.persistence.ManyToMany;

@Entity
@Table(name = "perg_x_resp")

public class perg_x_resp implements Serializable {
    
    @ManyToMany
    private List<resposta> resposta;
    @ManyToMany
    private List<pergunta> pergunta;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PerguntaCodigo")
    private int PerguntaCodigo;
    @Column(name = "RespostaCodigo")
    private int RespostaCodigo;

    public int getPerguntaCodigo() {
        return PerguntaCodigo;
    }

    public void setPerguntaCodigo(int PerguntaCodigo) {
        this.PerguntaCodigo = PerguntaCodigo;
    }

    public int getRespostaCodigo() {
        return RespostaCodigo;
    }

    public void setRespostaCodigo(int RespostaCodigo) {
        this.RespostaCodigo = RespostaCodigo;
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
        if (!(object instanceof perg_x_resp)) {
            return false;
        }
        perg_x_resp other = (perg_x_resp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crud.model.perg_x_resp[ id=" + id + " ]";
    }
    
    public List<perg_x_resp> buscarPergXResp (EntityManager em) {
        return em.createQuery("SELECT p FROM perg_x_resp p").getResultList();
    }
    
}
