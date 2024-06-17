package fye.slapburger.app;

import static com.apps.util.Console.*;
import com.apps.util.Prompter;
import fye.slapburger.Chef;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class BigBackBurgerApp {

  private Chef chef = new Chef();
  private final Prompter prompter = new Prompter(new Scanner(System.in));

  public void execute() {
    welcome();
    showMenu();
    placeOrder();
    confirmOrder();
    pay();
    cookOrder();
    serveOrder();
    reviewFood();
  }

  private void reviewFood() {
  }

  private void serveOrder() {
  }

  private void cookOrder() {
  }

  private void pay() {
    //TODO: give order total and take payment
  }

  private void confirmOrder() {
    chef.getOrder().displayOrder();

  }

  private void placeOrder() {
    //TODO: Choose from menu items and save the order to a file;
  }

  private void showMenu() {
  }


  private void welcome() {
    prompter.prompt("Welcome to Big Back Burger");
    try {
      clear();
      String bigBackBurgerFile = Files.readString(Path.of("resources/bigBackBurger.txt"));
      System.out.println("\n" + bigBackBurgerFile + "\n");
      pause(3500);
    } catch (IOException e){
        e.printStackTrace();
    }
  }
}