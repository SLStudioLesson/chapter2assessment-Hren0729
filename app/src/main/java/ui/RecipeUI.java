package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

import data.RecipeFileHandler;

public class RecipeUI {
    private BufferedReader reader;
    private RecipeFileHandler fileHandler;

    public RecipeUI() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        fileHandler = new RecipeFileHandler();
    }

    public RecipeUI(BufferedReader reader, RecipeFileHandler fileHandler) {
        this.reader = reader;
        this.fileHandler = fileHandler;
    }

    public void displayMenu() {
        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        displayRecipes(); // レシピ表示
                        break;
                    case "2":
                        addNewRecipe(); // 新規レシピ追加
                        break;
                    case "3":
                        searchRecipe(); // レシピ検索
                        break;
                    case "4":
                        System.out.println("Exit the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    /**
     * 設問1: 一覧表示機能
     * RecipeFileHandlerから読み込んだレシピデータを整形してコンソールに表示します。
     */
    private void displayRecipes() {
        ArrayList<String> recipes = fileHandler.readRecipes();

        System.out.println("Recipes");
        System.out.println("-----------------------------------");

        if (recipes.isEmpty()) {
            System.out.println("No recipes available.");
            return;
        }

        for (String recipe : recipes) {
            String[] parts = recipe.split(",",2);
            if (parts.length == 2) {
                System.out.println("Recipe Name: " + parts[0]);
                System.out.println("Main Ingredients: " + parts[1]);
            } else {
                System.out.println("Invalid recipe format: " + recipe);
            }
            System.out.println("-----------------------------------");
        }
    }

    /**
     * 設問2: 新規登録機能
     * ユーザーからレシピ名と主な材料を入力させ、RecipeFileHandlerを使用してrecipes.txtに新しいレシピを追加します。
     */
    private void addNewRecipe() throws IOException {
        System.out.print("Enter recipe name: ");
        String recipeName = reader.readLine();
        System.out.print("Enter main ingredients: ");
        String ingredients = reader.readLine();

        fileHandler.addRecipe(recipeName, ingredients);
        System.out.println("New recipe added successfully!");
    }

    /**
     * 設問3: 検索機能
     * ユーザーから検索クエリを入力させ、そのクエリに基づいてレシピを検索し、一致するレシピをコンソールに表示します。
     */
    private void searchRecipe() throws IOException {

        
    }
}