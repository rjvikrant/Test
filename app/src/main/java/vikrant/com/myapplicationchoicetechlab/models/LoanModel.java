package vikrant.com.myapplicationchoicetechlab.models;

public class LoanModel {

   String loanType;
   float emi;
   float outstandingLoan;
   int tenureOfLoan;

    public LoanModel(String loanType, float emi, float outstandingLoan, int tenureOfLoan) {
        this.loanType = loanType;
        this.emi = emi;
        this.outstandingLoan = outstandingLoan;
        this.tenureOfLoan = tenureOfLoan;
    }


    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public float getEmi() {
        return emi;
    }

    public void setEmi(float emi) {
        this.emi = emi;
    }

    public float getOutstandingLoan() {
        return outstandingLoan;
    }

    public void setOutstandingLoan(float outstandingLoan) {
        this.outstandingLoan = outstandingLoan;
    }

    public int getTenureOfLoan() {
        return tenureOfLoan;
    }

    public void setTenureOfLoan(int tenureOfLoan) {
        this.tenureOfLoan = tenureOfLoan;
    }
}
