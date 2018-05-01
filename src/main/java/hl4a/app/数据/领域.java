package hl4a.app.数据;

import com.droi.sdk.core.DroiObjectName;
import 间.安卓.后端.数据;

@DroiObjectName("Domain")
public class 领域 extends 数据 {

    public String 取领域名() {
        return 读取("name");
    }
    
    public void 置领域名(String $名称) {
        设置("name",$名称);
    }
    
    

}
