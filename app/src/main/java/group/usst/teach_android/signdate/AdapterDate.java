package group.usst.teach_android.signdate;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import group.usst.teach_android.R;
import group.usst.teach_android.utils.CalendarInfo;
import group.usst.teach_android.utils.Course;

/**
 * Created by Administrator on 2017/8/16.
 */

public class AdapterDate extends BaseAdapter {

    private Context context;

    private List<CalendarInfo> calendarInfoList =new ArrayList<CalendarInfo>();
    private OnSignedSuccess onSignedSuccess;


    public AdapterDate(Context context, List<Course> courses) {
        this.context = context;

        int maxDay = DateUtil.getCurrentMonthLastDay();//获取当月天数
        for (int i = 0; i < DateUtil.getFirstDayOfMonth() - 1; i++) {
            calendarInfoList.add(new CalendarInfo(0, 0));
        }
        for (int i = 0; i < maxDay; i++) {
            CalendarInfo newCalendarInfo = new CalendarInfo(i+1,1);
            for (Course course : courses) {
                if (course.getDay().getDate() == (i + 1)&&course.getDay().getMonth()==DateUtil.getCurrentMonth()) {
                    if (course.getIsAble() == 1) {
                        newCalendarInfo.setStatus(2);
                        break;
                    } else if (course.getIsAble() == 2) {
                        newCalendarInfo.setStatus(3);
                        break;
                    }
                }
            }
            calendarInfoList.add(newCalendarInfo);
        }
    }


    @Override
    public int getCount() {
        return calendarInfoList.size();
    }

    @Override
    public Object getItem(int i) {
        return calendarInfoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view==null){
            view = LayoutInflater.from(context).inflate(R.layout.item_gv,null);
            viewHolder = new ViewHolder();
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tv = view.findViewById(R.id.tvWeek);
        viewHolder.rlItem = view.findViewById(R.id.rlItem);
        viewHolder.ivStatus = view.findViewById(R.id.ivStatus);


        viewHolder.tv.setText(calendarInfoList.get(i).getDay()+"");
        if (calendarInfoList.get(i).getDay() == 0) {//不显示
            viewHolder.rlItem.setVisibility(View.GONE);
        } else if (calendarInfoList.get(i).getStatus() == 1) {//不可预约
            viewHolder.tv.setTextColor(Color.parseColor("#666666"));
            viewHolder.ivStatus.setVisibility(View.GONE);
        } else if (calendarInfoList.get(i).getStatus() == 2) {//课预约
            viewHolder.tv.setTextColor(Color.parseColor("#FD0000"));
            viewHolder.ivStatus.setVisibility(View.GONE);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onSignedSuccess!=null){
                        onSignedSuccess.OnSignedSuccess();
                    }
                }
            });
        } else if (calendarInfoList.get(i).getStatus() == 3) {//已预约
            viewHolder.tv.setTextColor(Color.parseColor("#0000FF"));
            viewHolder.ivStatus.setVisibility(View.VISIBLE);
        }

        return view;
    }


    class ViewHolder{
        RelativeLayout rlItem;
        TextView tv;
        ImageView ivStatus;
    }

    public void setOnSignedSuccess(OnSignedSuccess onSignedSuccess){
        this.onSignedSuccess = onSignedSuccess;
    }
}
