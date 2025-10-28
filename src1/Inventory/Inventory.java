package Inventory;

import java.util.ArrayList;
import java.util.Random;
import Display.*;

public class Inventory {
    private ArrayList<Item> items = new ArrayList<>();
    private Random rd = new Random();
    TextDisplay text = new TextDisplay();

    // total battles fought (for drop loot progression)
    private int battleCount = 0;

    // Add item to inventory
    public void addItem(Item item) {
        items.add(item);
        text.printSystemMessage("\nItem obtained: " + item.getName() + " - " + item.getDescription());
    }

    public void tryDrop() {
        battleCount++;
        double dropChance;

        // Progressive drop chance
        if (battleCount <= 2) {
            dropChance = 0.50;
        } else if (battleCount <= 4) {
            dropChance = 0.70;
        } else {
            dropChance = 0.85;
        }

        double roll = rd.nextDouble();

        if (roll < dropChance) {
            randomDrop();
        } else {
            text.printSystemMessage("No items dropped this time...");
        }
    }

    // Random drop selector
    private void randomDrop() {
        int roll = rd.nextInt(5);
        Item dropped = null;

        switch (roll) {
            case 0:
                dropped = new Item("Crimson Chorus", "Enemies take 5–10% more damage for 2–3 turns.");
                break;
            case 1:
                dropped = new Item("Silent Barrier", "1 turn of full immunity.");
                break;
            case 2:
                dropped = new Item("Resolved Dissonance", "Next B Dim doesn’t cost HP.");
                break;
            case 3:
                dropped = new Item("Minor’s Grace", "+1 free Minor chord use.");
                break;
            case 4:
                dropped = new Item("Major’s Blessing", "+1 free Major chord use.");
                break;
        }

        if (dropped != null) {
            addItem(dropped);
        }
    }

    // View inventory
    public void showInventory() {
        if (items.isEmpty()) {
            text.printSystemMessage("Inventory is empty.\n");
            return;
        }
        text.printSystemMessage("\n=== Inventory ===");
        for (Item i : items) {
            text.printSystemAnnouncement("- " + i.getName() + ": " + i.getDescription());
        }
    }
}
