package com.example.selectmultipleimages;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageSwitcher imagesIs;
    private Button previousBtn, nextBtn, pickImagesBtn;

    private ArrayList<Uri> imageUris;

    private static final int PICK_IMAGES_CODE = 0;

    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagesIs = findViewById(R.id.imagesIs);
        previousBtn = findViewById(R.id.previousBtn);
        nextBtn = findViewById(R.id.nextBtn);
        pickImagesBtn = findViewById(R.id.pickImagesBtn);

        imageUris = new ArrayList<>();

        imagesIs.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                return imageView;
            }
        });

        pickImagesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickImagesIntent();
            }
        });

        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position > 0){
                    position--;
                    imagesIs.setImageURI(imageUris.get(position));
                }
                else{
                    Toast.makeText(MainActivity.this, "No Previous Images", Toast.LENGTH_SHORT).show();
                }
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position < imageUris.size() - 1){
                    position++;
                    imagesIs.setImageURI(imageUris.get(position));
                }
                else{
                    Toast.makeText(MainActivity.this, "No More Images", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void pickImagesIntent(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Image(s)"), PICK_IMAGES_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGES_CODE){
            if (resultCode == Activity.RESULT_OK){
                if (data.getClipData() != null){
                    int cout = data.getClipData().getItemCount();
                    for (int i=0; i<cout; i++){
                        Uri imageUri = data.getClipData().getItemAt(i).getUri();
                        imageUris.add(imageUri);
                    }
                    imagesIs.setImageURI(imageUris.get(0));
                    position = 0;
                }
                else{
                    Uri imageUri = data.getData();
                    imageUris.add(imageUri);
                    imagesIs.setImageURI(imageUris.get(0));
                    position = 0;
                }
            }
        }
    }
}