package quiz;
public class Structure {

    Node primero = new Node();
    Node ultimo = new Node();
    Bolsas primera = new Bolsas();
    Bolsas ultimas = new Bolsas();
    int cantBolsa;
    int capacidad;
    public Structure() {
        primero = null;
        ultimo = null;
        primera = null;
        ultimas = null;
        cantBolsa = 1;
    }
    public boolean addBag(int seleccion){
        if(cantBolsa<= 6){
            switch (seleccion){
                case 6:
                    capacidad = 6;
                    break;
                case 8:
                    capacidad = 8;
                    break;
                case 12:
                    capacidad = 12;
                    break;
                default:
                    System.out.println("No existe esa capacidad...");
            }
            Bolsas nuevo = new Bolsas();
            if(primera== null){
                primera = nuevo;
                primera.tamanio = capacidad;
                primera.siguiente = null;
            }
            else{
                ultimas.siguiente = nuevo;
                nuevo.siguiente= null;
            }
            cantBolsa++;
            return true;
        }else{
            System.out.println("Cantidad maxima de bolsas Superada.");
           return false;
        }

    }
    public boolean addItems(Node item){
        Node nuevo = new Node();
        nuevo.ItemName = item.ItemName;
        nuevo.Rank = item.Rank;
        nuevo.Type = item.Type;
        nuevo.Durability = item.Durability;
        nuevo.Description = item.Description;

        if(primero== null){
            primero= nuevo;
            primero.next = null;
            return true;
        }
        else{
            ultimo.next = nuevo;
            nuevo.next= null;
            return true;
        }
    }
    public void displayItems(){
        Node actual = new Node();
        actual = primero;
        if(primero != null){
            while(actual!=null){
                System.out.println(""+actual.ItemName);
                System.out.println(""+actual.Rank);
                System.out.println(""+actual.Type);
                System.out.println(""+actual.Durability);
                System.out.println(""+actual.Description);
                actual =actual.next;
            }
        }else{
            System.out.println("La lista se encuentra vacia");
        }
    }
    public boolean exchangeItems(String itemName1, String itemName2){
        Node actual = new Node();
        Node Secundario = new Node();
        Node terciario = new Node();
        actual = primero;
        boolean encontrado = false;
        if(primero != null){
            while(actual!= null && encontrado != true){
                if (actual.ItemName.equals(itemName1)){
                    System.out.println("nodo con el dato" + actual.ItemName + "Encontrado ");
                    encontrado= true;
                }
                actual= actual.next;
            }
            boolean Encontrado2 = false;
            while(Secundario!= null && Encontrado2 != true){
                if (Secundario.ItemName.equals(itemName2)){
                    System.out.println("nodo con el dato" + Secundario.ItemName + "Encontrado ");
                    encontrado= true;
                }
                Secundario= Secundario.next;
            }
            if(encontrado == true && Encontrado2 == true){
                Secundario = terciario;
                Secundario =  actual;
                actual = terciario;
                return true;
            }
            if(!encontrado){
                System.out.println("Nodo no encontrado");
                return false;
            }
        }else{
            System.out.println("La lista se encontra vacia");
        }
        return false;
    }
    public void sortTaskByTRange(){
        boolean cambio;
        do{
            Node actual = primero;
            Node anterior = null;
            Node siguiente = primero.next;
            cambio = false;
            while ( siguiente != null) {
                if(actual.Rank>0){
                    cambio=true;
                    if(anterior != null){
                        Node FF = siguiente.next;
                        anterior.next = siguiente;
                        siguiente.next = actual;
                        actual.next = FF;
                    }else{
                        Node FF = siguiente.next;
                        primero = siguiente;
                        siguiente.next = actual;
                        actual.next = FF;
                    }
                    anterior = siguiente;
                    siguiente = actual.next;
                }else{
                    anterior = actual;
                    actual = siguiente;
                    siguiente = siguiente.next;
                }
            }

        }while(cambio);
    }
}
