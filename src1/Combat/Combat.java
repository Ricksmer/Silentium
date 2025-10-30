package Combat;

import java.util.Scanner;
import java.util.Random;

import Display.TextDisplay;
import Inventory.Inventory;
import Player.Character;
import Enemy.Monster;
import Display.CombatDisplay;

public class Combat {
    TextDisplay text = new TextDisplay();
    CombatDisplay combDisplay = new CombatDisplay();
    Metronome mt = new Metronome();
    Note nt = new Note();
    Random rd = new Random();
    Scanner sc = new Scanner(System.in);
    ChordSystem chordSystem = new ChordSystem();
    public static final Inventory inventory = new Inventory();

    private boolean isGameOver;

    public void battle(Character player, Monster enemy) {
        combDisplay.battleStart();
        int beat;
        mt.reset();
        int damage;
        isGameOver = false;
        player.setHp(player.getMaxHp());
        player.setShield(player.getMaxShield());
        player.resetTemporaryEffects();
        player.as.resetSkill();

        while (!isGameOver) {
            beat = mt.getBeat();

            turnAction(player, enemy, beat);

            // Game Check - enemy defeated?
            isGameOver = isEnemyDefeated(enemy);
            if (isGameOver) {
                text.printSystemMessage("--- You defeated " + enemy.name + "! ---\n");

                inventory.tryDrop();

                player.levelUp(player);
                break;
            }

            // Enemy Attack
            if (player.name.equals("Sonara")) {
                damage = player.ps.skillEffect(enemy);
                isGameOver = isEnemyDefeated(enemy);
                if (isGameOver) {
                    text.printSystemMessage("--- You defeated " + enemy.name + "! ---\n");

                    inventory.tryDrop();

                    player.levelUp(player);
                    break;
                }
            } else {
                damage = enemyAttack(enemy);
            }

            player.takeDamage(damage);
            combDisplay.playerStatsSummary(player);

            // Game Check - player defeated?
            isGameOver = isPlayerDefeated(player);
            if (isGameOver) break;

            player.updateTurnEffects();
        }
    }

    public void playerAttack(Character player, Monster enemy, int beat) {
        boolean isValidAttack = false;
        char note1 = ' ';
        char note2 = ' ';
        char note3 = ' ';

        while (!isValidAttack) {
            combDisplay.noteInput();

            text.printSystemInput("#1:   ");
            note1 = sc.next().toUpperCase().charAt(0);
            text.printSystemInput("#2:   ");
            note2 = sc.next().toUpperCase().charAt(0);
            text.printSystemInput("#3:   ");
            note3 = sc.next().toUpperCase().charAt(0);
            System.out.println();

            isValidAttack = checkNotes(player, note1, note2, note3);
            if (!isValidAttack) {
                text.printSystemError("Please re-enter your notes.");
            }
        }

        int damage = computeNoteDamage(player, note1, note2, note3, beat);

        if (player.getLevel() >= 3) {
            String chord = chordSystem.checkChord(note1, note2, note3);
            if (chord != null) {
                damage = chordSystem.applyChord(chord, player, damage);
            }
        }

        text.printSystemMessage("\tTotal Damage Dealt: " + damage);
        System.out.println();

        enemy.takeDamage(damage);
    }

    public boolean checkNotes(Character player, char n1, char n2, char n3) {
        if (nt.isValidNote(n1, player) && nt.isValidNote(n2, player) && nt.isValidNote(n3, player)) {
            if (n1 == n2 || n1 == n3 || n2 == n3) {
                text.printSystemError(" --- Duplicate notes detected! Please enter different notes. ---\n");
                combDisplay.displayValidNotes(player);
            } else {
                return true;
            }
        } else {
            combDisplay.displayValidNotes(player);
        }
        return false;
    }

    public int enemyAttack(Monster enemy) {
        int attack = rd.nextInt(1, 4);
        int damage = 0;

        if (attack == 1) {
            damage = enemy.sk1Damage;
        } else if (attack == 2) {
            damage = enemy.sk2Damage;
        } else if (attack == 3) {
            damage = enemy.sk3Damage;
        }

        text.printSystemMessage("\tMonster attacks Player and deals " + damage + " damage!");
        System.out.println();
        return damage;
    }

