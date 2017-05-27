package widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beerpad.R;

/**
 * Created by luisalfonsobejaranosanchez on 5/27/17.
 */

public class BookingTabTitleWidget extends LinearLayout {

    private TypedValue iconResource;
    private boolean hasValue;
    private String mainTitle;
    private View mRoot;

    public BookingTabTitleWidget(Context context) {
        super(context);
        initializeViews(context);
    }

    public BookingTabTitleWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
        parseAttr(context, attrs);
        initializeViews(context);
    }

    public BookingTabTitleWidget(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        parseAttr(context, attrs);
        initializeViews(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BookingTabTitleWidget(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        parseAttr(context, attrs);
        initializeViews(context);
    }

    private void parseAttr(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BookingTabTitleWidget, 0, 0);
        mainTitle = typedArray.getString(R.styleable.BookingTabTitleWidget_bookingTitle);

        iconResource = new TypedValue();
        hasValue = typedArray.getValue(R.styleable.BookingTabTitleWidget_bookingIcon, iconResource);
        typedArray.recycle();
    }

    private void initializeViews(Context context) {
        mRoot = inflate(context, R.layout.booking_tab_title, this);
        TextView mTitle = (TextView) findViewById(R.id.booking_tab_main_title);
        mTitle.setText(mainTitle);
        ImageView icon = (ImageView) findViewById(R.id.booking_tab);
        if (hasValue) {
            icon.setImageResource(iconResource.resourceId);
        }
    }

    public void setSelected() {
        mRoot.setBackgroundResource(R.drawable.sel_selected_booking_tab_title);
    }

    public void setDeselected() {
        mRoot.setBackgroundResource(android.R.color.transparent);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

}
