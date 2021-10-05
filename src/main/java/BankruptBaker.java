import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BankruptBaker {

    static final Integer ZERO = 0;

    static class Recipe implements Comparable<Recipe> {
        final String name;
        final int cost;

        public Recipe(String name, int cost) {
            this.name = name;
            this.cost = cost;
        }

        @Override
        public int compareTo(Recipe o) {
            int cmp = Integer.compare(cost, o.cost);
            return cmp != 0 ? cmp : name.compareTo(o.name);
        }
    }

    public static void main(String[] args) {
        try (final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int recipeBookCount = Integer.parseInt(br.readLine());
            String recipeBookName;
            String[] temp;
            int money;
            int ingredientCount;
            int recipeCount;
            String recipeName;
            TreeSet<Recipe> recipes = new TreeSet<>();
            Map<String, Integer> ingredientCosts = new HashMap<>();
            for (int recipeBookIndex = 0; recipeBookIndex < recipeBookCount; recipeBookIndex++) {
                ingredientCosts.clear();
                recipes.clear();
                recipeBookName = br.readLine().toUpperCase();
                temp = br.readLine().split("\\s+");
                ingredientCount = Integer.parseInt(temp[0]);
                recipeCount = Integer.parseInt(temp[1]);
                money = Integer.parseInt(temp[2]);
                for (int ingredientIndex = 0; ingredientIndex < ingredientCount; ingredientIndex++) {
                    temp = br.readLine().split("\\s+");
                    ingredientCosts.put(temp[0], Integer.parseInt(temp[1]));
                }
                for (int recipeIndex = 0; recipeIndex < recipeCount; recipeIndex++) {
                    recipeName = br.readLine();
                    ingredientCount = Integer.parseInt(br.readLine());
                    int cost = 0;
                    int i = 0;
                    Integer currentIngredientCost = ZERO;
                    for (i = 0; i < ingredientCount && cost <= money; i++) {
                        temp = br.readLine().split("\\s+");
                        currentIngredientCost = ingredientCosts.get(temp[0]);
                        if (currentIngredientCost == null) {
                            break;
                        }
                        cost += currentIngredientCost * Integer.parseInt(temp[1]);
                    }
                    if (i < ingredientCount) {
                        for (; i < ingredientCount; i++) {
                            br.readLine();
                        }
                    }
                    if (cost <= money && currentIngredientCost != null) {
                        recipes.add(new Recipe(recipeName, cost));
                    }
                }
                StringJoiner sj = new StringJoiner(System.lineSeparator());
                sj.setEmptyValue("Too expensive!");
                for (Recipe recipe : recipes) {
                    sj.add(recipe.name);
                }
                bw.write(recipeBookName);
                bw.newLine();
                bw.write(sj.toString());
                bw.newLine();
                bw.newLine();
            }
        } catch (Exception e) {

        }
    }
}
