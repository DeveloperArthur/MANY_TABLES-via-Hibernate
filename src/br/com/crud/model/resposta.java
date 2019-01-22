package br.com.crud.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "resposta")

public class resposta implements Serializable {
    
    @OneToMany
    private List<perg_x_resp> perg_x_resp;
    @OneToMany
    private List<pesquisa> pesquisa;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "RespostaCodigo")
    private int RespostaCodigo;
    @Column(name = "RespostaDescricao")
    private String RespostaDescricao;

    public int getRespostaCodigo() {
        return RespostaCodigo;
    }

    public void setRespostaCodigo(int RespostaCodigo) {
        this.RespostaCodigo = RespostaCodigo;
    }

    public String getRespostaDescricao() {
        return RespostaDescricao;
    }

    public void setRespostaDescricao(String RespostaDescricao) {
        this.RespostaDescricao = RespostaDescricao;
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
        return "br.com.crud.model.resposta[ id=" + id + " ]";
    }
    
    public List<resposta> buscarResposta (EntityManager em) {
        return em.createQuery("select c from resposta c").getResultList();
    }
    
}
