package Servlets;
import java.util.Iterator;
import java.io. IOException;
import java.util.List;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import jakarta. servlet .http.HttpServletRequest;
import Entities.Tanks;

public class Helper {
    public static JsonElement bodyParse(HttpServletRequest request) {
        JsonElement jsonElement=null;
        try {
            jsonElement = JsonParser.parseReader(request.getReader());

        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            e.printStackTrace();
        }
        return jsonElement;
    }
    public static Tanks userParse(HttpServletRequest request) {
        Tanks tank = new Tanks();
        JsonElement jsonElement = bodyParse(request);
        tank.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
        tank.setName(jsonElement.getAsJsonObject().get("name").getAsString());
        tank.setPower(jsonElement.getAsJsonObject().get("power").getAsInt());
        tank.setPower_reserve(jsonElement.getAsJsonObject().get("power_reserve").getAsInt());
        tank.setSpeed(jsonElement.getAsJsonObject().get("speed").getAsInt());
        tank.setPhoto(jsonElement.getAsJsonObject().get("photo").getAsString());
        return tank;
    }
    public static int getNextId(List<Tanks> list) {
        int maxId = 0;
        if (list == null){
            return 0;
        }
        for (Tanks Tanks : list) {
            int currentId = Tanks.getId();
            if (currentId > maxId) maxId = currentId;
        }
        return maxId+1;
    }
    public static int getIndexByUserId(int id,  List<Tanks> list){
        int listId = id;
        if (list == null){
            return -1;
        }
        for (Tanks temp : list) {
            if (temp.getId() == listId) {
                listId = list.indexOf(temp);
                break;
            }
        }
        return listId;
    }
}