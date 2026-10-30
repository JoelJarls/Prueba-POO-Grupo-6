# Casos de Prueba — Parqueadero Inteligente

Espacios iniciales creados en `Main`: A1, A2, A3, B1, B2.

| N° | Caso | Entrada | Resultado esperado | Resultado obtenido | Estado |
|----|------|---------|--------------------|--------------------|--------|
| 1 | Cobro de referencia (2 h 10 min) | Opción 4, placa `ABC123`, duración `2.1667` | Total a pagar: $4.50 (3 horas iniciadas × $1.50) | `✔ Salida registrada. Placa: ABC123 \| Duración: 2.1667 h \| Total a pagar: $4.50` | ✅ Correcto |
| 2 | Doble entrada activa | Opción 3 con `ABC123` dos veces seguidas | La segunda entrada se rechaza | `ERROR: La placa ABC123 ya tiene una entrada activa en el espacio A1.` | ✅ Correcto |
| 3 | Duración negativa | Opción 4, placa `XYZ1`, duración `-1` | Rechazar la duración | `ERROR: La duración no puede ser negativa.` | ✅ Correcto |
| 4 | Placa duplicada (sin distinguir mayúsculas) | Opción 1, placa `abc123` (ya existe `ABC123`) | Rechazar el registro | `ERROR: Ya existe un vehículo con la placa ABC123.` | ✅ Correcto |
| 5 | Espacio con ID duplicado | Opción 2, ID `A1` | Rechazar el espacio | `ERROR: Ya existe el espacio con ID A1.` | ✅ Correcto |
| 6 | Asignar solo espacios libres (parqueadero lleno) | Registrar P1–P6 y dar entrada a los seis | P1–P5 ocupan A1, A2, A3, B1, B2; P6 se rechaza | `ERROR: No hay espacios libres disponibles.` y ocupación `Total: 5 \| Libres: 0 \| Ocupados: 5` | ✅ Correcto |

Los resultados obtenidos se tomaron de la ejecución real del programa compilado con `javac` y ejecutado con `java Main`.
