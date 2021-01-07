/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizv2;



/**
 *
 * @author Admin
 */
public class Quiz {
     private int id;

    private String question;

    private String reponce;

    private String PerChoix;
    private String DexChoix;
    private String TroChoix;

    private static int compteur = 1;

    public Quiz(String question, String responce, String PerChoix, String DexChoix, String TroChoix) {
        setId(compteur++);
        this.question = question;
        this.reponce = reponce;
        this.PerChoix = PerChoix;
        this.DexChoix = DexChoix;
        this.TroChoix = TroChoix;
    }

    public Quiz(String question, String reponce, String PerChoix, String DexChoix) {
        setId(compteur++);
        this.question = question;
        this.reponce = reponce;
        this.PerChoix = PerChoix;
        this.DexChoix = DexChoix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponce() {
        return reponce;
    }

    public void setReponce(String reponce) {
        this.reponce = reponce;
    }

    public String getPerChoix() {
        return PerChoix;
    }

    public void setPerChoix(String PerChoix) {
        this.PerChoix = PerChoix;
    }

    public String getDexChoix() {
        return DexChoix;
    }

    public void setDexChoix(String DexChoix) {
        this.DexChoix = DexChoix;
    }

    public String getTroChoix() {
        return TroChoix;
    }

    public void setTroChoix(String TroChoix) {
        this.TroChoix = TroChoix;
    }
    

    @Override
    public String toString() {
        return "Quiz{" + "id=" + id + ", question=" + question + ", reponce=" + reponce + ", PerChoix=" + PerChoix + ", DexChoix=" + DexChoix + ", TroChoix=" + TroChoix + '}';
    }
    
}
