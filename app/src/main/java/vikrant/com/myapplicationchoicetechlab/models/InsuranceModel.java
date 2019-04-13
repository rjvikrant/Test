package vikrant.com.myapplicationchoicetechlab.models;

public class InsuranceModel {

    String insurance;
    float premium;
    float sumAssured;
    int tenureOfInsurance;

    public InsuranceModel(String insurance, float premium, float sumAssured, int tenureOfInsurance) {
        this.insurance = insurance;
        this.premium = premium;
        this.sumAssured = sumAssured;
        this.tenureOfInsurance = tenureOfInsurance;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public float getPremium() {
        return premium;
    }

    public void setPremium(float premium) {
        this.premium = premium;
    }

    public float getSumAssured() {
        return sumAssured;
    }

    public void setSumAssured(float sumAssured) {
        this.sumAssured = sumAssured;
    }

    public int getTenureOfInsurance() {
        return tenureOfInsurance;
    }

    public void setTenureOfInsurance(int tenureOfInsurance) {
        this.tenureOfInsurance = tenureOfInsurance;
    }
}

