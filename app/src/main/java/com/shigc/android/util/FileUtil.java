package com.shigc.android.util;

import android.content.Context;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Administrator on 2016/4/10 0010.
 */
public class FileUtil {
    private Context context;

    public FileUtil(Context context) {
        this.context = context;
    }

    public void save(String filename, String content) throws Exception{
        FileOutputStream out = context.openFileOutput(filename, Context.MODE_PRIVATE);
        out.write(content.getBytes());
        out.close();
    }

    public String read(String filename) throws Exception {
        FileInputStream in = context.openFileInput(filename);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int len = 0;

        while((len = in.read(buf)) != -1) {
            out.write(buf, 0 , len);
        }
        byte[] data = out.toByteArray();
        in.close();

        return new String(data);
    }
}
