package net.liven.Utils;

public class getTexture{
    private String TE_Texture_1;
    private String TE_Texture_2;
    private int INT_CurrentTexture;

    public getTexture(int INT_CurrentTexture, String TE_Texture_1, String TE_Texture_2){

        this.INT_CurrentTexture = INT_CurrentTexture;
        this.TE_Texture_1 = TE_Texture_1;
        this.TE_Texture_2 = TE_Texture_2;
    }




    public void setCur(int INT_CurrentTexture){

            this.INT_CurrentTexture = INT_CurrentTexture;

    }
    public int getCurrentTexture(){ return INT_CurrentTexture; }
    public String getTexture_1(){ return TE_Texture_1; }
    public String getTexture_2(){ return TE_Texture_2; }
}
