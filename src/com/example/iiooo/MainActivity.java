package com.example.iiooo;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {
	 
	  Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
	  Button btnPlus, btnMinus, btnMultiply, btnDivision;
	  Button btnClear;
	  Button btnEqual;
	  EditText ShowResult;
	  
	  //List<String> CaculationResult= new ArrayList<String>();
	  
	  int FinalResult=0;
	  int MiddleResult=0;
	  String sText=new String();
	  OperateSymbol Operate;
	  
    @Override
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 
        
        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        btn4=(Button)findViewById(R.id.button4);
        btn5=(Button)findViewById(R.id.button5);
        btn6=(Button)findViewById(R.id.button6);
        btn7=(Button)findViewById(R.id.button7);
        btn8=(Button)findViewById(R.id.button8);
        btn9=(Button)findViewById(R.id.button9);
        btn0=(Button)findViewById(R.id.button0);
        
        btnPlus=(Button)findViewById(R.id.btn_Plus);
        btnMinus=(Button)findViewById(R.id.btn_Minus);
        btnMultiply=(Button)findViewById(R.id.btn_Multiply);
        btnDivision=(Button)findViewById(R.id.btn_Division);
        
        btnClear=(Button)findViewById(R.id.btn_Clear);
        btnEqual=(Button)findViewById(R.id.btn_Equal);
        
        ShowResult = (EditText)findViewById(R.id.CaculateResult);
        
        FinalResult=0;
        Operate=OperateSymbol.none;
        
        
        btn1.setOnClickListener(new OnClickListener() {
         	@Override
         	public void onClick(View V){
         		Number(1);
         	}
    });          
        btn2.setOnClickListener(new OnClickListener() {
         	@Override
         	public void onClick(View V){
         		Number(2);
         	}
    }); 
        btn3.setOnClickListener(new OnClickListener() {
         	@Override
         	public void onClick(View V){
         		Number(3);
         	}
    }); 
        btn4.setOnClickListener(new OnClickListener() {
         	@Override
         	public void onClick(View V){
         		Number(4);
         	}
    }); 
        btn5.setOnClickListener(new OnClickListener() {
         	@Override
         	public void onClick(View V){
         		Number(5);
         	}
    }); 
        btn6.setOnClickListener(new OnClickListener() {
         	@Override
         	public void onClick(View V){
         		Number(6);
         	}
    }); 
        btn7.setOnClickListener(new OnClickListener() {
         	@Override
         	public void onClick(View V){
         		Number(7);
         	}
    }); 
        btn8.setOnClickListener(new OnClickListener() {
         	@Override
         	public void onClick(View V){
         		Number(8);
         	}
    }); 
        btn9.setOnClickListener(new OnClickListener() {
         	@Override
         	public void onClick(View V){
         		Number(9);
         	}
    }); 
        btn0.setOnClickListener(new OnClickListener() {
         	@Override
         	public void onClick(View V){
         		Number(0);
         	}
    }); 
        btnClear.setOnClickListener(new OnClickListener() {
         	@Override
         	public void onClick(View V){
         		FinalResult=0;
         		MiddleResult=0;
         		sText=new String();
         		ShowResult.setText("");
         		Operate=OperateSymbol.none;
         	}
    });
        btnPlus.setOnClickListener(new OnClickListener() {
         	@Override
         	public void onClick(View V){
         		Symbol(OperateSymbol.plus);
         	}
    });
        btnMinus.setOnClickListener(new OnClickListener() {
         	@Override
         	public void onClick(View V){
         		Symbol(OperateSymbol.minus);
          	}
    });
        btnMultiply.setOnClickListener(new OnClickListener() {
         	@Override
         	public void onClick(View V){
         		Symbol(OperateSymbol.multiply);
         	}
    });
        btnDivision.setOnClickListener(new OnClickListener() {
         	@Override
         	public void onClick(View V){
         		Symbol(OperateSymbol.division);
         	}
    });
        btnEqual.setOnClickListener(new OnClickListener() {
         	@Override
         	public void onClick(View V){
         		FinalResult=Caculation(FinalResult,Operate,MiddleResult);
         		ShowResult.setText(String.valueOf(FinalResult));
         	}
    });
       
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void Number(int x)
    {
 		MiddleResult=Storage(MiddleResult,x);
 		sText=StringAddNum(sText,x);
 		ShowResult.setText(sText);
    }
    
    public void Symbol(OperateSymbol op)
    { 	
   		FinalResult=MiddleResult;
 		Operate=op;
 		sText=StringAddSymbol(sText,op);
 		ShowResult.setText(sText);
 		MiddleResult=0;
    }
    
    public String StringAddNum(String text, int x)
    {
    	return text+String.valueOf(x);
    }
    
    public String StringAddSymbol(String text, OperateSymbol operation)
    {
    	switch(operation)
    	{
	    	case plus:
	    		return text+"+";
	    	case minus:
	    		return text+"-";
	    	case multiply:
	    		return text+"¡Á";
	    	case division:
	    		return text+"¡Â";
    	}
    	return "";
    }

    public int Storage(int before,int now){
    	int after=before*10+now;
    	return after;
    }
    
    public int Caculation(int before,OperateSymbol operation,int now)
    {
    	switch(operation)
    	{
	    	case plus:
	    		return before + now;
	    	case minus:
	    		return before - now;
	    	case multiply:
	    		return before * now;
	    	case division:
	    		return before / now;
    	}
    	return 0;
    }
    public enum OperateSymbol {
    	plus,minus,multiply,division,none
    }
}
