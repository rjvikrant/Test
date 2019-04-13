package vikrant.com.myapplicationchoicetechlab.Adapters;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import vikrant.com.myapplicationchoicetechlab.R;
import vikrant.com.myapplicationchoicetechlab.models.InsuranceModel;


public class InsuranceAdapter extends RecyclerView.Adapter<InsuranceAdapter.ViewHolder>
{
    private ArrayList<InsuranceModel> dataList;
    private Context activityContext;

    public ArrayList<InsuranceModel> getDataList() {
        return dataList;
    }

    public InsuranceAdapter(ArrayList<InsuranceModel> data, Context context)
    {
        this.dataList = data;
        this.activityContext =context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        AppCompatSpinner spinner_loan;
        AppCompatEditText edt_emi,edt_outstanding_loan,edt_tenure_of_loan;
        Button btn_delete;

        public ViewHolder(View itemView)
        {
            super(itemView);
            this.edt_emi = (AppCompatEditText) itemView.findViewById(R.id.edt_emi);
            this.edt_outstanding_loan = (AppCompatEditText) itemView.findViewById(R.id.edt_outstanding_loan);
            this.edt_tenure_of_loan = (AppCompatEditText) itemView.findViewById(R.id.edt_tenure_of_loan);
            this.btn_delete= (Button)itemView.findViewById(R.id.btn_delete);
            this.spinner_loan =(AppCompatSpinner)itemView.findViewById(R.id.spinner_loan);
        }
    }

    @Override
    public InsuranceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_insurance, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final InsuranceAdapter.ViewHolder holder, final int position)
    {

        holder.edt_emi.setText(String.valueOf(dataList.get(position).getPremium()));
        holder.edt_outstanding_loan.setText(String.valueOf(dataList.get(position).getSumAssured()));
        holder.edt_tenure_of_loan.setText(String.valueOf(dataList.get(position).getTenureOfInsurance()));


        holder.edt_tenure_of_loan.setOnEditorActionListener(new AppCompatEditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    // TODO do something

                    if (dataList.size() == 0) {
                        InsuranceModel loanModel = new InsuranceModel("", 0,0, 0);
                        dataList.add(loanModel);
                    }else  if (dataList.size()  == 1){
                        dataList.remove(0);
                        InsuranceModel loanModel = new InsuranceModel("", Float.parseFloat(holder.edt_emi.getText().toString()), Float.parseFloat(holder.edt_outstanding_loan.getText().toString()), Integer.parseInt(holder.edt_tenure_of_loan.getText().toString()));
                        dataList.add(loanModel);
                        notifyDataSetChanged();
                    }else if (dataList.size() <=2) {
                        InsuranceModel loanModel = new InsuranceModel("", Float.parseFloat(holder.edt_emi.getText().toString()), Float.parseFloat(holder.edt_outstanding_loan.getText().toString()), Integer.parseInt(holder.edt_tenure_of_loan.getText().toString()));
                        dataList.add(loanModel);
                        notifyDataSetChanged();
                    }else {

                        Toast.makeText(activityContext, "Not allowed", Toast.LENGTH_SHORT).show();
                    }

                    //notifyDataSetChanged();
                    handled = true;
                }
                return handled;
            }
        });
        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    dataList.remove(position);
                    notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return dataList.size();
    }
}