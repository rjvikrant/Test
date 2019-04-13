package vikrant.com.myapplicationchoicetechlab.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import vikrant.com.myapplicationchoicetechlab.Adapters.InsuranceAdapter;
import vikrant.com.myapplicationchoicetechlab.Adapters.LoanAdapter;
import vikrant.com.myapplicationchoicetechlab.R;
import vikrant.com.myapplicationchoicetechlab.models.InsuranceModel;
import vikrant.com.myapplicationchoicetechlab.models.LoanModel;

public class MyFragment extends Fragment {
    RecyclerView recyclerloan,recyclerInsurance;
    LoanAdapter loanAdapter;
    InsuranceAdapter insuranceAdapter;
    ArrayList<LoanModel> LoanData;
    ArrayList<InsuranceModel> InsuranceData;
    ImageButton btnAddLoanItem,btnAddInsuranceItem;

    public static MyFragment newInstance()
    {
        return new MyFragment();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= (View) inflater.inflate(R.layout.myfragment,container,false);



        // mTextViewEmpty = (TextView)view.findViewById(R.id.textViewEmpty);
      //  mImageViewEmpty = (ImageView)view.findViewById(R.id.imageViewEmpty);
       // mProgressBarLoading = (ProgressBar)view.findViewById(R.id.progressBarLoading);

            setLoadRecyclerView(v);
            setInsuranceRecyclerView(v);
        return v;

    }



    private void setLoadRecyclerView(View v) {

        recyclerloan = (RecyclerView) v.findViewById(R.id.loan_recycler);
        btnAddLoanItem =(ImageButton) v.findViewById(R.id.additem);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerloan.setLayoutManager(layoutManager);

        LoanData = new ArrayList<LoanModel>();


        LoanModel l1 = new LoanModel("",0,0,0);
        LoanData.add(l1);


        loanAdapter = new LoanAdapter(LoanData,getActivity());
        recyclerloan.setAdapter(loanAdapter);


        btnAddLoanItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (LoanData.size() <3) {


                    ArrayList<LoanModel> newData = new ArrayList<>();
                 //   LoanData.clear();
                    LoanModel l1 = new LoanModel("", 0, 0, 0);
                    newData.add(l1);
                    newData.addAll(loanAdapter.getDataList());
                   // LoanData.addAll(newData)
                    if (newData.size() <= 3)
                    recyclerloan.setAdapter(new LoanAdapter(newData,getActivity()));
                    else
                        Toast.makeText(getActivity(), "Can not add more than 3 elements", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity(), "Can not add more than 3 elements", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    private void setInsuranceRecyclerView(View v) {

        recyclerInsurance = (RecyclerView) v.findViewById(R.id.insurance_recycler);
        btnAddInsuranceItem =(ImageButton) v.findViewById(R.id.additem2);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerInsurance.setLayoutManager(layoutManager);

        InsuranceData = new ArrayList<InsuranceModel>();


        InsuranceModel l1 = new InsuranceModel("",0,0,0);
        InsuranceData.add(l1);


        insuranceAdapter = new InsuranceAdapter(InsuranceData,getActivity());
        recyclerInsurance.setAdapter(insuranceAdapter);


        btnAddInsuranceItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (InsuranceData.size() <2) {

                    ArrayList<InsuranceModel> newModel = new ArrayList<>();

                    InsuranceModel l1 = new InsuranceModel("",0,0,0);
                    newModel.add(l1);
                    newModel.addAll(insuranceAdapter.getDataList());
                    if (newModel.size() <= 2)
                    recyclerInsurance.setAdapter(new InsuranceAdapter(newModel,getActivity()));

                    else
                        Toast.makeText(getContext(), "Not allowed", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity(), "Can not add more than 2 elements", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}



