package cn.lc.startapp.task;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;

import androidx.annotation.Nullable;


import java.util.ArrayList;
import java.util.List;

import cn.lc.startapp.LogUtils;
import cn.lc.startapp.startup.AndroidStartup;
import cn.lc.startapp.startup.Startup;

public class Task2 extends AndroidStartup<Void> {
    static List<Class<? extends Startup<?>>> depends;

    static {
        depends = new ArrayList<>();
        depends.add(Task1.class);
    }

    @Nullable
    @Override
    public Void create(Context context) {
        String t = Looper.myLooper() == Looper.getMainLooper()
                ? "主线程: " : "子线程: ";
        LogUtils.log(t + " Task2：学习Socket");
        SystemClock.sleep(800);
        LogUtils.log(t + " Task2：掌握Socket");
        return null;
    }

    @Override
    public boolean callCreateOnMainThread() {
        return true;
    }

    @Override
    public boolean waitOnMainThread() {
        return false;
    }

    @Override
    public List<Class<? extends Startup<?>>> dependencies() {
        return depends;
    }
}
