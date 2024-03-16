package com.example.floraphysician

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.provider.MediaStore
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bestsoft32.tt_fancy_gif_dialog_lib.TTFancyGifDialog
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.CubeGrid
import kotlinx.android.synthetic.main.activity_detect.*
import java.io.IOException

@Suppress("DEPRECATION")
class
DetectActivity : AppCompatActivity() {

    private lateinit var mClassifier: Classifier
    private lateinit var mBitmap: Bitmap

    private val mCameraRequestCode = 0
    private val mGalleryRequestCode = 2

    private val mInputSize = 224
    private val mModelPath = "plant_disease_model.tflite"
    private val mLabelPath = "plant_labels.txt"

    private val mSamplePath1 = "apple.jpg"
    private val mSamplePath2 = "blueberry.jpg"
    private val mSamplePath3 = "cherry.jpg"
    private val mSamplePath4 = "corn.jpg"
    private val mSamplePath5 = "grape.jpg"
    private val mSamplePath6 = "orange.jpg"
    private val mSamplePath7 = "peach.jpg"
    private val mSamplePath8 = "pepperbell.jpg"
    private val mSamplePath9 = "potato.jpg"
    private val mSamplePath10 = "raspberry_healthy.jpg"
    private val mSamplePath11 = "soybean.JPG"
    private val mSamplePath12 = "squash.jpg"
    private val mSamplePath13 = "strawberry.jpg"
    private val mSamplePath14 = "tomato.jpg"

    var Medicine = ""


    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_detect)

        val progressBar = findViewById<View>(R.id.spin_kit) as ProgressBar
        val circle: Sprite = CubeGrid()
        progressBar.visibility = View.INVISIBLE

        val imageView = findViewById<ImageView>(R.id.crop_image_upload)
        val textView = findViewById<TextView>(R.id.crop_text_upload)
        val bundle = intent.extras

        if (bundle != null) {
            val resimg = bundle.getInt("EXTRA_SESSION_IMAGE")
            val resname = bundle.getString("EXTRA_SESSION_TEXT")
            imageView.setImageResource(resimg)
            textView.setText(resname)
        }


        val resname = bundle?.getString("EXTRA_SESSION_TEXT")

        mClassifier = Classifier(assets, mModelPath, mLabelPath, mInputSize)




        if (resname == "apple"){
            resources.assets.open(mSamplePath1).use {
                mBitmap = BitmapFactory.decodeStream(it)
                mBitmap = Bitmap.createScaledBitmap(mBitmap, mInputSize, mInputSize, true)
                mPhotoImageView.setImageBitmap(mBitmap)
            }
        }
        else if (resname == "blueberry"){
            resources.assets.open(mSamplePath2).use {
                mBitmap = BitmapFactory.decodeStream(it)
                mBitmap = Bitmap.createScaledBitmap(mBitmap, mInputSize, mInputSize, true)
                mPhotoImageView.setImageBitmap(mBitmap)
            }
        }
        else if (resname == "cherry"){
            resources.assets.open(mSamplePath3).use {
                mBitmap = BitmapFactory.decodeStream(it)
                mBitmap = Bitmap.createScaledBitmap(mBitmap, mInputSize, mInputSize, true)
                mPhotoImageView.setImageBitmap(mBitmap)
            }
        }
        else if (resname == "corn"){
            resources.assets.open(mSamplePath4).use {
                mBitmap = BitmapFactory.decodeStream(it)
                mBitmap = Bitmap.createScaledBitmap(mBitmap, mInputSize, mInputSize, true)
                mPhotoImageView.setImageBitmap(mBitmap)
            }
        }
        else if (resname == "grape"){
            resources.assets.open(mSamplePath5).use {
                mBitmap = BitmapFactory.decodeStream(it)
                mBitmap = Bitmap.createScaledBitmap(mBitmap, mInputSize, mInputSize, true)
                mPhotoImageView.setImageBitmap(mBitmap)
            }
        }
        else if (resname == "orange"){
            resources.assets.open(mSamplePath6).use {
                mBitmap = BitmapFactory.decodeStream(it)
                mBitmap = Bitmap.createScaledBitmap(mBitmap, mInputSize, mInputSize, true)
                mPhotoImageView.setImageBitmap(mBitmap)
            }
        }
        else if (resname == "peach"){
            resources.assets.open(mSamplePath7).use {
                mBitmap = BitmapFactory.decodeStream(it)
                mBitmap = Bitmap.createScaledBitmap(mBitmap, mInputSize, mInputSize, true)
                mPhotoImageView.setImageBitmap(mBitmap)
            }
        }
        else if (resname == "pepper bell"){
            resources.assets.open(mSamplePath8).use {
                mBitmap = BitmapFactory.decodeStream(it)
                mBitmap = Bitmap.createScaledBitmap(mBitmap, mInputSize, mInputSize, true)
                mPhotoImageView.setImageBitmap(mBitmap)
            }
        }
        else if (resname == "potato"){
            resources.assets.open(mSamplePath9).use {
                mBitmap = BitmapFactory.decodeStream(it)
                mBitmap = Bitmap.createScaledBitmap(mBitmap, mInputSize, mInputSize, true)
                mPhotoImageView.setImageBitmap(mBitmap)
            }
        }else if (resname == "raspberry"){
            resources.assets.open(mSamplePath10).use {
                mBitmap = BitmapFactory.decodeStream(it)
                mBitmap = Bitmap.createScaledBitmap(mBitmap, mInputSize, mInputSize, true)
                mPhotoImageView.setImageBitmap(mBitmap)
            }
        }
        else if (resname == "soybean"){
            resources.assets.open(mSamplePath11).use {
                mBitmap = BitmapFactory.decodeStream(it)
                mBitmap = Bitmap.createScaledBitmap(mBitmap, mInputSize, mInputSize, true)
                mPhotoImageView.setImageBitmap(mBitmap)
            }
        }
        else if (resname == "squash"){
            resources.assets.open(mSamplePath12).use {
                mBitmap = BitmapFactory.decodeStream(it)
                mBitmap = Bitmap.createScaledBitmap(mBitmap, mInputSize, mInputSize, true)
                mPhotoImageView.setImageBitmap(mBitmap)
            }
        }
        else if (resname == "strawberry"){
            resources.assets.open(mSamplePath13).use {
                mBitmap = BitmapFactory.decodeStream(it)
                mBitmap = Bitmap.createScaledBitmap(mBitmap, mInputSize, mInputSize, true)
                mPhotoImageView.setImageBitmap(mBitmap)
            }
        }
        else if (resname == "tomato"){
            resources.assets.open(mSamplePath14).use {
                mBitmap = BitmapFactory.decodeStream(it)
                mBitmap = Bitmap.createScaledBitmap(mBitmap, mInputSize, mInputSize, true)
                mPhotoImageView.setImageBitmap(mBitmap)
            }
        }




        mCameraButton.setOnClickListener {
            try{
                progressBar.visibility = View.INVISIBLE
                val callCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                mResultTextView.text = ""
                startActivityForResult(callCameraIntent, mCameraRequestCode)
            }catch(e:IOException){
                Toast.makeText(this,"Invalid Input ....!!!",Toast.LENGTH_LONG).show()
            }

        }

        mGalleryButton.setOnClickListener {

            try{
                progressBar.visibility = View.INVISIBLE
                val callGalleryIntent = Intent(Intent.ACTION_PICK)
                callGalleryIntent.type = "image/*"
                mResultTextView.text= ""
                startActivityForResult(callGalleryIntent, mGalleryRequestCode)
            }catch (e:IOException){
                Toast.makeText(this,"Invalid Input ....!!!",Toast.LENGTH_LONG).show()
            }

        }


        mDetectButton.setOnClickListener {

            try{
            val results = mClassifier.recognizeImage(mBitmap).first()

            results.title+"\n Confidence:"+results.confidence
            //mResultTextView.text= results?.title+"\n Confidence:"+results?.confidence

            if (results.confidence > 0.60) {

                val resname = bundle?.getCharSequence("EXTRA_SESSION_TEXT")
                if (results.title.contains(resname.toString())) {

                    results.title + "\n Confidence:" + results.confidence
                    mResultTextView.text= ""

                    if (results.title == "apple healthy" || results.title == "blueberry healthy" || results.title == "cherry including sour healthy" ||
                            results.title == "corn maize healthy" || results.title == "grape healthy" || results.title == "peach healthy" ||
                            results.title == "pepper bell healthy" || results.title == "potato healthy" || results.title == "raspberry healthy" ||
                            results.title == "soybean healthy" || results.title == "strawberry healthy" || results.title == "tomato healthy") {
                       Medicine = "No Need"
                    }
                    if (results.title == "apple black rot" && results.confidence > 0.60) {

                        Medicine = "Dithane M45"
                    } else if (results.title == "apple cedar apple rust" && results.confidence > 0.60) {

                        Medicine = "Orchard Spray"
                    } else if (results.title == "apple apple scab" && results.confidence > 0.60) {

                        Medicine = "Mencozeb"

                    } else if (results.title == "cherry including sour powdery mildew" && results.confidence > 0.60) {

                        Medicine = "Dithane M45"

                    } else if (results.title == "corn maize cercospora leaf spot gray leaf spot" && results.confidence > 0.60) {

                        Medicine = "Preblast"
                    } else if (results.title == "corn maize common rust" && results.confidence > 0.60) {

                        Medicine = "Garden Fungicide"
                    } else if (results.title == "corn maize northern leaf blight" && results.confidence > 0.60) {

                        Medicine = "Gramoxone"
                    } else if (results.title == "grape black rot" && results.confidence > 0.60) {

                        Medicine = "Ethhanol"
                    } else if (results.title == "grape esca black measles" && results.confidence > 0.60) {

                        Medicine = "Caustic Soda"
                    } else if (results.title == "grape leaf blight isariopsis leaf spot" && results.confidence > 0.60) {

                        Medicine = "Dithane M45"
                    } else if (results.title.contains("orange") && results.confidence > 0.60) {

                        Medicine = "Mencozeb"
                    } else if (results.title == "peach bacterial spot" && results.confidence > 0.60) {

                        Medicine = "Mencozeb"
                    } else if (results.title == "pepper bell bacterial spot" && results.confidence > 0.60) {

                        Medicine = "Captan"
                    } else if (results.title == "potato early blight" && results.confidence > 0.60) {

                        Medicine = "Dithane M45"
                    } else if (results.title == "potato late blight" && results.confidence > 0.60) {

                        Medicine = "Gramoxone"
                    } else if (results.title == "squash powdery mildew" && results.confidence > 0.60) {

                        Medicine = "Ethanol"
                    } else if (results.title == "strawberry leaf scorch" && results.confidence > 0.60) {

                        Medicine = "Ethanol"
                    } else if (results.title == "tomato bacterial spot" && results.confidence > 0.60) {

                        Medicine = "Captan"
                    } else if (results.title == "tomato early blight" && results.confidence > 0.60) {

                        Medicine = "Liquid Copper Spray"
                    } else if (results.title == "tomato late blight" && results.confidence > 0.60) {

                        Medicine = "Natural Disease Control "
                    } else if (results.title == "tomato leaf mold" && results.confidence > 0.60) {

                        Medicine = "Ethanol"
                    } else if (results.title == "tomato septoria leaf spot" && results.confidence > 0.60) {

                        Medicine = "Glyphosate"
                    } else if (results.title == "tomato target spot" && results.confidence > 0.60) {

                        Medicine = "Glyphosate"
                    } else if (results.title == "tomato spider mites two spotted spider mite" && results.confidence > 0.60) {

                        Medicine = "Ridomil"
                    } else if (results.title == "tomato tomato mosaic virus" && results.confidence > 0.60) {

                        Medicine = "Ethanol"
                    } else if (results.title == "tomato tomato yellow leaf curl virus" && results.confidence > 0.60) {

                        Medicine = "Round Up"
                    }
                    progressBar.indeterminateDrawable = circle
                    progressBar.visibility = View.VISIBLE
                    Handler().postDelayed({
                        TTFancyGifDialog.Builder(this@DetectActivity)
                                .setTitle("Diagnose & Prescription\nCrop Status \n"+ results.title)
                                .setMessage("Confidence : " + results.confidence + "\nMedicine : " + Medicine)
                                .setPositiveBtnText("Learn more")
                                .setPositiveBtnBackground("#22b573")
                                .setNegativeBtnText("Cancel")
                                .setNegativeBtnBackground("#c1272d")
                                .setGifResource(R.drawable.show_result_gif)
                                .isCancellable(false)

                                .OnPositiveClicked {

                                    if (Medicine == "No Need"){
                                        val progressBar = findViewById<View>(R.id.spin_kit) as ProgressBar
                                        progressBar.visibility = View.INVISIBLE

                                        Toast.makeText(this,"Your crop is HEALTHY",Toast.LENGTH_LONG).show()
                                        mResultTextView.text= ""

                                    }else{
                                        mResultTextView.text= ""
                                        progressBar.visibility = View.INVISIBLE
                                        val intent = Intent(this@DetectActivity, Help_Activity::class.java)
                                        intent.putExtra("medicine",Medicine)
//                                        if(Medicine == "Mencozeb"){
//                                            intent.putExtra("date","Year of launch (1962)")
//                                            intent.putExtra("description","Antifungal chemical Mencozeb is a dithiocarbamate non-systemic agricultural fungicide with multi-site, protective action on contact. It is a combination of two other dithiocarbamates: maneb and zineb. The mixture controls many fungal diseases in a wide range of field crops, fruits, nuts, vegetables, and ornamentals.")
//                                            intent.putExtra("resId", R.drawable.mencozeb);
//                                            intent.putExtra("Url","https://www.alibaba.com/product-detail/High-quality-fungicide-Mancozeb-Mancozeb-80_62190007570.html?spm=a2700.7735675.normalList.1.1045135ct2dpss")
//                                        }
                                        startActivity(intent)

                                        this.recreate();
                                    }
                                }
                                .OnNegativeClicked { Toast.makeText(this@DetectActivity, "Cancel", Toast.LENGTH_SHORT).show()
                                    mResultTextView.text= ""
                                    progressBar.visibility = View.INVISIBLE}
                                .build()
                    }, 2000)



                }else{
                    progressBar.indeterminateDrawable = circle
                    progressBar.visibility = View.VISIBLE
                    Handler().postDelayed({

                        TTFancyGifDialog.Builder(this@DetectActivity)
                                .setTitle("Diagnose & Prescription\nCrop Status \n " + "Image Not Found")
                                .setMessage("")
                                .setPositiveBtnText("Learn more")
                                .setPositiveBtnBackground("#22b573")
                                .setNegativeBtnText("Cancel")
                                .setNegativeBtnBackground("#c1272d")
                                .setGifResource(R.drawable.not_found_result)
                                .isCancellable(false)
                                .OnPositiveClicked {
                                    Toast.makeText(this, "Please select valid image", Toast.LENGTH_LONG).show()
                                    progressBar.visibility = View.INVISIBLE
                                    mResultTextView.text= ""
                                }
                                .OnNegativeClicked {
                                    Toast.makeText(this@DetectActivity, "Cancel", Toast.LENGTH_SHORT).show()
                                    progressBar.visibility = View.INVISIBLE
                                    mResultTextView.text= ""
                                }
                                .build()
                    },2000)
                }
            }
            else{
                progressBar.indeterminateDrawable = circle
                progressBar.visibility = View.VISIBLE
                Handler().postDelayed({
                TTFancyGifDialog.Builder(this@DetectActivity)
                        .setTitle("Diagnose & Prescription\nCrop Status \n "+ "Image Not Found")
                        .setMessage("")
                        .setPositiveBtnText("Learn more")
                        .setPositiveBtnBackground("#22b573")
                        .setNegativeBtnText("Cancel")
                        .setNegativeBtnBackground("#c1272d")
                        .setGifResource(R.drawable.not_found_result)
                        .isCancellable(false)
                        .OnPositiveClicked {
                            Toast.makeText(this,"Please select valid image",Toast.LENGTH_LONG).show()
                            progressBar.visibility = View.INVISIBLE
                            mResultTextView.text= ""
                        }
                        .OnNegativeClicked {
                            Toast.makeText(this@DetectActivity, "Cancel", Toast.LENGTH_SHORT).show()
                            progressBar.visibility = View.INVISIBLE
                            mResultTextView.text= ""}
                        .build()
                },2000)
            }
        }catch (e: Exception){
                mResultTextView.text= ""
                progressBar.indeterminateDrawable = circle
                progressBar.visibility = View.VISIBLE
                Handler().postDelayed({
                    progressBar.visibility = View.INVISIBLE
                    Toast.makeText(this, "Invalid Input ....!!!", Toast.LENGTH_LONG).show()
                },2000)


            }
        }
    }

    @SuppressLint("MissingSuperCall", "SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == mCameraRequestCode){
            //Considérons le cas de la caméra annulée
            if(resultCode == Activity.RESULT_OK && data != null) {
                mBitmap = data.extras!!.get("data") as Bitmap
                mBitmap = scaleImage(mBitmap)
                val toast = Toast.makeText(this, ("Image crop to: w= ${mBitmap.width} h= ${mBitmap.height}"), Toast.LENGTH_LONG)
                toast.setGravity(Gravity.BOTTOM, 0, 20)
                toast.show()
                mPhotoImageView.setImageBitmap(mBitmap)
                mResultTextView.text= "Your photo image set now."
            } else {
                Toast.makeText(this, "Camera cancel..", Toast.LENGTH_LONG).show()
            }
        } else if(requestCode == mGalleryRequestCode) {
            if (data != null) {
                val uri = data.data

                try {
                    mBitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
                } catch (e: IOException) {
                    e.printStackTrace()
                }

                println("Success!!!")
                mBitmap = scaleImage(mBitmap)
                mPhotoImageView.setImageBitmap(mBitmap)

            }
        } else {
            Toast.makeText(this, "Unrecognized request code", Toast.LENGTH_LONG).show()

        }
    }


    fun scaleImage(bitmap: Bitmap?): Bitmap {
        val orignalWidth = bitmap!!.width
        val originalHeight = bitmap.height
        val scaleWidth = mInputSize.toFloat() / orignalWidth
        val scaleHeight = mInputSize.toFloat() / originalHeight
        val matrix = Matrix()
        matrix.postScale(scaleWidth, scaleHeight)
        return Bitmap.createBitmap(bitmap, 0, 0, orignalWidth, originalHeight, matrix, true)
    }

}
