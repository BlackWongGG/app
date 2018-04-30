package hl4a.app.视图;
import android.graphics.Paint;
import android.graphics.Bitmap;
import 间.安卓.工具.视图;
import android.support.v4.graphics.BitmapCompat;
import android.graphics.Canvas;
import android.support.graphics.drawable.VectorDrawableCompat;
import 间.安卓.工具.环境;
import 间.安卓.资源.系统服务;

public class 图标工厂 {
    
    /*
       从 MaterialFileExplorer 抄来的
    */
    
    private Paint 背景 = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float density = 系统服务.屏幕信息.density;
    
    public 图标工厂() {
        背景.setStyle(Paint.Style.FILL);
        背景.setShadowLayer(2.5f, 1.0f, 1.0f, 0x64000000);
    }
    
    public Bitmap 制作(int $ID) {
        return 制作($ID,"控件");
    }
    
    public Bitmap 制作(int $ID,Object $背景颜色) {
        int $背景 = new Float(density * 48).intValue();
        int $图标 = new Float(density * 22).intValue();
        int $长度 = $背景 + $图标;
        Bitmap $图片 = Bitmap.createBitmap($长度,$长度,Bitmap.Config.ARGB_8888);
        Canvas $绘画 = new Canvas($图片);
        VectorDrawableCompat $生成 = VectorDrawableCompat.create(环境.取应用().getResources(),$ID,环境.取应用().getTheme());
        int $边距 = ($长度 - $图标) / 2;
        $生成.setBounds($边距,$边距,$边距 + $图标,$边距 + $图标);
        
        synchronized(this) {
            背景.setColor(视图.检查颜色($背景颜色));
            float $XY = $长度 / 2;
            $绘画.drawCircle($XY,$XY,$背景 / 2,背景);
            $生成.draw($绘画);
        }
        
        return $图片;
        
    }
    
}
