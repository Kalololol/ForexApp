package api;

import javax.xml.crypto.Data;
import java.util.Date;

public class USDExchangeRateToPLN {
    private String code;
    private double midValue;
    private Date courseDate;

    public USDExchangeRateToPLN(){};

    public USDExchangeRateToPLN(String code, double midValue, Date courseDate) {
        this.code = code;
        this.midValue = midValue;
        this.courseDate = courseDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getMidValue() {
        return midValue;
    }

    public void setMidValue(double midValue) {
        this.midValue = midValue;
    }

    public Date getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(Date courseDate) {
        this.courseDate = courseDate;
    }

    @Override
    public String toString() {
        return "USDExchangeRateToPLN{" +
                "code='" + code + '\'' +
                ", midValue=" + midValue +
                ", courseDate=" + courseDate +
                '}';
    }
}
