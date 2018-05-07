package hl4a.app.视图;

import 间.安卓.视图.列表视图;
import android.content.Context;
import android.view.ViewGroup;
import hl4a.app.适配器.脚本适配器;
import 间.安卓.组件.基本界面;

public class 脚本列表视图 extends 列表视图 {
   
    private 脚本适配器 适配器;
    
    public 脚本列表视图(基本界面 $上下文) {
        super($上下文);
        适配器 = new 脚本适配器($上下文);
        置适配器(适配器);
    }
    
    public 脚本列表视图(基本界面 $上下文,ViewGroup $父视图) {
        this($上下文);
        加入到($父视图);
    }
    
    public void 加载从目录(String $目录) {
        适配器.加载从目录($目录);
    }
    
}
