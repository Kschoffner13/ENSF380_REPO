public class Candy {

    public static void main(String[] args){
        String emation = "hate";
        Sweets mySweet = new Sweets("chcoclate");

        String candy = mySweet.getCandy();
        emotion = mySweet.getEmotion();

        System.out.print(emotion + canday);

    }
}

class Sweets{

    private String candy;
    private static String emotion = "love";

    public Sweets(){
        this.candy = "licorice";
    }

    public Sweets(String candy){
        this.candy = candy;
    }

    public void setCandy(String Candy){
        this.candy = candy;
    }

    public void setEmotion(String emotion){
        this.emotion = emotion;
    }

    public static String getEmotion(){
        return emotion;
    }

}