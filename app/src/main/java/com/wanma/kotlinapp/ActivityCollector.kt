package com.wanma.kotlinapp

import android.app.Activity

/**
 * author: wanma
 * Date: 2021/3/5
 * Description
 */
object ActivityCollector {
    private val activities = ArrayList<Activity>()

    fun addActivity(activity: Activity) {
        activities.add(activity)
    }

    fun removeActivity(activity: Activity) {
        activities.remove(activity)
    }

    fun finishAll() {
        for(activity in activities) {
            if(!activity.isFinishing) {
                activity.finish()
            }
        }
        activities.clear()
    }
}