import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Registro {
    private static final double TARIFA_POR_HORA = 1.50;
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private String placa;
    private String idEspacio;
    private LocalDateTime horaEntrada;
    private double duracionHoras;
    private double totalPagado;
    private boolean activo;

    public Registro(String placa, String idEspacio) {
        this.placa = placa;
        this.idEspacio = idEspacio;
        this.horaEntrada = LocalDateTime.now();
        this.activo = true;
        this.totalPagado = 0;
    }

    public void registrarSalida(double duracionHoras) {
        if (duracionHoras < 0) {
            throw new IllegalArgumentException("La duración no puede ser negativa.");
        }
        this.duracionHoras = duracionHoras;
        long horasIniciadas = (long) Math.ceil(duracionHoras);
        this.totalPagado = horasIniciadas * TARIFA_POR_HORA;
        this.activo = false;
    }

    public String getPlaca() { return placa; }
    public String getIdEspacio() { return idEspacio; }
    public boolean isActivo() { return activo; }
    public double getTotalPagado() { return totalPagado; }
    public double getDuracionHoras() { return duracionHoras; }

    @Override
    public String toString() {
        String entrada = horaEntrada.format(FORMATO);
        if (activo) {
            return String.format(
                "ACTIVO  | Placa: %-10s | Espacio: %-4s | Entrada: %s",
                placa, idEspacio, entrada);
        } else {
            return String.format(
                "CERRADO | Placa: %-10s | Espacio: %-4s | Entrada: %s | Dur: %.2f h | Total: $%.2f",
                placa, idEspacio, entrada, duracionHoras, totalPagado);
        }
    }
}
