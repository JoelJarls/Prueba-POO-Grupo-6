public class Vehiculo {
private String placa;
private String tipo; 
public Vehiculo(String placa, String tipo) {
this.placa = placa.toUpperCase().trim();
this.tipo = tipo.toUpperCase().trim();
}
public String getPlaca() { return placa; }
public String getTipo() { return tipo; }
@Override
public String toString() {
return "Vehiculo[placa=" + placa + ", tipo=" + tipo + "]";
}
}
