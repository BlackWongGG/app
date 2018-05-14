package hl4a.app.布局;

import android.content.Context;
import 间.安卓.视图.线性布局;
import 间.安卓.视图.输入框;

public class 布局_新建脚本 extends 线性布局 {

    public 输入框 输入;
    
    public 布局_新建脚本(Context $上下文) {
        super($上下文);
        置左右填充("填充");
        输入 = new 输入框(this);
        输入.置默认文本("文件名");
    }
    
}
