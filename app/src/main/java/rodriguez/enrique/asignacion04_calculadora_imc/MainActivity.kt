package rodriguez.enrique.asignacion04_calculadora_imc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Obtener referencias a los elementos de la interfaz
        val editTextPeso = findViewById<EditText>(R.id.etPeso)
        val editTextAltura = findViewById<EditText>(R.id.etEstatura)
        val buttonCalcular = findViewById<Button>(R.id.btnCalcularPeso)
        val textViewResultado = findViewById<TextView>(R.id.tvResultado)

        // Configurar el botón para calcular el IMC
        buttonCalcular.setOnClickListener {
            val pesoTexto = editTextPeso.text.toString().trim()
            val alturaTexto = editTextAltura.text.toString().trim()

            val peso = pesoTexto.toFloatOrNull()
            val alturaCm = alturaTexto.toFloatOrNull()

            if (peso != null && alturaCm != null && peso > 0 && alturaCm > 0) {
                val alturaM = alturaCm / 100 // Convertir centímetros a metros
                val imc = peso / (alturaM * alturaM)
                textViewResultado.text = "Tu IMC es: %.2f".format(imc)
            } else {
                textViewResultado.text = "Por favor, ingresa valores válidos (peso en kg y altura en cm)."
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
