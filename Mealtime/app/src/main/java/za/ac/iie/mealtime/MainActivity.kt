package za.ac.iie.mealtime

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


     // Declaring my variables and linking UI with their IDs
        val edtTextTimeOfDay = findViewById<EditText>(R.id. edtTextTimeOfDay)
        val btnSuggestMeal = findViewById<Button>(R.id. btnSuggestMeal)
        val txtViewMealSuggestion = findViewById<TextView>(R.id. txtViewMealSuggestion)
        val btnReset = findViewById<Button>(R.id.btnReset )

        // Assigning values to meal suggestions when the meal suggestions button is clicked
        btnSuggestMeal.setOnClickListener {
            val timeOfDay = edtTextTimeOfDay.text.toString().trim()


            var mealSuggestion = ""

            if (timeOfDay=="Morning") {
                mealSuggestion = "Breakfast: Eggs, Bacon / Sausage, Toast and FruitJuice"
            }else if (timeOfDay== "Mid-morning") {
                mealSuggestion = "Snack: Fruits or Yoghurt"
            }else if (timeOfDay== "Afternoon"){
            mealSuggestion = "Lunch: Chicken Mayo Sandwich and potato chips  "
            }else if (timeOfDay== "Mid-afternoon"){
                mealSuggestion = "snack: Chips or Pretzels"
            }else if (timeOfDay== "Night"){
                mealSuggestion = "Dinner:Alfredo Pasta"
            }else if (timeOfDay== "Night snack") {
                mealSuggestion = "Snack:Ice Cream or Cake "
            }else {
                mealSuggestion ="Invalid Input. Please enter Morning, Mid-morning, Afternoon, Mid-afternoon, Night, Night snack. "
            }
            txtViewMealSuggestion.text=mealSuggestion


        }
        // Creating an action for when the reset button is clicked
        btnReset.setOnClickListener {
            edtTextTimeOfDay.text.clear()
            txtViewMealSuggestion.text="Meal Suggested Here"
        }
        







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

private fun Any.clear() {

}



