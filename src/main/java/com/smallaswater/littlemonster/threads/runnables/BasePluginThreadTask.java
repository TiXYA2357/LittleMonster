package com.smallaswater.littlemonster.threads.runnables;

import com.smallaswater.littlemonster.LittleMonsterMainClass;

/**
 * @author SmallasWater
 * Create on 2021/6/29 8:17
 * Package com.smallaswater.littlemonster.threads.runnables
 */
public abstract class BasePluginThreadTask implements Runnable {

    @Override
    public final void run() {
        while (LittleMonsterMainClass.getInstance().isEnabled()) {
            try {
                if(!scheduler()) {
                    break;
                }
                Thread.sleep(1000);
            } catch (Exception e) {
                if (e instanceof InterruptedException) {
                    return;
                }
                LittleMonsterMainClass.getInstance().getLogger().error("BasePluginThreadTask Error", e);
            }
        }
    }

    /**
     * 循环执行
     * @return 是否继续执行
     * */
    abstract public boolean scheduler();

}
