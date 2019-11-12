package com.smarltines.buhwarcolono.ui.fragment.visita;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.smarltines.buhwarcolono.R;
import com.smarltines.buhwarcolono.ui.activity.MainActivity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class VisitaFragment extends Fragment {
    private TextView txtDateVisita;
    private Spinner spinnerVisita;
    private EditText mNombre,mApellidos;
    private ImageView iv;
    private Button btn;

    public final static int QRcodeWidth = 500 ;
    private static final String IMAGE_DIRECTORY = "/QRcodeVisitas";
    Bitmap bitmap ;

    //private File tempfile=null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_visita, container, false);
        spinnerVisita = view.findViewById(R.id.spinnerVisita);
        txtDateVisita = view.findViewById(R.id.txtDateVisita);

        mNombre=view.findViewById(R.id.editText);
        mApellidos=view.findViewById(R.id.editText2);
        btn=view.findViewById(R.id.button2);
        iv = (ImageView) view.findViewById(R.id.iv);

        Calendar calender = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String strDate = "Fecha : "+dateFormat.format(calender.getTime());

        String[] opcVisita = {"Familiar","Eventos","Personal"};

        ArrayAdapter adapterVisita = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, opcVisita);
        spinnerVisita.setAdapter(adapterVisita);
        txtDateVisita.setText(strDate);

        createQR(strDate);

        return view;
    }

    public static VisitaFragment newInstance() {
        VisitaFragment frag = new VisitaFragment();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }

    //METODOS QR
    private void createQR(final String fecha){

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = mNombre.getText().toString().trim();
                String apellidos=mApellidos.getText().toString().trim();
                String texto="";
                if (TextUtils.isEmpty(nombre)||TextUtils.isEmpty(apellidos)){
                    Toast.makeText(getActivity(), "Campos Vacios", Toast.LENGTH_SHORT).show();
                }else {
                    try {
                    texto=nombre+","+apellidos+","+fecha+","+spinnerVisita.getSelectedItem()+","+"DIRECCION PENDIENTE";

                    bitmap = TextToImageEncode(texto);
                    iv.setImageBitmap(bitmap);
                    String path = saveImage(bitmap);  //give read write permission
                    Toast.makeText(getActivity(), "QRCode saved to -> "+path, Toast.LENGTH_SHORT).show();
                    share(path);
                    } catch (WriterException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

    }

   private String saveImage(Bitmap myBitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File wallpaperDirectory = new File(
                Environment.getExternalStorageDirectory() + IMAGE_DIRECTORY);
        // have the object build the directory structure, if needed.

        if (!wallpaperDirectory.exists()) {
            Log.d("dirrrrrr", "" + wallpaperDirectory.mkdirs());
            wallpaperDirectory.mkdirs();
        }

        try {
            File f = new File(wallpaperDirectory, Calendar.getInstance()
                    .getTimeInMillis() + ".jpg");
            f.createNewFile();   //give read write permission
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
            MediaScannerConnection.scanFile(getActivity(),
                    new String[]{f.getPath()},
                    new String[]{"image/jpeg"}, null);
            fo.close();
            Log.d("TAG", "File Saved::--->" + f.getAbsolutePath());
            //tempfile=f;
            return f.getAbsolutePath();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return "";

    }

    private Bitmap TextToImageEncode(String Value) throws WriterException {
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(
                    Value,
                    BarcodeFormat.DATA_MATRIX.QR_CODE,
                    QRcodeWidth, QRcodeWidth, null
            );

        } catch (IllegalArgumentException Illegalargumentexception) {

            return null;
        }
        int bitMatrixWidth = bitMatrix.getWidth();

        int bitMatrixHeight = bitMatrix.getHeight();

        int[] pixels = new int[bitMatrixWidth * bitMatrixHeight];

        for (int y = 0; y < bitMatrixHeight; y++) {
            int offset = y * bitMatrixWidth;

            for (int x = 0; x < bitMatrixWidth; x++) {

                pixels[offset + x] = bitMatrix.get(x, y) ?
                        getResources().getColor(R.color.black):getResources().getColor(R.color.white);
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);

        bitmap.setPixels(pixels, 0, 500, 0, 0, bitMatrixWidth, bitMatrixHeight);
        return bitmap;
    }

    private void share(String route){

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        final Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("image/jpg");
        final File photoFile = new File(route);
        shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(photoFile));
        //startActivity(Intent.createChooser(shareIntent, "Share image using"));
        startActivity(Intent.createChooser(shareIntent, "Compartir QR vía"));
    }

}
