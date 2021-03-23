package com.wanma.kotlinapp

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.annotation.ColorInt
import java.io.*
//
//
///**
// * author: wanma
// * Date: 2021/1/22
// * Description
// */
//class CustomerView: View {
//
//    private var mContext: Context? = null
//
//    //起点X
//    private var mX = 0f
//
//    //起点Y
//    private var mY = 0f
//
//    //手写画笔
//    private val mGesturePaint: Paint = Paint()
//
//    //路径
//    private val mPath: Path = Path()
//
//    //画布
//    private var cacheCanvas: Canvas? = null
//
//    //生成的图片
//    private var cachebBitmap: Bitmap? = null
//
//    //画笔宽度 px；
//    private var mPaintWidth = 3
//
//    //画笔颜色
//    private var mPenColor: Int = android.graphics.Color.BLACK
//
//    //背景色（指最终签名结果文件的背景颜色，默认为透明色）
//    private var mBackColor: Int = android.graphics.Color.TRANSPARENT
//
//    private fun init(context: Context?) {
//        mContext = context
//        //设置抗锯齿
//        mGesturePaint.isAntiAlias = true
//        //设置签名笔画样式
//        mGesturePaint.style = Paint.Style.STROKE
//        //设置笔画宽度
//        mGesturePaint.strokeWidth = mPaintWidth.toFloat()
//        //设置签名颜色
//        mGesturePaint.color = mPenColor
//    }
//
//    constructor(context: Context?) : super(context){
//        init(context)
//    }
//
//    constructor(context: Context?,attributeSet: AttributeSet?) : super(context,attributeSet){
//        init(context)
//    }
//
//    constructor(context: Context?,attributeSet: AttributeSet,defStyleAttr : Int) : super(context,attributeSet,defStyleAttr){
//        init(context)
//    }
//
//    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
//        super.onSizeChanged(w, h, oldw, oldh)
//        //创建跟view一样大的bitmap，用来保存签名(在控件大小发生改变时调用。)
//        cachebBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
//        cacheCanvas = Canvas(cachebBitmap!!)
//        cacheCanvas?.drawColor(mBackColor)
//    }
//
//    override fun onDraw(canvas: Canvas) {
//        super.onDraw(canvas)
//        //画此次笔画之前的签名
//        canvas.drawBitmap(cachebBitmap!!, 0f, 0f, mGesturePaint)
//        // 通过画布绘制多点形成的图形
//        canvas.drawPath(mPath, mGesturePaint)
//    }
//
//    override fun onTouchEvent(event: MotionEvent): Boolean {
//        when (event.action) {
//            MotionEvent.ACTION_DOWN -> touchDown(event)
//            MotionEvent.ACTION_MOVE -> touchMove(event)
//            MotionEvent.ACTION_UP -> {
//                //将路径画到bitmap中，即一次笔画完成才去更新bitmap，而手势轨迹是实时显示在画板上的。
//                cacheCanvas!!.drawPath(mPath, mGesturePaint)
//                mPath.reset()
//            }
//        }
//        // 更新绘制
//        invalidate()
//        return true
//    }
//
//
//    // 手指点下屏幕时调用
//    private fun touchDown(event: MotionEvent) {
//        // 重置绘制路线
//        mPath.reset()
//        val x = event.x
//        val y = event.y
//        mX = x
//        mY = y
//        // mPath绘制的绘制起点
//        mPath.moveTo(x, y)
//    }
//
//    // 手指在屏幕上滑动时调用
//    private fun touchMove(event: MotionEvent) {
//        val x = event.x
//        val y = event.y
//        val previousX = mX
//        val previousY = mY
//        val dx = Math.abs(x - previousX)
//        val dy = Math.abs(y - previousY)
//        // 两点之间的距离大于等于3时，生成贝塞尔绘制曲线
//        if (dx >= 3 || dy >= 3) {
//            // 设置贝塞尔曲线的操作点为起点和终点的一半
//            val cX = (x + previousX) / 2
//            val cY = (y + previousY) / 2
//            // 二次贝塞尔，实现平滑曲线；previousX, previousY为操作点，cX, cY为终点
//            mPath.quadTo(previousX, previousY, cX, cY)
//            // 第二次执行时，第一次结束调用的坐标值将作为第二次调用的初始坐标值
//            mX = x
//            mY = y
//        }
//    }
//
//
//    /**
//     * 清除画板
//     */
//    fun clear() {
//        if (cacheCanvas != null) {
//            //更新画板信息
//            mGesturePaint.color = mPenColor
//            cacheCanvas?.drawColor(mBackColor, PorterDuff.Mode.CLEAR)
//            mGesturePaint.color = mPenColor
//            invalidate()
//        }
//    }
//
//    /**
//     * 保存画板
//     * @param path 保存到路径
//     */
//    @Throws(IOException::class)
//    fun save(path: String?) {
//        save(path, false, 0)
//    }
//
//    /**
//     * 保存画板
//     * @param path       保存到路径
//     * @param clearBlank 是否清除边缘空白区域
//     * @param blank  要保留的边缘空白距离
//     */
//    @Throws(IOException::class)
//    fun save(path: String?, clearBlank: Boolean, blank: Int) {
//        var bitmap = cachebBitmap!!
//        //BitmapUtil.createScaledBitmapByHeight(srcBitmap, 300);//  压缩图片
//        if (clearBlank) {
//            bitmap = clearBlank(bitmap, blank)
//        }
//        val bos = ByteArrayOutputStream()
//        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos)
//        val buffer: ByteArray = bos.toByteArray()
//        if (buffer != null) {
//            val file = File(path)
//            if (file.exists()) {
//                file.delete()
//            }
//            val outputStream: OutputStream = FileOutputStream(file)
//            outputStream.write(buffer)
//            outputStream.close()
//        }
//    }
//
//    /**
//     * 保存画板
//     * @param clearBlank 是否清除边缘空白区域
//     * @param blank  要保留的边缘空白距离
//     */
//    fun saveToBitmap(clearBlank: Boolean, blank: Int): Bitmap? {
//        var bitmap = cachebBitmap!!
//        //BitmapUtil.createScaledBitmapByHeight(srcBitmap, 300);//  压缩图片
//        if (clearBlank) {
//            bitmap = clearBlank(bitmap, blank)
//        }
//        //        int width = bitmap.getWidth();
////        int height = bitmap.getHeight();
////        int w;
////        int h;
////        if(width>2*height){
////            w = width -(width - 2*height);
////            h = height;
////        } else {
////            w = width;
////            h = height - (height - width/2);
////        }
////        return ThumbnailUtils.extractThumbnail(bitmap,w,h);
//        return bitmap
//    }
//
//    /**
//     * 获取画板的bitmap
//     * @return
//     */
//    fun getBitMap(): Bitmap? {
//        isDrawingCacheEnabled = true
//        buildDrawingCache()
//        val bitmap = drawingCache
//        isDrawingCacheEnabled = false
//        return bitmap
//    }
//
//    /**
//     * 逐行扫描 清楚边界空白。
//     *
//     * @param bp
//     * @param blank 边距留多少个像素
//     * @return
//     */
//    private fun clearBlank(bp: Bitmap, blank: Int): Bitmap {
//        var blank = blank
//        val HEIGHT = bp.height
//        val WIDTH = bp.width
//        var top = 0
//        var left = 0
//        var right = 0
//        var bottom = 0
//        var pixs = IntArray(WIDTH)
//        var isStop: Boolean
//        //扫描上边距不等于背景颜色的第一个点
//        for (y in 0 until HEIGHT) {
//            bp.getPixels(pixs, 0, WIDTH, 0, y, WIDTH, 1)
//            isStop = false
//            for (pix in pixs) {
//                if (pix != mBackColor) {
//                    top = y
//                    isStop = true
//                    break
//                }
//            }
//            if (isStop) {
//                break
//            }
//        }
//        //扫描下边距不等于背景颜色的第一个点
//        for (y in HEIGHT - 1 downTo 0) {
//            bp.getPixels(pixs, 0, WIDTH, 0, y, WIDTH, 1)
//            isStop = false
//            for (pix in pixs) {
//                if (pix != mBackColor) {
//                    bottom = y
//                    isStop = true
//                    break
//                }
//            }
//            if (isStop) {
//                break
//            }
//        }
//        pixs = IntArray(HEIGHT)
//        //扫描左边距不等于背景颜色的第一个点
//        for (x in 0 until WIDTH) {
//            bp.getPixels(pixs, 0, 1, x, 0, 1, HEIGHT)
//            isStop = false
//            for (pix in pixs) {
//                if (pix != mBackColor) {
//                    left = x
//                    isStop = true
//                    break
//                }
//            }
//            if (isStop) {
//                break
//            }
//        }
//        //扫描右边距不等于背景颜色的第一个点
//        for (x in WIDTH - 1 downTo 1) {
//            bp.getPixels(pixs, 0, 1, x, 0, 1, HEIGHT)
//            isStop = false
//            for (pix in pixs) {
//                if (pix != mBackColor) {
//                    right = x
//                    isStop = true
//                    break
//                }
//            }
//            if (isStop) {
//                break
//            }
//        }
//        if (blank < 0) {
//            blank = 0
//        }
//        //计算加上保留空白距离之后的图像大小
//        left = if (left - blank > 0) left - blank else 0
//        top = if (top - blank > 0) top - blank else 0
//        right = if (right + blank > WIDTH - 1) WIDTH - 1 else right + blank
//        bottom = if (bottom + blank > HEIGHT - 1) HEIGHT - 1 else bottom + blank
//        //防止创建null的bitmap  引发的崩溃
//        if (left == 0 && top == 0 && right == 0 && bottom == 0) {
//            left = 1
//            top = 1
//            right = 351
//            bottom = 251
//        }
//        return Bitmap.createBitmap(bp, left, top, right - left, bottom - top)
//    }
//
//    /**
//     * 设置画笔宽度 默认宽度为10px
//     *
//     * @param mPaintWidth
//     */
//    fun setPaintWidth(mPaintWidth: Int) {
//        var mPaintWidth = mPaintWidth
//        mPaintWidth = if (mPaintWidth > 0) mPaintWidth else 10
//        this.mPaintWidth = mPaintWidth
//        mGesturePaint.strokeWidth = mPaintWidth.toFloat()
//    }
//
//
//    fun setBackColor(@ColorInt backColor: Int) {
//        mBackColor = backColor
//    }
//
//
//    /**
//     * 设置画笔颜色
//     *
//     * @param mPenColor
//     */
//    fun setPenColor(mPenColor: Int) {
//        this.mPenColor = mPenColor
//        mGesturePaint.color = mPenColor
//    }
//}

