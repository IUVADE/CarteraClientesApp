package com.iuvade.iuvade3.carteraclientesapp.views;


class E_Articulos {
    int id;
    String concepto;
    String descripcion;
    double subtotal;
    double total;

public E_Articulos(int id, String concepto, double subtotal, String descripcion, double total){
    this.id=id;
    this.concepto=concepto;
    this.subtotal=subtotal;
    this.descripcion=descripcion;
    this.total=total;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
