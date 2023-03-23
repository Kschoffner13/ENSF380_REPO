package edu.ucalgary.oop;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameCharacterTest {

    @Test
    public void characterWarriorConstructor1Test() {
        CharacterWarrior warrior = new CharacterWarrior("Alex", 70);
        assertEquals("Alex", warrior.getCharacterName());
    }

    @Test
    public void characterWarriorConstructor2Test() {
        String[] weapons = {"sword", "shield"};
        CharacterWarrior warrior = new CharacterWarrior("Alex", 82, "sword");
        assertEquals("Alex", warrior.getCharacterName());
        assertEquals(weapons[0] + " and " + weapons[1], warrior.getWeapons());
    }

    @Test
    public void characterWarriorConstructor3Test() {
        String[] weapons = {"spear", "sword"};
        CharacterWarrior warrior = new CharacterWarrior("Alex", 99, "spear", "sword");
        assertEquals("Alex", warrior.getCharacterName());
        assertEquals(weapons[0] + " and " + weapons[1], warrior.getWeapons());
    }

    @Test
    public void characterRogueConstructorTest() {
        CharacterRogue rogue = new CharacterRogue("Alex", 76);
        assertEquals("Alex", rogue.getCharacterName());
        assertEquals("knife", rogue.getWeapon());
    }
}