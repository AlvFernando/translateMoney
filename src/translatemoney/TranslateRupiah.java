package translatemoney;

import java.util.HashMap;
import java.util.Map;

public class TranslateRupiah {
    private int length;
    private Integer input;
    private Map<Integer,String> lib= new HashMap<>(){{
        put(0, "");
        put(1, "satu");
        put(2, "dua");
        put(3, "tiga");
        put(4, "empat");
        put(5, "lima");
        put(6, "enam");
        put(7, "tujuh");
        put(8, "delapan");
        put(9, "sembilan");
        put(10, "sepuluh");
        put(11, "sebelas");
        put(12, "dua belas");
        put(13, "tiga belas");
        put(14, "empat belas");
        put(15, "lima belas");
        put(16, "enam belas");
        put(17, "tujuh belas");
        put(18, "delapan belas");
        put(19, "sembilan belas");
        put(100,"seratus");
        put(1000,"seribu");
    }};

    public TranslateRupiah(Integer input) {
        this.length = input.toString().length();
        this.input = input;
    }

    public String translate(){
        String res = "";
        if(length==1){
            res = unit(input);
        }else if(length==2){
            res = tens(input);
        }else if(length==3){
            res = hundreds(input);
        }
        else if(length>3&&length<7){
            res = thousands(input);
        }
        return res;
    }

    private String thousands(Integer input){
        String res = "";
        String thousandsString = unit(input/1000)+" ribu ";
        String hundredsString = hundreds(input%1000);
        if(input/1000==1){
            thousandsString = lib.get((input/1000)*1000) + " ";
        }
        res = thousandsString + hundredsString;
        return res;
    }

    private String hundreds(Integer input){
        String res = "";
        String hundredsString = "";
        String tensString = "";
        hundredsString = lib.get((input/100));
        
        if(input>=0&&input<10){
            return unit(input);
        }else if(input>=10&&input<99){
            return tens(input);
        }else if(input/100==1){
            hundredsString = lib.get((input/100)*100);
        }

        if(input%100<10){
            tensString = unit(input%100);
        }else{
            tensString = tens(input%100);
        }

        if(input/100==1){
            res = hundredsString + " " +tensString;
        }else{
            res = hundredsString+" ratus "+tensString;
        }
        return res;
    }

    private String tens(Integer input){
        String res = "";
        String tensString = "";
        String unitString = "";
        if(input/10 == 1){
            tensString = lib.get(input);
            res = tensString;
        }else{
            tensString = lib.get(input/10);
            unitString = unit(input%10);
            res = tensString+" puluh "+unitString;
        }
        return res;
    }

    private String unit(Integer input){
        String res = "";
        res = lib.get(input);
        return res;
    }
}
