package logic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class RateApi {

    @JsonProperty("no")
    private String no;
    @JsonProperty("effectiveDate")
    private Date effectiveDate;
    @JsonProperty("mid")
    private double mid;
    public RateApi(){}
    public RateApi(String no, Date effectiveDate, double mid) {
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.mid = mid;
    }
    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public double getMid() {
        return mid;
    }

    public void setMid(double mid) {
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "mid=" + mid +
                '}';
    }
}
