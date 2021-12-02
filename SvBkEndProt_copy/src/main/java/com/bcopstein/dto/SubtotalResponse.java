package com.bcopstein.dto;

public class SubtotalResponse {
    private Integer subtotal;
    private Integer imposto;
    private Integer total;

    public SubtotalResponse(Integer subtotal, Integer imposto, Integer total) {
        this.subtotal = subtotal;
        this.imposto = imposto;
        this.total = total;
    }

    public Integer getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getImposto() {
        return imposto;
    }

    public void setImposto(Integer imposto) {
        this.imposto = imposto;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
