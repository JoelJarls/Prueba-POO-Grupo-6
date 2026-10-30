public class Espacio {     
  private String  id;    
  private boolean libre;     
  public Espacio(String id) {        
    this.id    = id;        
    this.libre = true;    
  }     
  // ── Getters ──────────────────────────────────────────────────────────────    
  public String  getId(){ 
    return id;    
  }    
  public boolean isLibre(){ 
    return libre; 
  }     
  // ── Operaciones de estado ─────────────────────────────────────────────────    
   
  public void ocupar() { 
    this.libre = false; 
  }       
  public void liberar() { 
    this.libre = true;  
  }    
  @Override    
  public String toString() {        
    return "Espacio[id=" + id + ", estado=" + (libre ? "LIBRE" : "OCUPADO") + "]";    
  } 
}
