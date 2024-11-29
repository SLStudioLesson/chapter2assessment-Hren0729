package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RecipeFileHandler {
    private String filePath;

    public RecipeFileHandler() {
        this.filePath = "app\\src\\main\\resources\\recipes.txt";
    }

    public RecipeFileHandler(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 設問1: 一覧表示機能
     * recipes.txtからレシピデータを読み込み、それをリスト形式で返します。 <br> 
     * IOExceptionが発生したときは<i>Error reading file: 例外のメッセージ</i>とコンソールに表示します。
     *
     * @return レシピデータ
     */
    public ArrayList<String> readRecipes() {
        ArrayList<String> recipes = new ArrayList<>();
        File file = new File(filePath);

        // ファイルが存在するかどうか
        if (!file.exists()) {
            System.out.println("No recipes file found.");
            return recipes;
        }

        try (BufferedReader br = new BufferedReader(new FileReader("app\\src\\main\\resources\\recipes.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                recipes.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return recipes;
    }

    /**
     * 設問2: 新規登録機能
     * 新しいレシピをrecipes.txtに追加します。<br>
     * レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。
     *
     * @param recipeName レシピ名
     * @param ingredients 材料名
     */
    public void addRecipe(String recipeName, String ingredients) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("app\\src\\main\\resources\\recipes.txt", true))) {
            writer.write(recipeName + "," + ingredients);
            writer.newLine();  // 新しい行に書き込む
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}