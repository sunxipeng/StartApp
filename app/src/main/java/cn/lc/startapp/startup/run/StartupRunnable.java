package cn.lc.startapp.startup.run;

import android.content.Context;
import android.os.Process;

import cn.lc.startapp.startup.Result;
import cn.lc.startapp.startup.Startup;
import cn.lc.startapp.startup.manage.StartupCacheManager;
import cn.lc.startapp.startup.manage.StartupManager;


public class StartupRunnable implements Runnable {
    private StartupManager startupManager;
    private Startup<?> startup;
    private Context context;

    public StartupRunnable(Context context, Startup<?> startup,
                           StartupManager startupManager) {
        this.context = context;
        this.startup = startup;
        this.startupManager = startupManager;
    }

    @Override
    public void run() {
        Process.setThreadPriority(startup.getThreadPriority());
        startup.toWait();
        Object result = startup.create(context);
        StartupCacheManager.getInstance().saveInitializedComponent(startup.getClass(),
                new Result(result));

        startupManager.notifyChildren(startup);

    }
}
