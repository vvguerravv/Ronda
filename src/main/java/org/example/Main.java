package org.example;

import java.util.ArrayList;
import java.security.SecureRandom;
import java.util.Objects;
import java.util.Scanner;


public class Main {

    private Scanner scanner;

    public Main(){
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) throws InterruptedException {

        Main main = new Main();
        ArrayList<Baralho> baralhos = new ArrayList<>();
        SecureRandom secureRandom = new SecureRandom();

        for(Valor a: Valor.values()){
            for(int i = 0;i <4;i++){
                baralhos.add(new Baralho(a));
            }
        }

        System.out.println("Escolha duas cartas, para o P1 e para o P2 reespectivamente");

        int card1 = secureRandom.nextInt(baralhos.size());
        int card2 = secureRandom.nextInt(baralhos.size());

        while(Objects.equals(baralhos.get(card1).getValor(), baralhos.get(card2).getValor())){
            card2 = secureRandom.nextInt(baralhos.size());
        }


        System.out.println("As cartas são:" + baralhos.get(card1).getValor() + " " + baralhos.get(card2).getValor());

        baralhos.remove(card1);
        baralhos.remove(card2);

        String P1 = main.scanner.nextLine();
        String P2 = main.scanner.nextLine();


        while(true){
            int random = secureRandom.nextInt(baralhos.size());
            System.out.println("A carta da vez é: " + baralhos.get(random).getValor());

            if(baralhos.get(random).getValor().equalsIgnoreCase(P1)){
                System.out.println("Quem escolheu a carta: " + P1 + " ganhou");
                break;
            } else if(baralhos.get(random).getValor().equalsIgnoreCase(P2)){
                System.out.println("Quem escolheu a carta: " + P2 + " ganhou");
                break;
            }else{
                System.out.println("Vamos de novo");
                baralhos.remove(random);
                Thread.sleep(1000);
            }
        }
    }
}