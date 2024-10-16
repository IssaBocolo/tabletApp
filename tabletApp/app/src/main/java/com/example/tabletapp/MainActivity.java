package com.example.tabletapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    private static final double PRICE_SMALL = 2500.00;
    private static final double PRICE_MEDIUM = 3500.00;
    private static final double PRICE_LARGE = 4500.00;

    private static final double INTEREST_RATE = 85.4 / 100; // 85.4%
    private static final int MONTHS = 24; // Number of months for installment

    private ImageView displayImage;
    private TextView sizePriceTextView, resultTextView;
    private EditText nameEditText, customMessageEditText, choiceEditText;
    private Button buttonSmall, buttonMedium, buttonLarge, calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayImage = findViewById(R.id.displayImage);
        sizePriceTextView = findViewById(R.id.sizePriceTextView);
        resultTextView = findViewById(R.id.result);

        nameEditText = findViewById(R.id.studentName);
        customMessageEditText = findViewById(R.id.customMessage);
        choiceEditText = findViewById(R.id.choice);

        buttonSmall = findViewById(R.id.button1);
        buttonMedium = findViewById(R.id.button2);
        buttonLarge = findViewById(R.id.button3);
        calculateButton = findViewById(R.id.button4);

        buttonSmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateButtonColors(buttonSmall);
                displayImage.setImageResource(R.drawable.small);
                sizePriceTextView.setText("S - Small Tablet: R2500.00");
            }
        });

        buttonMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateButtonColors(buttonMedium);
                displayImage.setImageResource(R.drawable.medium);
                sizePriceTextView.setText("M - Medium Tablet: R3500.00");
            }
        });

        buttonLarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateButtonColors(buttonLarge);
                displayImage.setImageResource(R.drawable.large);
                sizePriceTextView.setText("L - Large Tablet: R4500.00");
            }
        });

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateMonthlyInstallment();
            }
        });
    }

    private void updateButtonColors(Button activeButton) {
        buttonSmall.setBackgroundColor(Color.parseColor("#9E9E9E"));
        buttonMedium.setBackgroundColor(Color.parseColor("#9E9E9E"));
        buttonLarge.setBackgroundColor(Color.parseColor("#9E9E9E"));

        activeButton.setBackgroundColor(Color.parseColor("#4CAF50"));
    }

    private void calculateMonthlyInstallment() {
        String name = nameEditText.getText().toString();
        String customMessage = customMessageEditText.getText().toString();
        String choice = choiceEditText.getText().toString().trim().toUpperCase();

        double tabletPrice = 0.0;


        if (choice.equals("S")) {
            tabletPrice = PRICE_SMALL;
        } else if (choice.equals("M")) {
            tabletPrice = PRICE_MEDIUM;
        } else if (choice.equals("L")) {
            tabletPrice = PRICE_LARGE;
        } else {
            resultTextView.setTextColor(Color.RED);
            resultTextView.setText("Invalid choice. Please select S, M, or L.");
            return;
        }

        double totalCreditPrice = tabletPrice * (1 + INTEREST_RATE);
        double monthlyInstallment = totalCreditPrice / MONTHS;
        DecimalFormat currencyFormat = new DecimalFormat("R#,##0.00");


        resultTextView.setTextColor(Color.BLACK);
        resultTextView.setText(
                String.format(
                        "%s\n %s\n" +
                                "Monthly Installment: %s\nTotal Credit Price: %s",
                        name,
                        customMessage,
                        currencyFormat.format(monthlyInstallment),
                        currencyFormat.format(totalCreditPrice)
                )
        );
    }
}

//---------------------------------------------------Calculator app
package com.example.simplecalculator;

 

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.widget.TextView;

 

public class MainActivity extends AppCompatActivity {

 

    EditText number1, number2;

    Button addButton, subtractButton, multiplyButton, divideButton;

    TextView result;

 

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

 

        number1 = findViewById(R.id.number1);

        number2 = findViewById(R.id.number2);

        addButton = findViewById(R.id.addButton);

        subtractButton = findViewById(R.id.subtractButton);

        multiplyButton = findViewById(R.id.multiplyButton);

        divideButton = findViewById(R.id.divideButton);

        result = findViewById(R.id.result);

 

        addButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                double num1 = Double.parseDouble(number1.getText().toString());

                double num2 = Double.parseDouble(number2.getText().toString());

                double res = num1 + num2;

