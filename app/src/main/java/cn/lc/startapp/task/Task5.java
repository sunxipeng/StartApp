package cn.lc.startapp.task;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;


import java.util.ArrayList;
import java.util.List;

import cn.lc.startapp.LogUtils;
import cn.lc.startapp.startup.AndroidStartup;
import cn.lc.startapp.startup.Startup;

public class Task5 extends AndroidStartup<Void> {

    static List<Class<? extends Startup<?>>> depends;

    static {
        depends = new ArrayList<>();
        depends.add(Task3.class);
        depends.add(Task4.class);
    }

    @Override
    public Void create(Context context) {
        String t = Looper.myLooper() == Looper.getMainLooper()
                ? "主线程: " : "子线程: ";
        LogUtils.log(t + " Task5：学习OkHttp");
        SystemClock.sleep(500);
        LogUtils.log(t + " Task5：掌握OkHttp");
        return null;
    }

    @Override
    public boolean callCreateOnMainThread() {
        return false;
    }

    @Override
    public boolean waitOnMainThread() {
        return true;
    }

    //执行此任务需要依赖哪些任务
    @Override
    public List<Class<? extends Startup<?>>> dependencies() {
        return depends;
    }

}
