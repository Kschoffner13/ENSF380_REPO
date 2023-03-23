package edu.ucalgary.oop;

public class CharacterRogue extends GameCharacter{
    private String weapon;

    public CharacterRogue(String characterName, int attackPriority) throws IllegalArgumentException {
        super(characterName, "rogue", attackPriority, 10);
        this.weapon = "knife";
    }
    public String getWeapon(){
        return weapon;
    }

    @Override
    public String getAttackMessage() {
       String returnMsg = this.getCharacterName() + " attacks with their " + this.getWeapon() + ".";
       return returnMsg;
    }
    @Override
    public String talk(String message) {
            // message = 
            String newMessage = "....(" + message + ")....";
            return newMessage;

    //    message = message.replaceAll("\\.", "!!!!!");
    //    return message.toUpperCase();
    }

    // public CharacterWarrior(String characterName, int attackPriority, String weapon) throws IllegalArgumentException {
    //     super(characterName, "warrior", attackPriority, 12);
    //     this.weapons[0] = "sword";
    //     this.weapons[1] = weapon;
    // }

    // public CharacterWarrior(String characterName, int attackPriority, String weapon1, String weapon2) throws IllegalArgumentException {
    //     super(characterName, "warrior", attackPriority, 12);
    //     this.weapons[0] = weapon1;
    //     this.weapons[1] = weapon2;
    // }


    // public String getWeapons() {
    //     String allWeapons = "";
    //     for (int i=0; i<weapons.length; i++) {
    //         if (weapons[i] == null) { break; }
    //         allWeapons = allWeapons + weapons[i] + " and ";
    //     }
    //     allWeapons = allWeapons.replaceAll(" and $", "");
    //     return allWeapons;
    // }




}