                result.setText("Result: " + res);

            }

        });

 

        subtractButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                double num1 = Double.parseDouble(number1.getText().toString());

                double num2 = Double.parseDouble(number2.getText().toString());

                double res = num1 - num2;

                result.setText("Result: " + res);

            }

        });

 

        multiplyButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                double num1 = Double.parseDouble(number1.getText().toString());

                double num2 = Double.parseDouble(number2.getText().toString());

                double res = num1 * num2;

                result.setText("Result: " + res);

            }

        });

 

        divideButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                double num1 = Double.parseDouble(number1.getText().toString());

                double num2 = Double.parseDouble(number2.getText().toString());

                double res = num1 / num2;

                result.setText("Result: " + res);

            }

        });

    }

}

//--------------------------------------------------------------------------------------Temperature Calculator app
import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.widget.RadioButton;

import android.widget.TextView;

 

import androidx.appcompat.app.AppCompatActivity;

 

public class MainActivity extends AppCompatActivity {

    private EditText inputEditText;

    private RadioButton celsiusRadioButton, fahrenheitRadioButton;

    private Button convertButton;

    private TextView resultTextView;

 

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

 

        inputEditText = findViewById(R.id.inputEditText);

        celsiusRadioButton = findViewById(R.id.celsiusRadioButton);

        fahrenheitRadioButton = findViewById(R.id.fahrenheitRadioButton);

        convertButton = findViewById(R.id.convertButton);

        resultTextView = findViewById(R.id.resultTextView);

 

        convertButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                convertTemperature();

            }

        });

    }

 

    private void convertTemperature() {

        String input = inputEditText.getText().toString().trim();

        if (input.isEmpty()) {

            resultTextView.setText("Please enter a temperature value.");

            return;

        }

 

        double temperature = Double.parseDouble(input);

        double convertedTemperature;

 

        if (celsiusRadioButton.isChecked()) {

            convertedTemperature = (temperature * 9 / 5) + 32;

            resultTextView.setText(temperature + "°C = " + convertedTemperature + "°F");

        } else if (fahrenheitRadioButton.isChecked()) {

            convertedTemperature = (temperature - 32) * 5 / 9;

            resultTextView.setText(temperature + "°F = " + convertedTemperature + "°C");

        } else {

            resultTextView.setText("Please select a temperature scale.");

        }

    }

}

//-----------------------------------------------------------------------Calendar and reminder app
import android.os.Bundle;

import android.view.View;

import android.widget.CalendarView;

import android.widget.EditText;

import android.widget.Toast;

 

import androidx.appcompat.app.AppCompatActivity;

 

import java.util.Date;

import java.util.HashMap;

 

public class MainActivity extends AppCompatActivity {

    private CalendarView calendarView;

    private EditText reminderEditText;

    private HashMap<Long, String> remindersMap;

 

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

 

        calendarView = findViewById(R.id.calendarView);

        reminderEditText = findViewById(R.id.reminderEditText);

        remindersMap = new HashMap<>();

 

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override

            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                // Note: month is zero-based (0 for January, 11 for December)

                String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;

                Toast.makeText(MainActivity.this, "Selected date: " + selectedDate, Toast.LENGTH_SHORT).show();

            }

        });

    }

 

    public void addReminder(View view) {

        String reminder = reminderEditText.getText().toString().trim();

        long selectedDate = calendarView.getDate();

 

        if (reminder.isEmpty()) {

            Toast.makeText(MainActivity.this, "Please enter a reminder", Toast.LENGTH_SHORT).show();

            return;

        }

 

        remindersMap.put(selectedDate, reminder);

        Toast.makeText(MainActivity.this, "Reminder added for selected date", Toast.LENGTH_SHORT).show();

    }

 

    public void viewReminders(View view) {

        long selectedDate = calendarView.getDate();

        String reminder = remindersMap.get(selectedDate);

 

        if (reminder != null) {

            Toast.makeText(MainActivity.this, "Reminder: " + reminder, Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(MainActivity.this, "No reminder found for selected date", Toast.LENGTH_SHORT).show();

        }

    }

}

//-----------------------------------------------------------------Salary Calculator app
import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.widget.TextView;

import android.widget.Toast;

 

import androidx.appcompat.app.AppCompatActivity;

 

public class MainActivity extends AppCompatActivity {

    private EditText salaryEditText;

    private Button calculateButton;

    private TextView resultTextView;

 

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

 

        salaryEditText = findViewById(R.id.salaryEditText);

        calculateButton = findViewById(R.id.calculateButton);

