package edu.escuelaing.arsw.model;

import java.time.LocalDateTime;

import javax.persistence.Table;

@Table(name = "subastas")
public class Subasta {
    private String remitente;
    private String destinatario;
    private String contenido;
    private LocalDateTime hora = LocalDateTime.now();
    private Estado estados;


    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public Estado getEstados() {
        return estados;
    }
    
    public void setEstados(Estado estados) {
        this.estados = estados;
    }

    
}
