package com.landlord.android.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EstateDTO implements Serializable {
    public int id;
    public byte[] image;
    public BigDecimal monthlyRent;
    BigDecimal owedAmount;



    public EstateDTO() {

    }

    public EstateDTO(int id, byte[] image, BigDecimal monthlyRent) {
        // public constructor is needed for parsing from/to JSON to work
    }

    public BigDecimal getOwedAmount() {
        return owedAmount;
    }

    public void setOwedAmount(BigDecimal owedAmount) {
        this.owedAmount = owedAmount;
    }

    public EstateDTO(
            int id,
            byte[] image,
            BigDecimal monthlyRent,
            BigDecimal owedAmount
    )
    {
        this.id=id;
        this.image=image;
        this.monthlyRent=monthlyRent;

        this.owedAmount=owedAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public BigDecimal getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(BigDecimal monthlyRent) {
        this.monthlyRent = monthlyRent;
    }
}
