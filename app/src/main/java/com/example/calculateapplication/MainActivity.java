package com.example.calculateapplication;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //    结果集
    private EditText editText;

    //数字1-9
    private Button main_btn1;
    private Button main_btn2;
    private Button main_btn3;
    private Button main_btn4;
    private Button main_btn5;
    private Button main_btn6;
    private Button main_btn7;
    private Button main_btn8;
    private Button main_btn9;
    private  Button main_btn0;

    //运算符
    private  Button main_btn1a  ;// +
    private  Button main_btnj;  // -
    private  Button main_btnx;  // *
    private  Button main_btnc;  // /
    private  Button main_btnd;  //小数点
    private  Button main_btn1d;  //=

    //清除
    private  Button main_btndel;

    boolean clear_flag;//清空标识

    public static char chs[] = new char[36];
    static {
        for(int i = 0; i < 10 ; i++) {
            chs[i] = (char)('0' + i);
        }
        for(int i = 10; i < chs.length; i++) {
            chs[i] = (char)('A' + (i - 10));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.help_item:
                Toast.makeText(this,"这是帮助",Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit_item:
                ActivityCollector.finishAll();
                break;
                default:

        }
        return true;


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(this.getResources().getConfiguration().orientation
        == Configuration.ORIENTATION_PORTRAIT){

            setContentView(R.layout.activity_main);
        }
        else{
            setContentView(R.layout.landscapet);
        }


        //数字1-9
        View main_btn1 = findViewById(R.id.main_btn1);
        View main_btn2 = findViewById(R.id.main_btn2);
        View main_btn3= findViewById(R.id.main_btn3);
        View main_btn4 = findViewById(R.id.main_btn4);
        View main_btn5 = findViewById(R.id.main_btn5);
        View main_btn6 = findViewById(R.id.main_btn6);
        View main_btn7 = findViewById(R.id.main_btn7);
        View main_btn8 = findViewById(R.id.main_btn8);
        View main_btn9 = findViewById(R.id.main_btn9);
        View main_btn0 = findViewById(R.id.main_btn0);
        //运算符
        View main_btn1a = findViewById(R.id.main_btn1a);// +
        View main_btnj = findViewById(R.id.main_btnj);// -
        View main_btnx = findViewById(R.id.main_btnx);// *
        View main_btnc = findViewById(R.id.main_btnc); // /
        View main_btnd = findViewById(R.id.main_btnd);//小数点
        View main_btn1d = findViewById(R.id.main_btn1d);//=
        View main_btndel = findViewById(R.id.main_btndel);//清空

        View main_btnsin=findViewById(R.id.main_sin);//
        View main_btncos=findViewById(R.id.main_cos);
        View main_btntan=findViewById(R.id.main_tan);
        View main_btnpow=findViewById(R.id.main_pow);//
        View main_btnclear=findViewById(R.id.main_clear);
        View main_btn28=findViewById(R.id.main_2to8);
        View main_btn210=findViewById(R.id.main_2to10);
        View main_btn216=findViewById(R.id.main_2to16);
        View main_btn82=findViewById(R.id.main_8to2);
        View main_btn810=findViewById(R.id.main_8to10);
        View main_btn816=findViewById(R.id.main_8to16);
        View main_btn102=findViewById(R.id.main_10to2);
        View main_btn108=findViewById(R.id.main_10to8);
        View main_btn1016=findViewById(R.id.main_10to16);
        View main_btn162=findViewById(R.id.main_16to2);
        View main_btn168=findViewById(R.id.main_16to8);
        View main_btn1610=findViewById(R.id.main_16to10);

        View main_d_kg=findViewById(R.id.d_kg);
        View main_d_wendu=findViewById(R.id.d_wendu);
        View main_d_J_cal=findViewById(R.id.d_J_cal);
        View main_d_m_ft=findViewById(R.id.d_m_ft);
        View main_a=findViewById(R.id.a);
        View main_b=findViewById(R.id.b);
        View main_c=findViewById(R.id.c);
        View main_d=findViewById(R.id.d);
        View main_e=findViewById(R.id.e);
        View main_f=findViewById(R.id.f);
        View main_cm=findViewById(R.id.cm);
        View main_dm=findViewById(R.id.dm);
        View main_m=findViewById(R.id.m);
        View main_km=findViewById(R.id.km);


        View main_vcm=findViewById(R.id.vcm);
        View main_vdm=findViewById(R.id.vdm);
        View main_vm=findViewById(R.id.vm);
        View main_vkm=findViewById(R.id.vkm);


        editText = (EditText) findViewById(R.id.main_et_result);//结果集


        //添加点击事件
        main_btn0.setOnClickListener(this);
        main_btn1.setOnClickListener(this);
        main_btn2.setOnClickListener(this);
        main_btn3.setOnClickListener(this);
        main_btn4.setOnClickListener(this);
        main_btn5.setOnClickListener(this);
        main_btn6.setOnClickListener(this);
        main_btn7.setOnClickListener(this);
        main_btn8.setOnClickListener(this);
        main_btn9.setOnClickListener(this);

        main_btnd.setOnClickListener(this);
        main_btndel.setOnClickListener(this);

        main_btn1a.setOnClickListener(this);
        main_btnj.setOnClickListener(this);
        main_btnx.setOnClickListener(this);
        main_btnc.setOnClickListener(this);
        main_btn1d.setOnClickListener(this);
        main_btnpow.setOnClickListener(this);
        main_a.setOnClickListener(this);
        main_b.setOnClickListener(this);
        main_c.setOnClickListener(this);
        main_d.setOnClickListener(this);
        main_e.setOnClickListener(this);
        main_f.setOnClickListener(this);




        main_btnsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string=editText.getText().toString();//
                Double num=Double.valueOf(string);
                double exp=Math.sin(num);//
                editText.setText("sin"+exp+""+"="+num);


            }
        });
        main_btncos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string=editText.getText().toString();
                Double num=Double.valueOf(string);
                double exp=Math.cos(num);
                editText.setText("cos"+num+""+"="+exp);

            }
        });
        main_btntan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string=editText.getText().toString();
                Double num=Double.valueOf(string);
                double exp=Math.tan(num);
                editText.setText("tan"+num+""+"="+exp);

            }
        });
        main_btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
            }
        });

        main_btn28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input=editText.getText().toString();
                String sum=transRadix(input,2,8);
                editText.setText(input+"(2进制转8进制后为)"+sum);
            }
        });
        main_btn210.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input=editText.getText().toString();
                String sum=transRadix(input,2,10);
                editText.setText(input+"(2进制转10进制后为)"+sum);
            }
        });
        main_btn216.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input=editText.getText().toString();
                String sum=transRadix(input,2,16);
                editText.setText(input+"(2进制转16进制后为)"+sum);
            }
        });
        main_btn82.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input=editText.getText().toString();
                String sum=transRadix(input,8,2);
                editText.setText(input+"(8进制转2进制后为)"+sum);
            }
        });
        main_btn810.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input=editText.getText().toString();
                String sum=transRadix(input,8,10);
                editText.setText(input+"(8进制转10进制后为)"+sum);
            }
        });
        main_btn816.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input=editText.getText().toString();
                String sum=transRadix(input,8,16);
                editText.setText(input+"(8进制转16进制后为)"+sum);
            }
        });
        main_btn102.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input=editText.getText().toString();
                String sum=transRadix(input,10,2);
                editText.setText(input+"(10进制转2进制后为)"+sum);
            }
        });
        main_btn108.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input=editText.getText().toString();
                String sum=transRadix(input,10,8);
                editText.setText(input+"(10进制转8进制后为)"+sum);
            }
        });
        main_btn1016.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input=editText.getText().toString();
                String sum=transRadix(input,10,16);
                editText.setText(input+"(10进制转16进制后为)"+sum);
            }
        });
        main_btn162.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input=editText.getText().toString();
                String sum=transRadix(input,16,2);
                editText.setText(input+"(16进制转2进制后为)"+sum);
            }
        });
        main_btn168.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input=editText.getText().toString();
                String sum=transRadix(input,16,8);
                editText.setText(input+"(16进制转8进制后为)"+sum);
            }
        });
        main_btn1610.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input=editText.getText().toString();
                String sum=transRadix(input,16,10);
                editText.setText(input+"(16进制转10进制后为)"+sum);
            }
        });

        main_d_kg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input=editText.getText().toString();
                double bang=(Double.valueOf(input))*2.2046226;
                double kg=(Double.valueOf(input))/2.2046226;
                editText.setText(input+"千克="+bang+"磅;"+input+"磅="+kg+"千克");

            }
        });

        main_d_wendu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input=editText.getText().toString();
                double f=(9/5)*((Double.valueOf(input))+32);
                double c=(5/9)*((Double.valueOf(input))-32);
                editText.setText(input+"℃="+f+"F;"+input+"F="+c+"℃");
            }
        });

        main_d_J_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input=editText.getText().toString();
                double J=(Double.valueOf(input))/0.2389;
                double cal=(Double.valueOf(input))*0.2389;
                editText.setText(input+"焦="+cal+"卡;"+input+"卡="+J+"焦");
            }
        });

        main_d_m_ft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input=editText.getText().toString();
                double ft=(Double.valueOf(input))*3.280839895013;
                double m=(Double.valueOf(input))/3.280839895013;
                editText.setText(input+"米="+ft+"英尺;"+input+"英尺="+m+"米");
            }
        });

        main_d_m_ft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input=editText.getText().toString();
                double ft=(Double.valueOf(input))*1000;
                double m=(Double.valueOf(input))/3.280839895013;
                editText.setText(input+"米="+ft+"英尺;"+input+"英尺="+m+"米");
            }
        });
        main_cm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input=editText.getText().toString();
                double cm=(Double.valueOf(input))*1;
                double dm=(Double.valueOf(input))*10;
                double m=(Double.valueOf(input))*100;
                double km=(Double.valueOf(input))*100000;
                editText.setText(cm+"cm="+dm+"dm="+m+"m="+km+"km");

            }
        });
        main_dm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input=editText.getText().toString();
                double cm=(Double.valueOf(input))/10;
                double dm=(Double.valueOf(input))*1;
                double m=(Double.valueOf(input))*10;
                double km=(Double.valueOf(input))*10000;
                editText.setText(cm+"cm="+dm+"dm="+m+"m="+km+"km");

            }
        });
        main_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input=editText.getText().toString();
                double cm=(Double.valueOf(input))/100;
                double dm=(Double.valueOf(input))/10;
                double m=(Double.valueOf(input))*1;
                double km=(Double.valueOf(input))*1000;
                editText.setText(cm+"cm="+dm+"dm="+m+"m="+km+"km");
            }
        });
        main_km.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input=editText.getText().toString();
                double cm=(Double.valueOf(input))/100000;
                double dm=(Double.valueOf(input))/10000;
                double m=(Double.valueOf(input))/1000;
                double km=(Double.valueOf(input))*1;
                editText.setText(cm+"cm="+dm+"dm="+m+"m="+km+"km");
            }
        });





        main_vcm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input=editText.getText().toString();
                double cm=(Double.valueOf(input))*1;

                double dm=(Double.valueOf(input))*1000;

                double m=(Double.valueOf(input))*1000000;

                double km1=(Double.valueOf(input))*100000;
                double km2=km1*100000;
                double km3=km2*100000;


                editText.setText(cm+"立方厘米="+dm+"立方分米="+m+"立方米="+km3+"立方千米");

            }
        });
        main_vdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input=editText.getText().toString();
                double cm1=(Double.valueOf(input))/10;
                double cm2=cm1/10;
                double cm3=cm2/10;

                double dm=(Double.valueOf(input))*1;

                double m1=(Double.valueOf(input))*10;
                double m2=m1*10;
                double m3=m2*10;

                double km1=(Double.valueOf(input))*10000;
                double km2=km1*10000;
                double km3=km2*10000;
                editText.setText(cm3+"立方厘米="+dm+"立方分米="+m3+"立方米="+km3+"立方千米");



            }
        });
        main_vm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input=editText.getText().toString();
                double cm1=(Double.valueOf(input))/100;
                double cm2=cm1/100;
                double cm3=cm2/100;


                double dm1=(Double.valueOf(input))/10;
                double dm2=cm1/10;
                double dm3=cm2/10;

                double m=(Double.valueOf(input))*1;

                double km1=(Double.valueOf(input))*1000;
                double km2=km1*1000;
                double km3=km2*1000;
                editText.setText(cm3+"立方厘米="+dm3+"立方分米="+m+"立方米="+km3+"立方千米");
            }
        });
        main_vkm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input=editText.getText().toString();
                double cm1=(Double.valueOf(input))/100000;
                double cm2=cm1/100000;
                double cm3=cm2/100000;


                double dm1=(Double.valueOf(input))/10000;
                double dm2=dm1/10000;
                double dm3=dm2/10000;

                double m1=(Double.valueOf(input))/1000;
                double m2=m1/1000;
                double m3=m2/1000;


                double km3=(Double.valueOf(input))*1;
                editText.setText(cm3+"立方厘米="+dm3+"立方分米="+m3+"立方米="+km3+"立方千米");
            }
        });



    }

    //读取每个按钮的点击的内容
    @Override
    public void onClick(View view) {
        //获取文本内容
        String input = editText.getText().toString();
        switch (view.getId()){
            case R.id.main_btn0:
            case R.id.main_btn1:
            case R.id.main_btn2:
            case R.id.main_btn3:
            case R.id.main_btn4:
            case R.id.main_btn5:
            case R.id.main_btn6:
            case R.id.main_btn7:
            case R.id.main_btn8:
            case R.id.main_btn9:
            case R.id.a:
            case R.id.b:
            case R.id.c:
            case R.id.d:
            case R.id.e:
            case R.id.f:
            case R.id.main_btnd:
                if(clear_flag){
                    clear_flag = false;
                    editText.setText("");//赋值为空
                }
                editText.setText(input + ((Button)view).getText());//结果集就为本身
                break;
            case R.id.main_btn1a:
            case R.id.main_btnj:
            case R.id.main_btnx:
            case R.id.main_btnc:
            case R.id.main_pow:
                if(clear_flag){
                    clear_flag = false;
                    input = "";
                    editText.setText("");
                }
                editText.setText(input + " " + ((Button)view).getText() + " ");
                break;
            case R.id.main_btndel:
                if(clear_flag){
                    clear_flag = false;
                    input = "";
                    editText.setText("");
                }else if(input != null || !input.equals("")) {//如果获取到的内容为空
                    editText.setText(input.substring(0, input.length() - 1));//结果集为空
                }
                break;
            case R.id.main_btn1d://运算结果  =
                getResult();//调用处理结果集的方法
                break;





        }
    }

    //运算结果的方法
    private void getResult(){
        String exp = editText.getText().toString();//获取文本框的内容
        if(exp==null||exp.equals("")){
            return;
        }
        if(!exp.contains(" ")){
            return;
        }
        if(clear_flag){
            clear_flag = false;
            return;
        }
        clear_flag = true;
        double result = 0;

        //进行截取
        //运算符前的数字
        String s1 = exp.substring(0,exp.indexOf(" "));
        //运算符
        String op = exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);
        //运算符后的数字
        String s2 = exp.substring(exp.indexOf(" ")+3);

        if(!s1.equals("")&&!s2.equals("")) {//如果包含小数点的运算
            double d1 = Double.parseDouble(s1);//则数字都是double类型
            double d2 = Double.parseDouble(s2);
            if (op.equals("+")) {//如果是 +
                result = d1 + d2;
            } else if (op.equals("-")) {
                result = d1 - d2;
            } else if (op.equals("*")) {
                result = d1 * d2;
            }else if(op.equals("^")){
                result=Math.pow(d1,d2);
            }

            else if (op.equals("/")) {
                if (d2 == 0) { //如果被除数是0
                    result = 0; //则结果是0
                }
                else {//否则执行正常是除法运算
                    result = d1 / d2;
                }
            }

            if (!s1.contains(".") && !s2.contains(".") && !op.equals("/")) {//如果是整数类型
                int r = (int) result; //都是整形
                editText.setText(r + "");
            } else{
                editText.setText(result + "");
            }
        }else if(!s1.equals("") && s2.equals("")){//如果是只输入运算符前的数
            editText.setText(exp);//直接返回当前文本框的内容
        }else if(s1.equals("") && !s2.equals("")){//如果是只输入运算符后面的数
            double d2 = Double.parseDouble(s2);

            //运算符前没有输入数字
            if (op.equals("+")) {
                result = 0 + d2;
            } else if (op.equals("-")) {
                result = 0 - d2;
            } else if (op.equals("*")) {
                result = 0;
            } else if (op.equals("/")) {
                result = 0;
            }

            if (!s1.contains(".") && !s2.contains(".")) {
                int r = (int) result;
                editText.setText(r + "");
            } else{
                editText.setText(result + "");
            }
        }else {
            editText.setText("");
        }

    }


    public static String transRadix(String num, int fromRadix, int toRadix) {
        int number = Integer.valueOf(num, fromRadix);//11,2,3
        StringBuilder sb = new StringBuilder();
        while (number != 0) {//
            sb.append(chs[number%toRadix]);//10
            number = number / toRadix;//
        }
        return sb.reverse().toString();

    }


}
