package com.example.floraphysician;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class Custom_Adapter extends PagerAdapter {

    private int[] profile_images={R.drawable.profile1,R.drawable.profile2,R.drawable.profile3,R.drawable.profile4,R.drawable.profile5,
            R.drawable.profile6,R.drawable.profile7,R.drawable.profile8,R.drawable.profile9,R.drawable.profile10,};
    private static final int REQUEST_CALL=1;
    private Context context;
    private LayoutInflater layoutInflater;

    public Custom_Adapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return profile_images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.card_items,container,false);

        ImageView imageView,add_contact_img,call_btn,email_img;
        final TextView analyst_name,identity,followers,following,email,contact,add_contact_text;

        imageView=view.findViewById(R.id.card_image);
        analyst_name=view.findViewById(R.id.analyst_name);
        identity=view.findViewById(R.id.identity_id);
        followers=view.findViewById(R.id.followers_id);
        following=view.findViewById(R.id.following_id);
        email=view.findViewById(R.id.email_id);
        contact=view.findViewById(R.id.contact_id);
        add_contact_text=view.findViewById(R.id.add_contact_id);
        add_contact_img=view.findViewById(R.id.add_contact_img);

        call_btn=view.findViewById(R.id.call_btn);
        email_img=view.findViewById(R.id.email_id_img);




        imageView.setImageResource(profile_images[position]);


        if(position==0)
        {
            analyst_name.setText("Analyst 1");
            identity.setText("01");
            followers.setText("1200");
            following.setText("150");
            email.setText("analyst1@gmail.com");
            contact.setText("+92 316 5288902");


            email_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "syedawais653@gmail.com" });
                    intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "mail body");
                    context.startActivity(intent);
                }
            });
            email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "syedawais653@gmail.com" });
                    intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "mail body");
                    context.startActivity(intent);

                }
            });
            call_btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+92 316 5288902"));
                    context.startActivity(intent);
                }
            });

            add_contact_text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                    intent
                            .putExtra(ContactsContract.Intents.Insert.PHONE,contact.getText())
                            .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE,ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                            .putExtra(ContactsContract.Intents.Insert.NAME,analyst_name.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL,email.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE,ContactsContract.CommonDataKinds.Email.TYPE_WORK);

                    context.startActivity(intent);


                }
            });

            add_contact_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                    intent
                            .putExtra(ContactsContract.Intents.Insert.PHONE,contact.getText())
                            .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE,ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                            .putExtra(ContactsContract.Intents.Insert.NAME,analyst_name.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL,email.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE,ContactsContract.CommonDataKinds.Email.TYPE_WORK);

                    context.startActivity(intent);

                }
            });


        }else if (position==1)
        {
            analyst_name.setText("Analyst 2");
            identity.setText("02");
            followers.setText("1000");
            following.setText("120");
            email.setText("analyst2@gmail.com");
            contact.setText("+92 312 1234568");


            email_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "syedawais653@gmail.com" });
                    intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "mail body");
                    context.startActivity(intent);

                }
            });
            email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "syedawais653@gmail.com" });
                    intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "mail body");
                    context.startActivity(intent);

                }
            });

            call_btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+92 312 1234568"));
                    context.startActivity(intent);
                }
            });


            add_contact_text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                    intent
                            .putExtra(ContactsContract.Intents.Insert.PHONE,contact.getText())
                            .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE,ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                            .putExtra(ContactsContract.Intents.Insert.NAME,analyst_name.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL,email.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE,ContactsContract.CommonDataKinds.Email.TYPE_WORK);

                    context.startActivity(intent);


                }
            });

            add_contact_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                    intent
                            .putExtra(ContactsContract.Intents.Insert.PHONE,contact.getText())
                            .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE,ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                            .putExtra(ContactsContract.Intents.Insert.NAME,analyst_name.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL,email.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE,ContactsContract.CommonDataKinds.Email.TYPE_WORK);


                    context.startActivity(intent);

                }
            });

        }else if (position==2)
        {
            analyst_name.setText("Analyst 3");
            identity.setText("03");
            followers.setText("1220");
            following.setText("130");
            email.setText("analyst3@gmail.com");
            contact.setText("+92 312 1234569");


            email_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "syedawais653@gmail.com" });
                    intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "mail body");
                    context.startActivity(intent);

                }
            });
            email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "syedawais653@gmail.com" });
                    intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "mail body");
                    context.startActivity(intent);

                }
            });


            call_btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+92 312 1234569"));
                    context.startActivity(intent);
                }
            });



            add_contact_text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                    intent
                            .putExtra(ContactsContract.Intents.Insert.PHONE,contact.getText())
                            .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE,ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                            .putExtra(ContactsContract.Intents.Insert.NAME,analyst_name.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL,email.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE,ContactsContract.CommonDataKinds.Email.TYPE_WORK);

                    context.startActivity(intent);


                }
            });

            add_contact_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                    intent
                            .putExtra(ContactsContract.Intents.Insert.PHONE,contact.getText())
                            .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE,ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                            .putExtra(ContactsContract.Intents.Insert.NAME,analyst_name.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL,email.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE,ContactsContract.CommonDataKinds.Email.TYPE_WORK);


                    context.startActivity(intent);

                }
            });

        }else if (position==3)
        {
            analyst_name.setText("Analyst 4");
            identity.setText("04");
            followers.setText("1300");
            following.setText("140");
            email.setText("analyst4@gmail.com");
            contact.setText("+92 312 1234561");


            email_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "syedawais653@gmail.com" });
                    intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "mail body");
                    context.startActivity(intent);

                }
            });
            email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "syedawais653@gmail.com" });
                    intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "mail body");
                    context.startActivity(intent);

                }
            });


            call_btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+92 312 1234561"));
                    context.startActivity(intent);
                }
            });


            add_contact_text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                    intent
                            .putExtra(ContactsContract.Intents.Insert.PHONE,contact.getText())
                            .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE,ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                            .putExtra(ContactsContract.Intents.Insert.NAME,analyst_name.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL,email.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE,ContactsContract.CommonDataKinds.Email.TYPE_WORK);

                    context.startActivity(intent);


                }
            });

            add_contact_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                    intent
                            .putExtra(ContactsContract.Intents.Insert.PHONE,contact.getText())
                            .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE,ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                            .putExtra(ContactsContract.Intents.Insert.NAME,analyst_name.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL,email.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE,ContactsContract.CommonDataKinds.Email.TYPE_WORK);


                    context.startActivity(intent);

                }
            });

        }else if (position==4)
        {
            analyst_name.setText("Analyst 5");
            identity.setText("05");
            followers.setText("900");
            following.setText("100");
            email.setText("analyst5@gmail.com");
            contact.setText("+92 312 1234562");


            email_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "syedawais653@gmail.com" });
                    intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "mail body");
                    context.startActivity(intent);

                }
            });
            email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "syedawais653@gmail.com" });
                    intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "mail body");
                    context.startActivity(intent);

                }
            });


            call_btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+92 312 1234562"));
                    context.startActivity(intent);
                }
            });

            add_contact_text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                    intent
                            .putExtra(ContactsContract.Intents.Insert.PHONE,contact.getText())
                            .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE,ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                            .putExtra(ContactsContract.Intents.Insert.NAME,analyst_name.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL,email.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE,ContactsContract.CommonDataKinds.Email.TYPE_WORK);

                    context.startActivity(intent);


                }
            });

            add_contact_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                    intent
                            .putExtra(ContactsContract.Intents.Insert.PHONE,contact.getText())
                            .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE,ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                            .putExtra(ContactsContract.Intents.Insert.NAME,analyst_name.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL,email.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE,ContactsContract.CommonDataKinds.Email.TYPE_WORK);


                    context.startActivity(intent);

                }
            });

        }else if (position==5)
        {
            analyst_name.setText("Analyst 6");
            identity.setText("06");
            followers.setText("1100");
            following.setText("190");
            email.setText("analyst6@gmail.com");
            contact.setText("+92 312 1234563");


            email_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "syedawais653@gmail.com" });
                    intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "mail body");
                    context.startActivity(intent);
                }
            });
            email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "syedawais653@gmail.com" });
                    intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "mail body");
                    context.startActivity(intent);
                }
            });


            call_btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+92 312 1234563"));
                    context.startActivity(intent);
                }
            });

            add_contact_text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                    intent
                            .putExtra(ContactsContract.Intents.Insert.PHONE,contact.getText())
                            .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE,ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                            .putExtra(ContactsContract.Intents.Insert.NAME,analyst_name.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL,email.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE,ContactsContract.CommonDataKinds.Email.TYPE_WORK);

                    context.startActivity(intent);


                }
            });

            add_contact_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                    intent
                            .putExtra(ContactsContract.Intents.Insert.PHONE,contact.getText())
                            .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE,ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                            .putExtra(ContactsContract.Intents.Insert.NAME,analyst_name.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL,email.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE,ContactsContract.CommonDataKinds.Email.TYPE_WORK);

                    context.startActivity(intent);

                }
            });

        }else if (position==6)
        {
            analyst_name.setText("Analyst 7");
            identity.setText("07");
            followers.setText("1250");
            following.setText("110");
            email.setText("analyst7@gmail.com");
            contact.setText("+92 312 1234564");


            email_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "syedawais653@gmail.com" });
                    intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "mail body");
                    context.startActivity(intent);

                }
            });
            email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "syedawais653@gmail.com" });
                    intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "mail body");
                    context.startActivity(intent);

                }
            });


            call_btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+92 312 1234564"));
                    context.startActivity(intent);
                }
            });

            add_contact_text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                    intent
                            .putExtra(ContactsContract.Intents.Insert.PHONE,contact.getText())
                            .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE,ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                            .putExtra(ContactsContract.Intents.Insert.NAME,analyst_name.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL,email.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE,ContactsContract.CommonDataKinds.Email.TYPE_WORK);

                    context.startActivity(intent);


                }
            });

            add_contact_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                    intent
                            .putExtra(ContactsContract.Intents.Insert.PHONE,contact.getText())
                            .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE,ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                            .putExtra(ContactsContract.Intents.Insert.NAME,analyst_name.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL,email.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE,ContactsContract.CommonDataKinds.Email.TYPE_WORK);


                    context.startActivity(intent);

                }
            });

        }else if (position==7)
        {
            analyst_name.setText("Analyst 8");
            identity.setText("08");
            followers.setText("1500");
            following.setText("200");
            email.setText("analyst8@gmail.com");
            contact.setText("+92 312 1234565");


            email_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "syedas653@gmail.com" });
                    intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "mail body");
                    context.startActivity(intent);

                }
            });
            email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "syeda3@gmail.com" });
                    intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "mail body");
                    context.startActivity(intent);
                }
            });

            call_btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+92 312 1234565"));
                    context.startActivity(intent);
                }
            });


            add_contact_text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                    intent
                            .putExtra(ContactsContract.Intents.Insert.PHONE,contact.getText())
                            .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE,ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                            .putExtra(ContactsContract.Intents.Insert.NAME,analyst_name.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL,email.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE,ContactsContract.CommonDataKinds.Email.TYPE_WORK);

                    context.startActivity(intent);


                }
            });

            add_contact_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                    intent
                            .putExtra(ContactsContract.Intents.Insert.PHONE,contact.getText())
                            .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE,ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                            .putExtra(ContactsContract.Intents.Insert.NAME,analyst_name.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL,email.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE,ContactsContract.CommonDataKinds.Email.TYPE_WORK);


                    context.startActivity(intent);

                }
            });

        }else if (position==8)
        {
            analyst_name.setText("Analyst 9");
            identity.setText("09");
            followers.setText("1800");
            following.setText("190");
            email.setText("analyst9@gmail.com");
            contact.setText("+92 312 1234571");


            email_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "syedawais653@gmail.com" });
                    intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "mail body");
                    context.startActivity(intent);

                }
            });
            email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "syedawais653@gmail.com" });
                    intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "mail body");
                    context.startActivity(intent);

                }
            });

            call_btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+92 312 1234571"));
                    context.startActivity(intent);
                }
            });


            add_contact_text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                    intent
                            .putExtra(ContactsContract.Intents.Insert.PHONE,contact.getText())
                            .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE,ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                            .putExtra(ContactsContract.Intents.Insert.NAME,analyst_name.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL,email.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE,ContactsContract.CommonDataKinds.Email.TYPE_WORK);

                    context.startActivity(intent);


                }
            });

            add_contact_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                    intent
                            .putExtra(ContactsContract.Intents.Insert.PHONE,contact.getText())
                            .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE,ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                            .putExtra(ContactsContract.Intents.Insert.NAME,analyst_name.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL,email.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE,ContactsContract.CommonDataKinds.Email.TYPE_WORK);


                    context.startActivity(intent);

                }
            });

        }else if (position==9)
        {
            analyst_name.setText("Analyst 10");
            identity.setText("10");
            followers.setText("1650");
            following.setText("250");
            email.setText("analyst10@gmail.com");
            contact.setText("+92 312 1234572");


            email_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "syedawais653@gmail.com" });
                    intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "mail body");
                    context.startActivity(intent);

                }
            });
            email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "syedawais653@gmail.com" });
                    intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "mail body");
                    context.startActivity(intent);

                }
            });


            call_btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+92 312 1234572"));
                    context.startActivity(intent);
                }
            });


            add_contact_text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                    intent
                            .putExtra(ContactsContract.Intents.Insert.PHONE,contact.getText())
                            .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE,ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                            .putExtra(ContactsContract.Intents.Insert.NAME,analyst_name.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL,email.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE,ContactsContract.CommonDataKinds.Email.TYPE_WORK);

                    context.startActivity(intent);


                }
            });

            add_contact_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                    intent
                            .putExtra(ContactsContract.Intents.Insert.PHONE,contact.getText())
                            .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE,ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                            .putExtra(ContactsContract.Intents.Insert.NAME,analyst_name.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL,email.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE,ContactsContract.CommonDataKinds.Email.TYPE_WORK);

                    context.startActivity(intent);

                }
            });

        }

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }


}
