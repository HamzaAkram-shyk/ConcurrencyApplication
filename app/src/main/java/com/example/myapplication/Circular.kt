package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat

class Circular(context: Context, attr: AttributeSet) : View(context, attr) {
    private var paint: Paint = Paint()
    var centerOfX = width / 2f
    private val centerOfY = height / 2f
    var radiusOfCircleView = 40F

    init {
        paint.color = ContextCompat.getColor(context, android.R.color.holo_green_light)
//        //paint.strokeWidth = 40f
//        paint.style = Paint.Style.STROKE// Constructor Call
    }

    override fun onDraw(canvas: Canvas?) {
       // canvas?.drawCircle(width/2f,height/2f ,radiusOfCircleView, paint)
      //  canvas?.drawRect(RectF(centerOfX,30f,centerOfX+100f,150f),paint)
        canvas?.drawRect(100f,50f,150f,100f,paint)
        // canvas?.drawOval(100f, 100f, 250f, 200f, paint)
        super.onDraw(canvas)
    }
}