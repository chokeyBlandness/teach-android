package group.usst.teach_android.signdate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.List;

import group.usst.teach_android.R;
import group.usst.teach_android.utils.Course;

/**
 * Created by Administrator on 2017/8/16.
 */

public class SignDate extends LinearLayout {

    private TextView tvYear;
    private InnerGridView gvWeek;
    private InnerGridView gvDate;
    private AdapterDate adapterDate;

    private List<Course> courses;

    public SignDate(Context context) {
        super(context);
        init();
    }

    public SignDate(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SignDate(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){}

    public void setView(){
        View view = View.inflate(getContext(), R.layout.layout_signdate,this);
        tvYear = view.findViewById(R.id.tvYear);
        gvWeek = view.findViewById(R.id.gvWeek);
        gvDate = view.findViewById(R.id.gvDate);
        tvYear.setText(DateUtil.getCurrentYearAndMonth());
        gvWeek.setAdapter(new AdapterWeek(getContext()));


        adapterDate = new AdapterDate(getContext(),courses);
        gvDate.setAdapter(adapterDate);
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }


    /**
     * 签到成功的回调
     * @param onSignedSuccess
     */
    public void setOnSignedSuccess(OnSignedSuccess onSignedSuccess){
        adapterDate.setOnSignedSuccess(onSignedSuccess);
    }
}
