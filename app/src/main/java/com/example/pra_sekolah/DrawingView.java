package com.example.pra_sekolah;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawingView extends View {

    private Path path;
    private Paint paint;

    public DrawingView(Context context) {
        super(context);
        init();
    }

    public DrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        path = new Path();
        paint = new Paint();
        paint.setColor(Color.BLACK); // Warna default garis
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10); // Ketebalan garis
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                break;
            case MotionEvent.ACTION_UP:
                // Tidak ada tindakan khusus saat jari diangkat
                break;
            default:
                return false;
        }

        // Meminta view untuk digambar ulang (memanggil onDraw)
        invalidate();
        return true;
    }

    // Metode untuk mengubah warna garis
    public void setStrokeColor(int color) {
        paint.setColor(color);
    }

    // Metode untuk mengubah ketebalan garis
    public void setStrokeWidth(float width) {
        paint.setStrokeWidth(width);
    }

    // Metode untuk menghapus semua gambar
    public void clearCanvas() {
        path.reset();
        invalidate();
    }
}