    public int computeNoteDamage(Character player, char note1, char note2, char note3, int beat) {
        int initialDamage = 0;
        initialDamage += nt.noteDamage(note1);
        initialDamage += nt.noteDamage(note2);
        initialDamage += nt.noteDamage(note3);
        text.printSystemMessage("Initial Damage: " + initialDamage);

        if (player.name.equals("Sonara")) {
            initialDamage = player.as.skillEffect(player, initialDamage);
        }

        if (player.getLevel() > 1) {
            text.printSystemMessage("Metronome: " + beat);
            int finalDamage = mt.updateBeat(player, initialDamage);
            text.printSystemMessage("Final Damage: " + finalDamage);
            return finalDamage;
        }
        return initialDamage;
    }

    public boolean isPlayerDefeated(Character player) {
        if (player.getHp() <= 0) {
            player.setHp(0);
            isGameOver = true;
            combDisplay.battleEnd(false);
            return true;
        }
        return false;
    }

    public boolean isEnemyDefeated(Monster enemy) {
        if (enemy.getHp() <= 0) {
            enemy.setHp(0);
            isGameOver = true;
            return true;
        }
        return false;
    }

    public void turnAction(Character player, Monster enemy, int beat) {
        boolean isTurnOver;
        int action = 0;
        boolean isEnabled;

        if (player.getLevel() > 1)
            text.printSystemMessage("Metronome: " + beat);

        nt.generateNotes();

        if (player.getLevel() < 3) {
            do {
                if (player.name.equals("Lyron")) { if (player.as.skillEffect(player)) nt.generateNotes(); }
                if (player.name.equals("Aurelius")) {
                    nt.setPreserveNextDamage(player.as.skillActive);
                    player.as.skillEffectAurelius(player, 0);
                }

                nt.damagePerNote(player);
                isTurnOver = false;
                combDisplay.turnAction(player);
                isEnabled = true;

                while (isEnabled) {
                    try {
                        action = sc.nextInt();
                        System.out.println();
                        if (action <= 0 || action > 4) {
                            text.printSystemError("--- Invalid Input ---");
                            text.printSystemInput("Select: ");
                        } else {
                            isEnabled = false;
                        }
                    } catch (Exception e) {
                        text.printSystemError("--- Invalid Input ---");
                        text.printSystemInput("Select: ");
                        sc.next();
                    }
                }

                switch (action) {
                    case 1:
                        playerAttack(player, enemy, beat);
                        combDisplay.enemyStatsSummary(enemy);
                        isTurnOver = true;
                        break;
                    case 2:
                        player.as.useSkill(player);
                        break;
                    case 3:
                        combDisplay.playerStatsSummary(player);
                        combDisplay.enemyStatsSummary(enemy);
                        break;
                    case 4:
                        text.printSystemMessage("No content available...");
                        break;
                }
            } while (!isTurnOver);
        } else {
            do {
                if (player.name.equals("Lyron")) { if (player.as.skillEffect(player)) nt.generateNotes(); }

                nt.damagePerNote(player);
                isTurnOver = false;
                combDisplay.turnAction(player);
                isEnabled = true;

                while (isEnabled) {
                    try {
                        action = sc.nextInt();
                        System.out.println();
                        if (action <= 0 || action > 6) {
                            text.printSystemError("--- Invalid Input ---");
                            text.printSystemInput("Select: ");
                        } else {
                            isEnabled = false;
                        }
                    } catch (Exception e) {
                        text.printSystemError("--- Invalid Input ---");
                        text.printSystemInput("Select: ");
                        sc.next();
                    }
                }

                switch (action) {
                    case 1:
                        playerAttack(player, enemy, beat);
                        combDisplay.enemyStatsSummary(enemy);
                        isTurnOver = true;
                        break;
                    case 2:
                        player.as.useSkill(player);
                        break;
                    case 3:
                        inventory.useItem(player);
                        break;
                    case 4:
                        combDisplay.chordChart(chordSystem);
                        break;
                    case 5:
                        combDisplay.playerStatsSummary(player);
                        combDisplay.enemyStatsSummary(enemy);
                        break;
                    case 6:
                        text.printSystemMessage("No content available...");
                        break;
                }
            } while (!isTurnOver);
        }
    }
}