        resultTextView = findViewById(R.id.resultTextView);

 

        calculateButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                calculateSalary();

            }

        });

    }

 

    private void calculateSalary() {

        String salaryString = salaryEditText.getText().toString().trim();

 

        if (salaryString.isEmpty()) {

            Toast.makeText(MainActivity.this, "Please enter a salary", Toast.LENGTH_SHORT).show();

        } else {

            double salary = Double.parseDouble(salaryString);

 

            // Calculate tax (assuming a fixed tax rate of 20%)

            double tax = salary * 0.2;

 

            // Calculate net salary

            double netSalary = salary - tax;

 

            String result = "Gross Salary: $" + salary + "\n" +

                    "Tax: $" + tax + "\n" +

                    "Net Salary: $" + netSalary;

 

            resultTextView.setText(result);

        }

    }

}

//----------------------------------------------------------------Tip calcutor app
import android.os.Bundle;

import android.widget.Button;

import android.widget.EditText;

import android.widget.SeekBar;

import android.widget.TextView;

 

import androidx.appcompat.app.AppCompatActivity;

 

public class MainActivity extends AppCompatActivity {

 

    EditText editTextBillAmount;

    SeekBar seekBarTipPercentage;

    TextView textViewTipPercentage, textViewResult;

    Button buttonCalculate;

 

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

 

        editTextBillAmount = findViewById(R.id.editTextBillAmount);

        seekBarTipPercentage = findViewById(R.id.seekBarTipPercentage);

        textViewTipPercentage = findViewById(R.id.textViewTipPercentage);

        textViewResult = findViewById(R.id.textViewResult);

        buttonCalculate = findViewById(R.id.buttonCalculate);

 

        seekBarTipPercentage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                textViewTipPercentage.setText("Tip Percentage: " + progress + "%");

            }

 

            @Override

            public void onStartTrackingTouch(SeekBar seekBar) {}

 

            @Override

            public void onStopTrackingTouch(SeekBar seekBar) {}

        });

 

        buttonCalculate.setOnClickListener(v -> calculateTip());

    }

 

    private void calculateTip() {

        double billAmount = Double.parseDouble(editTextBillAmount.getText().toString());

        int tipPercentage = seekBarTipPercentage.getProgress();

        double tipAmount = (billAmount * tipPercentage) / 100;

        double totalBill = billAmount + tipAmount;

        textViewResult.setText(String.format("Tip Amount: $%.2f\nTotal Bill: $%.2f", tipAmount, totalBill));

    }

}

//---------------------------------------------------------------Note taking app
import android.os.Bundle;

import android.view.View;

import android.widget.AdapterView;

import android.widget.ArrayAdapter;

import android.widget.Button;

import android.widget.EditText;

import android.widget.ListView;

import android.widget.Toast;

 

import androidx.appcompat.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;

 

import java.util.ArrayList;

 

public class MainActivity extends AppCompatActivity {

 

    ListView noteListView;

    Button addNoteButton;

    ArrayList<String> notesList;

    ArrayAdapter<String> notesAdapter;

 

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

 

        noteListView = findViewById(R.id.noteListView);

        addNoteButton = findViewById(R.id.addNoteButton);

        notesList = new ArrayList<>();

        notesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notesList);

        noteListView.setAdapter(notesAdapter);

 

        addNoteButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                showAddNoteDialog();

            }

        });

 

        noteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedNote = notesList.get(position);

                showEditNoteDialog(selectedNote, position);

            }

        });

 

        noteListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override

            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                notesList.remove(position);

                notesAdapter.notifyDataSetChanged();

                Toast.makeText(MainActivity.this, "Note deleted", Toast.LENGTH_SHORT).show();

                return true;

            }

        });

    }

 

    private void showAddNoteDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Add Note");

 

        final EditText input = new EditText(this);

        builder.setView(input);

 

        builder.setPositiveButton("Add", (dialog, which) -> {

            String note = input.getText().toString().trim();

            if (!note.isEmpty()) {

                notesList.add(note);

                notesAdapter.notifyDataSetChanged();

            }

        });

 

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

 

        builder.show();

    }

 

    private void showEditNoteDialog(String note, final int position) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Edit Note");

 

        final EditText input = new EditText(this);

        input.setText(note);

        builder.setView(input);

 

        builder.setPositiveButton("Save", (dialog, which) -> {

            String editedNote = input.getText().toString().trim();

            if (!editedNote.isEmpty()) {

                notesList.set(position, editedNote);

                notesAdapter.notifyDataSetChanged();

            }

        });

 

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

 

        builder.show();

    }

}

