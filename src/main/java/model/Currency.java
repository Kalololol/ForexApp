package model;

import java.util.Date;

public class Currency {
    private Date date;
    private String code;
    private double mid;
    public Currency (){}
    public Currency(Date date, String code, double mid) {
        this.date = date;
        this.code = code;
        this.mid = mid;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getMid() {
        return mid;
    }

    public void setMid(double mid) {
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "date=" + date +
                ", code='" + code + '\'' +
                ", mid=" + mid +
                '}';
    }
}
