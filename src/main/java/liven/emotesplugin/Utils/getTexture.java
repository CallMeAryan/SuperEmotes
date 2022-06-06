package liven.emotesplugin.Utils;




import java.util.UUID;

public class getTexture{
    private String t1;
    private String t2;
    private int CurrentText;

    public getTexture(int currentTe, String Te1, String Te2){

        this.CurrentText = currentTe;
        this.t1 = Te1;
        this.t2 = Te2;
    }
    public String getText1(){
        return t1;
    }

    public int getcur(){

        return CurrentText;
    }
    public void setText(int currentTexture, String Texture1, String Texture2){
        this.t1 = Texture1;
        this.t2 = Texture2;
        this.CurrentText = currentTexture;
    }

    public void setCur(int currentText){

            this.CurrentText = currentText;

    }
//8005862850
    public String getText2(){
        return t2;
    }
}
