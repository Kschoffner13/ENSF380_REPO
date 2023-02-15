public class CharacterQuiz {

    private static char theChar = 'a';

    public void aMethod(char theChar){
        this.theChar = 'B';
    }

    public static void main(String args []){
        CharacterQuiz theChar = new CharacterQuiz();
        theChar.aMethod('3');
        System.out.println(theChar);

    }

}
