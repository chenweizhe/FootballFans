package com.example.strivezhe_chen.footballfans.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.LruCache;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.strivezhe_chen.footballfans.Adapter.sportnewsAdapter;
import com.example.strivezhe_chen.footballfans.R;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhe on 2016/8/9.
 *
 */
public class ImageLoader {
    private ImageView imageView;
    private String mUrl;
    private ListView listView;
    private Set<myAsyncTask> tasks;

    //创建cache
    private LruCache<String,Bitmap> mCache;

    public ImageLoader(ListView listView) {
        this.listView = listView;
        tasks = new HashSet<>();
        //获取做大可用内存
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int cacheSize = maxMemory/4;

        mCache = new LruCache<String, Bitmap>(cacheSize){


            @Override
            protected int sizeOf(String key, Bitmap value) {
                //每次存入缓存的时候调用
                return value.getByteCount();
            }
        };
    }

    /**
     * 增加到缓存
     * @param url
     * @param bitmap
     */
    public  void addBitmapToCache(String url,Bitmap bitmap){

        if (getBitmapFromCache(url)==null){
            mCache.put(url,bitmap);
        }
    }

    /**
     * 从缓存中获取数据
     * @param url
     * @return
     */
    public Bitmap getBitmapFromCache(String url){
        return mCache.get(url);
    }


    private Handler handler = new Handler(){

        /**
         * 通过handler来处理图片
         * @param msg
         */
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            //为避免listview缓存机制造成的图片错乱 必须加这个条件
            if (imageView.getTag().equals(mUrl)){
                imageView.setImageBitmap((Bitmap) msg.obj);
            }

        }
    };

    /**
     * 使用多线程实现异步加载任务
     * @param imageView
     * @param url
     */
    public void showImageByThread(ImageView imageView, final String url){
        this.imageView = imageView;
        this.mUrl = url;
        new Thread(){
            @Override
            public void run() {
                super.run();
                Bitmap bitmap = getBitmapFromURL(url);
                Message message = Message.obtain();
                message.obj = bitmap;
                handler.sendMessage(message);
            }
        }.start();
    }
    public Bitmap getBitmapFromURL(String urlString){
        Bitmap bitmap;
        InputStream is = null;
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            is = new BufferedInputStream(connection.getInputStream());
            bitmap = BitmapFactory.decodeStream(is);
            connection.disconnect();
            return bitmap;
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (is != null)
                   is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public void showImageByAsyncTask(ImageView imageView,String url){

        //从缓存中取出图片
        Bitmap bitmap = getBitmapFromCache(url);

        if (bitmap == null){
            imageView.setImageResource(R.mipmap.newssquarepic2);
        }else {
            imageView.setImageBitmap(bitmap);
        }

    }

    public void loadImage(int start,int end){
        for (int i = start;i <end;i++){

            String url = sportnewsAdapter.PicUrls[i];
            if (url.contains(".gif")){
                ImageView imageView = (ImageView) listView.findViewWithTag(url);
                imageView.setImageResource(R.mipmap.newssquarepic2);
            }else {
            //从缓存中取出图片
            Bitmap bitmap = getBitmapFromCache(url);
            if (bitmap == null){
                myAsyncTask task = new myAsyncTask(url);
                task.execute(url);
                tasks.add(task);
            }else {
                ImageView imageView = (ImageView) listView.findViewWithTag(url);
                imageView.setImageBitmap(bitmap);
            }

            }
        }
    }

    public void cancelAllTasks() {
        if (tasks != null){
            for (myAsyncTask task:tasks){
                task.cancel(false);
            }
        }
    }

    private class myAsyncTask extends AsyncTask<String,Void,Bitmap>{
        //        private ImageView imageView;
        private String url;

        public myAsyncTask(String url) {
//            this.imageView = imageView;
            this.url = url;
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            String url = params[0];
            //从网络获取图片
            Bitmap bitmap = getBitmapFromURL(params[0]);
            if (bitmap != null){
                //将图片加入缓存
                addBitmapToCache(url,bitmap);
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            ImageView imageView = (ImageView) listView.findViewWithTag(url);
            if (imageView!=null && bitmap !=null){
                imageView.setImageBitmap(bitmap);
            }
            tasks.remove(this);
        }
    }
}
