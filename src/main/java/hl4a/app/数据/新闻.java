package hl4a.app.数据;

import 间.安卓.后端.数据;
import com.droi.sdk.core.DroiObjectName;
import 间.安卓.后端.后端;

@DroiObjectName("News")
public class 新闻 extends 数据 {

    static {
        后端.注册(新闻.class);
    }

}
