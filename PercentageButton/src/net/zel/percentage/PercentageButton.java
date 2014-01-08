package net.zel.percentage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;


public class PercentageButton extends Button {


   private float mPercentageWidth;
   private float mPercentageHeight;
   private final int MAX_PERCENTAGE = 100;


    public PercentageButton(Context context) {
        this(context, null);
    }

    public PercentageButton(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.buttonStyle);
    }

    public PercentageButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, context);
    }

    private void init(AttributeSet attrs, Context context) {
        TypedArray typeAttr = context.obtainStyledAttributes(attrs, R.styleable.custom_size);

        mPercentageHeight = typeAttr.getFloat(R.styleable.custom_size_percentage_height, 1.0f);
        mPercentageWidth = typeAttr.getFloat(R.styleable.custom_size_percentage_width, 1.0f);

        typeAttr.recycle();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        if((mPercentageHeight > MAX_PERCENTAGE) || (mPercentageWidth > MAX_PERCENTAGE) ||  (mPercentageHeight < 0) || (mPercentageWidth < 0))
                throw new RuntimeException("invalid attribute value");

        int height = (int) (MeasureSpec.getSize(heightMeasureSpec)* mPercentageHeight /MAX_PERCENTAGE);
        int width = (int) (MeasureSpec.getSize(widthMeasureSpec)* mPercentageWidth /MAX_PERCENTAGE);

        setWidth(width);
        setHeight(height);
        setMeasuredDimension(width, height);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setPercentageWidth(int percentageWidth){
        mPercentageWidth = percentageWidth;
        setWidth((int) mPercentageWidth);
        invalidate();

    }

    public void setPercentageHeight(int percentageHeight){
        mPercentageHeight = percentageHeight;
        setHeight((int) mPercentageHeight);
        invalidate();
    }


}
