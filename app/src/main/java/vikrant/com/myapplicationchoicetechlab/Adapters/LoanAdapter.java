package vikrant.com.myapplicationchoicetechlab.Adapters;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
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
import vikrant.com.myapplicationchoicetechlab.models.LoanModel;

public class LoanAdapter extends RecyclerView.Adapter<LoanAdapter.ViewHolder>
{
    public ArrayList<LoanModel> getDataList() {
        return dataList;
    }

    private ArrayList<LoanModel> dataList;
    private Context activityContext;

    public LoanAdapter(ArrayList<LoanModel> data, Context context)
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
    public LoanAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_loan, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final LoanAdapter.ViewHolder holder, final int position)
    {

        holder.edt_emi.setText(String.valueOf(dataList.get(position).getEmi()));
        holder.edt_outstanding_loan.setText(String.valueOf(dataList.get(position).getOutstandingLoan()));
        holder.edt_tenure_of_loan.setText(String.valueOf(dataList.get(position).getTenureOfLoan()));

        holder.edt_tenure_of_loan.setOnEditorActionListener(new AppCompatEditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    // TODO do something

                    if (dataList.size()  == 1){
                        dataList.remove(0);
                        LoanModel loanModel = new LoanModel("", Float.parseFloat(holder.edt_emi.getText().toString()), Float.parseFloat(holder.edt_outstanding_loan.getText().toString()), Integer.parseInt(holder.edt_tenure_of_loan.getText().toString()));
                        dataList.add(loanModel);
                        notifyDataSetChanged();
                    }else if (dataList.size() <=3) {
                        LoanModel loanModel = new LoanModel("", Float.parseFloat(holder.edt_emi.getText().toString()), Float.parseFloat(holder.edt_outstanding_loan.getText().toString()), Integer.parseInt(holder.edt_tenure_of_loan.getText().toString()));
                        dataList.add(loanModel);
                        notifyDataSetChanged();
                    }else {

                        Toast.makeText(activityContext, "Not allowed", Toast.LENGTH_SHORT).show();
                    }
                    handled = true;
                }
                return handled;
            }
        });
        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dataList.size() >1) {
                    dataList.remove(position);
                    notifyDataSetChanged();
                }else {
                    Toast.makeText(activityContext, "You can not remove this element", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return dataList.size();
    }
}