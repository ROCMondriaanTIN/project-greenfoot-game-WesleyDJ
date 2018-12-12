import java.util.HashMap;
import java.util.Map;

public class WorldRegistry {

    private Map<Integer, MyWorld> levels = new HashMap();
    
    public void registerLevel(int index, MyWorld level){
        levels.put(index, level);
    }
    
    public MyWorld getLevel(int index){
        levels.putIfAbsent(index, new Level1());
        return levels.get(index);
    }
    public void setLevel(int index, MyWorld level){
        levels.put(index, level);
    }
    
}