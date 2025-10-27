package Inventory;

import Player.Character;

public class Item {
    private String name;
    private String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Apply item effect to player
    public void applyEffect(Character player) {
        switch (name) {
            case "Crimson Chorus":
                System.out.println("Crimson Chorus activated! Enemies take more damage for 3 turns.");
                player.setDamageBuff(1.1); // +10% damage temporarily
                break;

            case "Silent Barrier":
                System.out.println("Silent Barrier activated! You are immune for 1 turn!");
                player.setShield(9999); // temporary full immunity (fake high shield)
                break;

            case "Resolved Dissonance":
                System.out.println("Resolved Dissonance active! No HP loss from next B Dim chord.");
                player.setDamageBuff(1.0); // we’d track this in ChordSystem if needed
                break;

            case "Minor’s Grace":
                System.out.println("Minor’s Grace! Start battle with +1 free use of any Minor chord.");
                player.setDamageBuff(1.15);
                break;

            case "Major’s Blessing":
                System.out.println("Major’s Blessing! Start battle with +1 free use of any Major chord.");
                player.setDamageBuff(1.2);
                break;
        }
    }
}