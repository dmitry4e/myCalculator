package homework.che.mycalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Math.sqrt;

public class MainActivity extends Activity {

    TextView result_TV, work_TV, operator_TV;
    String operator="";
    Double number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result_TV= findViewById(R.id.result_TV);
        work_TV= findViewById(R.id.work_TV);
        operator_TV= findViewById(R.id.operator_TV);
    }

    public void btnNumber_Click(View view) {
        if(operator.equals("=")){
            number=null;
            result_TV.setText("");
            operator_TV.setText("");
        }
        else{        }
        Button btn=(Button)view;
        work_TV.append(btn.getText().toString());
    }

    public void btnFunction_Click(View view) {
        Button btn=(Button)view;
        String o=btn.getText().toString();


        if(work_TV.length()>0){
            try{
                Double num=Double.valueOf(work_TV.getText().toString());
                doProgress(num,o);
            }
            catch(NumberFormatException ex){           }
        }
        operator=o;
        operator_TV.setText(operator);
    }

    private void doProgress(Double operand, String o) {

        if(number==null){
            number=Double.valueOf(operand);

        }
        else {
            Double secondNumber=Double.valueOf(operand);
            switch (operator){
                case "=":
                    number=operand;
                    break;
                case "+":
                    number+=secondNumber;
                    break;
                case "-":
                    number-=secondNumber;
                    break;
                case "*":
                    number*=secondNumber;
                    break;
                case "/":
                    if(secondNumber==0){
                        number=0.0;
                    }
                    else{
                        number/=secondNumber;
                    }
                    break;
            }
        }
        result_TV.setText(number.toString());
        work_TV.setText("");



    }

    public void btnClear_Click(View view) {
        number=null;
        result_TV.setText("");
        operator_TV.setText("");
        work_TV.setText("");
    }


    public void btnBackspace_Click(View view) {
        String buffer=work_TV.getText().toString();
        work_TV.setText(buffer.substring(0, buffer.length() - 1));
    }

    public void btnSqrt_Click(View view) {
        Button btn=(Button)view;
        operator=btn.getText().toString();
        result_TV.setText(operator);
        operator_TV.setText("=");
        if(number==null){
            number=Double.valueOf(work_TV.getText().toString());
        }
        Double result=sqrt(number);
        work_TV.setText(result.toString());
    }

    public void btnPlusMinus_Click(View view) {
        if(work_TV.length()==0){
            work_TV.setText("-");
        }
        else{
            Double buffer= Double.valueOf(work_TV.getText().toString());
            number=buffer*-1;
            work_TV.setText(number.toString());
        }
    }
}
