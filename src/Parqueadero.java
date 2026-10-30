import java.util.ArrayList; 
public class Parqueadero {     
  private String nombre;    
  private ArrayList<Vehiculo> vehiculos;    
  private ArrayList<Espacio>  espacios;    
  private ArrayList<Registro> registros;     
  public Parqueadero(String nombre) {        
    this.nombre    = nombre;        
    this.vehiculos = new ArrayList<>();        
    this.espacios  = new ArrayList<>();        
    this.registros = new ArrayList<>();    
  }       
  public String registrarVehiculo(String placa, String tipo) {        
    placa = placa.toUpperCase().trim();       
    if (buscarVehiculo(placa) != null) {            
      return "ERROR: Ya existe un vehículo con la placa " + placa + ".";        
    }        
    vehiculos.add(new Vehiculo(placa, tipo));        
    return "Vehículo registrado: " + placa + " (" + tipo.toUpperCase().trim() + ")";    
  }       
  public Vehiculo buscarVehiculo(String placa) {        
    placa = placa.toUpperCase().trim();        
    for (Vehiculo v : vehiculos) {            
      if (v.getPlaca().equals(placa)) return v;        
    }        
    return null;    
  }       
  public String agregarEspacio(String id) {        
    for (Espacio e : espacios) {            
      if (e.getId().equalsIgnoreCase(id)) {
                return "ERROR: Ya existe el espacio con ID " + id + ".";            
      }       
    }        
    espacios.add(new Espacio(id));        
    return "Espacio agregado: " + id;    
  }       
  private Espacio buscarEspacioLibre() {        
    for (Espacio e : espacios) {            
      if (e.isLibre()) return e;       
    }        
    return null;    
  }        
  private void liberarEspacio(String idEspacio) {        
    for (Espacio e : espacios) {            
      if (e.getId().equals(idEspacio)) {                
        e.liberar();                
        return;            
      }        
    }    
  }      
  public String registrarEntrada(String placa) {        
    placa = placa.toUpperCase().trim();         
    if (buscarVehiculo(placa) == null) {            
      return "ERROR: No existe vehículo con placa " + placa + ". Regístrelo primero (opción 1).";        
    }               
    for (Registro r : registros) {            
      if (r.getPlaca().equals(placa) && r.isActivo()) {                
        return "ERROR: La placa " + placa + " ya tiene una entrada activa en el espacio " + r.getIdEspacio() + ".";
      }        
    }         
    Espacio espacio = buscarEspacioLibre();        
    if (espacio == null) {            
      return "ERROR: No hay espacios libres disponibles.";       
    }        
    espacio.ocupar();      
    registros.add(new Registro(placa, espacio.getId()));   
    return "Entrada registrada. Placa: " + placa + " → Espacio: " + espacio.getId();   
  }      
  public String registrarSalida(String placa, double duracionHoras) {        
    placa = placa.toUpperCase().trim();
         if (duracionHoras < 0) {            
           return "ERROR: La duración no puede ser negativa.";        
         }       
    for (Registro r : registros) {        
      if (r.getPlaca().equals(placa) && r.isActivo()) {  
        r.registrarSalida(duracionHoras);         
        liberarEspacio(r.getIdEspacio());          
        return String.format(               
          "Salida registrada. Placa: %s | Duración: %.4f h | Total a pagar: $%.2f",                
          placa, duracionHoras, r.getTotalPagado());           
      }   
    }      
    return "ERROR: No se encontró entrada activa para la placa " + placa + ".";    
  }      
  public void mostrarOcupacion() {        
    int libres = 0, ocupados = 0;       
    System.out.println("\n═══════════════ ESTADO DEL PARQUEADERO ═══════════════");       
    System.out.println("  " + nombre);        for (Espacio e : espacios) {      
      System.out.println("  " + e);            if (e.isLibre()) libres++; else ocupados++;      
    }        System.out.printf("%n  Total: %d | Libres: %d | Ocupados: %d%n",              
                               espacios.size(), libres, ocupados);       
    System.out.println("═══════════════════════════════════════════════════════\n");   
  }   
  
  public void mostrarRegistros() {   
    System.out.println("\n══════════════════ HISTORIAL DE REGISTROS ══════════════════");    
    if (registros.isEmpty()) {         
      System.out.println("  No hay registros.");    
    } else {          
      for (Registro r : registros) {              
        System.out.println("  " + r);      
      }       
    }       
    System.out.println("════════════════════════════════════════════════════════════\n");   
  }    
  
  public void mostrarVehiculos() {     
    System.out.println("\n══════════════════ VEHÍCULOS REGISTRADOS ══════════════════");      
    if (vehiculos.isEmpty()) {   
      System.out.println("  No hay vehículos registrados.");  
    } else {         
      for (Vehiculo v : vehiculos) {    
      System.out.println("  " + v);       
      }     
    }      
    System.out.println("════════════════════════════════════════════════════════════\n");  
  } 
  public String getNombre() { return nombre; }
}






  