class CustomerView : View {

    /**
     * 画笔
     */
    private lateinit var paint : Paint
    private lateinit var path : Path
    private lateinit var cacheCanvas : Canvas
    /**
     * 签名画布
     */
    private lateinit var signBitmap: Bitmap
    //画笔颜色
    private var paintColor : Int = Color.BLACK
    //画笔宽度
    private var paintWidth  = 3f
    private var xAlixs : Float = 0.0f
    private var yAlixs : Float = 0.0f
    /**
     * 背景色（指最终签名结果文件的背景颜色,这里我设置为白色）
     *  你也可以设置为透明的
     */
    private var mBackColor = Color.WHITE

    //是否已经签名
    private var isSigned : Boolean = false

    constructor(context: Context?) : super(context){
        init(context)
    }

    constructor(context: Context?,attributeSet: AttributeSet?) : super(context,attributeSet){
        init(context)
    }

    constructor(context: Context?,attributeSet: AttributeSet,defStyleAttr : Int) : super(context,attributeSet,defStyleAttr){
        init(context)
    }


    fun init(context: Context?){
        paint = Paint()
        path = Path()
        //setBackgroundColor(Color.WHITE)

        paint.color = paintColor//设置签名颜色
        paint.style = Paint.Style.STROKE  //设置填充样式
        paint.isAntiAlias = true  //抗锯齿功能
        paint.strokeWidth = paintWidth//设置画笔宽度
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        //创建跟view一样大的bitmap，用来保存签名
        signBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)

