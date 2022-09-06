package cn.lc.startapp;

import android.app.Application;

import cn.lc.startapp.startup.manage.StartupManager;
import cn.lc.startapp.task.Task1;
import cn.lc.startapp.task.Task2;
import cn.lc.startapp.task.Task3;
import cn.lc.startapp.task.Task4;
import cn.lc.startapp.task.Task5;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /*new StartupManager.Builder()
                .addStartup(new Task5())
                .addStartup(new Task4())
                .addStartup(new Task3())
                .addStartup(new Task2())
                .addStartup(new Task1())
                .build(this)
                .start().await();*/
    }
}
