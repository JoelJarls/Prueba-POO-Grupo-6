# Análisis del Problema — Parqueadero Inteligente
## Problema
Un parqueadero necesita administrar plazas, vehículos y pagos de forma automatizada, controlando la 
asignación de espacios, el registro de entradas/salidas y el cobro justo por el tiempo de estancia.
## Entradas
| Dato | Descripción |
|------|-------------|
| Placa | Identificador único del vehículo (texto, se normaliza a mayúsculas) |
| Tipo | Categoría del vehículo: AUTO, MOTO o CAMIONETA |
| ID espacio | Identificador de cada plaza (ej.: A1, B2) |
| Duración | Tiempo de estancia en horas (decimal, ej.: 2.1667 = 2h 10min) |

## Procesos

1. **Registro de vehículos**: validar placa única; normalizar a mayúsculas.
2. **Gestión de espacios**: mantener estado libre/ocupado con identificador único.
3. **Entrada**: verificar vehículo registrado, que no tenga entrada activa y que exista espacio libre; asignar automáticamente el primer espacio libre.
4. **Salida y cobro**: validar duración ≥ 0; calcular `ceil(duracionHoras) × $1.50`; cerrar el `Registro` y liberar el espacio.
5. **Reportes**: mostrar ocupación global e historial de registros.

## Salidas

- Mensajes de confirmación o error para cada operación.
- Reporte de estado de espacios (libre/ocupado) con totales.
- Historial de registros activos y cerrados con duración y monto pagado.

## Decisiones de diseño

| Decisión | Justificación |
|----------|---------------|
| Clase `Registro` separada de `Parqueadero` | Encapsula la lógica de entrada/salida y el cálculo de pago; Parqueadero solo coordina |
| `Math.ceil` para horas iniciadas | Cobrar la hora completa aunque no se complete: regla del negocio |
| `ArrayList` para las colecciones | Facilita la adición dinámica de vehículos, espacios y registros |
| Placa normalizada a mayúsculas en constructor | Evita duplicados por diferencia de caja (ej.: "abc123" = "ABC123") |
| Atributo `activo` en `Registro` | Distingue registros abiertos de cerrados sin eliminarlos, conservando el historial |