        cacheCanvas = Canvas(signBitmap)
        cacheCanvas.drawColor(mBackColor)

        isSigned = false
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //画此次笔画之前的签名
        canvas.drawBitmap(signBitmap, 0f, 0f, paint)
        // 通过画布绘制多点形成的图形
        canvas.drawPath(path,paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        //记录每次 X ， Y轴的坐标
        xAlixs = event.x
        yAlixs = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                path.reset()

                path.moveTo(xAlixs, yAlixs)
            }

            MotionEvent.ACTION_MOVE -> {
                path.lineTo(xAlixs, yAlixs)
                isSigned = true
            }

            MotionEvent.ACTION_UP -> {
                //将路径画到bitmap中，即一次笔画完成才去更新bitmap，而手势轨迹是实时显示在画板上的。
                cacheCanvas.drawPath(path, paint)
                path.reset()
            }

            else -> print("error")
        }

        // 更新绘制
        invalidate()

        return true
    }

    /**
     * 清除画板
     */
    public fun clear(){

        isSigned = false
        path.reset()
        paint.color = paintColor
        cacheCanvas.drawColor(mBackColor, PorterDuff.Mode.CLEAR)

        invalidate()
    }

    /**
     * 保存画板
     *
     * @param path       保存到路径
     */
    @Throws(IOException::class)
    fun save(path: String) {

        val bitmap = signBitmap
        //  如果图片过大的话，需要压缩图片，不过在我测试手机上最大才50多kb

        val bos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos)
        val buffer = bos.toByteArray()

        if (buffer != null) {
            val file = File(path)
            if (file.exists()) {
                file.delete()
            }

            val outputStream = FileOutputStream(file)
            outputStream.write(buffer)
            outputStream.close()
        }
    }


    //TODO 这里可以扩展一些setter方法


    /**
     * 是否有签名
     *
     * @return isSigned
     */
    public fun getHasSigned() : Boolean{
        return isSigned
    }

}