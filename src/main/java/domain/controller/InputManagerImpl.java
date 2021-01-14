package domain.controller;

import domain.user.Player;

import java.util.Scanner;

public class InputManagerImpl implements InputManager {
    private Scanner scanner;

    public InputManagerImpl(Scanner scanner) {
        this.scanner = scanner;
    }

    public Integer readInteger() {
        String inputStr = scanner.nextLine();
        Integer input;
        try {
            input = Integer.parseInt(inputStr);
        }
        catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력해주세요.");
            return null;
        }
        return input;
    }

    private void printChoiceStatePrompt(Player player) {
        player.printHand();
        System.out.println("0 : 스탠드 (멈춥니다.)");
        System.out.println("1 : 히트 (한장 더 받습니다.)");
        System.out.println("어떻게 하시겠습니까?");
    }

    public boolean choiceState(Player player) {
        printChoiceStatePrompt(player);
        Integer select = readInteger();
        if (select == null) return false;
        if (select == 1) {
            player.hit();
            return true;
        }
        player.stand();
        return true;
    }
}
