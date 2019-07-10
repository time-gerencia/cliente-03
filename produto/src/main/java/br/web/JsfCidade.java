/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author alexandrelerario
 */
@Named(value = "jsfCidade")
@SessionScoped
public class JsfCidade implements Serializable {

    /**
     * Creates a new instance of JsfCidade
     */
    public JsfCidade() {
    }
    
    private Integer codigo;
    private String nome;
    private long latitude;
    private long longitude;
    private String error;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
      public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }
    
    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }
    
     public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    public void persist(){
        br.data.entity.Cidade cid = new br.data.entity.Cidade();
        
        
         try{
            if(codigo == 0)
            {
              throw new Exception("Cidade não pode ter código 0.");  
            }
            cid.setCodigo(codigo);
        cid.setNome(nome);
        cid.setLatitude(latitude);
        cid.setLongitude(longitude);
        new br.data.crud.CrudCidade().persist(cid);
        }catch(Exception exp)
        {
            cid.setError(exp.getMessage());
            this.setError(exp.getMessage());
        }
    }
    
    public java.util.Collection<br.data.entity.Cidade> getAll(){
        return new br.data.crud.CrudCidade().getAll();
    }
}
