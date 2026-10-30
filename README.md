# Parqueadero Inteligente — Grupo 6
## Integrantes
| N° | Nombre | Contribución |
|----|--------|-------------|
| 1 | Peñafiel Leyber | `Vehiculo.java`, estructura del repositorio, `.gitignore` |
| 2 | Joel Pacha | `Espacio.java` |
| 3 | Marlon Yaguana | `Registro.java` |
| 4 | Joseph Castro | `Parqueadero.java` |
| 5 | Matías Pico | `Main.java` |
| 6 | Steeve Ortiz | `docs/` (analisis.md, casos_prueba.md, diagrama de clases) |
## Objetivo
Construir una aplicación de consola en Java que administre un parqueadero: registrar vehículos y
espacios, gestionar entradas/salidas con duración y cobrar **$1.50 USD por hora iniciada**.
## Clases implementadas
| Clase | Responsabilidad |
|-------|----------------|
| `Vehiculo` | Almacena placa y tipo del vehículo |
| `Espacio` | Representa una plaza física (libre/ocupado) |
| `Registro` | Registra entrada/salida y calcula el pago |
| `Parqueadero` | Coordina vehículos, espacios y registros; centraliza las reglas de negocio |
| `Main` | Menú interactivo con Scanner y switch |
## Métodos principales
- `registrarVehiculo(placa, tipo)` — registra sin duplicados
- `agregarEspacio(id)` — agrega plaza con ID único
- `registrarEntrada(placa)` — asigna primer espacio libre; impide doble entrada activa
- `registrarSalida(placa, duracionHoras)` — cierra el registro, cobra y libera el espacio
- `registrarSalida` en `Registro` — calcula `ceil(horas) × $1.50`
- `mostrarOcupacion()` — lista espacios libres/ocupados
- `mostrarRegistros()` — historial completo
- `mostrarVehiculos()` — lista de vehículos registrados
## Compilación y ejecución
```bash
# Desde la raíz del repositorio
cd src
javac Vehiculo.java Espacio.java Registro.java Parqueadero.java Main.java
java Main
```
## Caso de prueba de referencia
Una estancia de **2 h 10 min** (2.1667 h) → `ceil(2.1667) = 3 horas iniciadas` → **$4.50 USD**.
## Repositorio
<https://github.com/JoelJarls/Prueba-POO-Grupo-6>
