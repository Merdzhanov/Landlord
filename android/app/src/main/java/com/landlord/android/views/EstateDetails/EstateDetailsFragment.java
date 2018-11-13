package com.landlord.android.views.EstateDetails;



import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.landlord.android.R;
import com.landlord.android.models.Estate;
import com.landlord.android.models.User;
import com.landlord.android.models.base.UserType;
import com.landlord.android.views.EstatesList.EstatesListActivity;
import com.squareup.picasso.Picasso;

import java.text.BreakIterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.exceptions.Exceptions;

public class EstateDetailsFragment
        extends Fragment
        implements EstateDetailsContracts.View , ReviewListener{

   // public static final String ARG_OBJECT = "object";

    private EstateDetailsContracts.Presenter mPresenter;

    @BindView(R.id.tv_name)
    TextView mNameTextView;

    @BindView(R.id.iv_estate_details)
    ImageView mImageView;

    @BindView(R.id.tv_description)
    TextView mDescriptionTextView;

    @BindView(R.id.tv_address)
    TextView mAddressTextView;

    @BindView(R.id.tv_monthly_rent)
    TextView mMonthlyRentTextView;

    @BindView(R.id.tv_owed_amount)
    TextView mOwedAmountTextView;

    @BindView(R.id.tv_due_date)
    TextView mDueDateTextView;

    @BindView(R.id.tv_due_date_approaching)
    TextView mDueDateApproachingTextView;

    @BindView(R.id.tv_landlord_name)
    TextView mLandlordName;

    @BindView(R.id.rating_landlord)
    RatingBar mLandlordRatingBar;

    @BindView(R.id.tv_rate_landlord)
    TextView mRateLandlord;

    @BindView(R.id.tv_tenant_name)
    TextView mTenantName;

    @BindView(R.id.rating_tenant)
    RatingBar mTenantRatingBar;

    @BindView(R.id.tv_rate_tenant)
    TextView mRateTenant;

    View mView;
    ReviewListener mReviewListener;
    User mLandlord;
    User mTenant;
    private String mWhoRates;

    Handler handler = new Handler();
    // Define the code block to be executed
    private Runnable runnableCode = new Runnable() {
        @Override
        public void run() {
            // Do something here on the main thread
            Log.d("Handlers", "Called on main thread");
            refresh();
            // Repeat this the same runnable code block again another 2 seconds
            handler.postDelayed(runnableCode, 5000);
        }
        private void refresh() {
            mPresenter.loadEstate();
        }
    };

    @Inject
    public EstateDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_estate_details, container, false);
        ButterKnife.bind(this, rootView);
        mView=rootView;
        hideKeyboardFrom(getContext(), mView);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadEstate();
        hideKeyboardFrom(getContext(), mView);
    }

    @Override
    public void onStart() {
        super.onStart();
        handler.post(runnableCode);
        hideKeyboardFrom(getContext(), mView);
    }

    @Override
    public void showEstate(Estate Estate) {
        mReviewListener=this;
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(EstatesListActivity.getAppContext());
        String username = sharedPrefs.getString("username", "");
        mNameTextView.setText(Estate.getName());
        Picasso.get().load(Estate.getImageUrl()).into(mImageView);
        mDescriptionTextView.setText("Description : " + Estate.getDescription());
        mDescriptionTextView.setMovementMethod(new ScrollingMovementMethod());
        mAddressTextView.setText("Address : " + Estate.getAddress());
        mMonthlyRentTextView.setText("Monthly Rent : " + Estate.getMonthlyRent().toString() + " BGN");
        mOwedAmountTextView.setText("Owed Amount : " + Estate.getOwedAmount()  + " BGN");
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        //DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date dueDate=Estate.getDueDate();
        String dueDateString = dateFormat.format(dueDate);
        mDueDateTextView.setText("Due Date : " + dueDateString);
        Date today=new Date();
        long diffInMillies = dueDate.getTime() - today.getTime();
        TimeUnit timeUnit=TimeUnit.DAYS;
        long daysLambda= timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS)+1;
        if(daysLambda<=5&&daysLambda>=-1){
            if(daysLambda>1){
                mDueDateApproachingTextView.setText("   (in " + daysLambda + " days!)");
            }
            if(daysLambda==1){
                mDueDateApproachingTextView.setText("   (in " + daysLambda + " day!!)");
            }
            if(daysLambda==0){
                mDueDateApproachingTextView.setText("   (Today!!!)");
            }
        }else{
            mDueDateApproachingTextView.setVisibility(View.GONE);
        }
        //User landlord=null;
        try{
            mLandlord=Estate.getUsers().stream()
                .filter(user -> user.getUserType().compareTo(UserType.LANDLORD)==0 )
                .findFirst()
                .get();
        }catch (Throwable e) {
            e.printStackTrace();
        }
        if(mLandlord!=null) {
            if (mLandlord.getUserName().equals(username)) {
                mRateLandlord.setVisibility(View.GONE);
            }
            mLandlordName.setText("Landlord : " + mLandlord.getFirstName() + " " + mLandlord.getLastName() + "(" + mLandlord.getUserName() + ")");
            mLandlordRatingBar.setRating(mLandlord.getRating());
            mRateLandlord.setText("Rate Landlord");
            mRateLandlord.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context= getContext();
                    FiveStarsDialog fiveStarsDialog = new FiveStarsDialog(context);//new FiveStarsDialog(getContext(),mTenant);
                    fiveStarsDialog.setRateText("How many stars your landlord deserves?")
                            .setTitle("")
                            //.setForceMode(false)
                            .setStarColor(Color.YELLOW)
                            //.setUpperBound(2) // Market opened if a rating >= 2 is selected
                            //.setNegativeReviewListener(this) // OVERRIDE mail intent for negative review
                            .setReviewListener(mReviewListener) // Used to listen for reviews (if you want to track them )
                            .showAfter(0);
                }
            });
        }else{
            mLandlordName.setVisibility(View.GONE);
            mLandlordRatingBar.setVisibility(View.GONE);
            mRateLandlord.setVisibility(View.GONE);
        }
        //final User tenant=null;
        try{
            mTenant=Estate.getUsers().stream()
                    .filter(user -> user.getUserType().compareTo(UserType.TENANT)==0 )
                    .findFirst()
                    .get();
        }catch (Throwable e) {
            e.printStackTrace();
        }
        if(mTenant!=null) {
            mTenantName.setText("Tenant : " + mTenant.getFirstName() + " " + mTenant.getLastName() + "(" + mTenant.getUserName() + ")");
            mTenantRatingBar.setRating(mTenant.getRating());
            if(mTenant.getUserName().equals(username)){
                mWhoRates="tenant";
                mRateTenant.setVisibility(View.GONE);
            }
            mRateTenant.setText("Rate Tenant");
            mRateTenant.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context= getContext();
                    FiveStarsDialog fiveStarsDialog = new FiveStarsDialog(context);//new FiveStarsDialog(getContext(),mTenant);
                    fiveStarsDialog.setRateText("How many stars your tenant deserves?")
                            .setTitle("")
                            //.setForceMode(false)
                            .setStarColor(Color.YELLOW)
                            //.setUpperBound(2) // Market opened if a rating >= 2 is selected
                            //.setNegativeReviewListener(this) // OVERRIDE mail intent for negative review
                            .setReviewListener(mReviewListener) // Used to listen for reviews (if you want to track them )
                            .showAfter(0);
                }
            });
        }else{
            mTenantName.setVisibility(View.GONE);
            mTenantRatingBar.setVisibility(View.GONE);
            mRateTenant.setVisibility(View.GONE);
        }
       // mRatingBar.setOnRatingBarChangeListener();
    }

    @Override
    public void setPresenter(EstateDetailsContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError(Throwable e) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onReview(int stars) {//, User user) {
        if (mWhoRates == "tenant") {
            mPresenter.setRating(mTenant, mLandlord, stars);
        } else {
            mPresenter.setRating(mLandlord, mTenant, stars);
        }
    }

    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
