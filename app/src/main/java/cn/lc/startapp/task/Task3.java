
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

public class Task3 extends AndroidStartup<Void> {

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
        LogUtils.log(t+" Task3：学习设计模式");
        SystemClock.sleep(2_000);
        LogUtils.log(t+" Task3：掌握设计模式");
        return null;
    }


    //    执行此任务需要依赖哪些任务
    @Nullable
    @Override
    public List<Class<? extends Startup<?>>> dependencies() {
        return depends;
    }


    @Override
    public boolean callCreateOnMainThread() {
        return false;
    }

    @Override
    public boolean waitOnMainThread() {
        return false;
    }
}
