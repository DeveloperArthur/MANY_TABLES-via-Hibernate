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
@Table(name = "pesquisa")

public class pesquisa implements Serializable {
    
    @ManyToMany
    private List<campus> campus;
    @ManyToMany
    private List<pergunta> pergunta;
    @ManyToMany
    private List<resposta> resposta;
    @ManyToMany
    private List<curso> curso;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PesquisaCodigo")
    private int PesquisaCodigo;
    @Column(name = "FilialCodigo")
    private int FilialCodigo;
    @Column(name = "CursoCodigo")
    private int CursoCodigo;
    @Column(name = "RespostaCodigo")
    private int RespostaCodigo;
    @Column(name = "TotalResposta")
    private int TotalResposta;

    public int getPesquisaCodigo() {
        return PesquisaCodigo;
    }

    public void setPesquisaCodigo(int PesquisaCodigo) {
        this.PesquisaCodigo = PesquisaCodigo;
    }

    public int getFilialCodigo() {
        return FilialCodigo;
    }

    public void setFilialCodigo(int FilialCodigo) {
        this.FilialCodigo = FilialCodigo;
    }

    public int getCursoCodigo() {
        return CursoCodigo;
    }

    public void setCursoCodigo(int CursoCodigo) {
        this.CursoCodigo = CursoCodigo;
    }

    public int getRespostaCodigo() {
        return RespostaCodigo;
    }

    public void setRespostaCodigo(int RespostaCodigo) {
        this.RespostaCodigo = RespostaCodigo;
    }

    public int getTotalResposta() {
        return TotalResposta;
    }

    public void setTotalResposta(int TotalResposta) {
        this.TotalResposta = TotalResposta;
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
        if (!(object instanceof pesquisa)) {
            return false;
        }
        pesquisa other = (pesquisa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crud.model.pesquisa[ id=" + id + " ]";
    }
    
    public List<pesquisa> buscarPesquisa (EntityManager em) {
        return em.createQuery("SELECT p FROM pesquisa p").getResultList();
    }
    
}
