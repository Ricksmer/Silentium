package Inventory;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import Display.*;
import Player.Character;

public class Inventory {
    private ArrayList<Item> items = new ArrayList<>();
    private Random rd = new Random();
    private Scanner sc = new Scanner(System.in);
    TextDisplay text = new TextDisplay();

    private int battleCount = 0; // for loot progression

    public void addItem(Item item) {
        items.add(item);
        text.printSystemAnnouncement("Item obtained: " + item.getName() + " - " + item.getDescription() + "\n");
    }

    public void tryDrop() {
        battleCount++;
        double dropChance;

        if (battleCount <= 2) dropChance = 0.50;
        else if (battleCount <= 4) dropChance = 0.70;
        else dropChance = 0.85;

        double roll = rd.nextDouble();

        if (roll < dropChance) randomDrop();
        else text.printSystemMessage("No items dropped this time...\n");
    }

    private void randomDrop() {
        int roll = rd.nextInt(5);
        Item dropped = null;

        switch (roll) {
            case 0 -> dropped = new Item("Crimson Chorus", "Enemies take 5–10% more damage for 2–3 turns.");
            case 1 -> dropped = new Item("Silent Barrier", "1 turn of full immunity.");
            case 2 -> dropped = new Item("Resolved Dissonance", "Next B Dim doesn’t cost HP.");
            case 3 -> dropped = new Item("Minor’s Grace", "+1 free Minor chord use.");
            case 4 -> dropped = new Item("Major’s Blessing", "+1 free Major chord use.");
        }

        if (dropped != null) addItem(dropped);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void showInventory() {
        text.printSystemMessage("--- Inventory ---\n");

        if (items.isEmpty()) {
            text.printSystemAnnouncement("Your inventory is empty.");
            return;
        }

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            text.printSystemAnnouncement("[ " + (i + 1) + " ] " + item.getName() + " - " + item.getDescription());
        }
    }

    public void useItem(Character player) {
        if (items.isEmpty()) {
            text.printSystemAnnouncement("Your inventory is empty. Nothing to use!\n");
            return;
        }

        while (true) {
            text.printSystemMessage("--- INVENTORY ---\n");
            for (int i = 0; i < items.size(); i++) {
                Item item = items.get(i);
                text.printSystemAnnouncement("[ " + (i + 1) + " ] " + item.getName() + " - " + item.getDescription());
            }
            text.printSystemMessage("[ 0 ] Go Back\n");

            text.printSystemInput("Choose an item to use: ");
            int choice;

            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                sc.nextLine(); // clear input
                text.printSystemError("Invalid input. Please enter a number.");
                continue;
            }

            if (choice == 0) {
                text.printSystemMessage("You closed your inventory.");
                break;
            }

            if (choice < 1 || choice > items.size()) {
                text.printSystemError("Invalid choice. Try again.");
                continue;
            }

            Item selectedItem = items.get(choice - 1);

            text.printSystemMessage("You used " + selectedItem.getName() + "!");
            selectedItem.applyEffect(player);
            items.remove(choice - 1);
            text.printSystemMessage(selectedItem.getName() + " has been consumed.\n");

            break;
        }
    }
}
