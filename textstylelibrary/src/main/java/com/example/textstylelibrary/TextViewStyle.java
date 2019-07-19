package com.example.textstylelibrary;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

public class TextViewStyle extends View {

    private String text;
    private int textSize;
    private int textColor;
    private Paint paint = new Paint();
    private int height, width;
    private int DEFAULT_TEXT_SIZE = 20;
    private String fonts[] = {"font1.ttf", "font2.ttf", "font3.otf", "font4.ttf", "font5.ttf"};
    private int textStyle = 0;
    private Typeface typeface;
    private int DEFAULT_TEXT_STYLE = 0;

    public TextViewStyle(Context context) {
        super(context);

        setup();

    }

    public TextViewStyle(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public TextViewStyle(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        //Getting attributes from resource
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextViewStyle, defStyle, 0);
        textSize = typedArray.getInteger(R.styleable.TextViewStyle_textSize, DEFAULT_TEXT_SIZE);


        CharSequence charSequence = typedArray.getString(R.styleable.TextViewStyle_text);

        if (charSequence != null) {
            text = charSequence.toString();
        } else {
            text = " ";
        }

        textColor = typedArray.getColor(R.styleable.TextViewStyle_textColor, Color.BLACK);

        textStyle = typedArray.getInteger(R.styleable.TextViewStyle_textStyle, DEFAULT_TEXT_STYLE);

        //Attributes text view
        AssetManager assetManager = context.getAssets();

        if (textStyle == 0) {
            typeface = Typeface.createFromAsset(assetManager, fonts[textStyle]);
        } else {
            typeface = Typeface.createFromAsset(assetManager, fonts[textStyle - 1]);
        }

        typedArray.recycle();

        setup();
    }

    private void setup() {

        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(8);
        paint.setColor(textColor);
        paint.setTextSize(textSize);
        paint.setTypeface(typeface);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawText(text, 150, 150, paint);
    }

}