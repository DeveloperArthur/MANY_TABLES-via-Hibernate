package br.com.crud.dao;

import br.com.crud.model.campus;
import br.com.crud.model.curso;
import br.com.crud.model.perg_x_resp;
import br.com.crud.model.pergunta;
import br.com.crud.model.pesquisa;
import br.com.crud.model.resposta;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Crud {

    
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CrudPU");
        EntityManager em = factory.createEntityManager();
        
        campus camp1 = new campus();
        curso cur1 = new curso();
        curso cur2 = new curso();
        curso cur3 = new curso();
        curso cur4 = new curso();
        perg_x_resp pxr1 = new perg_x_resp();
        pergunta perg1 = new pergunta();
        pesquisa pesq1 = new pesquisa();
        resposta resp1 = new resposta();
        
        camp1.setFilialNome("uninove");
        camp1.setFilialCodigo(239);
        
        em.getTransaction().begin();
        em.persist(camp1);
        em.getTransaction().commit();
        
        cur1.setCursoNome("veterinario");
        cur1.setCursoCodigo(11);
        
        em.getTransaction().begin();
        em.persist(cur1);
        em.getTransaction().commit();
        
        cur2.setCursoNome("ciencia da computacao");
        cur2.setCursoCodigo(12);
        
        em.getTransaction().begin();
        em.persist(cur2);
        em.getTransaction().commit();
        
        cur3.setCursoNome("administracao");
        cur3.setCursoCodigo(13);
        
        em.getTransaction().begin();
        em.persist(cur3);
        em.getTransaction().commit();
        
        cur4.setCursoNome("medicina");
        cur4.setCursoCodigo(14);
        
        em.getTransaction().begin();
        em.persist(cur4);
        em.getTransaction().commit();
        
        //pxr1.setRespostaCodigo(20);
        //pxr1.setPerguntaCodigo(30);
        
        perg1.setPerguntaDescricao("voce programa em java?");
        perg1.setPerguntaCodigo(82);
        
        em.getTransaction().begin();
        em.persist(perg1);
        em.getTransaction().commit();
        
        resp1.setRespostaDescricao("tambem");
        resp1.setRespostaCodigo(10);
        
        em.getTransaction().begin();
        em.persist(resp1);
        em.getTransaction().commit();
        
        pesq1.setCursoCodigo(10);
        pesq1.setFilialCodigo(239);
        pesq1.setPesquisaCodigo(30);
        pesq1.setRespostaCodigo(20);
        pesq1.setTotalResposta(100);
        
        em.getTransaction().begin();
        em.persist(pesq1);
        em.getTransaction().commit();
        
        // merge em todos os objetos que vamos buscar 
        em.getTransaction().begin();
        em.merge(camp1);
        em.getTransaction().commit();
        
        em.getTransaction().begin();
        em.merge(cur1);
        em.getTransaction().commit();
        
        em.getTransaction().begin();
        em.merge(perg1);
        em.getTransaction().commit();
        
        em.getTransaction().begin();
        em.merge(resp1);
        em.getTransaction().commit();
        
        
        //busca
        List<curso> lstCurso = cur1.buscarCurso(em);
        for (curso xnome:lstCurso){
            System.out.println("Nome: "+xnome.getCursoNome());  
        }
        
        /*
        List<campus> lstCampus = camp1.buscarCampus(em);
        for (campus xnome:lstCampus){
            System.out.println("Nome: "+xnome.getFilialNome());  
        } 
        List<curso> lstCurso = cur1.buscarCurso(em);
        for (curso xnome:lstCurso){
            System.out.println("Nome: "+xnome.getCursoNome());  
        } 
        
        List<pergunta> lstPergunta = perg1.buscarPergunta(em);
        for (pergunta xnome:lstPergunta){
            System.out.println("Nome: "+xnome.getPerguntaDescricao());  
        } 
        
        List<resposta> lstResposta = resp1.buscarResposta(em);
        for (resposta xnome:lstResposta){
            System.out.println("Nome: "+xnome.getRespostaDescricao());  
        } 
        */
    }
    
}
