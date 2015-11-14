package io.github.kevinsu917.xpro.common.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Creator: KevinSu kevinsu917@126.com
 * Date 2015-11-15-00:23
 * Description:
 */
public class Functions {

    /**
     * toast,注意请在ui线程中调用
     *
     * @param context
     * @param text
     */
    public static void toast(Context context, CharSequence text) {
        if (context == null) {
            return;
        }
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}
