package com.example.recycleview;

import android.util.Log;
import android.widget.Toast;

import com.example.recycleview.model.Story;
import com.example.recycleview.model.Topic;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Utils {            //tạo instance
    private List<Topic> listTopic;
    private static Utils instance;

    public List<Topic> getListTopic() {
        return listTopic;
    }

    private Utils() {
        //for singleton
    }

    public static Utils getInstance(){          // tạo phương thức dùng chung cho ứng dụng
        if(instance==null){
            instance = new Utils();
        }
        return instance;
    }

    public void initTopicData() {               // đọc file assets
        listTopic = new ArrayList<>();
        try {
            String[] listPath = App.getInstance().getAssets().list("icon");     //tạo 1 mảng và ánh xạ từng phần tử đổ vào listTopic
            for (String fileName : listPath) {                  // đọc dữ liệu của list
                String iconName = "icon/" + fileName;
                //     Log.i("kmfg", "initTopicData: "+iconName);
                String title = fileName.replace(".png", "");
                listTopic.add(new Topic(iconName, title));          // gán dữ liệu cho listTopic
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getTextAs(String path){
        try{
            InputStream in = App.getInstance().getAssets().open(path);
            BufferedReader br=new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
            StringBuilder text = new StringBuilder();
            String line=br.readLine();
//            int len = in.read(buff);
            while(line!=null){
//                text.append(new String(buff, 0, len));
//                len = in.read(buff);
                text.append(line).append("\n");
                line=br.readLine();
            }
            br.close();
            in.close();
            return text.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}

