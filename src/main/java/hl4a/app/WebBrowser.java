package hl4a.app;

import android.net.Uri;
import android.os.Bundle;
import 间.安卓.工具.提示;
import 间.安卓.组件.基本界面;
import 间.安卓.视图.浏览器;
import 间.网络.资源;
import 间.网络.连接;
import 间.接口.回调方法;
import 间.接口.返回值;
import 间.接口.单值方法;
import 间.安卓.工具.设备;
import 间.安卓.工具.处理;
import 间.安卓.弹窗.列表弹窗;

public class WebBrowser extends 基本界面 {

    浏览器 浏览器;
    列表弹窗 列表;

    @Override
    public void 界面创建事件(Bundle $恢复) {
        super.界面创建事件($恢复);
        置滑动返回(true);
        Uri $链接 = getIntent().getData();
        if ($链接 == null) { 结束界面(); return; }
        取标题栏().返回按钮(this);
        
        置标题($链接.toString());
        浏览器 = 打开布局(new 浏览器(this));
        浏览器.置链接($链接.toString());
      
        浏览器.置标题更换事件(代理("置标题"));

        取菜单().添加("复制链接", 配置("复制链接"));
        取菜单().添加("复制源码", 配置("复制源码"));
        取菜单().添加("设置标识", 配置("选择标识"));

        列表 = new 列表弹窗(this);

        添加标识("电脑 : safari 5.1 – MAC", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_8; en-us) AppleWebKit/534.50 (KHTML, like Gecko) Version/5.1 Safari/534.50");

        添加标识("电脑 : safari 5.1 – Windows", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-us) AppleWebKit/534.50 (KHTML, like Gecko) Version/5.1 Safari/534.50");

        添加标识("电脑 : IE 9.0", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0;");

        添加标识("电脑 : IE 8.0", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0; Trident/4.0)");

        添加标识("电脑 : IE 7.0", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0)");

        添加标识("电脑 : IE 6.0", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");

        添加标识("电脑 : Firefox 4.0.1 – MAC", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv:2.0.1) Gecko/20100101 Firefox/4.0.1");

        添加标识("电脑 : Firefox 4.0.1 – Windows", "Mozilla/5.0 (Windows NT 6.1; rv:2.0.1) Gecko/20100101 Firefox/4.0.1");

        添加标识("电脑 : Opera 11.11 – MAC", "Opera/9.80 (Macintosh; Intel Mac OS X 10.6.8; U; en) Presto/2.8.131 Version/11.11");

        添加标识("电脑 : Opera 11.11 – Windows", "Opera/9.80 (Windows NT 6.1; U; en) Presto/2.8.131 Version/11.11");

        添加标识("电脑 : Chrome 17.0 – MAC", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_0) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11");

        添加标识("电脑 : 傲游（Maxthon）", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Maxthon 2.0)");

        添加标识("电脑 : 腾讯TT", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; TencentTraveler 4.0)");

        添加标识("电脑 : 世界之窗（The World） 2.x", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");

        添加标识("电脑 : 世界之窗（The World） 3.x", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; The World)");

        添加标识("电脑 : 搜狗浏览器 1.x", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; SE 2.X MetaSr 1.0; SE 2.X MetaSr 1.0; .NET CLR 2.0.50727; SE 2.X MetaSr 1.0)");

        添加标识("电脑 : 360浏览器", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; 360SE)");

        添加标识("电脑 : Avant", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Avant Browser)");

        添加标识("电脑 : Green Browser", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");

        添加标识("手机 : safari iOS 4.33 – iPhone", "Mozilla/5.0 (iPhone; U; CPU iPhone OS 4_3_3 like Mac OS X; en-us) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8J2 Safari/6533.18.5");

        添加标识("手机 : safari iOS 4.33 – iPod Touch", "Mozilla/5.0 (iPod; U; CPU iPhone OS 4_3_3 like Mac OS X; en-us) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8J2 Safari/6533.18.5");

        添加标识("手机 : safari iOS 4.33 – iPad", "Mozilla/5.0 (iPad; U; CPU OS 4_3_3 like Mac OS X; en-us) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8J2 Safari/6533.18.5");

        添加标识("手机 : Android N1", "Mozilla/5.0 (Linux; U; Android " + 设备.取版本() + "; en-us; Nexus One Build/FRF91) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");

        添加标识("手机 : Android QQ浏览器 For android", "MQQBrowser/26 Mozilla/5.0 (Linux; U; Android " + 设备.取版本() + "; zh-cn; MB200 Build/GRJ22; CyanogenMod-7) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");

        添加标识("手机 : Android Opera Mobile", "Opera/9.80 (Android " + 设备.取版本() + "; Linux; Opera Mobi/build-1107180945; U; en-GB) Presto/2.8.149 Version/11.10");

        添加标识("手机 : Android Pad Moto Xoom", "Mozilla/5.0 (Linux; U; Android " + 设备.取版本() + "; en-us; Xoom Build/HRI39) AppleWebKit/534.13 (KHTML, like Gecko) Version/4.0 Safari/534.13");

        添加标识("手机 : BlackBerry", "Mozilla/5.0 (BlackBerry; U; BlackBerry 9800; en) AppleWebKit/534.1+ (KHTML, like Gecko) Version/6.0.0.337 Mobile Safari/534.1+");

        添加标识("手机 : WebOS HP Touchpad", "Mozilla/5.0 (hp-tablet; Linux; hpwOS/3.0.0; U; en-US) AppleWebKit/534.6 (KHTML, like Gecko) wOSBrowser/233.70 Safari/534.6 TouchPad/1.0");

        添加标识("手机 : Nokia N97", "Mozilla/5.0 (SymbianOS/9.4; Series60/5.0 NokiaN97-1/20.0.019; Profile/MIDP-2.1 Configuration/CLDC-1.1) AppleWebKit/525 (KHTML, like Gecko) BrowserNG/7.1.18124");

        添加标识("手机 : Windows Phone Mango", "Mozilla/5.0 (compatible; MSIE 9.0; Windows Phone OS 7.5; Trident/5.0; IEMobile/9.0; HTC; Titan)");

        添加标识("手机 : UC无", "UCWEB7.0.2.37/28/999");

        添加标识("手机 : UC标准", "NOKIA5700/ UCWEB7.0.2.37/28/999");

        添加标识("手机 : UCOpenwave", "Openwave/ UCWEB7.0.2.37/28/999");

        添加标识("手机 : UC Opera", "Mozilla/4.0 (compatible; MSIE 6.0; ) Opera/UCWEB7.0.2.37/28/999");
    }

    void 复制链接() {
        设备.置剪切板(浏览器.取链接());
        提示.普通("复制成功~ ");
    }

    void 复制源码() {
        设备.置剪切板(浏览器.取源码());
        提示.普通("复制成功~ ");
    }

    void 选择标识() {
        列表.显示();
        提示.普通("请选择浏览器标识 ~");
    }

    void 添加标识(String $名称, String $标识) {
        
        列表.添加($名称, 配置("设置标识", $标识));

    }

    void 设置标识(String $标识) {

        浏览器.getSettings().setUserAgentString($标识);
        浏览器.reload();
        
        提示.普通("设置成功 ~");

    }


}
