package hl4a.app;

import 间.安卓.组件.基本应用;
import 间.安卓.后端.LeanCloud;
import 间.安卓.工具.主题;
import 间.安卓.工具.颜色;
//import 间.安卓.工具.图灵;

public class Application extends 基本应用 {

    @Override
    public void 应用创建事件() {
        主题.置颜色(颜色.粉色);
        //图灵.用户("f52a40b68a194459a45ad9deca0bff42");
        LeanCloud.初始化("Qttdpyw603TbXotgm9yNaKWM-gzGzoHsz","bIGCIm97yUPCAnLWawqGcnaP");
    }
    
}