//--------------------------------------------------Calculate Salary
package com.example.testing;

 

import android.os.Bundle;

import android.view.View;

import android.widget.EditText;

import android.widget.TextView;

 

import androidx.appcompat.app.AppCompatActivity;

 

public class MainActivity extends AppCompatActivity {

 

    private EditText basicSalaryInput;

    private TextView netSalaryResult;

 

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

 

        basicSalaryInput = findViewById(R.id.basicSalaryInput);

        netSalaryResult = findViewById(R.id.netSalaryResult);

    }

 

    public void calculateNetSalary(View view) {

        try {

            double basicSalary = Double.parseDouble(basicSalaryInput.getText().toString());

            double tax = 0.15 * basicSalary;

            double netSalary = basicSalary - tax;

            netSalaryResult.setText("Net Salary: R " + netSalary);

        } catch (NumberFormatException e) {

            netSalaryResult.setText("Invalid input. Please enter a valid number.");

        }

    }

}


//------------------------------------------------------------------------Calculate Area
package com.example.testing;

 

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

 

public class MainActivity extends AppCompatActivity {

 

    EditText editTextLength, editTextWidth;

    Button buttonCalculate;

    TextView textViewResult;

 

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

 

        editTextLength = findViewById(R.id.editTextLength);

        editTextWidth = findViewById(R.id.editTextWidth);

        buttonCalculate = findViewById(R.id.buttonCalculate);

        textViewResult = findViewById(R.id.textViewResult);

 

        buttonCalculate.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                calculateArea();

            }

        });

    }

 

    private void calculateArea() {

        String lengthStr = editTextLength.getText().toString();

        String widthStr = editTextWidth.getText().toString();

 

        if (lengthStr.isEmpty() || widthStr.isEmpty()) {

            textViewResult.setText("Please enter both length and width.");

            return;

        }

 

        double length = Double.parseDouble(lengthStr);

        double width = Double.parseDouble(widthStr);

 

        double area = length * width;

 

        textViewResult.setText("Area: " + area);

    }

}


//----------------------------------------------------------Coffee Shop
import android.os.Bundle;

import android.view.View;

import android.widget.AdapterView;

import android.widget.ArrayAdapter;

import android.widget.ListView;

import android.widget.Toast;

 

import androidx.appcompat.app.AppCompatActivity;

 

public class MainActivity extends AppCompatActivity {

 

    String[] coffeeOptions = {"Espresso", "Latte", "Cappuccino", "Americano"};

    double[] prices = {2.50, 3.00, 3.50, 2.75};

 

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

 

        ListView listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, coffeeOptions);

        listView.setAdapter(adapter);

 

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedCoffee = coffeeOptions[position];

                double price = prices[position];

                String message = "You selected " + selectedCoffee + " which costs $" + price;

                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

            }

        });

    }

}

//----------------------------------------------To-Do list app
package com.example.todoapp;

 

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.ArrayAdapter;

import android.widget.Button;

import android.widget.EditText;

import android.widget.ListView;

import java.util.ArrayList;

 

public class MainActivity extends AppCompatActivity {

    private EditText taskEditText;

    private Button addButton;

    private ListView taskListView;

    private ArrayAdapter<String> adapter;

    private ArrayList<String> tasks;

 

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

 

        taskEditText = findViewById(R.id.taskEditText);

        addButton = findViewById(R.id.addButton);

        taskListView = findViewById(R.id.taskListView);

 

        tasks = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);

        taskListView.setAdapter(adapter);

 

        addButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                String task = taskEditText.getText().toString();

                if (!task.isEmpty()) {

                    tasks.add(task);

                    adapter.notifyDataSetChanged();

                    taskEditText.setText("");

                }

            }

        });

    }

}


//----------------------------------------------------Greeting app
import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

 

public class MainActivity extends AppCompatActivity {

 

    EditText nameEditText;

    TextView greetingTextView;

    Button submitButton;

 

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

 

        nameEditText = findViewById(R.id.nameEditText);

        greetingTextView = findViewById(R.id.greetingTextView);

        submitButton = findViewById(R.id.submitButton);

 

        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                String name = nameEditText.getText().toString();

                String greetingMessage = "Hello, " + name + "! Welcome to GreetingsApp!";

                greetingTextView.setText(greetingMessage);

            }

        });

    }

}