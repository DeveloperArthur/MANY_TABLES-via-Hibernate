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
@Table(name = "pergunta")

public class pergunta implements Serializable {
    
    @OneToMany
    private List<perg_x_resp> perg_x_resp;
    @OneToMany
    private List<pesquisa> pesquisa;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PerguntaCodigo")
    private int PerguntaCodigo;
    @Column(name = "PerguntaDescricao")
    private String PerguntaDescricao;

    public int getPerguntaCodigo() {
        return PerguntaCodigo;
    }

    public void setPerguntaCodigo(int PerguntaCodigo) {
        this.PerguntaCodigo = PerguntaCodigo;
    }

    public String getPerguntaDescricao() {
        return PerguntaDescricao;
    }

    public void setPerguntaDescricao(String PerguntaDescricao) {
        this.PerguntaDescricao = PerguntaDescricao;
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
        if (!(object instanceof pergunta)) {
            return false;
        }
        pergunta other = (pergunta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crud.model.pergunta[ id=" + id + " ]";
    }
    
    public List<pergunta> buscarPergunta (EntityManager em) {
        return em.createQuery("SELECT p FROM pergunta p").getResultList();
    }
    
}
