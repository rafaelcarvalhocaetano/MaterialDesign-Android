package io.mda.recicleview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by rafael on 31/12/17.
 */

public class DownloadImage extends AsyncTask<String, Void, Bitmap> {

    private ImageView imageView;

    public DownloadImage(ImageView imageView){
        this.imageView = imageView;
    }
    @Override
    protected Bitmap doInBackground(String... strings) {

        String url = strings[0];
        Bitmap bitmap = null;

        try {
            InputStream inputStream = new URL(url).openStream();
            bitmap = BitmapFactory.decodeStream( inputStream );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        imageView.setImageBitmap( bitmap );
    }
}
