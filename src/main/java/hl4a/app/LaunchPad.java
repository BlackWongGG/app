package hl4a.app;

import android.os.Bundle;
import hl4a.app.界面.主页;
import 间.安卓.组件.启动界面;

public class LaunchPad extends 启动界面 {

    @Override
    protected void 准备完成() {
        跳转界面(主页.class);
        结束界面();
    }

    
}
