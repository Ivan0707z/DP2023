package servlet;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import entity.DeviceEntity;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CRUDConfig {
    public static JsonElement bodyParse(HttpServletRequest request) {
        JsonElement jsonElement=null;

        try {
            jsonElement = JsonParser.parseReader(request.getReader());
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            e.printStackTrace();
        }

        return jsonElement;
    }

    public static DeviceEntity deviceParse(HttpServletRequest request) {
        DeviceEntity device = new DeviceEntity();
        JsonElement jsonElement = bodyParse(request);
        device.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
        device.setName(jsonElement.getAsJsonObject().get("name").getAsString());
        device.setType(jsonElement.getAsJsonObject().get("type").getAsString());
        device.setImage(jsonElement.getAsJsonObject().get("image").getAsString());
        device.setPrice(jsonElement.getAsJsonObject().get("price").getAsInt());
        device.setAmount(jsonElement.getAsJsonObject().get("amount").getAsInt());
        device.setDescription(jsonElement.getAsJsonObject().get("description").getAsString());
        return device;
    }

    public static int getNextId(List<DeviceEntity> list) {
        int maxId = 0;

        Iterator<DeviceEntity> iterator = list.iterator();
        while(iterator.hasNext()) {
            int currentId = iterator.next().getId();
            if(currentId>maxId) maxId=currentId;
        }
        return maxId+1;
    }

    public static int getIndexByUserId(int id,List<DeviceEntity> list) {
        int listId = id;

        Iterator<DeviceEntity> iterator = list.iterator();
        while(iterator.hasNext()) {
            DeviceEntity temp =iterator.next();
            if(temp.getId()==listId) {
                listId=list.indexOf(temp);
                break;
            }
        }
        return listId;
    }

}
