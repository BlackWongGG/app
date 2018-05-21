package hl4a.app;

import 间.安卓.组件.基本应用;
import 间.安卓.工具.主题;
import 间.安卓.工具.颜色;
import hl4a.app.界面.主页;
import android.content.Context;
import 间.安卓.后端.后端;
import 间.安卓.后端.提供者.LeanCloud;

public class Application extends 基本应用 {
    
    @Override
    public void 应用创建事件() {
        主题.置颜色(颜色.深紫);
        后端.置当前后端(new LeanCloud("Qttdpyw603TbXotgm9yNaKWM-gzGzoHsz","bIGCIm97yUPCAnLWawqGcnaP"));
    }

}
