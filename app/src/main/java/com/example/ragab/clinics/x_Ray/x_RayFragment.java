package com.example.ragab.clinics.x_Ray;
import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import Util.RoundedTransformation;
import androidx.fragment.app.Fragment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.ragab.clinics.R;
import com.squareup.picasso.Picasso;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class x_RayFragment extends Fragment implements View.OnClickListener {

    private Button addPicturee;
    private LinearLayout selectedImagess;
//    private ImageView xrayImg;
    private String filePath;
    private static final int REQUEST_PERMISSIONS_READ_EXTERNAL_STORAGE = 600, REQUEST_PERMISSIONS_WRITE_EXTERNAL_STORAGE = 601;
    DialogInterface.OnClickListener onDialogClickWithImagee;
    public static ArrayList<String> bookingPhotos = new ArrayList<>();
    {
        onDialogClickWithImagee = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                switch (item) {
                    case 0:
                        if (checkReadExternalPermission())
                            openImageChooser();
                        break;
                    case 1:
                        if (checkCameraPermission())
                            takeCameraPhoto();
                        break;
                    case 2:
                        dialog.dismiss();
                        break;
                }
            }
        };
    }

    public x_RayFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_x__ray, container, false);
        Define_Strings();
        Declare_controls(view);
        addPicturee.setOnClickListener(this);
        return view;
    }

    private void Define_Strings() {
    }

    private void Declare_controls(View view) {
        addPicturee = view.findViewById(R.id.addpicture);
        selectedImagess = view.findViewById(R.id.show_selected_photo);
//        xrayImg = view.findViewById(R.id.xrayImg);
//        Picasso.get()
//                .load(R.drawable.xray12)
//                .transform(new RoundedTransformation())
//                .resize(500, 500)
//                .into(xrayImg);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_PERMISSIONS_READ_EXTERNAL_STORAGE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openImageChooser();
                } else {
                    Toast.makeText(getActivity(), "readFromGalleryPhotoPermissionRequired", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case REQUEST_PERMISSIONS_WRITE_EXTERNAL_STORAGE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    takeCameraPhoto();
                } else {
                    Toast.makeText(getActivity(), "takingCameraPhotoPermissionRequired", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }

    private boolean checkReadExternalPermission() {
        boolean isGranted = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
        if (!isGranted)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_PERMISSIONS_READ_EXTERNAL_STORAGE);
            }
        return isGranted;
    }
    private boolean checkCameraPermission() {
        boolean isGranted = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
        if (!isGranted)
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERMISSIONS_WRITE_EXTERNAL_STORAGE);
        return isGranted;
    }

    private void openImageChooser() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, 100);
    }
    private void takeCameraPhoto() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, 200);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            if (resultCode == getActivity().RESULT_CANCELED) {
                return;
            }
            if (requestCode == 100 && resultCode == Activity.RESULT_OK && null != data) {
                if (data != null) {
                    Uri selectedImage = data.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};
                    Cursor cursor = getActivity().getContentResolver().query(
                            selectedImage, filePathColumn, null, null, null);
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    filePath = cursor.getString(columnIndex);
                    Log.w("filepath", filePath);
                    cursor.close();
                    String encodedImage = encodeImage(filePath);
                    bookingPhotos.add(encodedImage);
                    Bitmap yourSelectedImage = BitmapFactory.decodeFile(filePath);
                    final ImageView imageView = new ImageView(getActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(250, 270);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    imageView.setPadding(10, 10, 10, 10);
                    imageView.setImageBitmap(yourSelectedImage);
                    if (selectedImagess.getVisibility() == View.GONE)
                        selectedImagess.setVisibility(View.VISIBLE);
                    selectedImagess.addView(imageView);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AlertDialog.Builder builder =   new AlertDialog.Builder(getActivity());
                            builder.setMessage("هل تريد مسح الصوره")
                                    .setCancelable(false)
                                    .setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {

                                            if (bookingPhotos.size() == 1) {
                                                imageView.setVisibility(View.GONE);
                                                bookingPhotos.remove(bookingPhotos.get(0));
                                                selectedImagess.setVisibility(View.GONE);
                                            } else if (bookingPhotos.size() == 2){
                                                imageView.setVisibility(View.GONE);
                                                bookingPhotos.remove(bookingPhotos.get(1));
                                            }else if (bookingPhotos.size() >= 3){
                                                imageView.setVisibility(View.GONE);
                                                bookingPhotos.remove(bookingPhotos.get(2));
                                            }

                                        }
                                    }).setNegativeButton("لا", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                            AlertDialog alert = builder.create();
                            alert.setTitle("مسح");
                            alert.show();
                        }
                    });
                    Log.w("path", encodedImage);
                }
            } else if (requestCode == 200 && resultCode == Activity.RESULT_OK) {
                Bundle extras = data.getExtras();
                Bitmap captureImage = (Bitmap) extras.get("data");
                String encodedImage = encodeImage(captureImage);
                bookingPhotos.add(encodedImage);
                Log.w("takePhotoFile", encodedImage);
                final ImageView imageView = new ImageView(getActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(250, 270);
                imageView.setLayoutParams(layoutParams);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setPadding(10, 10, 10, 10);
                imageView.setImageBitmap(captureImage);
                if (selectedImagess.getVisibility() == View.GONE)
                    selectedImagess.setVisibility(View.VISIBLE);
                selectedImagess.addView(imageView);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder =   new AlertDialog.Builder(getActivity());
                        builder.setMessage("هل تريد مسح الصوره")
                                .setCancelable(false)
                                .setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {

                                        if (bookingPhotos.size() == 1) {
                                            imageView.setVisibility(View.GONE);
                                            bookingPhotos.remove(bookingPhotos.get(0));
                                            selectedImagess.setVisibility(View.GONE);
                                        } else if (bookingPhotos.size() == 2){
                                            imageView.setVisibility(View.GONE);
                                            bookingPhotos.remove(bookingPhotos.get(1));
                                        }else if (bookingPhotos.size() >= 3){
                                            imageView.setVisibility(View.GONE);
                                            bookingPhotos.remove(bookingPhotos.get(2));
                                        }

                                    }
                                }).setNegativeButton("لا", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                        AlertDialog alert = builder.create();
                        alert.setTitle("مسح");
                        alert.show();
                    }
                });
            }
        } catch (Exception e) {
            Toast.makeText(getActivity(), "حدث خطأ", Toast.LENGTH_SHORT).show();
        }
    }

    private String encodeImage(String path) {
        File imagefile = new File(path);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(imagefile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Bitmap bm = BitmapFactory.decodeStream(fis);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();
        String encImage = Base64.encodeToString(b, Base64.DEFAULT);
        return encImage;
    }
    private String encodeImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String encoded = Base64.encodeToString(byteArray, Base64.DEFAULT);
        return encoded;
    }

    private void errorMessage(String message) {
        new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE)
                .setTitleText("عفوا")
                .setContentText(message)
                .setConfirmText("العودة")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismiss();
                    }
                })
                .show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addpicture:
                if (bookingPhotos.size() < 3) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle(getString(R.string.add_photo));
                    builder.setItems(new CharSequence[]{getString(R.string.choose_photo), getString(R.string.take_photo), getString(R.string.cancle_photo)}, onDialogClickWithImagee);
                    AlertDialog alert = builder.create();
                    alert.show();
                } else {
                    errorMessage("لا يمكن إضافة أكثر من 3 صور");
                }
                break;
        }

    }

}
