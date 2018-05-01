package hl4a.app.数据;

import android.graphics.Bitmap;
import com.droi.sdk.core.DroiExpose;
import com.droi.sdk.core.DroiFile;
import com.droi.sdk.core.DroiReference;
import 间.安卓.后端.后端;
import 间.安卓.后端.后端文件;
import 间.安卓.工具.图片;
import 间.工具.引用;
import 间.接口.返回值;
import android.widget.ImageView;
import 间.接口.方法;
import 间.安卓.视图.实现.图片实现;
import 间.工具.处理;
import 间.安卓.工具.调用;

public class 用户 extends 间.安卓.后端.用户 {

    @DroiExpose private String sign;
    @DroiReference private DroiFile icon;

    static {
        后端.注册(用户.class);
    }

    public static 返回值<用户> 同步登录(String $用户名, String $密码) {
        return 同步登录($用户名, $密码, 用户.class);
    }

    public static 用户 取当前用户() {
        return 取当前用户(用户.class);
    }

    public String 取签名() {
        return sign;
    }

    public void 置签名(String $签名) {
        sign = $签名;
    }
    
    public void 显示头像(ImageView $视图) {
        调用.异步(this,"同步显示头像",$视图);
    }

    public void 同步显示头像(ImageView $视图) {

        引用<Bitmap> $图片 = 同步取头像().取内容();
        if ($图片 != null) {
            图片实现.置图片($视图, $图片.读取());
        }
       
    }

    public 返回值<引用<Bitmap>> 同步取头像() {

        if (icon == null) return 返回值.失败;
        返回值<byte[]> $字节 = 后端文件.同步读取(icon);
        if (!$字节.成功()) return (返回值)$字节;
        return 返回值.创建(new 引用<Bitmap>(图片.读取($字节.取内容())));

    }

}
